package com.ape.vaadin;

import javax.inject.Inject;

import com.ape.vaadin.commons.cdi.util.CustomCDIViewProvider;
import com.ape.vaadin.dashboard.annotation.Layouts.Layout;
import com.ape.vaadin.dashboard.layout.IRootLayout;
import com.ape.vaadin.dashboard.ui.controller.ViewController;
import com.ape.vaadin.dashboard.util.enumerations.Layouts;
import com.ape.vaadin.dashboard.util.enumerations.UserInterface;
import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.AbstractLayout;

@Theme("desktoptheme")
@SuppressWarnings("serial")
@CDIUI(value="desktop")
public class DesktopUI extends AbstractUI {

	@Inject
	@Layout(userInterface = UserInterface.DESKTOP, layout = Layouts.NAVIGATOR_LAYOUT)
	private AbstractLayout navigatorLayout;
	
	@Inject
	private CustomCDIViewProvider viewProvider;
	
	@Inject
	@Layout(userInterface = UserInterface.DESKTOP, layout = Layouts.ROOT)
	private IRootLayout rootLayout;
	
	@SuppressWarnings("unused")
	@Inject
	private ViewController viewController;
	
	@Override
	protected void init(VaadinRequest request) {
		Navigator navigator = new Navigator(DesktopUI.this, this.navigatorLayout);
		navigator.addProvider(getViewProvider());
		setNavigator(navigator);
		this.rootLayout.setNavigatorLayout(this.navigatorLayout);
		setContent(this.rootLayout);
		super.init(request);
	}
	
	@Override
	protected CustomCDIViewProvider getViewProvider() {
		return this.viewProvider;
	}
	
	@Override
	protected IRootLayout getRootLayout() {
		return this.rootLayout;
	}	
}
