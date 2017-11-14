package org.cyk.playground.ui.primefaces.page.menu;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.common.userinterface.command.Menu;
import org.cyk.utility.common.userinterface.command.MenuNode;
import org.cyk.utility.common.userinterface.container.Window;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class MenusPage extends Window implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Menu menuBar,tabMenu,panelMenu,slideMenu,breadCrumb;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Menus");
		
		createMenuBar();
		createTabMenu();
		createPanelMenu();
	}
	
	private void createMenuBar(){
		menuBar = __createMenu__(Menu.RenderType.BAR);
	}
	
	private void createTabMenu(){
		tabMenu = __createMenu__(Menu.RenderType.TAB);
	}
	
	private void createPanelMenu(){
		panelMenu = __createMenu__(Menu.RenderType.PANEL);
	}
	
	private Menu __createMenu__(Menu.RenderType renderType){
		Menu menu = new Menu();
		menu.setRenderType(renderType);
		MenuNode menuNode = new MenuNode();
		menuNode.setLabelFromIdentifier("L1");
		menu.addOneChild(menuNode);
		
		menuNode = new MenuNode();
		menuNode.setLabelFromIdentifier("L2");
		menu.addOneChild(menuNode);
		
		MenuNode menuNode3 = new MenuNode();
		menuNode3.setLabelFromIdentifier("L3");
		menu.addOneChild(menuNode3);
		menuNode = new MenuNode();
		menuNode.setLabelFromIdentifier("L31");
		menuNode3.addOneChild(menuNode);
		menuNode = new MenuNode();
		menuNode.setLabelFromIdentifier("L32");
		menuNode3.addOneChild(menuNode);
		MenuNode menuNode33 = new MenuNode();
		menuNode33.setLabelFromIdentifier("L33");
		menuNode3.addOneChild(menuNode33);
		menuNode = new MenuNode();
		menuNode.setLabelFromIdentifier("L331");
		menuNode33.addOneChild(menuNode);
		menuNode = new MenuNode();
		menuNode.setLabelFromIdentifier("L332_Google");
		menuNode.getPropertiesMap().setUrl("http://www.google.com");
		menuNode33.addOneChild(menuNode);
		menuNode = new MenuNode();
		menuNode.setLabelFromIdentifier("L333");
		menuNode33.addOneChild(menuNode);
		menuNode = new MenuNode();
		menuNode.setLabelFromIdentifier("L334");
		menuNode33.addOneChild(menuNode);
		
		menuNode = new MenuNode();
		menuNode.setLabelFromIdentifier("L4");
		menu.addOneChild(menuNode);
		
		menuNode = new MenuNode();
		menuNode.setLabelFromIdentifier("L5");
		menu.addOneChild(menuNode);
		
		menu.build();
		
		return menu;
	}
	
}
