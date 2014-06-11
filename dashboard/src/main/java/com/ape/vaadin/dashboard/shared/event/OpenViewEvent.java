package com.ape.vaadin.dashboard.shared.event;

import com.ape.vaadin.dashboard.view.IView;

public class OpenViewEvent {
	
	private Class<IView> viewClass;
	private Object[] params;
	
	public OpenViewEvent(Class<IView> viewClass, Object[] params) {
		super();
		this.viewClass = viewClass;
		this.params = params;
	}
	
	public OpenViewEvent(Class<IView> viewClass) {
		super();
		this.viewClass = viewClass;
	}
	
	public Class<IView> getViewClass() {
		return this.viewClass;
	}
	
	public void setViewClazz(Class<IView> viewClass) {
		this.viewClass = viewClass;
	}
	
	public Object[] getParams() {
		return this.params;
	}
	
	public void setParams(Object[] params) {
		this.params = params;
	}
}
