package com.ape.vaadin.dashboard.view;

import javax.enterprise.inject.New;
import javax.inject.Inject;

import com.ape.vaadin.DesktopUI;
import com.ape.vaadin.dashboard.annotation.Menu.MenuEntries;
import com.ape.vaadin.dashboard.annotation.Menu.MenuEntry;
import com.ape.vaadin.navigation.MainMenu;
import com.vaadin.addon.calendar.ui.Calendar;
import com.vaadin.cdi.CDIView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@CDIView(value = TrainingScheduleView.VIEW_ID, uis = {DesktopUI.class})
@MenuEntries(menuEntries = {@MenuEntry(menu = MainMenu.class, position = 1)})
public class TrainingScheduleView extends AbstractView {
	
	private static final long serialVersionUID = 1L;
	public static final String VIEW_ID = "trainingschedule";
	@Inject
	@New
	private Label label;
	
	@Inject
	@New
	Calendar calendar;
	
	@Override
	public void attach() {
		// TODO Auto-generated method stub
		super.attach();
	}
	
	@Override
	protected void createChildren() {
		this.label.setValue("Trainingschedule");
	}
	
	@Override
	protected void layoutComponents() {
		VerticalLayout vLayout = new VerticalLayout();
		
		vLayout.addComponent(this.label);
		vLayout.addComponent(this.calendar);
		setCompositionRoot(vLayout);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getViewId() {
		// TODO Auto-generated method stub
		return VIEW_ID;
	}
	
	@Override
	protected boolean isMainMenuItem() {
		return false;
	}
	
}
