package org.cyk.playground.ui.primefaces.page;

import java.io.Serializable;

public class PhoneNumberTypeDataTable extends org.cyk.utility.common.userinterface.collection.DataTable implements Serializable {
	private static final long serialVersionUID = -6211058744595898478L;
	
	@Override
	protected void __prepare__() {
		super.__prepare__();
		//columns
		addColumnsByFieldNames("globalIdentifier.code","globalIdentifier.name","globalIdentifier.owner");
	}
	
}
