package org.cyk.playground.ui.primefaces;

import org.cyk.playground.ui.primefaces.model.Location;
import org.cyk.playground.ui.primefaces.model.LocationType;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.playground.ui.primefaces.model.PhoneNumberType;
import org.cyk.playground.ui.primefaces.page.crud.EditLocationPage;
import org.cyk.playground.ui.primefaces.page.crud.EditLocationTypePage;
import org.cyk.playground.ui.primefaces.page.crud.EditPersonPage;
import org.cyk.playground.ui.primefaces.page.crud.EditPhoneNumberTypePage;
import org.cyk.utility.common.userinterface.container.window.EditWindow;

public class EditFormMasterClassLocator extends EditWindow.FormMaster.ClassLocator {
	private static final long serialVersionUID = 1L;
	
	@Override
	public Class<?> locate(Class<?> basedClass) {
		if(Person.class.equals(basedClass))
			return EditPersonPage.FormMaster.class;
		if(PhoneNumberType.class.equals(basedClass))
			return EditPhoneNumberTypePage.FormMaster.class;
		if(LocationType.class.equals(basedClass))
			return EditLocationTypePage.FormMaster.class;
		if(Location.class.equals(basedClass))
			return EditLocationPage.FormMaster.class;
		return super.locate(basedClass);
	}
	
}