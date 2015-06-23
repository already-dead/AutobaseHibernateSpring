package dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import base.BaseDao;
import data.Users;
import exception.DaoException;

@Repository("usersDao")
@Transactional(propagation = Propagation.MANDATORY)
public class DaoUsers extends BaseDao<Users> implements IUsersDao{

	private static Logger log = Logger.getLogger(DaoUsers.class);
	private static DaoUsers thisDao;

	public DaoUsers() {
		super();
	}

	public static DaoUsers getDaoUsers() {
		if (thisDao == null)
			thisDao = new DaoUsers();
		return thisDao;
	}

	public Users logUser(String email, String pas) throws DaoException {
		Users currUser = new Users();
		try {
			Query pojoQuery = getSession().createQuery(
					"select u from Users u where u.del=0 and u.active=1 and u.login='"
							+ email + "' and u.password='" + pas + "'");
			currUser = (Users) pojoQuery.uniqueResult();
			if (currUser != null) {
				log.info("login user class: " + currUser);
				return currUser;
			} else {
				return new Users();
			}
		} catch (HibernateException e) {
			log.error("Error authoritizing user in Dao:" + e);
			throw new DaoException(e);
		}
	}

}
