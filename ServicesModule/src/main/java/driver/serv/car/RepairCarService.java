package driver.serv.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoCars;
import data.Cars;
import exception.DaoException;
import exception.ServiceException;
import service.LogService;

@Service("repairCarService")
@Transactional
public class RepairCarService extends LogService {
	private static RepairCarService thisService;
	
	@Autowired
	private DaoCars dao;
	
	public static  RepairCarService getService()
	{
		if(thisService == null)
			thisService = new RepairCarService();
		return thisService;
	}

	@Override
	public List<?> servGet() throws ServiceException{
    	dao = DaoCars.getDaoCars();
		List<Cars> cars = null;
		try {
			cars = dao.getAll();
			return cars;
		} catch (DaoException e) {
			printLog(e,3);
			throw new ServiceException(e);
		}
	}

}