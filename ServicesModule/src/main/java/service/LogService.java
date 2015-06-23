package service;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exception.ServiceException;

@Service("logService")
@Transactional
public class LogService extends BaseService {
	private static Logger log = Logger.getLogger(LogService.class);
	
	public void printLog(Exception e, int code) {
		String message;
        switch (code)
        {
        case 1: {
        	message = "Возникла ошибка при удалении данных: ";
        	break;
        } case 2: {
        	message = "Возникла ошибка при добавлении данных: ";
        	break;
        } case 3: {
        	message = "Возникла ошибка при чтении данных: ";
        	break;
        } case 4: {
        	message = "Ошибка при авторизации ";
        	break;
        } case 5: {
        	message = "Ошибка при регистрации нового пользователя: ";
        	break;
        }
        default: message = "Непредвиденная ошибка: ";
        }  
        log.error(message+e);
	}

	@Override
	public void servUpd(List<String> param) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public int servRet(List<String> param) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<?> servGet() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, List<?>> servGetMany() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
