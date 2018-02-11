package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import org.cyk.playground.ui.primefaces.model.Article;
import org.cyk.playground.ui.primefaces.model.Order;
import org.cyk.playground.ui.primefaces.model.OrderItem;
import org.cyk.playground.ui.primefaces.model.movement.MovementAction;
import org.cyk.playground.ui.primefaces.model.movement.MovementCollection;
import org.cyk.playground.ui.primefaces.model.movement.MovementCollectionItem;
import org.cyk.utility.common.userinterface.command.Menu;

public class MenuBuilderDyanour extends org.cyk.ui.web.primefaces.resources.MenuBuilder implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Override
	protected void addNodeIdentifiablesManage(Menu menu) {
		super.addNodeIdentifiablesManage(menu);
		menu.addNode("Ventes")
			.addNodeActionListMany(Order.class,OrderItem.class,Article.class,MovementAction.class,MovementCollection.class,MovementCollectionItem.class)
		;
		
		menu.addNode("Clients")
			.addNodeActionListMany(Order.class,OrderItem.class,Article.class,MovementAction.class,MovementCollection.class,MovementCollectionItem.class)
		;
		
		menu.addNode("Articles")
			.addNodeActionListMany(Order.class,OrderItem.class,Article.class,MovementAction.class,MovementCollection.class,MovementCollectionItem.class)
		;
		
		menu.addNode("Cloture")
			.addNodeActionListMany(Order.class,OrderItem.class,Article.class,MovementAction.class,MovementCollection.class,MovementCollectionItem.class)
		;
		
		menu.addNode("Achats")
			.addNodeActionListMany(Order.class,OrderItem.class,Article.class,MovementAction.class,MovementCollection.class,MovementCollectionItem.class)
		;
		
		menu.addNode("Utilisateurs")
			.addNodeActionListMany(Order.class,OrderItem.class,Article.class,MovementAction.class,MovementCollection.class,MovementCollectionItem.class)
		;
		
	}
	
}
