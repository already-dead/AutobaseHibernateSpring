package base;


import exception.DaoException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository("baseDao")
@Transactional(propagation = Propagation.MANDATORY)
public class BaseDao<T> extends AbstractDao implements Dao<T> {
    private static Logger log = Logger.getLogger(BaseDao.class);
    
    @Autowired
    private SessionFactory sessionFactory;

    public BaseDao() {
    }

    public void saveOrUpdate(T t) throws DaoException{
        try {
        	getSession().saveOrUpdate(t);
            log.info("saveOrUpdate(t):" + t);
        } catch (HibernateException e) {
            log.error("Error save or update " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public T get(Serializable id) throws DaoException {
        log.info("Get class by id:" + id);
        T t = null;
        try {
            t = ((T) getSession().get(getPersistentClass(), id));
            log.info("get clazz:" + t);
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return t;
    }
    
    @SuppressWarnings("unchecked")
	public List<T> getAll() throws DaoException {
		List<T> list = null;
		try {
            Query pojoQuery = getSession().createQuery("select t from "+getPersistentClass().getSimpleName()+" t where t.del=0");
            list = pojoQuery.list();
            log.info("get all clazz");
        } catch (HibernateException e) {
            log.error("Error getAll " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return list;
	}
    
    @SuppressWarnings("unchecked")
    public T load(Serializable id) throws DaoException {
        log.info("Load class by id:" + id);
        T t = null;
        try {
            t = (T) getSession().load(getPersistentClass(), id);
            log.info("load() clazz:" + t);
            getSession().isDirty();
        } catch (HibernateException e) {
            log.error("Error load() " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return t;
    }

    public void sdelete(T t) throws DaoException {
        try {
        	getSession().delete(t);
            log.info("Delete:" + t);
        } catch (HibernateException e) {
            log.error("Error delete " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
    }
    
    public void fakeDel(Serializable id) throws DaoException {
        try {
            Query delQuery = getSession().createQuery("update "+getPersistentClass().getSimpleName()+" t set t.del=1 where t.id="+id);
            delQuery.executeUpdate();  
            log.info("Fake delete from "+ getPersistentClass().getSimpleName()+" id = "+id);
        } catch (HibernateException e) {
            log.error("Error fake delete from "+ getPersistentClass().getSimpleName()+" id = "+id + " in Dao" + e);
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private Class<T> getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
