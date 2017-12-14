package org.cyk.playground.ui.primefaces;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.playground.ui.primefaces.model.PhoneNumberType;
import org.cyk.ui.web.primefaces.resources.LazyDataModel;
import org.cyk.utility.common.userinterface.Component;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.primefaces.model.SortOrder;

public class ComponentAdapter extends org.cyk.ui.web.primefaces.resources.ComponentAdapter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public Object build(Component component) {
		Object object = super.build(component);
		if(component instanceof DataTable){
			if(Person.class.equals(component.getPropertiesMap().getActionOnClass()) && Boolean.TRUE.equals(component.getPropertiesMap().getLazy())){
				System.out.println("ComponentAdapter.build()");
				component.getPropertiesMap().setValue(new LazyDataModel<Person>(component){
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
			}else if(PhoneNumberType.class.equals(component.getPropertiesMap().getActionOnClass()) && Boolean.TRUE.equals(component.getPropertiesMap().getLazy())){
				component.getPropertiesMap().setValue(new LazyDataModel<PhoneNumberType>(component){
					private static final long serialVersionUID = 1L;
					
					@Override
					protected List<PhoneNumberType> __getInstances__(int first, int pageSize, String sortField, SortOrder sortOrder,Map<String, Object> filters) {
						return PhoneNumberType.COLLECTION;
					}
					
					@Override
					protected Boolean isFilterable(Map<String, Object> filters) {
						return Boolean.TRUE;
					}
					
					@Override
					protected List<PhoneNumberType> filter(List<PhoneNumberType> collection, Map<String, Object> filters) {
						return PhoneNumberType.filter(collection, filters);
					}
					
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
