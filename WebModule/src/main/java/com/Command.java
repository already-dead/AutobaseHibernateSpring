package com;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.WebException;

public abstract class Command {
	public ArrayList<String> paramReq;
	abstract public void execute(HttpServletRequest request,HttpServletResponse response) throws WebException;
}
