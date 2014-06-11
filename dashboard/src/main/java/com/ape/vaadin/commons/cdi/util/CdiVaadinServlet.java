package com.ape.vaadin.commons.cdi.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.vaadin.server.Constants;
import com.vaadin.server.VaadinServlet;

@WebServlet(urlPatterns = {"/*", "/VAADIN/*"}, asyncSupported = true, initParams = {
		@WebInitParam(name = Constants.PARAMETER_WIDGETSET, value = "com.ape.vaadin.AppWidgetSet"),
		@WebInitParam(name = Constants.SERVLET_PARAMETER_PRODUCTION_MODE, value = "false"),
		@WebInitParam(name = Constants.SERVLET_PARAMETER_PUSH_MODE, value = "true"),
		@WebInitParam(name = Constants.SERVLET_PARAMETER_UI_PROVIDER, value = "com.vaadin.cdi.CDIUIProvider"),})
public class CdiVaadinServlet extends VaadinServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
}