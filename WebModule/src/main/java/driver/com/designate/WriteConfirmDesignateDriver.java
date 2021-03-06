package driver.com.designate;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;

import com.ReqDisp;

import driver.serv.designate.WriteConfirmService;
import exception.ServiceException;
import exception.WebException;


public class WriteConfirmDesignateDriver extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		String driverId = request.getParameter("driverid");
		request.setAttribute("driverid", driverId);
		
		paramReq = new ArrayList<String>();
		paramReq.add(request.getParameter("flightid"));
		paramReq.add(request.getParameter("condition"));
		
		BaseService serv = WriteConfirmService.getService();
		try {
			serv.servUpd(paramReq);
			request.setAttribute("list", serv.servGet());
			redirect(request,response,"/WEB-INF/jsp/driver/editDesignate.jsp",false);
		} catch (ServiceException e) {
			request.setAttribute("error", "При подтверждении рейса произпшла ошибка");
			request.setAttribute("link", "/AutoBase/menu/driver/?mode=editdesignate");
			redirect(request,response,"/login/?mode=error",true);
		}
		


	}	
}		