package org.cyk.playground.ui.primefaces.form;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.cyk.playground.ui.primefaces.model.ModelWithoutInputAnnotation;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.Window;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Named @ViewScoped @Getter @Setter
public class FormModelWithoutInputAnnotationPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ModelWithoutInputAnnotation model = new ModelWithoutInputAnnotation();
	private Form.Master form;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Form All Inputs");
		
		form = Form.Master.get(model, Constant.Action.CREATE).setSubmitCommandActionAdapterClass(SubmitCommandActionAdapter.class)
				.setLabelFromIdentifier("myformlabel").build();
		
		form.getSubmitCommand().getPropertiesMap().setAjax(Boolean.FALSE);//because of file upload
		//form.getSubmitCommand().getPropertiesMap().setPartialSubmit(Boolean.FALSE);
	}

	@Getter @Setter @Accessors(chain=true)
	public static class SubmitCommandActionAdapter extends org.cyk.utility.common.userinterface.container.Form.Master.SubmitCommandActionAdapter implements Serializable{
		private static final long serialVersionUID = 1L;

		@Override
		protected Object __execute__() {
			System.out.println("FormModelWithoutInputAnnotationPage.SubmitCommandActionAdapter.__execute__()");
			super.__execute__();
			System.out.println(ToStringBuilder.reflectionToString(form.getObject(), ToStringStyle.MULTI_LINE_STYLE));
			return null;
		}
		
	}
}
