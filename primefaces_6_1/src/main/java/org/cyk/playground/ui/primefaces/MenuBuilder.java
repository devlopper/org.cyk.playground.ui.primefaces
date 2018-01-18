package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import org.cyk.playground.ui.primefaces.model.Article;
import org.cyk.playground.ui.primefaces.model.Locality;
import org.cyk.playground.ui.primefaces.model.LocalityType;
import org.cyk.playground.ui.primefaces.model.Location;
import org.cyk.playground.ui.primefaces.model.LocationType;
import org.cyk.playground.ui.primefaces.model.Order;
import org.cyk.playground.ui.primefaces.model.OrderItem;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.playground.ui.primefaces.model.PhoneNumberType;
import org.cyk.playground.ui.primefaces.model.movement.MovementAction;
import org.cyk.playground.ui.primefaces.model.movement.MovementCollection;
import org.cyk.playground.ui.primefaces.model.movement.MovementCollectionItem;
import org.cyk.utility.common.userinterface.command.Menu;

public class MenuBuilder extends org.cyk.ui.web.primefaces.resources.MenuBuilder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void addNodeIdentifiablesManage(Menu menu) {
		super.addNodeIdentifiablesManage(menu);
		menu.addNode("ui.menu.controlpanel.identifiables.manage.person")
			.addNodeActionListMany(Person.class)
		;
		
		menu.addNode("ui.menu.controlpanel.identifiables.manage.order")
			.addNodeActionListMany(Order.class,OrderItem.class,Article.class,MovementAction.class,MovementCollection.class,MovementCollectionItem.class)
		;
		
		menu.addNode("ui.menu.controlpanel.identifiables.manage.contact")
			.addNodeActionListMany(PhoneNumberType.class,LocationType.class,LocalityType.class,Locality.class,Location.class)
		;
		
		
		
	}
	
}