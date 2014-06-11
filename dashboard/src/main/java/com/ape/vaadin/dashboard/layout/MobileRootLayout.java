package com.ape.vaadin.dashboard.layout;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.ape.vaadin.dashboard.annotation.Layouts.DashboardUI;
import com.ape.vaadin.dashboard.annotation.Layouts.Layout;
import com.ape.vaadin.dashboard.util.enumerations.Layouts;
import com.ape.vaadin.dashboard.util.enumerations.UserInterface;
import com.ape.vaadin.navigation.MainMenu;
import com.vaadin.cdi.UIScoped;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.VerticalLayout;

@UIScoped
@DashboardUI(userInterface = UserInterface.MOBILE)
@Layout(userInterface = UserInterface.MOBILE, layout = Layouts.ROOT)
public class MobileRootLayout extends VerticalLayout implements IRootLayout {
	private static final long serialVersionUID = 1L;
	
	@Inject
	@DashboardUI(userInterface = UserInterface.MOBILE)
	private MainMenu mainNavigation;
	private AbstractLayout navigatorLayout;
	
	@PostConstruct
	private void initLayout() {
		addStyleName("mobile-root");
	}
	
	@Override
	public void attach() {
		super.attach();
		addComponent(this.navigatorLayout);
		addComponent(getMainMenu());
	}
	
	@Override
	public void setNavigatorLayout(AbstractLayout layout) {
		this.navigatorLayout = layout;
	}
	
	@Override
	public MainMenu getMainMenu() {
		return this.mainNavigation;
	}
}
