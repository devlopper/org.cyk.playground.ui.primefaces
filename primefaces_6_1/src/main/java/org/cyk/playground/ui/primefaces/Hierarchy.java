package org.cyk.playground.ui.primefaces;

import java.util.Collection;

import org.cyk.playground.ui.primefaces.model.LocalityType;

public class Hierarchy {

	public static class Listener extends org.cyk.ui.web.primefaces.resources.component.Hierarchy.Listener {
		private static final long serialVersionUID = 1L;
		
		@Override
		public void processColumnsFieldNames(org.cyk.utility.common.userinterface.hierarchy.Hierarchy hierarchy,Collection<String> fieldNames) {
			super.processColumnsFieldNames(hierarchy, fieldNames);
			if(LocalityType.class.equals(hierarchy.getPropertiesMap().getActionOnClass())){
				//if(Constant.Action.LIST.equals(hierarchy.getPropertiesMap().getAction()))
				//	fieldNames.add("amount");
			}
			
		}
	}
	
}
