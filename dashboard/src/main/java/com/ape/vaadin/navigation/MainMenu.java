package com.ape.vaadin.navigation;

import javax.enterprise.inject.New;
import javax.inject.Inject;

import com.ape.vaadin.commons.menu.IMenu;
import com.ape.vaadin.commons.menu.IMenuItem;
import com.ape.vaadin.dashboard.shared.event.OpenViewEvent;
import com.ape.vaadin.dashboard.view.IView;
import com.vaadin.cdi.UIScoped;
import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;

@UIScoped
public class MainMenu extends CustomComponent implements IMenu {
	private static final long serialVersionUID = 1L;
	@Inject
	private javax.enterprise.event.Event<OpenViewEvent> openViewEvent;
	@Inject
	@New
	private Label label;
	
	@Override
	public void attach() {
		super.attach();
		((AbstractLayout) this.getCompositionRoot()).addComponent(new Label("MainMenu"));
	}
	
	@Override
	public void setCompositionRoot(Component compositionRoot) {
		if(getCompositionRoot() == null) {
			if(compositionRoot instanceof AbstractComponentContainer) {
				super.setCompositionRoot(compositionRoot);
			} else {
				// FIXME add Error-Logging to inform, that the compositionRoot is not instance of AbstractLayout
			}
		}
		// FIXME add Logging to inform, that the compositionRoot can only be set onetime
	}
	
	public void addViewButton(final Class<IView> viewClass) {
		
	}
	
	public MainMenu() {
		super();
	}
	
	@Override
	public void addMenuItem(final IMenuItem menuEntry) {
		Button viewButton = new Button(menuEntry.getView().getName(), new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void buttonClick(ClickEvent event) {
				MainMenu.this.openViewEvent.fire(new OpenViewEvent(menuEntry.getView()));
			}
		});
		((AbstractLayout) this.getCompositionRoot()).addComponent(viewButton);
	}
	
}
