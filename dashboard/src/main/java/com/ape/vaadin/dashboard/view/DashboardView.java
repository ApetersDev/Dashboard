package com.ape.vaadin.dashboard.view;

import javax.enterprise.inject.New;
import javax.inject.Inject;

import com.ape.vaadin.DesktopUI;
import com.ape.vaadin.MobileUI;
import com.ape.vaadin.dashboard.annotation.Menu.MenuEntries;
import com.ape.vaadin.dashboard.annotation.Menu.MenuEntry;
import com.ape.vaadin.navigation.MainMenu;
import com.vaadin.cdi.CDIView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@CDIView(uis = {DesktopUI.class, MobileUI.class})
@MenuEntries(menuEntries = {@MenuEntry(menu = MainMenu.class)})
public class DashboardView extends AbstractView {
	
	private static final long serialVersionUID = 1L;
	public static final String VIEW_ID = "dashboard";
	@Inject
	@New
	private Label label;
	
	@Override
	public void attach() {
		// TODO Auto-generated method stub
		super.attach();
	}
	
	@Override
	protected void createChildren() {
		this.label.setCaption("Dashboard");
	}
	
	@Override
	protected void layoutComponents() {
		VerticalLayout vLayout = new VerticalLayout();
		
		vLayout.addComponent(this.label);
		setCompositionRoot(vLayout);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getViewId() {
		return VIEW_ID;
	}
	
	@Override
	protected boolean isMainMenuItem() {
		return true;
	}
	
}
