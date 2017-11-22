package org.cyk.playground.ui.primefaces;

import org.cyk.playground.ui.primefaces.model.Location;
import org.cyk.playground.ui.primefaces.model.LocationType;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.playground.ui.primefaces.model.PhoneNumberType;
import org.cyk.playground.ui.primefaces.page.crud.ListLocationPage;
import org.cyk.playground.ui.primefaces.page.crud.ListLocationTypePage;
import org.cyk.playground.ui.primefaces.page.crud.ListPersonPage;
import org.cyk.playground.ui.primefaces.page.crud.ListPhoneNumberTypePage;
import org.cyk.utility.common.userinterface.container.window.ListWindow;

public class ListDataTableClassLocator extends ListWindow.DataTable.ClassLocator {
	private static final long serialVersionUID = 1L;
	
	@Override
	public Class<?> locate(Class<?> basedClass) {
		if(Person.class.equals(basedClass))
			return ListPersonPage.DataTable.class;
		if(PhoneNumberType.class.equals(basedClass))
			return ListPhoneNumberTypePage.DataTable.class;
		if(LocationType.class.equals(basedClass))
			return ListLocationTypePage.DataTable.class;
		if(Location.class.equals(basedClass))
			return ListLocationPage.DataTable.class;
		return super.locate(basedClass);
	}
	
}