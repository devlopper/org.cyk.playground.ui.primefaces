package org.cyk.playground.ui.primefaces.page.model;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.Window;
import org.cyk.utility.common.userinterface.input.Input;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Named @ViewScoped @Getter @Setter
public class CreatePersonPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Form.Master form;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Create person");
		
		form = new Form.Master(new Person(),SubmitCommandActionAdapter.class);
		
		Form.Detail detail = form.getDetail();
		detail.setFieldsObjectFromMaster("globalIdentifier");
		detail.add("code");
		detail.add("image");
		detail.add("name");
		detail.setFieldsObjectFromMaster();
		detail.add("lastnames");
		detail.add("nationality");
		detail.add("sex");
		detail.setFieldsObjectFromMaster("globalIdentifier");
		detail.add("description");
		detail.add("otherDetails");
		
		form.build();
		
		form.getSubmitCommand().getPropertiesMap().setAjax(Boolean.FALSE);//because of file upload
		//form.getSubmitCommand().getPropertiesMap().setPartialSubmit(Boolean.FALSE);
	}

	@Getter @Setter @Accessors(chain=true)
	public static class SubmitCommandActionAdapter extends org.cyk.utility.common.userinterface.container.Form.Master.SubmitCommandActionAdapter implements Serializable{
		private static final long serialVersionUID = 1L;

		@Override
		protected Object __execute__() {
			System.out.println("CreatePersonPage.SubmitCommandActionAdapter.__execute__()");
			super.__execute__();
			System.out.println(ToStringBuilder.reflectionToString(form.getObject(), ToStringStyle.MULTI_LINE_STYLE));
			return null;
		}
		
	}
}
