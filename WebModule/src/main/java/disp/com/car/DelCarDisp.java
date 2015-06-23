package disp.com.car;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;

import com.ReqDisp;

import disp.serv.car.DelCarService;
import exception.ServiceException;
import exception.WebException;

public class DelCarDisp extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		paramReq = new ArrayList<String>();
		paramReq.add(request.getParameter("carid"));
		BaseService serv = DelCarService.getService();
		try {
			serv.servUpd(paramReq);
		} catch (ServiceException e) {
			request.setAttribute("error", "Приозошла ошибка при удалении!");
			request.setAttribute("link", "/AutoBase/menu/dispatcher/?mode=designate");
			redirect(request,response,"/login/?mode=error",false);
		}
		
		redirect(request,response,"/menu/dispatcher/?mode=showcars",false);
	}

}

