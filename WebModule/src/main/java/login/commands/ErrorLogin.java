package login.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ReqDisp;

public class ErrorLogin extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		request.setAttribute("id",id);
		
		redirect(request,response,"/WEB-INF/jsp/error/error.jsp",true);
		
	}

}
