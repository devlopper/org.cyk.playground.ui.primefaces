package org.cyk.playground.ui.primefaces.page.crud;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.Window;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class ListPersonPage extends Window implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private DataTable dataTable = new DataTable();
	private List<Person> persons = new ArrayList<>(Person.COLLECTION);
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Person list");
		
		DataTable.Columns columns = new DataTable.Columns();
		DataTable.Column column = new DataTable.Column();
		column.getPropertiesMap().setName("c1");
		columns.addOneChild(new DataTable.Column());
		column.getPropertiesMap().setName("c2");
		columns.addOneChild(new DataTable.Column());
		
		dataTable.getPropertiesMap().setColumns(columns);
	}
	
}
