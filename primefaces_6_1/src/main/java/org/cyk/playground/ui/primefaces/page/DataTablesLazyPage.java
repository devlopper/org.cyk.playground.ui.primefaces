package org.cyk.playground.ui.primefaces.page;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.Component;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.window.Window;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class DataTablesLazyPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private DataTable personDataTable1,personDataTable2,personDataTable3,personDataTable4;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Data tables Load");
		
		personDataTable1 = createPersonDataTable(null,null,null,Boolean.FALSE, Person.instanciateManyRandomly(5));
		personDataTable2 = createPersonDataTable(null,null,null,Boolean.TRUE, Person.instanciateManyRandomly(5));
		
		personDataTable3 = createPersonDataTable(Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE, Person.instanciateManyRandomly(5));
		personDataTable4 = createPersonDataTable(Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE, Person.instanciateManyRandomly(5));
	}
	
	private DataTable createPersonDataTable(Boolean onPrepareAddMenu,Boolean onPrepareAddColumnOrderNumber,Boolean onPrepareAddColumnAction,Boolean onPrepareCallLoad
			,final Collection<Person> persons){
		DataTable dataTable = new DataTable(){
			private static final long serialVersionUID = 1L;

			@Override
			public Component load() {
				addManyRow(persons);
				return this;
			}
		};
		dataTable.setOnPrepareAddMenu(onPrepareAddMenu);
		dataTable.setOnPrepareAddColumnAction(onPrepareAddColumnAction);
		dataTable.setOnPrepareAddColumnOrderNumber(onPrepareAddColumnOrderNumber);
		dataTable.setActionOnClass(Person.class);
		dataTable.addColumnsByFieldNames("globalIdentifier.code","globalIdentifier.name","lastnames");
		dataTable.setOnPrepareCallLoad(onPrepareCallLoad);
		dataTable.prepare();
		dataTable.build();
		if(!Boolean.TRUE.equals(onPrepareCallLoad))
			dataTable.load();
		return dataTable;
	}
	
}
