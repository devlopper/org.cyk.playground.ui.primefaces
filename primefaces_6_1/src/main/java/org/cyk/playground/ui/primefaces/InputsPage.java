package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class InputsPage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String inputText;
	private String inputPassword;
	
	public void submit(){
		System.out.println("InputsPage.submit() InputText = "+inputText+" , InputPassword = "+inputPassword);
	}
	
}
