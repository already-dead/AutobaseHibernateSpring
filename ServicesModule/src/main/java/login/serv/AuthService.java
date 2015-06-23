
package login.serv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.LogService;
import dao.DaoUsers;
import dao.IUsersDao;
import data.Users;
import exception.DaoException;
import exception.ServiceException;

@Service("authService")
@Transactional
public class AuthService extends LogService {
	private static AuthService thisService;
	Users user;
	
	@Autowired
	private IUsersDao dao;
	
	public static  AuthService getService()
	{
		if(thisService == null)
			thisService = new AuthService();
		return thisService;
	}

	@Override
	public int servRet(List<String> param) throws ServiceException  {	
		
		String currEmail = param.get(0);
		String currPas = param.get(1);
		
		dao = DaoUsers.getDaoUsers();
		
		try {
			user = dao.logUser(currEmail, currPas);
			if ("1".equals(user.getRole())) {
				return 1;
			}
			if ("2".equals(user.getRole())) {
				return 2;
			}
			return 0;
		} catch (DaoException e) {
			printLog(e,4);
			throw new ServiceException(e);
		}
	}

	@Override
	public List<?> servGet() {
		List<Integer> id = new ArrayList<Integer>();
		id.add(user.getId());
		return id;
	}

}

