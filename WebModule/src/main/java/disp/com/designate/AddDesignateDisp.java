package disp.com.designate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;

import com.ReqDisp;

import disp.serv.designate.AddDesignateService;
import exception.ServiceException;
import exception.WebException;

public class AddDesignateDisp extends ReqDisp {
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
		BaseService serv = AddDesignateService.getService();
		
		HashMap<String, List<?>> map;
		try {
			map = serv.servGetMany();
			Set<String> keys = map.keySet();
			Iterator<String> itr = keys.iterator();
			while (itr.hasNext()) {
				String currKey = itr.next();
				request.setAttribute(currKey, map.get(currKey));
			}
		} catch (ServiceException e) {
			request.setAttribute("error", "Приозошла ошибка при добавлении рейса!");
			request.setAttribute("link", "/AutoBase/menu/dispatcher/?");
			redirect(request,response,"/login/?mode=error",false);
		}

		
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		redirect(request,response,"/WEB-INF/jsp/disp/addDesignate.jsp",false);
	}

}
