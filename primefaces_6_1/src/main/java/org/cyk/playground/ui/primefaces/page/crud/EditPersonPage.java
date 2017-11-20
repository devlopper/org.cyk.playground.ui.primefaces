package org.cyk.playground.ui.primefaces.page.crud;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.Component;
import org.cyk.utility.common.userinterface.Layout;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.window.Window;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Named @ViewScoped @Getter @Setter
public class EditPersonPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Form.Master form;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		
		form = Form.Master.get(this, getActionOnClassInstances().iterator().next(),action).setSubmitCommandActionAdapterClass(SubmitCommandActionAdapter.class);
		form.build();
		
	}
	
	@Getter @Setter @Accessors(chain=true)
	public static class FormMaster extends Form.Master implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Override
		public Component prepare() {
			super.prepare();
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
			detail.add("otherDetails");
			return this;
		}
		
	}
	
	@Getter @Setter @Accessors(chain=true)
	public static class SubmitCommandActionAdapter extends org.cyk.utility.common.userinterface.container.Form.Master.SubmitCommandActionAdapter.Web implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@Override
		protected void create() {
			Person.COLLECTION.add((Person)form.getObject());
		}
		
		@Override
		protected void delete() {
			Person.COLLECTION.remove((Person)form.getObject());
		}
				
	}
	
}
