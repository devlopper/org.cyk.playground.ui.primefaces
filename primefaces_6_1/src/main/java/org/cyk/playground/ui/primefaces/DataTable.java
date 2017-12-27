package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import org.cyk.playground.ui.primefaces.model.Order;
import org.cyk.playground.ui.primefaces.model.OrderItem;
import org.cyk.ui.web.primefaces.resources.page.controlpanel.IdentifiableListPage;

public class DataTable extends IdentifiableListPage.DataTable implements Serializable {
	private static final long serialVersionUID = -6211058744595898478L;
	
	@Override
	protected void __prepare__() {
		super.__prepare__();
		//columns
		if(Order.class.equals(getPropertiesMap().getActionOnClass())){
			addColumnsByFieldNames("amount");	
		}else if(OrderItem.class.equals(getPropertiesMap().getActionOnClass())){
			addColumnsByFieldNames("order","article","amount");
		}
	}
	
}
