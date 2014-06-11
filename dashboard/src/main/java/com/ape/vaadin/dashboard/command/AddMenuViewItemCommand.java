package com.ape.vaadin.dashboard.command;

import com.ape.vaadin.commons.menu.IMenu;
import com.ape.vaadin.commons.menu.IMenuItem;

public class AddMenuViewItemCommand implements ICommand {
	
	private final IMenu menu;
	private final IMenuItem menuEntry;
	
	public AddMenuViewItemCommand(IMenu menu, IMenuItem menuItem) {
		super();
		this.menu = menu;
		this.menuEntry = menuItem;
	}
	
	@Override
	public boolean execute() {
		this.menu.addMenuItem(this.menuEntry);
		return true;
	}
}
