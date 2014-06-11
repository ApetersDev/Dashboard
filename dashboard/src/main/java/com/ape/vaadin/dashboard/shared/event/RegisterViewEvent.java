package com.ape.vaadin.dashboard.shared.event;

import com.ape.vaadin.dashboard.view.IView;
import com.vaadin.navigator.View;


public class RegisterViewEvent {


	private Class<IView>viewClass;
	
	public RegisterViewEvent(Class<IView> clazz) {
		super();
		this.viewClass = clazz;
	}

	public Class<IView> getViewClass() {
		return viewClass;
	}

	public void setViewClass(Class<IView> viewClass) {
		this.viewClass = viewClass;
	}
	

	
}
