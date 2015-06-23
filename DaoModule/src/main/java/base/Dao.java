package base;

import exception.DaoException;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {
    void saveOrUpdate(T t) throws DaoException;

    T get(Serializable id) throws DaoException;
    
    List<T> getAll() throws DaoException;

    T load(Serializable id) throws DaoException;

    void sdelete(T t) throws DaoException;
    
    void fakeDel(Serializable id) throws DaoException;
}




