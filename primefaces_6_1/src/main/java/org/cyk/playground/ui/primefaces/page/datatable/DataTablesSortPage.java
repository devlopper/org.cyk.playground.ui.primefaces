package org.cyk.playground.ui.primefaces.page.datatable;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.lang3.ArrayUtils;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.window.Window;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class DataTablesSortPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private DataTable personDataTableNotPaged,personDataTablePaged,personDataTableLazy;
	private Integer page = 5;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Data tables Sort");
		
		final String[] fieldNames = new String[]{"globalIdentifier.code","globalIdentifier.name","lastnames"};
		
		personDataTableNotPaged = DataTable.instanciateOne(Person.class, fieldNames, Person.COLLECTION, null, null);
		personDataTablePaged = DataTable.instanciateOne(Person.class, fieldNames, Person.COLLECTION, page, null);
		personDataTableLazy = DataTable.instanciateOne(Person.class, fieldNames, null, page, Boolean.TRUE);
		personDataTableLazy.getPropertiesMap().setValue(new DataTablesLazyPage.LazyDataModel<Person>(personDataTableLazy){
			private static final long serialVersionUID = 1L;
			
			@Override
			protected Boolean isSortable(String fieldName) {
				return ArrayUtils.contains(fieldNames, fieldName);
			}
			
			@Override
			protected Boolean isPageable(Integer first, Integer size) {
				return Boolean.TRUE;
			}
		});
		
		/*
		personDataTableNotPaged = createDataTable(Person.class,new String[]{"globalIdentifier.code","globalIdentifier.name","lastnames"},page,Boolean.FALSE);
		personDataTableNotPaged.getColumn("__orderNumber__").getPropertiesMap().setSortable(Boolean.TRUE);
		personDataTableNotPaged.getColumn("globalIdentifier.code").getPropertiesMap().setSortable(Boolean.TRUE);
		personDataTableNotPaged.getColumn("globalIdentifier.name").getPropertiesMap().setSortable(Boolean.TRUE);
		personDataTableNotPaged.getColumn("lastnames").getPropertiesMap().setSortable(Boolean.TRUE);
		*/
		
		personDataTableNotPaged.getColumn("__orderNumber__").getPropertiesMap().setSortable(Boolean.TRUE);
		personDataTableNotPaged.getColumn("globalIdentifier.code").getPropertiesMap().setSortable(Boolean.TRUE);
		personDataTableNotPaged.getColumn("globalIdentifier.name").getPropertiesMap().setSortable(Boolean.TRUE);
		personDataTableNotPaged.getColumn("lastnames").getPropertiesMap().setSortable(Boolean.TRUE);
		
		personDataTablePaged.getColumn("__orderNumber__").getPropertiesMap().setSortable(Boolean.TRUE);
		personDataTablePaged.getColumn("globalIdentifier.code").getPropertiesMap().setSortable(Boolean.TRUE);
		personDataTablePaged.getColumn("globalIdentifier.name").getPropertiesMap().setSortable(Boolean.TRUE);
		personDataTablePaged.getColumn("lastnames").getPropertiesMap().setSortable(Boolean.TRUE);
		
		personDataTableLazy.getColumn("__orderNumber__").getPropertiesMap().setSortable(Boolean.TRUE);
		personDataTableLazy.getColumn("globalIdentifier.code").getPropertiesMap().setSortable(Boolean.TRUE);
		personDataTableLazy.getColumn("globalIdentifier.name").getPropertiesMap().setSortable(Boolean.TRUE);
		personDataTableLazy.getColumn("lastnames").getPropertiesMap().setSortable(Boolean.TRUE);
	}
	
}
