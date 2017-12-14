package org.cyk.playground.ui.primefaces.page.crud;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.common.userinterface.Component;
import org.cyk.utility.common.userinterface.Layout;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.window.EditWindow;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Named @ViewScoped @Getter @Setter
public class EditPersonPage extends EditWindow implements Serializable {
	private static final long serialVersionUID = 1L;
		
	@Getter @Setter @Accessors(chain=true)
	public static class FormMaster extends Form.Master implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Override
		public Component prepare() {
			//controls
			//inputs
			Form.Detail detail = getDetail();
			detail.getLayout().setType(Layout.Type.ADAPTIVE);
			detail.setFieldsObjectFromMaster("globalIdentifier");
			detail.add("code");
			detail.add("image",1,3).addBreak();
			detail.add("name").addBreak();
			detail.setFieldsObjectFromMaster();
			detail.add("lastnames").addBreak();
			detail.add("nationality");
			detail.add("sex").addBreak();
			detail.setFieldsObjectFromMaster("globalIdentifier");
			detail.add("description").addBreak();
			//detail.add("otherDetails");
			return this;
		}
		
	}
		
}
