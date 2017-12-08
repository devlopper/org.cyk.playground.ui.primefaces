package org.cyk.playground.ui.primefaces.page;

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
	
	private static final List<Person> PERSONS = (List<Person>) Person.instanciateManyRandomly(200);
	
	private DataTable personDataTable;
	private Integer page = 5;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Data tables Lazy");
		
		personDataTable = createDataTable(Person.class,new String[]{"globalIdentifier.code","globalIdentifier.name","lastnames"},page);
		
	}
	
	private <T extends AbstractIdentified> DataTable createDataTable(Class<T> aClass,String[] fieldNames,Integer page){
		DataTable dataTable = new DataTable();
		
		dataTable.setActionOnClass(aClass);
		dataTable.addColumnsByFieldNames(fieldNames);
		dataTable.getPropertiesMap().setRows(page);
		dataTable.getPropertiesMap().setPaginator(page != null);
		dataTable.getPropertiesMap().setLazy(Boolean.TRUE);
		dataTable.prepare();
		dataTable.build();
		
		dataTable.getPropertiesMap().setValue(new LazyDataModel<T>(dataTable));
		return dataTable;
	}
	
	public static class LazyDataModel<T extends AbstractIdentified> extends org.primefaces.model.LazyDataModel<DataTable.Row> implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private Component component;
		
		public LazyDataModel(Component component) {
			this.component = component;
		}
		
		@Override
		public List<DataTable.Row> load(int first, int pageSize, String sortField,SortOrder sortOrder, Map<String, Object> filters) {
			@SuppressWarnings("unchecked")
			List<T> p = (List<T>) PERSONS.subList(first, first + pageSize > PERSONS.size() ? PERSONS.size() -1 : first + pageSize);
			setRowCount(PERSONS.size());
			return (List<DataTable.Row>) DataTable.Row.instanciateMany(p,component,null);
		}
		
		
		
	}
}
