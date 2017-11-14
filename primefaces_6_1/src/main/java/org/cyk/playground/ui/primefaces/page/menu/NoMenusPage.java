package org.cyk.playground.ui.primefaces.page.menu;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.common.userinterface.command.Menu;
import org.cyk.utility.common.userinterface.container.Window;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class NoMenusPage extends Window implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("No Menus");
		
	}
	
	@Override
	protected Menu createMainMenu() {
		return null;
	}
	
	@Override
	protected Menu createContextMenu() {
		return null;
	}
	
}
