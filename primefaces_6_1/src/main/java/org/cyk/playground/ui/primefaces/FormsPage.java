package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.ui.web.primefaces.resources.page.Page;
import org.cyk.utility.common.helper.CommandHelper;
import org.cyk.utility.common.userinterface.Layout;
import org.cyk.utility.common.userinterface.command.Menu;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.input.Input;
import org.cyk.utility.common.userinterface.input.InputText;
import org.primefaces.extensions.model.dynaform.DynaFormModel;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class FormsPage extends Page implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Form.Master form;
	private Form.Detail formDetail;
	private DynaFormModel model;  
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Forms");
		form = new Form.Master();
		form.setLabelFromIdentifier("myformlabel");
		
		/*
		formDetail = new Form.Detail();
		formDetail.getLayout().setType(Layout.Type.VERTICAL);
		
		InputText c1 = new InputText();
		c1.setLabelFromIdentifier("c1");
		InputText c2 = new InputText();
		c2.setLabelFromIdentifier("c2");
		InputText c3 = new InputText();
		c3.setLabelFromIdentifier("c3");
		InputText c4 = new InputText();
		c4.setLabelFromIdentifier("c4");
		
		formDetail.add(c1,c2,c3,c4);
		form.setDetail(formDetail);
		*/
		form.setMenu(new Menu());
		model = createModel();
		form.setDetail(formDetail);
		formDetail.getPropertiesMap().setValue(model);
		
		form.getSubmitCommand().setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;

			@Override
			protected Object __execute__() {
				for(Object object : formDetail.getLayout().getChildren().getElements())
					System.out.println( ((Input<?>)object).getLabel().getPropertiesMap().getValue()+" = "+((Input<?>)object).getValue() );
				return null;
			}
		});
		
		form.getSubmitCommand().getAction().setIsNotifiableOnStatusSuccess(Boolean.TRUE);
		//form.getSubmitCommand().setConfirm(new Confirm());
		
	}
	
	private DynaFormModel createModel(){
    	formDetail = new Form.Detail();
    	InputText c1 = new InputText();
    	c1.setLabelFromIdentifier("f1");
    	InputText c2 = new InputText();
    	c2.setLabelFromIdentifier("f2");
    	InputText c3 = new InputText();
    	c3.setLabelFromIdentifier("f3");
    	InputText c4 = new InputText();
    	c4.setLabelFromIdentifier("f4");
    	InputText c5 = new InputText();
    	c5.setLabelFromIdentifier("f5");
    	InputText c6 = new InputText();
    	c6.setLabelFromIdentifier("f6");
    	InputText c7 = new InputText();
    	c7.setLabelFromIdentifier("f7");
    	c7.getArea().getWidth().setDistance(2);
    	InputText c8 = new InputText();
    	c8.setLabelFromIdentifier("f8");
    	
    	formDetail.getLayout().setType( org.cyk.utility.common.userinterface.Layout.Type.ADAPTIVE);
    	formDetail.layOut(c1).layOut(c2).layOutBreak().layOut(c3).layOutBreak().layOut(c4).layOut(c5).layOutBreak().layOut(c6).layOut(c7).layOutBreak().layOut(c8).layOutBreak();
		
    	DynaFormModel model = (DynaFormModel) Form.Detail.buildTarget(formDetail);
    	
        return model;
    }
	
}
