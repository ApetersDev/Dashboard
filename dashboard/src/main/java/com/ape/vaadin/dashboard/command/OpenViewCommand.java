package com.ape.vaadin.dashboard.command;

import com.vaadin.navigator.Navigator;

public class OpenViewCommand implements ICommand {
	
	private Navigator navigator;
	private final String navigationState;
	
	public OpenViewCommand(Navigator navigator, String navigationState) {
		super();
		this.navigator = navigator;
		this.navigationState = navigationState;
	}
	
	@Override
	public boolean execute() {
		this.navigator.navigateTo(this.navigationState);
		return true;
	}
	
	public Navigator getNavigator() {
		return this.navigator;
	}
	
	public void setNavigator(Navigator navigator) {
		this.navigator = navigator;
	}
	
}
