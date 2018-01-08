package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import org.cyk.playground.ui.primefaces.model.Article;
import org.cyk.playground.ui.primefaces.model.Order;
import org.cyk.playground.ui.primefaces.model.OrderItem;
import org.cyk.playground.ui.primefaces.model.movement.MovementAction;
import org.cyk.playground.ui.primefaces.model.movement.MovementCollection;
import org.cyk.playground.ui.primefaces.model.movement.MovementCollectionItem;
import org.cyk.ui.web.primefaces.resources.page.controlpanel.IdentifiableConsultPage;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.helper.IconHelper;
import org.cyk.utility.common.helper.RandomHelper;
import org.cyk.utility.common.helper.UniformResourceLocatorHelper;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.command.Menu;
import org.cyk.utility.common.userinterface.container.Form;

public class IdentifiableConsultPageFormMaster extends IdentifiableConsultPage.FormMaster implements Serializable {
	private static final long serialVersionUID = -6211058744595898478L;
	
	@Override
	protected void __prepare__() {
		super.__prepare__();
		Form.Detail detail = getDetail();
		detail.setFieldsObjectFromMaster();
		
		if(Order.class.equals(getPropertiesMap().getActionOnClass())){
			detail.addReadOnly("amount");
			
			/**/
			DataTable dataTable = instanciateDataTable(OrderItem.class,null,null,Boolean.TRUE/*,"order","article.globalIdentifier.name","article.unitPrice","quantity","reduction","amount"*/);
			dataTable.getPropertiesMap().setOnPrepareAddMenu(Boolean.TRUE);
			dataTable.getPropertiesMap().setOnPrepareAddColumnAction(true);
			dataTable.prepare();
			dataTable.build();
			
			Menu menu = (Menu) dataTable.getPropertiesMap().getMainMenu();
			menu.addNode("add article")._setPropertyUrl(Constant.Action.CREATE, OrderItem.class
					,Order.class,((Order)detail.getMaster().getObject()).getCode()
					,Article.class,RandomHelper.getInstance().getElement(Article.COLLECTION).getCode()
					)
				._setPropertyIcon(IconHelper.Icon.FontAwesome.PLUS);
			
			menu.build();
		}else if(OrderItem.class.equals(getPropertiesMap().getActionOnClass())){
			detail.add("order").addBreak();
			detail.add("article").addBreak();
			detail.add("quantity").addBreak();
			detail.add("amount").addBreak();	
		}else if(MovementCollection.class.equals(getPropertiesMap().getActionOnClass())){
			detail.addReadOnly("value");
			
			/**/
			DataTable dataTable = instanciateDataTable(MovementCollectionItem.class,null,null,Boolean.TRUE/*,"movementCollection","movementAction","value","previousCumul","cumul"*/);
			dataTable.getPropertiesMap().setOnPrepareAddMenu(Boolean.TRUE);
			dataTable.getPropertiesMap().setOnPrepareAddColumnAction(true);
			dataTable.getPropertiesMap().setOnPrepareAddMenuAddCommand(Boolean.FALSE);
			
			MovementAction movementAction = MovementAction.IN;
			dataTable.addMainMenuNode(movementAction.getName(), IconHelper.Icon.FontAwesome.PLUS, UniformResourceLocatorHelper.getInstance()
					.getStringifier(Constant.Action.CREATE, MovementCollectionItem.class).addQueryParameterInstances(detail.getMaster().getObject(),movementAction))
					._setLabelPropertyValue(movementAction.getName())
					;
			
			movementAction = MovementAction.OUT;
			dataTable.addMainMenuNode(movementAction.getName(), IconHelper.Icon.FontAwesome.MINUS, UniformResourceLocatorHelper.getInstance()
					.getStringifier(Constant.Action.CREATE, MovementCollectionItem.class).addQueryParameterInstances(detail.getMaster().getObject(),movementAction))
					._setLabelPropertyValue(movementAction.getName())
					;
			
			dataTable.prepare();
			dataTable.build();
			
		}
		
	}
	
}
