package disp.com.car;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;

import com.ReqDisp;

import disp.serv.car.AddWriteCarService;
import exception.ServiceException;
import exception.WebException;

public class AddWriteCarDisp extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException  {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		paramReq = new ArrayList<String>();
		paramReq.add(request.getParameter("brand"));
		paramReq.add(request.getParameter("model"));
		paramReq.add(request.getParameter("regNumber"));
		paramReq.add(request.getParameter("condition"));
		
		BaseService serv = AddWriteCarService.getService();
		try {
			serv.servUpd(paramReq);
		} catch (ServiceException e) {
			request.setAttribute("error", "При добавлении автомобиля произошла ошибка");
			request.setAttribute("link", "/AutoBase/menu/dispatcher/?mode=showcars");
			redirect(request,response,"/login/?mode=error",true);
		}
		
		redirect(request,response,"/menu/dispatcher/?mode=showcars",true);
	}

}
