package org.cyk.playground.ui.primefaces.page.crud;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.container.window.ListWindow;

@Named @ViewScoped @Getter @Setter
public class ListPersonPage extends ListWindow implements Serializable {

	private static final long serialVersionUID = 1L;
		
	public static class DataTable extends org.cyk.utility.common.userinterface.collection.DataTable implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public DataTable() {
			super(Person.class);
			//columns
			addColumn("code", "globalIdentifier.code");
			addColumn("name", "globalIdentifier.name");
			addColumn("lastnames", "lastnames");
			addColumn("sex", "sex");
			addColumn("nationality", "nationality");
			//rows
			addManyRow(Person.COLLECTION);
		}
		
	}
}
