package org.cyk.playground.ui.primefaces.model;

import java.io.Serializable;

import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.input.InputText;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class PersonForms {
	
	@Getter @Setter @Accessors(chain=true)
	public static class Simple extends Form.Master implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public Simple(Object object) {
			Form.Detail formDetail = instanciateDetail(org.cyk.utility.common.userinterface.Layout.Type.ADAPTIVE);
			formDetail.layOut(new InputText().setField(object, "code")).layOutBreak()
			.layOut(new InputText().setField(object, "firstname")).layOut(new InputText().setField(object, "lastname")).layOutBreak();
			//formDetail.normalize();
		}
		
	}
	
	@Getter @Setter @Accessors(chain=true)
	public static class Full extends Form.Master implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public Full(Object object) {
			Form.Detail formDetail = instanciateDetail(org.cyk.utility.common.userinterface.Layout.Type.ADAPTIVE);
			formDetail.layOut(new InputText().setField(object, "code")).layOutBreak()
			.layOut(new InputText().setField(object, "image")).layOut(new InputText().setField(object, "firstname")).layOutBreak()
			.layOut(new InputText().setField(object, "lastname")).layOut(new InputText().setField(object, "birthDate")).layOutBreak();
		}
		
	}

}
