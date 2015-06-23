package login.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ReqDisp;


public class RegShowLogin extends ReqDisp {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		redirect(request,response,"/WEB-INF/html/reg.jsp",false);
	}

}
