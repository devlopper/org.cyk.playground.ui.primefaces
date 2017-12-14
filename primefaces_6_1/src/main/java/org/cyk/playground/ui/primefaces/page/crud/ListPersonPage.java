package org.cyk.playground.ui.primefaces.page.crud;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.common.userinterface.container.window.ListWindow;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class ListPersonPage extends ListWindow implements Serializable {

	private static final long serialVersionUID = 1L;
		
	public static class DataTable extends org.cyk.utility.common.userinterface.collection.DataTable implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Override
		protected void __prepare__() {
			super.__prepare__();
			//columns
			addColumn("photo", "globalIdentifier.image");
			addColumn("code", "globalIdentifier.code");
			addColumn("name", "globalIdentifier.name");
			addColumn("lastnames", "lastnames");
			addColumn("sex", "sex");
			addColumn("nationality", "nationality");
			
		}
		
	}
}
