package org.cyk.playground.ui.primefaces;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.cyk.ui.web.primefaces.resources.page.Page;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.event.Confirm;
import org.cyk.utility.common.userinterface.input.InputText;
import org.primefaces.extensions.model.dynaform.DynaFormModel;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Named @ViewScoped @Getter @Setter
public class FormsPage extends Page implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Form.Master form;
	private DataModel dataModel = new DataModel();
	private DynaFormModel model;  
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Forms");
		form = new Form.Master(SubmitCommandActionAdapter.class).setObject(dataModel);
		form.setLabelFromIdentifier("myformlabel");
		form.getSubmitCommand().setConfirm(new Confirm());
		
		model = createModel();
	}
	
	private DynaFormModel createModel(){
    	Form.Detail formDetail = new Form.Detail();
    	form.setDetail(formDetail);
    	
    	InputText c1 = new InputText();
    	c1.setLabelFromIdentifier("f1").setField(dataModel, "firstName");
    	InputText c2 = new InputText();
    	c2.setLabelFromIdentifier("f2").setField(dataModel, "lastName");
    	InputText c3 = new InputText();
    	c3.setLabelFromIdentifier("f3");
    	InputText c4 = new InputText();
    	c4.setLabelFromIdentifier("f4");
    	InputText c5 = new InputText();
    	c5.setLabelFromIdentifier("f5");
    	InputText c6 = new InputText();
    	c6.setLabelFromIdentifier("f6");
    	InputText c7 = new InputText();
    	c7.setLabelFromIdentifier("f7").setField(dataModel, "otherDetails");
    	c7.getArea().getWidth().setDistance(2);
    	InputText c8 = new InputText();
    	c8.setLabelFromIdentifier("f8");
    	
    	formDetail.getLayout().setType( org.cyk.utility.common.userinterface.Layout.Type.ADAPTIVE);
    	formDetail.layOut(c1).layOut(c2).layOutBreak().layOut(c3).layOutBreak().layOut(c4).layOut(c5).layOutBreak().layOut(c6).layOut(c7).layOutBreak().layOut(c8).layOutBreak();
		
    	DynaFormModel model = (DynaFormModel) Form.Detail.buildTarget(formDetail);
		formDetail.getPropertiesMap().setValue(model);
		
        return model;
    }
	
	@Getter @Setter
	public static class DataModel {
		
		private String firstName;
		private String lastName;
		private Date dateOfBirth;
		private String otherDetails;
		
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
		}
	}
	
	@Getter @Setter @Accessors(chain=true)
	public static class SubmitCommandActionAdapter extends org.cyk.utility.common.userinterface.container.Form.Master.SubmitCommandActionAdapter implements Serializable{
		private static final long serialVersionUID = 1L;

		@Override
		protected Object __execute__() {
			super.__execute__();
			System.out.println("FormsPage.SubmitCommandActionAdapter.__execute__() : CALL BUSINESS SERVICE to handle data : "+form.getObject());
			return null;
		}
		
	}
}
