package login.serv;

import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.LogService;
import dao.DaoUsers;
import data.UserDetail;
import data.Users;
import exception.DaoException;
import exception.ServiceException;

@Service("regService")
@Transactional
public class RegService extends LogService {
	private static RegService thisService;
	
	@Autowired
	private DaoUsers dao;
	
	public static  RegService getService()
	{
		if(thisService == null)
			thisService = new RegService();
		return thisService;
	}

	@Override
	public int servRet(List<String> param) throws ServiceException {	
		Users currUser = new Users();
		UserDetail uDetail = new UserDetail();
		dao = DaoUsers.getDaoUsers();
		List<Users> users;
		try {
			users = dao.getAll();
			if (param.get(0).equals(param.get(1))) {
				ListIterator<Users> iterator = users.listIterator();
				while (iterator.hasNext()) {
					Users data = iterator.next();
					if (data.getLogin().equals(param.get(2))) {
						return 0;
					}
				}
				
				currUser.setLogin(param.get(2));
				currUser.setPassword(param.get(0));
				currUser.setRole(param.get(3));
				currUser.setActive(1);
				uDetail.setName(param.get(4));
				uDetail.setSurname(param.get(5));
				currUser.setUserDetail(uDetail);
				
				dao.saveOrUpdate(currUser);
				return 1;
			} else {
				return 2;
			}
		} catch (DaoException e) {
			printLog(e,5);
			throw new ServiceException(e);
		}	
	}

}

