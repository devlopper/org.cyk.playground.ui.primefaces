package org.cyk.playground.ui.primefaces.page.datatable;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.window.Window;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class DataTablesPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private DataTable personDataTable;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Data tables");
		
		personDataTable = new DataTable(){
			private static final long serialVersionUID = 1L;

			@Override
			public DataTable load() {
				addManyRow(Person.COLLECTION);
				return this;
			}
		};
		
		personDataTable.getPropertiesMap().setOnPrepareAddMenu(Boolean.TRUE);
		personDataTable.getPropertiesMap().setOnPrepareAddColumnOrderNumber(Boolean.TRUE);
		personDataTable.getPropertiesMap().setOnPrepareAddColumnAction(Boolean.TRUE);
		personDataTable.setOnPrepareCallLoad(Boolean.TRUE);
		
		personDataTable.getPropertiesMap().setActionOnClass(Person.class);
		personDataTable.addColumnsByFieldNames("globalIdentifier.image","globalIdentifier.code","globalIdentifier.name","lastnames","globalIdentifier.usable"
				,"globalIdentifier.creationDate","globalIdentifier.description","nationality");
		
		personDataTable.prepare();
		personDataTable.build();
		
	}
		
}
