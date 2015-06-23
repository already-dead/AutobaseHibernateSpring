package login.commands;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.serv.AuthService;
import service.BaseService;

import com.ReqDisp;

import exception.ServiceException;
import exception.WebException;


public class AuthLogin extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException {	
		paramReq = new ArrayList<String>();
		paramReq.add(request.getParameter("email"));
		paramReq.add(request.getParameter("password"));
		
		BaseService serv = AuthService.getService();
		try {
			int res = serv.servRet(paramReq);
			Integer id = (Integer) serv.servGet().get(0);
			switch (res)
			{
			case 0: {
	    		request.setAttribute("error", "Неверно введены логин и/или пароль");
	    		request.setAttribute("link", "/AutoBase/menu/driver/?id=0");
	    		redirect(request,response,"/login/?mode=error",true);
				break;
			} case 1: {
				request.setAttribute("id", id);
				redirect(request,response,"/menu/dispatcher/",false);
				break;
			} case 2: {
				request.setAttribute("id", id);
				redirect(request,response,"/menu/driver/",false);
				break;
			}
			default: {
	    		request.setAttribute("error", "Произошла непредвиденная ошибка. Попробуйте еще раз");
	    		request.setAttribute("link", "/AutoBase/menu/driver/?id=0");
	    		redirect(request,response,"/login/?mode=error",true);
			}
			}
		} catch (ServiceException e) {
    		request.setAttribute("error", "При авторизации произошла ошибкаа");
    		request.setAttribute("link", "/AutoBase/menu/driver/?id=0");
    		redirect(request,response,"/login/?mode=error",true);
		}
	}

}
