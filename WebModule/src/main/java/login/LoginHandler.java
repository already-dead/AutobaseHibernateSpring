package login;

import javax.servlet.http.HttpServlet;

import login.commands.AuthLogin;
import login.commands.ErrorLogin;
import login.commands.RegLogin;
import login.commands.RegShowLogin;

import com.Command;

public class LoginHandler extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public Command handler(String mode) {
		if ("reg".equals(mode)) {
			return new RegLogin();
		} else {
		if ("regshow".equals(mode)) {
			return new RegShowLogin();
		} else {
		if ("error".equals(mode)) {
			return new ErrorLogin();
		} else {
			return new AuthLogin();
		}}}
	}

}
