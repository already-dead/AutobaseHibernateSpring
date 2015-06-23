package driver.com.designate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ReqDisp;

public class ConfirmDesignateDriver extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {	
		String flightId = request.getParameter("flightid");
		String driverId = request.getParameter("driverid");
		request.setAttribute("driverid", driverId);
		request.setAttribute("flightid", flightId);
		
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		redirect(request,response,"/WEB-INF/jsp/driver/enterCondition.jsp",false);
	}

}