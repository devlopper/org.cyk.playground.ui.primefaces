package org.cyk.playground.ui.primefaces.page.crud;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.userinterface.Layout;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.Window;

@Named @ViewScoped @Getter @Setter
public class EditPersonPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Form.Master form;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Person "+action);
		
		Person person = Constant.Action.CREATE.equals(action) ? new Person() : Person.get((String)actionOnClassInstanceIdentifiers.iterator().next());
		
		form = new Form.Master(this,person,action,SubmitCommandActionAdapter.class);
		
		Form.Detail detail = form.getDetail();
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
		
		form.build();
		
		//form.getSubmitCommand().getPropertiesMap().setAjax(!Constant.Action.isCreateOrUpdate(form.getAction()));//because of file upload
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
