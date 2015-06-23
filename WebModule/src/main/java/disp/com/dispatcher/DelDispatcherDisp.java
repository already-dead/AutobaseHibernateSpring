package disp.com.dispatcher;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;

import com.ReqDisp;

import disp.serv.dispatcher.DelDispatcherService;
import exception.ServiceException;
import exception.WebException;

public class DelDispatcherDisp extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		paramReq = new ArrayList<String>();
		paramReq.add(request.getParameter("dispid"));
		
		BaseService serv = DelDispatcherService.getService();
		try {
			serv.servUpd(paramReq);
		} catch (ServiceException e) {
			request.setAttribute("error", "При удалении диспетчера произошла ошибка!");
			request.setAttribute("link", "/AutoBase/menu/dispatcher/?mode=showdisp");
			redirect(request,response,"/login/?mode=error",false);
		}
	
		redirect(request,response,"/menu/dispatcher/?mode=showdisp",false);

	}

}
