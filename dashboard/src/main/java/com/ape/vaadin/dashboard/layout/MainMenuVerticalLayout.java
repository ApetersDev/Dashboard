package com.ape.vaadin.dashboard.layout;

import javax.enterprise.inject.New;
import javax.inject.Inject;

import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

public class MainMenuVerticalLayout extends VerticalLayout {
	@Inject
	@New
	Tree firstLevelTree;
	
	@Override
	public void attach() {
		// TODO Auto-generated method stub
		super.attach();
		createChildren();
		layoutComponents();
	}
	
	private void layoutComponents() {
		this.addComponent(this.firstLevelTree);
		
	}
	
	private void createChildren() {
		createMenu();
	}
	
	private void createMenu() {
		
	}
}
