package com.ape.vaadin.dashboard.layout;

import com.ape.vaadin.navigation.MainMenu;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Component;

public interface IRootLayout extends Component {
	public abstract MainMenu getMainMenu();
	
	public abstract void setNavigatorLayout(AbstractLayout layout);
	
}
