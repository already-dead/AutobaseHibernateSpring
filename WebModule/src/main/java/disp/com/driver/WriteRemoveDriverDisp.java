package disp.com.driver;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;

import com.ReqDisp;

import disp.serv.driver.RemoveWriteDriverService;
import exception.ServiceException;
import exception.WebException;

public class WriteRemoveDriverDisp extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		paramReq = new ArrayList<String>();
		paramReq.add(request.getParameter("driverid"));
		
		BaseService serv = RemoveWriteDriverService.getService();
		try {
			serv.servUpd(paramReq);
		} catch (ServiceException e) {
			request.setAttribute("error", "При отстранении водителя возникла ошибка!");
			request.setAttribute("link", "/AutoBase/menu/dispatcher/?mode=remove");
			redirect(request,response,"/login/?mode=error",true);
		}

		redirect(request,response,"/menu/dispatcher/?mode=remove",true);

	}

}
