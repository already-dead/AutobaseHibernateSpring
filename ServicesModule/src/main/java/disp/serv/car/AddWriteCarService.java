package disp.serv.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoCars;
import data.Cars;
import exception.DaoException;
import exception.ServiceException;
import service.LogService;

@Service("addWriteCarService")
@Transactional
public class AddWriteCarService extends LogService {
	private static AddWriteCarService thisService;
	
	@Autowired
	private DaoCars dao;
	
	public static  AddWriteCarService getService()
	{
		if(thisService == null)
			thisService = new AddWriteCarService();
		return thisService;
	}

	@Override
	public void servUpd(List<String> param) throws ServiceException {
		Cars car = new Cars();
		dao = DaoCars.getDaoCars();

		try {
			car.setBrand(param.get(0));
			car.setModel(param.get(1));
			car.setRegNumber(param.get(2));
			car.setCondition(Integer.valueOf(param.get(3)));		
			dao.saveOrUpdate(car);
        } catch (DaoException e) {
        	printLog(e,2);
        	throw new ServiceException(e);
        }
		
	}

}
