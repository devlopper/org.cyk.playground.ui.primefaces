package org.cyk.playground.ui.primefaces.page.movement;

import java.io.Serializable;

import org.cyk.ui.web.primefaces.resources.page.controlpanel.IdentifiableListPage;

public class MovementCollectionItemDataTable extends IdentifiableListPage.DataTable implements Serializable {
	private static final long serialVersionUID = -6211058744595898478L;
	
	@Override
	protected void __prepare__() {
		super.__prepare__();
		//columns
		addColumnsByFieldNames("movementCollection");
		addColumnsByFieldNames("movementAction");
		addColumnsByFieldNames("value");
	}
	
}
