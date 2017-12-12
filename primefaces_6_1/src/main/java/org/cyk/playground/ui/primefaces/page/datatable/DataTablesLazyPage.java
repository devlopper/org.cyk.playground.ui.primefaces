package org.cyk.playground.ui.primefaces.page.datatable;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.AbstractIdentified;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.Component;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.window.Window;
import org.primefaces.model.SortOrder;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class DataTablesLazyPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private DataTable personDataTable;
	private Integer page = 5;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Data tables Lazy");
		
		personDataTable = createDataTable(Person.class,new String[]{"globalIdentifier.code","globalIdentifier.name","lastnames"},page);
		
	}
	
	public static <T extends AbstractIdentified> DataTable createDataTable(Class<T> aClass,String[] fieldNames,Integer page){
		DataTable dataTable = new DataTable();
		
		dataTable.getPropertiesMap().setActionOnClass(aClass);
		dataTable.addColumnsByFieldNames(fieldNames);
		dataTable.getPropertiesMap().setRows(page);
		dataTable.getPropertiesMap().setPaginator(Boolean.TRUE);
		dataTable.getPropertiesMap().setLazy(Boolean.TRUE);
		dataTable.prepare();
		dataTable.build();
		
		dataTable.getPropertiesMap().setValue(new LazyDataModel<T>(dataTable));
		return dataTable;
	}
	
	public static class LazyDataModel<T extends AbstractIdentified> extends org.cyk.ui.web.primefaces.resources.LazyDataModel<T> implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public LazyDataModel(Component component) {
			super(component);
		}
		
		@SuppressWarnings("unchecked")
		@Override
		protected List<T> __getInstances__(int first, int pageSize, String sortField, SortOrder sortOrder,Map<String, Object> filters) {
			return (List<T>) Person.COLLECTION;
		}
		
	}
}
