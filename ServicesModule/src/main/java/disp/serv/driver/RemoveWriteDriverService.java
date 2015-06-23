package disp.serv.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoUsers;
import data.Users;
import exception.DaoException;
import exception.ServiceException;
import service.LogService;

@Service("removeWriteDriverService")
@Transactional
public class RemoveWriteDriverService extends LogService {
	private static RemoveWriteDriverService thisService;
	
	@Autowired
	private DaoUsers dao;
	
	public static  RemoveWriteDriverService getService()
	{
		if(thisService == null)
			thisService = new RemoveWriteDriverService();
		return thisService;
	}

	@Override
	public void servUpd(List<String> param) throws ServiceException {
		
		String id = param.get(0);
    	dao = DaoUsers.getDaoUsers();
		Users driver = null;
		try {
			driver = dao.get(Integer.parseInt(id));
			if (driver.getActive()==0) {
				driver.setActive(1);
			} else {
				driver.setActive(0);
			}
			dao.saveOrUpdate(driver);
		} catch (DaoException e) {
			printLog(e,2);
			throw new ServiceException(e);
		}
	}


}
