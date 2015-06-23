package driver.com.car;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseService;

import com.ReqDisp;

import driver.serv.car.WriteRepairCarService;
import exception.ServiceException;
import exception.WebException;


public class WriteRepairCarDriver extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		paramReq = new ArrayList<String>();
		paramReq.add(request.getParameter("carid"));
		
		BaseService serv = WriteRepairCarService.getService();
		try {
			int res = serv.servRet(paramReq);
			if (res==1) {
				request.setAttribute("list", serv.servGet());
				redirect(request,response,"/WEB-INF/jsp/driver/repairCar.jsp",false);
			} else {
				request.setAttribute("error", "Автомобиль не нуждается в ремонте");
				request.setAttribute("link", "/AutoBase/menu/driver/?mode=repair");
				redirect(request,response,"/login/?mode=error",false);
			}
		} catch (ServiceException e) {
	        request.setAttribute("error", "При ремонте автомобиля произошла ошибка"); 		
			request.setAttribute("link", "/AutoBase/menu/driver/?mode=repair");
			redirect(request,response,"/login/?mode=error",false);
		}
		
	}

}
