package disp.com.car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;

import com.ReqDisp;

import disp.serv.car.ShowCarsService;
import exception.ServiceException;
import exception.WebException;


public class ShowCarsDisp extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException {	
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		BaseService serv = ShowCarsService.getService();
		try {
			request.setAttribute("list", serv.servGet());
		} catch (ServiceException e) {
			request.setAttribute("error", "При чтении данных произошла ошибка");
			request.setAttribute("link", "/AutoBase/menu/dispatcher/?");
			redirect(request,response,"/login/?mode=error",true);
		}
		
		redirect(request,response,"/WEB-INF/jsp/disp/showCars.jsp",false);
	}

}