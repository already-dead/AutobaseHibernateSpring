package driver;

import javax.servlet.http.HttpServlet;

import com.Command;

import driver.com.ShowMenuDriver;
import driver.com.car.ShowRepairCarDriver;
import driver.com.car.WriteRepairCarDriver;
import driver.com.designate.ConfirmDesignateDriver;
import driver.com.designate.ShowEditDesignateDriver;
import driver.com.designate.WriteCancelDesignateDriver;
import driver.com.designate.WriteConfirmDesignateDriver;

public class DriverHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Command handler(String mode) {
		if ("repair".equals(mode)) {
			return new ShowRepairCarDriver();
		} else {
		if ("writerepair".equals(mode)) {
			return new WriteRepairCarDriver();
		} else {
		if ("editdesignate".equals(mode)) {
			return new ShowEditDesignateDriver();
		} else {
		if ("cancel".equals(mode)) {
			return new WriteCancelDesignateDriver();
		} else {
		if ("confirm".equals(mode)) {
			return new ConfirmDesignateDriver();
		} else {
		if ("writeconfirm".equals(mode)) {
			return new WriteConfirmDesignateDriver();
		} else {
			return new ShowMenuDriver();
		}}}}}}
		
	}

}
