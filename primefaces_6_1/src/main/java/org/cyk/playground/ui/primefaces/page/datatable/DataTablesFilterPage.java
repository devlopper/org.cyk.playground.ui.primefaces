package org.cyk.playground.ui.primefaces.page.datatable;

import java.io.Serializable;
import java.util.List;

import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.window.Window;

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
		/*
		personDataTableNotPaged = createDataTable(Person.class,new String[]{"globalIdentifier.code","globalIdentifier.name","lastnames"},page,Boolean.FALSE);
		personDataTableNotPaged.getColumn("__orderNumber__").getPropertiesMap().setFilterable(Boolean.TRUE);
		personDataTableNotPaged.getColumn("globalIdentifier.code").getPropertiesMap().setFilterable(Boolean.TRUE);
		personDataTableNotPaged.getColumn("globalIdentifier.name").getPropertiesMap().setFilterable(Boolean.TRUE);
		personDataTableNotPaged.getColumn("lastnames").getPropertiesMap().setFilterable(Boolean.TRUE);
		
		personDataTablePaged = DataTablesPagingPage.createDataTable(Person.class,new String[]{"globalIdentifier.code","globalIdentifier.name","lastnames"},page,Person.COLLECTION);
		*/
		personDataTableLazy = DataTablesLazyPage.createDataTable(Person.class,new String[]{"globalIdentifier.code","globalIdentifier.name","lastnames"},page);
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
