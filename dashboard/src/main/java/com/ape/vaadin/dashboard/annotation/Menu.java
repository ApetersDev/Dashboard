package com.ape.vaadin.dashboard.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.inject.Stereotype;

import com.ape.vaadin.navigation.MainMenu;
import com.vaadin.ui.AbstractComponent;

public class Menu {
	@Stereotype
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE})
	public @interface MenuEntries {
		public enum PARAMETER {
			MENUENTRIES;
			
			@Override
			public String toString() {
				switch(this) {
					case MENUENTRIES:
						return "menuEntries";
					default:
						return this.name().toLowerCase();
				}
			};
		}
		
		MenuEntry[] menuEntries() default {};
	}
	
	@Stereotype
	@Retention(RetentionPolicy.RUNTIME)
	@Target({})
	public @interface MenuEntry {
		
		public Class<? extends AbstractComponent> menu() default MainMenu.class;
		
		public String parentId() default "";
		
		public int position() default 0;
	}
}
