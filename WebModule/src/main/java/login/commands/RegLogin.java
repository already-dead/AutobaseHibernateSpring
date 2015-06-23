package login.commands;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.serv.RegService;
import service.BaseService;

import com.ReqDisp;

import exception.ServiceException;
import exception.WebException;

public class RegLogin extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
		paramReq = new ArrayList<String>();
		paramReq.add(request.getParameter("password1"));
		paramReq.add(request.getParameter("password2"));
		paramReq.add(request.getParameter("login"));
		paramReq.add(request.getParameter("role"));
		paramReq.add(request.getParameter("name"));
		paramReq.add(request.getParameter("surname"));
		
		BaseService serv = RegService.getService();
		try {
			int res = serv.servRet(paramReq);
			switch (res)
	        {
	        case 0: {
				request.setAttribute("error", "Пользователь с данным логином уже существует!");
				request.setAttribute("link", "/AutoBase/login/?mode=regshow");
	        	break;
	        }
	        case 1: {
				request.setAttribute("error", "Пользователь успешно создан! Войдите в систему со свои логином и паролем");
				request.setAttribute("link", "/AutoBase/menu/driver/");
	        	break;
	        }
	        case 2: {
				request.setAttribute("error", "Введенные пароли не совпадают!");
				request.setAttribute("link", "/AutoBase/login/?mode=regshow");
	        	break;
	        }
	        default: {
	    		request.setAttribute("error", "Непредвиденная ошибка");
	    		request.setAttribute("link", "/AutoBase/login/?mode=regshow");
	        }      
	        }
			redirect(request,response,"/login/?mode=error",false);
		} catch (ServiceException e) {
    		request.setAttribute("error", "При регистрации произошлав ошибка");
    		request.setAttribute("link", "/AutoBase/login/?mode=regshow");
    		redirect(request,response,"/login/?mode=error",false);
		}
	

	}

}
