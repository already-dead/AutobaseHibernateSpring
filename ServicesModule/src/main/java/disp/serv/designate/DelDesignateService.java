package disp.serv.designate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoFlights;
import exception.DaoException;
import exception.ServiceException;
import service.LogService;

@Service("delDesignateService")
@Transactional
public class DelDesignateService extends LogService {
	private static DelDesignateService thisService;
	
	@Autowired
	private DaoFlights dao;
	
	public static  DelDesignateService getService()
	{
		if(thisService == null)
			thisService = new DelDesignateService();
		return thisService;
	}

	@Override
	public void servUpd(List<String> param) throws ServiceException {
		String flightId = param.get(0);
		dao = DaoFlights.getDaoFlights();
		try {
			dao.fakeDel(flightId);
		} catch (DaoException e) {
			printLog(e,1);
			throw new ServiceException(e);
		}
	}

}