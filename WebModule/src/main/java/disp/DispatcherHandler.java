package disp;

import javax.servlet.http.HttpServlet;

import com.Command;

import disp.com.ShowMenuDisp;
import disp.com.car.AddCarDisp;
import disp.com.car.AddWriteCarDisp;
import disp.com.car.DelCarDisp;
import disp.com.car.ShowCarsDisp;
import disp.com.designate.AddDesignateDisp;
import disp.com.designate.AddWriteDesignateDisp;
import disp.com.designate.DelDesignateDisp;
import disp.com.designate.ShowDesignateDriversDisp;
//import disp.com.dispatcher.AddDispatcherDisp;
//import disp.com.dispatcher.AddWriteDispatcherDisp;
import disp.com.dispatcher.DelDispatcherDisp;
import disp.com.dispatcher.ShowDispatchersDisp;
//import disp.com.driver.AddDriverDisp;
//import disp.com.driver.AddWriteDriverDisp;
import disp.com.driver.DelDriverDisp;
import disp.com.driver.ShowDriversDisp;
import disp.com.driver.ShowRemoveDriversDisp;
import disp.com.driver.WriteRemoveDriverDisp;



public class DispatcherHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Command handler(String mode) {
		if ("remove".equals(mode))
			return new ShowRemoveDriversDisp();
		if ("removewrite".equals(mode))
			return new WriteRemoveDriverDisp();
		if ("designate".equals(mode))
			return new ShowDesignateDriversDisp();
		if ("adddesignate".equals(mode))
			return new AddDesignateDisp();
		if ("addwritedesignate".equals(mode))
			return new AddWriteDesignateDisp();
		if ("deldesignate".equals(mode))
			return new DelDesignateDisp();
		if ("showcars".equals(mode))
			return new ShowCarsDisp();
		if ("addcar".equals(mode))
			return new AddCarDisp();
		if ("addwritecar".equals(mode))
			return new AddWriteCarDisp();
		if ("delcar".equals(mode))
			return new DelCarDisp();
		if ("showdrivers".equals(mode))
			return new ShowDriversDisp();
		if ("deldriver".equals(mode))
			return new DelDriverDisp();
		if ("showdisp".equals(mode))
			return new ShowDispatchersDisp();
		if ("deldisp".equals(mode))
			return new DelDispatcherDisp();
		return new ShowMenuDisp();
	}
}
