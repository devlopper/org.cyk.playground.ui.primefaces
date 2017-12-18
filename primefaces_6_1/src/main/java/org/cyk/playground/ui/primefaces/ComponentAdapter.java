package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import org.cyk.playground.ui.primefaces.model.AbstractIdentified;
import org.cyk.ui.web.primefaces.resources.LazyDataModel;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.Constant.Action;
import org.cyk.utility.common.userinterface.Component;
import org.cyk.utility.common.userinterface.collection.DataTable;

public class ComponentAdapter extends org.cyk.ui.web.primefaces.resources.ComponentAdapter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public Object build(Component component) {
		Object object = super.build(component);
		if(component instanceof DataTable){
			if(!Constant.Action.isCreateOrUpdate((Action) component.getPropertiesMap().getAction()) && Boolean.TRUE.equals(component.getPropertiesMap().getLazy())){
				component.getPropertiesMap().setValue(new LazyDataModel<AbstractIdentified>(component){
					private static final long serialVersionUID = 1L;
					
					@Override
					protected Boolean isPageable(Integer first, Integer size) {
						return Boolean.TRUE;
					}
					
					@Override
					protected Boolean isSortable(String fieldName) {
						return Boolean.TRUE;
					}
				});
			}
		}
		return object;
	}
	
}
