package com.ape.vaadin;

import com.ape.vaadin.commons.cdi.util.CustomCDIViewProvider;
import com.ape.vaadin.dashboard.layout.IRootLayout;
import com.ape.vaadin.navigation.MainMenu;
import com.vaadin.cdi.UIScoped;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@UIScoped
public abstract class AbstractUI extends UI {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 3873158958800732391L;
	
	protected abstract CustomCDIViewProvider getViewProvider();
	
	protected abstract IRootLayout getRootLayout();
	
	@Override
	protected void init(VaadinRequest request) {
		this.getViewProvider().registerViewsForUI(this.getClass());
	}
	
	public MainMenu getMainMenu() {
		return getRootLayout().getMainMenu();
	}
}
