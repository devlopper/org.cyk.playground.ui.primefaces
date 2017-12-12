package org.cyk.playground.ui.primefaces.page.datatable;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.Component;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.command.Command;
import org.cyk.utility.common.userinterface.container.window.Window;
import org.cyk.utility.common.userinterface.input.InputText;

import lombok.Getter;
import lombok.Setter;

//@javax.inject.Named @javax.faces.view.ViewScoped 
@javax.faces.bean.ManagedBean @javax.faces.bean.ViewScoped
@Getter @Setter
public class DataTablesFilterPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private DataTable personDataTableNotPaged,personDataTablePaged,personDataTableLazy;
	private Integer page = 5;
	private List<Person> filterValues;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Data tables Filter");
		
		final String[] fieldNames = new String[]{"globalIdentifier.code","globalIdentifier.name","lastnames"};
		
		personDataTableNotPaged = DataTable.instanciateOne(Person.class, fieldNames, Person.COLLECTION, null, null);
		personDataTablePaged = DataTable.instanciateOne(Person.class, fieldNames, Person.COLLECTION, page, null);
		personDataTableLazy = DataTable.instanciateOne(Person.class, fieldNames, null, page, Boolean.TRUE);
		personDataTableLazy.getPropertiesMap().setValue(new DataTablesLazyPage.LazyDataModel<Person>(personDataTableLazy){
			private static final long serialVersionUID = 1L;
			
			@Override
			protected Boolean isFilterable(Map<String, Object> filters) {
				return Boolean.TRUE;
			}
			
			@Override
			protected List<Person> filter(List<Person> collection, Map<String, Object> filters) {
				return Person.filter(collection, filters);
			}
			
			@Override
			protected Boolean isPageable(Integer first, Integer size) {
				return Boolean.TRUE;
			}
		});
		
		//personDataTableNotPaged.getColumn("__orderNumber__").getPropertiesMap().setFilterable(Boolean.TRUE);
		personDataTableNotPaged.getColumn("globalIdentifier.code").getPropertiesMap().setFilterable(Boolean.TRUE);
		personDataTableNotPaged.getColumn("globalIdentifier.name").getPropertiesMap().setFilterable(Boolean.TRUE);
		personDataTableNotPaged.getColumn("lastnames").getPropertiesMap().setFilterable(Boolean.TRUE);
		
		//personDataTablePaged.getColumn("__orderNumber__").getPropertiesMap().setFilterable(Boolean.TRUE);
		personDataTablePaged.getColumn("globalIdentifier.code").getPropertiesMap().setFilterable(Boolean.TRUE);
		personDataTablePaged.getColumn("globalIdentifier.name").getPropertiesMap().setFilterable(Boolean.TRUE);
		personDataTablePaged.getColumn("lastnames").getPropertiesMap().setFilterable(Boolean.TRUE);
		
		//personDataTableLazy.getColumn("__orderNumber__").getPropertiesMap().setFilterable(Boolean.TRUE);
		personDataTableLazy.getColumn("globalIdentifier.code").getPropertiesMap().setFilterable(Boolean.TRUE);
		personDataTableLazy.getColumn("globalIdentifier.name").getPropertiesMap().setFilterable(Boolean.TRUE);
		personDataTableLazy.getColumn("lastnames").getPropertiesMap().setFilterable(Boolean.TRUE);
		
		InputText input = (InputText) personDataTableLazy.getPropertiesMap().getFilterInputComponent();
		//input.getPropertiesMap().setOnKeyUp("PF('"+personDataTableLazy.getPropertiesMap().getWidgetVar()+"').filter()");
		
		Command command = (Command) personDataTableLazy.getPropertiesMap().getFilterCommandComponent();
		command.getPropertiesMap().setType("button");
		command.getPropertiesMap().setOnClick("PF('"+personDataTableLazy.getPropertiesMap().getWidgetVar()+"').filter()");
	}
	
	/*
	private <T extends AbstractIdentified> DataTable createDataTable(Class<T> aClass,String[] fieldNames,Integer page,Boolean lazy){
		DataTable dataTable = new DataTable();
		
		dataTable.setActionOnClass(aClass);
		dataTable.addColumnsByFieldNames(fieldNames);
		if(lazy)
			dataTable.getPropertiesMap().setRows(page);
		dataTable.getPropertiesMap().setPaginator(lazy);
		dataTable.getPropertiesMap().setLazy(lazy);
		dataTable.prepare();
		dataTable.build();
		if(Boolean.TRUE.equals(lazy))
			dataTable.getPropertiesMap().setValue(new DataTablesLazyPage.LazyDataModel<T>(dataTable));
		else
			dataTable.addManyRow(Person.COLLECTION);
		return dataTable;
	}*/
	
}
