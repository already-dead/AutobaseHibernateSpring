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

@Service("writeRepairCarService")
@Transactional
public class WriteRepairCarService extends LogService {
	private static WriteRepairCarService thisService;
	
	@Autowired
	private DaoCars dao;
	
	public static  WriteRepairCarService getService()
	{
		if(thisService == null)
			thisService = new WriteRepairCarService();
		return thisService;
	}

	@Override
	public int servRet(List<String> param) throws ServiceException{
		String carid = param.get(0);		
    	dao = DaoCars.getDaoCars();
		Cars car = null;
		try {
			car = dao.get(Integer.parseInt(carid));
			if (car.getCondition()<10) {
				car.setCondition(10);
				dao.saveOrUpdate(car);
				return 1;
			} else {
				return 0;
			}
		} catch (DaoException e) {
			printLog(e,2);
			throw new ServiceException(e);
		}
	}

	@Override
	public List<?> servGet() throws ServiceException{
		DaoCars dao = DaoCars.getDaoCars();
		List<Cars> cars = null;
		try {
			cars = dao.getAll();
			return cars;
		} catch (DaoException e) {
			printLog(e,2);
			throw new ServiceException(e);
		}

	}

}
