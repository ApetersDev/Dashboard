package com.ape.vaadin.dashboard.view;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;

public abstract class AbstractView extends CustomComponent implements IView {
	
	private static final long serialVersionUID = 1L;
	
	protected abstract void createChildren();
	
	protected abstract void layoutComponents();
	
	protected abstract boolean isMainMenuItem();
	
	@Override
	public void enter(ViewChangeEvent event) {
		createChildren();
		layoutComponents();
	}
	
}
