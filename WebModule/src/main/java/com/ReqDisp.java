package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import exception.WebException;


public class ReqDisp extends Command{
	private static Logger log = Logger.getLogger(ReqDisp.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws WebException {
		// TODO Auto-generated method stub
	}
	
	public void redirect(HttpServletRequest request, HttpServletResponse response, String str, Boolean inc) {
		RequestDispatcher dispatcher = request.getRequestDispatcher(str);
		try {
			if (inc)
				dispatcher.include(request, response);
			else
				dispatcher.forward(request, response);
		} catch (ServletException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
	}


}
