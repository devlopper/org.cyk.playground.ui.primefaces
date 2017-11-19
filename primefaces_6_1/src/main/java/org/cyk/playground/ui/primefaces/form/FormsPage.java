package org.cyk.playground.ui.primefaces.form;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.Window;
import org.cyk.utility.common.userinterface.input.InputText;
import org.cyk.utility.common.userinterface.input.InputTextarea;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Named @ViewScoped @Getter @Setter
public class FormsPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Form.Master form;
	private DataModel dataModel = new DataModel();
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Forms");
		
		form = new Form.Master(this,dataModel,action,SubmitCommandActionAdapter.class).setLabelFromIdentifier("myformlabel");
		
		createModel();
		
		form.build();
		
		
	}
	
	private void createModel(){
    	Form.Detail formDetail = form.instanciateDetail(org.cyk.utility.common.userinterface.Layout.Type.ADAPTIVE);
    	InputText c1 = new InputText();
    	c1.setLabelFromIdentifier("f1")._setField(dataModel, "firstName");
    	InputText c2 = new InputText();
    	c2.setLabelFromIdentifier("f2")._setField(dataModel, "lastName");
    	InputText c3 = new InputText();
    	c3.setLabelFromIdentifier("f3");
    	InputText c4 = new InputText();
    	c4.setLabelFromIdentifier("f4");
    	InputText c5 = new InputText();
    	c5.setLabelFromIdentifier("f5");
    	InputText c6 = new InputText();
    	c6.setLabelFromIdentifier("f6");
    	InputTextarea c7 = new InputTextarea();
    	c7.setLabelFromIdentifier("f7")._setField(dataModel, "otherDetails");
    	c7.getArea().getWidth().setDistance(2);
    	InputText c8 = new InputText();
    	c8.setLabelFromIdentifier("f8");
    	
    	formDetail.layOut(c1).layOut(c2).layOutBreak().layOut(c3).layOutBreak().layOut(c4).layOut(c5).layOutBreak().layOut(c6).layOut(c7).layOutBreak().layOut(c8).layOutBreak();		
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
		
		@Override
		public Boolean getIsConfirmable() {
			return Boolean.TRUE;
		}
		
	}
}
