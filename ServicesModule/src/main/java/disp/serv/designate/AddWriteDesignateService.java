package disp.serv.designate;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoFlights;
import data.Flights;
import exception.DaoException;
import exception.ServiceException;
import service.LogService;

@Service("addWriteDesignateService")
@Transactional
public class AddWriteDesignateService extends LogService {
	private static AddWriteDesignateService thisService;
	
	@Autowired
	private DaoFlights dao;
	
	public static  AddWriteDesignateService getService()
	{
		if(thisService == null)
			thisService = new AddWriteDesignateService();
		return thisService;
	}

	@Override
	public void servUpd(List<String> param) throws ServiceException{	
		Flights flight = new Flights();
		dao = DaoFlights.getDaoFlights();

		flight.setDate(param.get(0));
		flight.setAdress(param.get(1));
		flight.setDriver(Integer.valueOf(param.get(2)));
		flight.setCar(Integer.valueOf(param.get(3)));
		flight.setStatus(0);

		try {
			dao.saveOrUpdate(flight);
		} catch (DaoException e) {
			printLog(e,2);
			throw new ServiceException(e);
		}
	}

}
