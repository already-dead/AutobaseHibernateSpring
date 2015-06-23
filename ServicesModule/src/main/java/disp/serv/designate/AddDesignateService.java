package disp.serv.designate;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoCars;
import dao.DaoUserDetail;
import data.Cars;
import data.UserDetail;
import exception.DaoException;
import exception.ServiceException;
import service.LogService;

@Service("addDesignateService")
@Transactional
public class AddDesignateService extends LogService {
	private static AddDesignateService thisService;
	
	@Autowired
	private DaoCars daoC;
	
	@Autowired
	private DaoUserDetail dao;
	
	public static  AddDesignateService getService()
	{
		if(thisService == null)
			thisService = new AddDesignateService();
		return thisService;
	}
	
	@Override
	public HashMap<String, List<?>> servGetMany() throws ServiceException {
		HashMap<String, List<?>> map = new HashMap<String, List<?>>();
    	dao = DaoUserDetail.getDaoUserDetail();
    	daoC = DaoCars.getDaoCars();
		List<Cars> cars = null;
		List<UserDetail> drivers = null;
		try {
			drivers = dao.getDrivers();
			map.put("drivers", drivers);
			cars = daoC.getAll();
			map.put("cars", cars);
			return map;
		} catch (DaoException e) {
			printLog(e,2);
			throw new ServiceException(e);
		}
	}


}
