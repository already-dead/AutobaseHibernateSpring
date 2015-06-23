package disp.com.designate;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;

import com.ReqDisp;

import disp.serv.designate.AddWriteDesignateService;
import exception.ServiceException;
import exception.WebException;

public class AddWriteDesignateDisp extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException  {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		paramReq = new ArrayList<String>();
		paramReq.add(request.getParameter("date"));
		paramReq.add(request.getParameter("adress"));
		paramReq.add(request.getParameter("driver"));
		paramReq.add(request.getParameter("car"));
		
		BaseService serv = AddWriteDesignateService.getService();
		try {
			serv.servUpd(paramReq);
		} catch (ServiceException e) {
			request.setAttribute("error", "При добавлении заказа произошла ошибка");
			request.setAttribute("link", "/AutoBase/menu/dispatcher/?mode=designate");
			redirect(request,response,"/login/?mode=error",true);
		}
	
		redirect(request,response,"/menu/dispatcher/?mode=designate",true);

	}

}
