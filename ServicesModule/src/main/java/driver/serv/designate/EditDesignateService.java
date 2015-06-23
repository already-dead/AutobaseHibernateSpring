package driver.serv.designate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoFlights;
import data.Flights;
import exception.DaoException;
import exception.ServiceException;
import service.LogService;

@Service("editDesignateService")
@Transactional
public class EditDesignateService extends LogService {
	private static EditDesignateService thisService;
	
	@Autowired
	private DaoFlights dao;
	
	public static  EditDesignateService getService()
	{
		if(thisService == null)
			thisService = new EditDesignateService();
		return thisService;
	}

	@Override
	public List<?> servGet() throws ServiceException {
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
