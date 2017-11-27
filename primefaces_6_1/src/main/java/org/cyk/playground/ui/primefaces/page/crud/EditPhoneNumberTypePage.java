package org.cyk.playground.ui.primefaces.page.crud;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.EditFormMasterClassLocator;
import org.cyk.utility.common.userinterface.container.window.EditWindow;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Named @ViewScoped @Getter @Setter
public class EditPhoneNumberTypePage extends EditWindow implements Serializable {
	private static final long serialVersionUID = 1L;
		
	@Getter @Setter @Accessors(chain=true)
	public static class FormMaster extends EditFormMasterClassLocator.EnumerationForm implements Serializable {
		private static final long serialVersionUID = 1L;
		

	}
		
}
