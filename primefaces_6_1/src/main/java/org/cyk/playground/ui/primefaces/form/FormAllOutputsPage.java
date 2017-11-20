package org.cyk.playground.ui.primefaces.form;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.ContextListener;
import org.cyk.playground.ui.primefaces.model.AllOutputs;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.helper.FileHelper;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.window.Window;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class FormAllOutputsPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Form.Master form;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Form All Outputs");
		
		AllOutputs allOutputs = new AllOutputs();
		
		allOutputs.setOutputText("This is my text");
		allOutputs.setOutputFile1(FileHelper.getInstance().get(ContextListener.class, "image001.png"));
		//allOutputs.setOutputFile4(FileHelper.getInstance().get(ContextListener.class, "image002.png"));
	
		form = Form.Master.get(this,allOutputs, Constant.Action.READ).build();
				
		
	}

	
}
