package org.cyk.playground.ui.primefaces.page.crud;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import org.cyk.utility.common.userinterface.container.window.ListWindow;

@Named @ViewScoped @Getter @Setter
public class ListLocationTypePage extends ListWindow implements Serializable {

	private static final long serialVersionUID = 1L;
		
	public static class DataTable extends org.cyk.utility.common.userinterface.collection.DataTable implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Override
		protected void __prepare__() {
			super.__prepare__();
			addColumn("code", "globalIdentifier.code");
			addColumn("name", "globalIdentifier.name");
		}
		
	}
}
