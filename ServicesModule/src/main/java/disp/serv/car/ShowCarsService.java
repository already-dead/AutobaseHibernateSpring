package disp.serv.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import base.BaseDao;
import dao.DaoCars;
import data.Cars;
import exception.DaoException;
import exception.ServiceException;
import service.LogService;

@Service("showCarsService")
@Transactional
public class ShowCarsService extends LogService {
	private static ShowCarsService thisService;
	
	@Autowired
	private BaseDao<Cars> dao;
	
	public static  ShowCarsService getService()
	{
		if(thisService == null)
			thisService = new ShowCarsService();
		return thisService;
	}

	@Override
	public List<?> servGet() throws ServiceException {
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
