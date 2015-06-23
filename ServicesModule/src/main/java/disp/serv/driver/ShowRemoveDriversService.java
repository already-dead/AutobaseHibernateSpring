package disp.serv.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoUserDetail;
import data.UserDetail;
import exception.DaoException;
import exception.ServiceException;
import service.LogService;

@Service("showRemoveDriverService")
@Transactional
public class ShowRemoveDriversService extends LogService {
	private static ShowRemoveDriversService thisService;
	
	@Autowired
	private DaoUserDetail dao;
	
	public static  ShowRemoveDriversService getService()
	{
		if(thisService == null)
			thisService = new ShowRemoveDriversService();
		return thisService;
	}

	@Override
	public List<?> servGet() throws ServiceException {
    	dao = DaoUserDetail.getDaoUserDetail();
		List<UserDetail> drivers = null;
		try {
			drivers = dao.getDrivers();
		} catch (DaoException e) {
			printLog(e,3);
			throw new ServiceException(e);
		}
		return drivers;
	}

}