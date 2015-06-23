package service;

import java.util.HashMap;
import java.util.List;

import exception.ServiceException;


public abstract class BaseService {
	abstract public void servUpd(List<String> param) throws ServiceException;
	abstract public int servRet(List<String> param) throws ServiceException;
	abstract public List<?> servGet() throws ServiceException;
	abstract public HashMap<String,List<?>> servGetMany() throws ServiceException;
}