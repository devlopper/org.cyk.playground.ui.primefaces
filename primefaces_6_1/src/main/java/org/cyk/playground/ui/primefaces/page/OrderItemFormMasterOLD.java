package org.cyk.playground.ui.primefaces.page;

import java.io.Serializable;

import org.cyk.ui.web.primefaces.resources.page.controlpanel.IdentifiableEditPage;
import org.cyk.utility.common.userinterface.container.Form;

public class OrderItemFormMasterOLD extends IdentifiableEditPage.FormMaster implements Serializable {
	private static final long serialVersionUID = -6211058744595898478L;
	
	@Override
	protected void __prepare__() {
		super.__prepare__();
		Form.Detail detail = getDetail();
		detail.setFieldsObjectFromMaster();
		detail.add("order").addBreak();
		detail.add("article").addBreak();
		detail.add("quantity").addBreak();
		detail.add("amount").addBreak();
	}
	
}
