package org.cyk.playground.ui.primefaces.page.crud;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.Layout;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.Window;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Named @ViewScoped @Getter @Setter
public class ConsultPersonPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Form.Master form;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Person "+action);
		
		Person person = Person.get((String)actionOnClassInstanceIdentifiers.iterator().next());
		
		//person.getGlobalIdentifier().setImage(new File(FileHelper.getInstance().get(ContextListener.class, "image001.png")));
		//System.out.println("CreatePersonPage.initialisation() : "+person.getGlobalIdentifier().getImage());
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
		
		form.getSubmitCommand().getPropertiesMap().setAjax(Boolean.FALSE);//because of file upload
		//form.getSubmitCommand().getPropertiesMap().setPartialSubmit(Boolean.FALSE);
		
	}
	
	@Getter @Setter @Accessors(chain=true)
	public static class SubmitCommandActionAdapter extends org.cyk.utility.common.userinterface.container.Form.Master.SubmitCommandActionAdapter implements Serializable{
		private static final long serialVersionUID = 1L;

		
		
	}
	
}
