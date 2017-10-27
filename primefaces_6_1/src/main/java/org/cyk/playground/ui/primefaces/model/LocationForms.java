package org.cyk.playground.ui.primefaces.model;

import java.io.Serializable;

import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.input.InputText;
import org.cyk.utility.common.userinterface.input.InputTextarea;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class LocationForms {
	
	@Getter @Setter @Accessors(chain=true)
	public static class Simple extends Form.Master implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public Simple(Object object) {
			Form.Detail formDetail = instanciateDetail(org.cyk.utility.common.userinterface.Layout.Type.ADAPTIVE);
			formDetail.layOut(new InputTextarea().setField(object, "address"));
			//formDetail.normalize();
		}
		
	}
	
	@Getter @Setter @Accessors(chain=true)
	public static class Full extends Form.Master implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public Full(Object object) {
			Form.Detail formDetail = instanciateDetail(org.cyk.utility.common.userinterface.Layout.Type.ADAPTIVE);
			formDetail.layOut(new InputText().setField(object, "country")).layOut(new InputText().setField(object, "address")).layOutBreak()
			.layOut(new InputText().setField(object, "otherDetails"));
		}
		
	}

}
