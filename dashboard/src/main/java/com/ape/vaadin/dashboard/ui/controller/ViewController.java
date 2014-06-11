package com.ape.vaadin.dashboard.ui.controller;

import java.util.List;

import javax.enterprise.event.Observes;

import com.ape.vaadin.AbstractUI;
import com.ape.vaadin.commons.cdi.util.CustomAnnotationUtil;
import com.ape.vaadin.commons.menu.IMenu;
import com.ape.vaadin.commons.menu.MenuItemImpl;
import com.ape.vaadin.dashboard.annotation.Menu.MenuEntries;
import com.ape.vaadin.dashboard.annotation.Menu.MenuEntry;
import com.ape.vaadin.dashboard.command.AddMenuViewItemCommand;
import com.ape.vaadin.dashboard.command.OpenViewCommand;
import com.ape.vaadin.dashboard.shared.event.OpenViewEvent;
import com.ape.vaadin.dashboard.shared.event.RegisterViewEvent;
import com.ape.vaadin.navigation.MainMenu;
import com.vaadin.cdi.CDIView;
import com.vaadin.ui.UI;

public class ViewController {
	
	public void listenRegisterViewEvent(@Observes RegisterViewEvent registerViewEvent) {
		List<MenuEntry> menus = CustomAnnotationUtil.valuesOfClassAnnotationParamater(registerViewEvent.getViewClass(), MenuEntries.class,
				MenuEntries.PARAMETER.MENUENTRIES.toString(), MenuEntry.class);
		for(MenuEntry menuEntry : menus) {
			IMenu menu = null;
			MenuItemImpl menuEntryImpl = new MenuItemImpl();
			menuEntryImpl.setParentId(menuEntry.parentId());
			menuEntryImpl.setView(registerViewEvent.getViewClass());
			menuEntryImpl.setPosition(menuEntry.position());
			if(menuEntry.menu().equals(MainMenu.class)) {
				AbstractUI currentUi = (AbstractUI) UI.getCurrent();
				menu = currentUi.getMainMenu();
			}
			
			if(menu != null) {
				new AddMenuViewItemCommand(menu, menuEntryImpl).execute();
			}
		}
		
	}
	
	public void listenOpenViewEvent(@Observes OpenViewEvent openViewEvent) {
		String navigationState = "";
		try {
			navigationState = CustomAnnotationUtil.valueOfClassAnnotationParamater(openViewEvent.getViewClass(), CDIView.class, "value", String.class);
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new OpenViewCommand(UI.getCurrent().getNavigator(), navigationState).execute();
	}
}
