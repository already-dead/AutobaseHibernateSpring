package disp.serv.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoCars;
import exception.DaoException;
import exception.ServiceException;
import service.LogService;

@Service("delCarService")
@Transactional
public class DelCarService extends LogService {
	private static DelCarService thisService;
	
	@Autowired
	private DaoCars dao;
	
	public static  DelCarService getService()
	{
		if(thisService == null)
			thisService = new DelCarService();
		return thisService;
	}

	@Override
	public void servUpd(List<String> param) throws ServiceException {
		String carId = param.get(0);	
		dao = DaoCars.getDaoCars();
		try {
			dao.fakeDel(carId);
		} catch (DaoException e) {
			printLog(e,1);
            throw new ServiceException(e);
		}		
	}

}
