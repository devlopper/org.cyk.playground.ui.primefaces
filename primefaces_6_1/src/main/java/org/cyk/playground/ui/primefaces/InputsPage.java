package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.ui.web.primefaces.resources.page.Page;
import org.cyk.utility.common.userinterface.input.InputText;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class InputsPage extends Page implements Serializable {

	private static final long serialVersionUID = 1L;

	private InputText inputText;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		inputText = new InputText();
		//inputText.getPropertiesMap().setOnChange("alert('it has changed')");
		//inputText.getPropertiesMap().setOnClick("alert('it has been clicked')");
	}
	
	public void submit(){
		//System.out.println("InputsPage.submit() InputText = "+inputText+" , InputPassword = "+inputPassword);
	}
	
}
