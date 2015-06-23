package driver.com;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ReqDisp;

public class ShowMenuDriver extends ReqDisp {
	private boolean ex = false;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {	
		
		for (Enumeration<String> names = request.getAttributeNames(); names.hasMoreElements() ;) {
	         if(names.nextElement().equals("id")) {
	        	 ex = true;
	        	 break;
	         }
	     }	
		if (ex==false) { 
			String id = request.getParameter("id");
			request.setAttribute("id", id);
		}
		
		redirect(request,response,"/WEB-INF/jsp/driver/driverMenu.jsp",false);
	}

}
