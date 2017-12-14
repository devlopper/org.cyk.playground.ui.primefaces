package org.cyk.playground.ui.primefaces;

import org.cyk.playground.ui.primefaces.model.LocalityType;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.playground.ui.primefaces.page.LocalityTypeDataTable;
import org.cyk.utility.common.helper.ClassHelper;
import org.cyk.utility.common.helper.FilterHelper;
import org.cyk.utility.common.userinterface.Component;
import org.cyk.utility.common.userinterface.container.window.ListWindow;
import org.cyk.utility.test.unit.AbstractUnitTest;
import org.junit.Test;

public class ClassLocatorUnitTest extends AbstractUnitTest {
	private static final long serialVersionUID = 1L;

	static {
		ClassHelper.getInstance().map(ClassHelper.Listener.class, org.cyk.playground.ui.primefaces.ClassHelper.Listener.class);
	}
	
	@Test
	public void getDataTableClass(){
		Component.ClassLocator.GetOrgCykSystem.MODULE_PREFIXES = new String[]{"playground.ui.primefaces.page"};
		Component.ClassLocator.GetOrgCykSystem.NAME_TOKEN_TO_REPLACE = "org.cyk.system.playground.";
		Component.ClassLocator.GetOrgCykSystem.NAME_TOKEN_REPLACEMENT = "org.cyk.playground.";
		assertEquals(LocalityTypeDataTable.class, ListWindow.DataTable.ClassLocator.getInstance().locate(LocalityType.class));
	}
	
	@Test
	public void getFilterClass(){
		assertEquals(Person.Filter.class, FilterHelper.Filter.ClassLocator.getInstance().locate(Person.class));
	}

}
