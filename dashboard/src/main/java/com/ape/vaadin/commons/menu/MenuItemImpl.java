package com.ape.vaadin.commons.menu;

import com.ape.vaadin.dashboard.view.IView;
import com.vaadin.server.Resource;

public class MenuItemImpl implements IMenuItem {
	private Class<IView> view;
	private String parentId;
	private int position;
	private Resource icon;
	
	@Override
	public Class<IView> getView() {
		return this.view;
	}
	
	@Override
	public String getParentId() {
		return this.parentId;
	}
	
	@Override
	public int getPosition() {
		return this.position;
	}
	
	@Override
	public Resource getIcon() {
		return this.icon;
	}
	
	public void setView(Class<IView> view) {
		this.view = view;
	}
	
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public void setIcon(Resource icon) {
		this.icon = icon;
	}
	
}
