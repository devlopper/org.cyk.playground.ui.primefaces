package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import org.cyk.playground.ui.primefaces.model.Location;
import org.cyk.playground.ui.primefaces.model.LocationType;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.playground.ui.primefaces.page.crud.EditLocationPage;
import org.cyk.playground.ui.primefaces.page.crud.EditLocationTypePage;
import org.cyk.playground.ui.primefaces.page.crud.EditPersonPage;
import org.cyk.utility.common.userinterface.Component;
import org.cyk.utility.common.userinterface.Layout;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.window.EditWindow;

public class EditFormMasterClassLocator extends EditWindow.FormMaster.ClassLocator {
	private static final long serialVersionUID = 1L;
	
	@Override
	public Class<?> locate(Class<?> basedClass) {
		if(Person.class.equals(basedClass))
			return EditPersonPage.FormMaster.class;
		if(LocationType.class.equals(basedClass))
			return EditLocationTypePage.FormMaster.class;
		if(Location.class.equals(basedClass))
			return EditLocationPage.FormMaster.class;
		return super.locate(basedClass);
	}
	
	@Getter @Setter @Accessors(chain=true)
	public static class EnumerationForm extends Form.Master implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Override
		public Component prepare() {
			//controls
			//inputs
			Form.Detail detail = getDetail();
			detail.getLayout().setType(Layout.Type.ADAPTIVE);
			detail.setFieldsObjectFromMaster("globalIdentifier");
			detail.add("code").addBreak();
			detail.add("name").addBreak();
	
			return this;
		}
		
	}
	
}