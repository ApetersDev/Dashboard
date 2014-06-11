package com.ape.vaadin.commons.cdi.producer;

import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

import com.ape.vaadin.dashboard.annotation.Layouts.Layout;
import com.ape.vaadin.dashboard.layout.MainMenuVerticalLayout;
import com.ape.vaadin.dashboard.util.enumerations.Layouts;
import com.ape.vaadin.dashboard.util.enumerations.UserInterface;
import com.vaadin.addon.responsive.Responsive;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

public class LayoutProducer {
	@Produces
	@Layout(userInterface = UserInterface.DESKTOP, layout = Layouts.NAVIGATOR_LAYOUT)
	public AbstractLayout initDesktopNavigatorLayout(@New final CssLayout layout) {
		layout.addStyleName("desktop-navigator");
		layout.addComponent(new Label("Desktop"));
		layout.setWidth(100, Unit.PERCENTAGE);
		new Responsive(layout);
		return layout;
	}
	
	@Produces
	@Layout(userInterface = UserInterface.MOBILE, layout = Layouts.NAVIGATOR_LAYOUT)
	public AbstractLayout initMobileNavigatorLayout(@New final CssLayout layout) {
		layout.addStyleName("mobile-navigator");
		layout.addComponent(new Label("Mobile"));
		return layout;
	}
	
	@Produces
	@Layout(userInterface = UserInterface.MOBILE, layout = Layouts.MAIN_MENU)
	public AbstractLayout initMobileMainMenuLayout(@New final CssLayout layout) {
		layout.addStyleName("mobile-main-menu-layout");
		return layout;
	}
	
	@Produces
	@Layout(userInterface = UserInterface.DESKTOP, layout = Layouts.MAIN_MENU)
	public AbstractLayout initDesktopMainMenuLayout(@New final MainMenuVerticalLayout layout) {
		layout.addStyleName("desktop-main-menu-layout");
		return layout;
	}
}
