package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import org.cyk.playground.ui.primefaces.page.menu.Session1MenusPage;
import org.cyk.playground.ui.primefaces.page.menu.Session2MenusPage;
import org.cyk.playground.ui.primefaces.page.menu.Session3MenusPage;
import org.cyk.utility.common.userinterface.command.Menu;
import org.cyk.utility.common.userinterface.command.MenuNode;

public class MenuBuilder extends org.cyk.ui.web.primefaces.resources.MenuBuilder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Menu __execute__() {
		Menu menu = super.__execute__();
		
		if(Menu.Type.MAIN.equals(menu.getType())){
			if(componentParent instanceof Session1MenusPage || componentParent instanceof Session2MenusPage || componentParent instanceof Session3MenusPage){
				MenuNode menuNode = new MenuNode();
				menuNode.setLabelFromIdentifier("Session Item 1");
				menu.addOneChild(menuNode);
				
				menuNode = new MenuNode();
				menuNode.setLabelFromIdentifier("Session Item 2");
				menu.addOneChild(menuNode);
				
				if(componentParent instanceof Session1MenusPage){
					menuNode = new MenuNode();
					menuNode.setLabelFromIdentifier("Session I Item");
					menu.addOneChild(menuNode);
				}
				if(componentParent instanceof Session2MenusPage){
					menuNode = new MenuNode();
					menuNode.setLabelFromIdentifier("Session IIa Item");
					menu.addOneChild(menuNode);
					
					menuNode = new MenuNode();
					menuNode.setLabelFromIdentifier("Session IIb Item");
					menu.addOneChild(menuNode);
				}
				if(componentParent instanceof Session3MenusPage){
					menuNode = new MenuNode();
					menuNode.setLabelFromIdentifier("Session III Item");
					menu.addOneChild(menuNode);
				}
			}	
		}else if(Menu.Type.CONTEXT.equals(menu.getType())){
			if(componentParent instanceof Session2MenusPage){
				MenuNode menuNode1 = new MenuNode();
				menuNode1.setLabelFromIdentifier("SCI A ");
				menu.addOneChild(menuNode1);
				
				MenuNode menuNode = new MenuNode();
				menuNode.setLabelFromIdentifier("A1");
				menuNode1.addOneChild(menuNode);
				
				menuNode = new MenuNode();
				menuNode.setLabelFromIdentifier("A2");
				menuNode1.addOneChild(menuNode);
			}
		}
		
		return menu;
	}
	
}