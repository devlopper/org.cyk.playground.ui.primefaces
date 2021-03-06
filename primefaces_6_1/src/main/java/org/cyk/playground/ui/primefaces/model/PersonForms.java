package org.cyk.playground.ui.primefaces.model;

import java.io.Serializable;

import org.cyk.utility.common.userinterface.container.form.FormDetail;
import org.cyk.utility.common.userinterface.container.form.Form;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class PersonForms {
	
	@Getter @Setter @Accessors(chain=true)
	public static class Simple extends Form implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public Simple(Object object) {
			setObject(object);
			FormDetail detail = instanciateDetail(org.cyk.utility.common.userinterface.Layout.Type.ADAPTIVE);
			detail.add("code").addBreak().add("firstname").add("lastname").addBreak();
		}	
	}
	
	@Getter @Setter @Accessors(chain=true)
	public static class Full extends Form implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public Full(Object object) {
			setObject(object);
			FormDetail detail = instanciateDetail(org.cyk.utility.common.userinterface.Layout.Type.ADAPTIVE);
			detail.add("code").add(new String[]{"image"},4,1).addBreak()
			.add("firstname").addBreak()
			.add("lastname").addBreak()
			.add("birthDate").addBreak();
		}
		
	}

}
