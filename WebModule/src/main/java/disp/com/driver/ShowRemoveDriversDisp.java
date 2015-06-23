package disp.com.driver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;

import com.ReqDisp;

import disp.serv.driver.ShowRemoveDriversService;
import exception.ServiceException;
import exception.WebException;


public class ShowRemoveDriversDisp extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		BaseService serv = ShowRemoveDriversService.getService();
		try {
			request.setAttribute("list", serv.servGet());
		} catch (ServiceException e) {
			request.setAttribute("error", "При чтении данных произошла ошибка");
			request.setAttribute("link", "/AutoBase/menu/dispatcher/?");
			redirect(request,response,"/login/?mode=error",true);
		}
		
		redirect(request,response,"/WEB-INF/jsp/disp/removeDriver.jsp",false);
	}

}
