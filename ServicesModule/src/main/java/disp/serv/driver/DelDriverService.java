package disp.serv.driver;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoUserDetail;
import dao.DaoUsers;
import exception.DaoException;
import exception.ServiceException;
import service.LogService;

@Service("delDriverService")
@Transactional
public class DelDriverService extends LogService {
	private static DelDriverService thisService;
	
	@Autowired
	private DaoUsers dao;
	
	@Autowired
	private DaoUserDetail detDao;
	
	public static  DelDriverService getService()
	{
		if(thisService == null)
			thisService = new DelDriverService();
		return thisService;
	}

	@Override
	public void servUpd(List<String> param) throws ServiceException {
		String driverId = param.get(0);
		
		dao = DaoUsers.getDaoUsers();
		detDao = DaoUserDetail.getDaoUserDetail();
		try {
			dao.fakeDel(Integer.parseInt(driverId));
			detDao.fakeDel(Integer.parseInt(driverId));
		} catch (DaoException e) {
			printLog(e,1);
			throw new ServiceException(e);
		}
	}

}
