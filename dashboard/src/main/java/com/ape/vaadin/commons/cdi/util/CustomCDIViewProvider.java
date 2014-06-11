package com.ape.vaadin.commons.cdi.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import com.ape.vaadin.dashboard.shared.event.RegisterViewEvent;
import com.ape.vaadin.dashboard.view.IView;
import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.View;
import com.vaadin.ui.UI;

@Default
public class CustomCDIViewProvider extends CDIViewProvider {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private BeanManager beanManager;
	
	@Inject
	private Event<RegisterViewEvent> registerViewEvent;
	
	@SuppressWarnings({"unchecked", "serial"})
	public void registerViewsForUI(Class<? extends UI> uiClass) {
		Set<Bean<?>> viewBeans = this.beanManager.getBeans(View.class, new AnnotationLiteral<Any>() {
		});
		for(Bean<?> bean : viewBeans) {
			List<Class<? extends UI>> uiClasses = Arrays.asList(bean.getBeanClass().getAnnotation(CDIView.class).uis());
			if(uiClasses.contains(uiClass)) {
				this.registerViewEvent.fire(new RegisterViewEvent((Class<IView>) bean.getBeanClass()));
			}
		}
	}
}
