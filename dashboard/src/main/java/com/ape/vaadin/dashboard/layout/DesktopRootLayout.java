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
import com.vaadin.ui.CssLayout;

@UIScoped
@DashboardUI(userInterface = UserInterface.DESKTOP)
@Layout(userInterface = UserInterface.DESKTOP, layout = Layouts.ROOT)
public class DesktopRootLayout extends CssLayout implements IRootLayout {
	private static final long serialVersionUID = 1L;
	@Inject
	@DashboardUI(userInterface = UserInterface.DESKTOP)
	private MainMenu mainMenu;
	private AbstractLayout navigatorLayout;
	
	@PostConstruct
	private void initLayout() {
		addStyleName("desktop-root");
	}
	
	@Override
	public void attach() {
		super.attach();
		addComponent(getMainMenu());
		addComponent(this.navigatorLayout);
	}
	
	@Override
	public void setNavigatorLayout(AbstractLayout layout) {
		this.navigatorLayout = layout;
	}
	
	@Override
	public MainMenu getMainMenu() {
		return this.mainMenu;
	}
}
