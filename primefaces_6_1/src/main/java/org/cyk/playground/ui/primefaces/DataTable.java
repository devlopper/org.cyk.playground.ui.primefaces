package org.cyk.playground.ui.primefaces;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.cyk.playground.ui.primefaces.model.Order;
import org.cyk.playground.ui.primefaces.model.OrderItem;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.Constant;

public class DataTable {

	public static class Listener extends org.cyk.ui.web.primefaces.resources.component.DataTable.Listener {
		private static final long serialVersionUID = 1L;
		
		@Override
		public void processColumnsFieldNames(org.cyk.utility.common.userinterface.collection.DataTable dataTable,Collection<String> fieldNames) {
			super.processColumnsFieldNames(dataTable, fieldNames);
			if(Person.class.equals(dataTable.getPropertiesMap().getActionOnClass())){
				fieldNames.add("globalIdentifier.image");
				fieldNames.add("lastnames");
				fieldNames.add("sex");
				fieldNames.add("nationality");
			}else if(Order.class.equals(dataTable.getPropertiesMap().getActionOnClass())){
				if(Constant.Action.LIST.equals(dataTable.getPropertiesMap().getAction()))
					fieldNames.add("amount");
			}else if(OrderItem.class.equals(dataTable.getPropertiesMap().getActionOnClass())){
				if(!(dataTable.getPropertiesMap().getMaster() instanceof Order))
					fieldNames.add("order");
				fieldNames.addAll(Arrays.asList("article.unitPrice","quantity","reduction","amount"));
			}
		}
		
		@Override
		public List<String> getColumnsFieldNamesOrder(org.cyk.utility.common.userinterface.collection.DataTable dataTable) {
			if(Person.class.equals(dataTable.getPropertiesMap().getActionOnClass()))
				return Arrays.asList("globalIdentifier.image","globalIdentifier.name");
			return super.getColumnsFieldNamesOrder(dataTable);
		}
	}
	
}
