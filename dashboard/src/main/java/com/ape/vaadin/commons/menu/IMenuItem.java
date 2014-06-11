package com.ape.vaadin.commons.menu;

import com.ape.vaadin.dashboard.view.IView;
import com.vaadin.server.Resource;

public interface IMenuItem {
	public abstract Class<IView> getView();
	
	public String getParentId();
	
	public int getPosition();
	
	public Resource getIcon();
}
