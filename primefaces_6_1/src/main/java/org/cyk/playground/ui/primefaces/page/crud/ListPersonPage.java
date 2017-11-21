package org.cyk.playground.ui.primefaces.page.crud;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.window.Window;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class ListPersonPage extends Window implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Person list");
		
		dataTable = new DataTable(Person.class);
		
		dataTable.addColumn("code", "globalIdentifier.code");
		dataTable.addColumn("name", "globalIdentifier.name");
		dataTable.addColumn("lastnames", "lastnames");
		dataTable.addColumn("nationality", "nationality");
		
		dataTable.addManyRow(Person.COLLECTION);
		
		dataTable.build();
	}
	
	@Override
	protected Boolean getIsAutomaticallySetForm() {
		// TODO Auto-generated method stub
		return Boolean.FALSE;
	}
}
