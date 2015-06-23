package disp.serv.dispatcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoUserDetail;
import dao.DaoUsers;
import exception.DaoException;
import exception.ServiceException;
import service.LogService;

@Service("delDispatcherService")
@Transactional
public class DelDispatcherService extends LogService {
	private static DelDispatcherService thisService;
	
	@Autowired
	private DaoUsers dao;
	
	@Autowired
	private DaoUserDetail detDao;
	
	public static  DelDispatcherService getService()
	{
		if(thisService == null)
			thisService = new DelDispatcherService();
		return thisService;
	}

	@Override
	public void servUpd(List<String> param) throws ServiceException {
		String dispId = param.get(0);
		
		dao = DaoUsers.getDaoUsers();
		detDao = DaoUserDetail.getDaoUserDetail();
		try {
			dao.fakeDel(Integer.parseInt(dispId));
			detDao.fakeDel(Integer.parseInt(dispId));
		} catch (DaoException e) {
			printLog(e,1);
			throw new ServiceException(e);
		}

	}

}
