package disp.serv.dispatcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoUserDetail;
import data.UserDetail;
import exception.DaoException;
import exception.ServiceException;
import service.LogService;

@Service("showDispatcherService")
@Transactional
public class ShowDispatchersService extends LogService {
	private static ShowDispatchersService thisService;
	
	@Autowired
	private DaoUserDetail dao;
	
	public static  ShowDispatchersService getService()
	{
		if(thisService == null)
			thisService = new ShowDispatchersService();
		return thisService;
	}

	@Override
	public List<?> servGet() throws ServiceException {
		dao = DaoUserDetail.getDaoUserDetail();
		List<UserDetail> disps = null;
		try {
			disps = dao.getDisp();
			return disps;
		} catch (DaoException e) {
			printLog(e,3);
			throw new ServiceException(e);
		}
	}

}
