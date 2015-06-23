package driver.com.car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;

import com.ReqDisp;

import driver.serv.car.RepairCarService;
import exception.ServiceException;
import exception.WebException;

public class ShowRepairCarDriver extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException {	
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		BaseService serv = RepairCarService.getService();
		try {
			request.setAttribute("list", serv.servGet());
		} catch (ServiceException e) {
			request.setAttribute("error", "При чтении данных произошла ошибка");
			request.setAttribute("link", "/AutoBase/menu/driver/?");
			redirect(request,response,"/login/?mode=error",true);
		}

		redirect(request,response,"/WEB-INF/jsp/driver/repairCar.jsp",false);
	}

}