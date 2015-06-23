package dao;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import base.BaseDao;
import data.UserDetail;
import exception.DaoException;

@Repository("userDetailDao")
@Transactional(propagation = Propagation.MANDATORY)
public class DaoUserDetail extends BaseDao<UserDetail>{	
	private static Logger log = Logger.getLogger(DaoUserDetail.class);
	private static DaoUserDetail thisDao; 

	public DaoUserDetail() {
		super();
	}
	
	public static  DaoUserDetail getDaoUserDetail()
	{
		if(thisDao == null)
			thisDao = new DaoUserDetail();
		return thisDao;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserDetail> getDrivers() throws DaoException {
		List<UserDetail> drivers = null;
		try {
            Query pojoQuery = getSession().createQuery("select u from UserDetail u where u.del=0 and u.users.active=1 and u.users.role='2'");
            drivers = pojoQuery.list();
            log.info("get drivers clazz");
            return drivers;
        } catch (HibernateException e) {
            log.error("Error get drivers in Dao" + e);
            throw new DaoException(e);
        }
	}

	@SuppressWarnings("unchecked")
	public List<UserDetail> getDisp() throws DaoException {
		List<UserDetail> disp = null;
		try {
            Query pojoQuery = getSession().createQuery("select u from UserDetail u where u.del=0 and u.users.active=1 and u.users.role='1'");
            disp = pojoQuery.list();
            log.info("get disp clazz");
            return disp;
        } catch (HibernateException e) {
            log.error("Error get disp in Dao" + e);
            throw new DaoException(e);
        }
	}
	

}
