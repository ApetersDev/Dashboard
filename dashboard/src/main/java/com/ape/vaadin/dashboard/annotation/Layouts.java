package com.ape.vaadin.dashboard.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import com.ape.vaadin.dashboard.util.enumerations.UserInterface;

public class Layouts {
	
	@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Qualifier
	public @interface DashboardUI {
		UserInterface userInterface() default UserInterface.DESKTOP;
	}
	
	@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Qualifier
	public @interface Layout {
		UserInterface userInterface() default UserInterface.DESKTOP;
		
		com.ape.vaadin.dashboard.util.enumerations.Layouts layout();
	}
}
