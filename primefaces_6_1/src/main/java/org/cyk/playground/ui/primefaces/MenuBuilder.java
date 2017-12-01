package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import org.cyk.playground.ui.primefaces.model.Locality;
import org.cyk.playground.ui.primefaces.model.LocalityType;
import org.cyk.playground.ui.primefaces.model.Location;
import org.cyk.playground.ui.primefaces.model.LocationType;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.playground.ui.primefaces.model.PhoneNumberType;
import org.cyk.utility.common.userinterface.command.Menu;

public class MenuBuilder extends org.cyk.ui.web.primefaces.resources.MenuBuilder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Menu __execute__() {
		Menu menu = super.__execute__();
		
		if(Menu.Type.MAIN.equals(menu.getType())){
			//menu.addNode("person.list")._setPropertyUrl(Constant.Action.LIST, Person.class);
		/*
			menu.addNode("person.list")._setPropertyUrl(Constant.Action.LIST, Person.class);
			menu.addNode("phonenumbertype.list")._setPropertyUrl(Constant.Action.LIST, PhoneNumberType.class);
			menu.addNode("locationtype.list")._setPropertyUrl(Constant.Action.LIST, LocationType.class);
			menu.addNode("location.list")._setPropertyUrl(Constant.Action.LIST, Location.class);
			
			MenuNode menuNode = null;
			
			if(componentParent instanceof Session1MenusPage || componentParent instanceof Session2MenusPage || componentParent instanceof Session3MenusPage){
				menuNode = new MenuNode();
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
			*/
		}else if(Menu.Type.CONTEXT.equals(menu.getType())){
			/*
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
			*/
		}
		
		return menu;
	}
	
	@Override
	protected void addNodeIdentifiablesManage(Menu menu) {
		super.addNodeIdentifiablesManage(menu);
		menu.addNode("ui.menu.controlpanel.identifiables.manage.person")
			.addNodeActionListMany(Person.class)
		;
		
		menu.addNode("ui.menu.controlpanel.identifiables.manage.contact")
			.addNodeActionListMany(PhoneNumberType.class,LocationType.class,LocalityType.class,Locality.class)
		;
		
		menu.addNode("ui.menu.controlpanel.identifiables.manage.other")
			.addNodeActionListMany(Location.class)
		;
		
	}
	
}