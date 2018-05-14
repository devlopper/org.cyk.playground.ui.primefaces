package org.cyk.playground.ui.primefaces.model;

import java.io.Serializable;

import org.cyk.utility.common.userinterface.container.form.FormDetail;
import org.cyk.utility.common.userinterface.container.form.Form;
import org.cyk.utility.common.userinterface.input.InputText;
import org.cyk.utility.common.userinterface.input.InputTextarea;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class LocationForms {
	
	@Getter @Setter @Accessors(chain=true)
	public static class Simple extends Form implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public Simple(Object object) {
			FormDetail formDetail = instanciateDetail(org.cyk.utility.common.userinterface.Layout.Type.ADAPTIVE);
			formDetail.add(new InputTextarea().__setField__(object, "address"));
			//formDetail.normalize();
		}
		
	}
	
	@Getter @Setter @Accessors(chain=true)
	public static class Full extends Form implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public Full(Object object) {
			FormDetail formDetail = instanciateDetail(org.cyk.utility.common.userinterface.Layout.Type.ADAPTIVE);
			formDetail.add(new InputText().__setField__(object, "country"),new InputText().__setField__(object, "address")).addBreak()
			.add(new InputText().__setField__(object, "otherDetails"));
		}
		
	}

}
