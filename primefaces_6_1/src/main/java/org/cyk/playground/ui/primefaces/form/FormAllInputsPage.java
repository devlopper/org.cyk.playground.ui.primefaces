package org.cyk.playground.ui.primefaces.form;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.AllInputs;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.Window;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Named @ViewScoped @Getter @Setter
public class FormAllInputsPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Form.Master form;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Form All Inputs");
		
		form = Form.Master.get(new AllInputs(), Constant.Action.CREATE).setSubmitCommandActionAdapterClass(SubmitCommandActionAdapter.class)
				.setLabelFromIdentifier("myformlabel").build();
	}

	@Getter @Setter @Accessors(chain=true)
	public static class SubmitCommandActionAdapter extends org.cyk.utility.common.userinterface.container.Form.Master.SubmitCommandActionAdapter implements Serializable{
		private static final long serialVersionUID = 1L;

		@Override
		protected Object __execute__() {
			System.out.println("FormAllInputsPage.SubmitCommandActionAdapter.__execute__()");
			return null;
		}
		
	}
}
