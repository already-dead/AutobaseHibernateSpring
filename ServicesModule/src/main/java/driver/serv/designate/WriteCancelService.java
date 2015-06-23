package driver.serv.designate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.LogService;
import dao.DaoFlights;
import data.Flights;
import exception.DaoException;
import exception.ServiceException;

@Service("writeCancelService")
@Transactional
public class WriteCancelService extends LogService {
	private static WriteCancelService thisService;
	
	@Autowired
	private DaoFlights dao;
	
	public static  WriteCancelService getService()
	{
		if(thisService == null)
			thisService = new WriteCancelService();
		return thisService;
	}

	@Override
	public void servUpd(List<String> param) throws ServiceException{	
		String flightId = param.get(0);
			
    	dao = DaoFlights.getDaoFlights();
		Flights flight;
		try {
			flight = dao.get(Integer.parseInt(flightId));
			flight.setStatus(-1);
			dao.saveOrUpdate(flight);
		} catch (DaoException e) {
			printLog(e,2);
			throw new ServiceException(e);
		}	
	}

	@Override
	public List<?> servGet() throws ServiceException{
		dao = DaoFlights.getDaoFlights();
		List<Flights> flights = null;
		try {
			flights = dao.getAll();
			return flights;
		} catch (DaoException e) {
			printLog(e,3);
			throw new ServiceException(e);
		}
	}

}
