package disp.com.driver;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;

import com.ReqDisp;

import disp.serv.driver.DelDriverService;
import exception.ServiceException;
import exception.WebException;

public class DelDriverDisp extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		paramReq = new ArrayList<String>();
		paramReq.add(request.getParameter("driverid"));
		
		BaseService serv = DelDriverService.getService();
		try {
			serv.servUpd(paramReq);
		} catch (ServiceException e) {
			request.setAttribute("error", "При удалении произошла ошибка!");
			request.setAttribute("link", "/AutoBase/menu/dispatcher/?mode=showdrivers");
			redirect(request,response,"/login/?mode=error",false);
		}

		redirect(request,response,"/menu/dispatcher/?mode=showdrivers",false);

	}

}
