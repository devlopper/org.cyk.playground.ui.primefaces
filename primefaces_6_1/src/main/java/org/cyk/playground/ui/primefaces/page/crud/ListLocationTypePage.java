package org.cyk.playground.ui.primefaces.page.crud;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.LocationType;
import org.cyk.utility.common.userinterface.container.window.ListWindow;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class ListLocationTypePage extends ListWindow implements Serializable {

	private static final long serialVersionUID = 1L;
		
	public static class DataTable extends org.cyk.utility.common.userinterface.collection.DataTable implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public DataTable() {
			super(LocationType.class);
			//columns
			addColumn("code", "globalIdentifier.code");
			addColumn("name", "globalIdentifier.name");
			
			//rows
			addManyRow(LocationType.COLLECTION);
		}
		
	}
}
