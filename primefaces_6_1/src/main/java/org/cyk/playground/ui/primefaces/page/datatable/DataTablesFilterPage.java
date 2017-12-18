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
		
		final String[] fieldNames = new String[]{"globalIdentifier.code","globalIdentifier.name","lastnames"};
		
		personDataTableNotPaged = DataTable.instanciateOne(Person.class, fieldNames, Person.COLLECTION, null, null);
		personDataTablePaged = DataTable.instanciateOne(Person.class, fieldNames, Person.COLLECTION, page, null);
		personDataTableLazy = DataTable.instanciateOne(Person.class, fieldNames, null, page, Boolean.TRUE);
		
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
		
	}
	
	
}
