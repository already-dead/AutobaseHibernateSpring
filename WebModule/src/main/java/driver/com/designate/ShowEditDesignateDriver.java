package driver.com.designate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;

import com.ReqDisp;

import driver.serv.designate.EditDesignateService;
import exception.ServiceException;
import exception.WebException;

public class ShowEditDesignateDriver extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		String driverId = request.getParameter("id");
		request.setAttribute("driverid", driverId);

		BaseService serv = EditDesignateService.getService();
		try {
			request.setAttribute("list", serv.servGet());
			redirect(request,response,"/WEB-INF/jsp/driver/editDesignate.jsp",false);
		} catch (ServiceException e) {
			request.setAttribute("error", "При чтении данных произошла ошибка");
			request.setAttribute("link", "/AutoBase/menu/driver/?");
			redirect(request,response,"/login/?mode=error",true);
		}

	}

}