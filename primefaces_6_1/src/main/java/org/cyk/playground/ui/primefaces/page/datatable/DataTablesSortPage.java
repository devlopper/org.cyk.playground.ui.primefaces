package org.cyk.playground.ui.primefaces.page.datatable;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.AbstractIdentified;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.window.Window;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class DataTablesSortPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private DataTable personDataTableNotPaged,personDataTablePaged;
	private Integer page = 5;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Data tables Lazy");
		
		personDataTableNotPaged = createDataTable(Person.class,new String[]{"globalIdentifier.code","globalIdentifier.name","lastnames"},page);
		personDataTablePaged = createDataTable(Person.class,new String[]{"globalIdentifier.code","globalIdentifier.name","lastnames"},page);
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
		
		dataTable.getPropertiesMap().setValue(new DataTablesLazyPage.LazyDataModel<T>(dataTable));
		return dataTable;
	}
	
}
