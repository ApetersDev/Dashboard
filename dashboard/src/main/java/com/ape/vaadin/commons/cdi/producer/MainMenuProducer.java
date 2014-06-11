package com.ape.vaadin.commons.cdi.producer;

import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.ape.vaadin.dashboard.annotation.Layouts.DashboardUI;
import com.ape.vaadin.dashboard.annotation.Layouts.Layout;
import com.ape.vaadin.dashboard.util.enumerations.Layouts;
import com.ape.vaadin.dashboard.util.enumerations.UserInterface;
import com.ape.vaadin.navigation.MainMenu;
import com.vaadin.cdi.UIScoped;
import com.vaadin.ui.AbstractLayout;

public class MainMenuProducer {
	
	@Inject
	private MainMenu mainMenu;
	
	@Produces
	@DashboardUI(userInterface = UserInterface.DESKTOP)
	public MainMenu initDesktopMainNavigation(@Layout(userInterface = UserInterface.DESKTOP, layout = Layouts.MAIN_MENU) AbstractLayout mainMenuLayout) {
		mainMenu.addStyleName("desktop-main-navigation");
		mainMenu.setCompositionRoot(mainMenuLayout);
		return mainMenu;
	}
	
	@Produces
	@DashboardUI(userInterface = UserInterface.MOBILE)
	public MainMenu initMobileNavigatorLayout( @Layout(userInterface = UserInterface.MOBILE, layout = Layouts.MAIN_MENU) AbstractLayout mainMenuLayout) {
		mainMenu.addStyleName("mobile-main-navigation");
		mainMenu.setCompositionRoot(mainMenuLayout);
		return mainMenu;
	}
}
