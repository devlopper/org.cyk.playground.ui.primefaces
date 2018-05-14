package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import org.cyk.playground.ui.primefaces.model.Order;
import org.cyk.playground.ui.primefaces.model.OrderItem;
import org.cyk.playground.ui.primefaces.model.movement.MovementAction;
import org.cyk.playground.ui.primefaces.model.movement.MovementCollection;
import org.cyk.playground.ui.primefaces.model.movement.MovementCollectionItem;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.helper.IconHelper;
import org.cyk.utility.common.helper.UniformResourceLocatorHelper;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.form.FormDetail;
import org.cyk.utility.common.userinterface.output.OutputText;

public class IdentifiableConsultPageFormMaster extends org.cyk.ui.web.primefaces.resources.page.controlpanel.IdentifiableConsultPage.FormMaster implements Serializable {
	private static final long serialVersionUID = -6211058744595898478L;
	
	@Override
	protected void __prepare__() {
		super.__prepare__();
		FormDetail detail = getDetail();
		detail.setFieldsObjectFromMaster();
		
		if(Order.class.equals(getPropertiesMap().getActionOnClass())){
			detail.addReadOnly("amount");
			
			/**/
			DataTable dataTable = instanciateDataTable(OrderItem.class,null,null,Boolean.TRUE);
			dataTable.getPropertiesMap().setOnPrepareAddMenuAddCommand(Boolean.FALSE);
			dataTable.addMainMenuNode("add article", IconHelper.Icon.FontAwesome.PLUS, UniformResourceLocatorHelper.getInstance()
					.getStringifier(Constant.Action.CREATE, OrderItem.class).addQueryParameterInstances(detail.getMaster().getObject()))
					._setLabelPropertyValue("add article")
					;
			dataTable.prepare();
			dataTable.build();
			if(((Order)detail.getMaster().getObject()).getAmount() != null)
				((OutputText)dataTable.getColumn("amount").getPropertiesMap().getFooter()).getPropertiesMap().setValue( ((Order)detail.getMaster().getObject()).getAmount() );
		}else if(OrderItem.class.equals(getPropertiesMap().getActionOnClass())){
			detail.add("order").addBreak();
			detail.add("article").addBreak();
			detail.add("quantity").addBreak();
			detail.add("amount").addBreak();	
		}else if(MovementCollection.class.equals(getPropertiesMap().getActionOnClass())){
			detail.addReadOnly("value");
			
			/**/
			DataTable dataTable = instanciateDataTable(MovementCollectionItem.class,null,null,Boolean.TRUE/*,"movementCollection","movementAction","value","previousCumul","cumul"*/);
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
