package org.cyk.playground.ui.primefaces.page.movement;

import java.io.Serializable;

import org.cyk.ui.web.primefaces.resources.page.controlpanel.IdentifiableEditPage;
import org.cyk.utility.common.userinterface.container.Form;

public class MovementCollectionItemFormMaster extends IdentifiableEditPage.FormMaster implements Serializable {
	private static final long serialVersionUID = -6211058744595898478L;
	
	@Override
	protected void __prepare__() {
		super.__prepare__();
		Form.Detail detail = getDetail();
		
		detail.setFieldsObjectFromMaster();
		detail.add("movementCollection").addBreak();
		detail.addReadOnly("previousCumul").addBreak();
		detail.add("movementAction").addBreak();
		detail.add("value").addBreak();
		detail.addReadOnly("cumul").addBreak();
		
		detail.addEvent("movementCollection", new String[]{"previousCumul","cumul"});
		detail.addEvent("movementAction", new String[]{"cumul"});
		detail.addEvent("value", new String[]{"cumul"});
	}
	
}
