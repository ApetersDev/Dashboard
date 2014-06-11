package com.ape.vaadin.commons.menu;

public interface ITreeHierarchyMenu extends IMenuHierarchy {
	
	public abstract void addMenuItem(IMenuItem menuItem, int position, String parentId);
	
}