package org.cyk.playground.ui.primefaces.model;

import java.io.Serializable;

import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.input.Input;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class Forms {
	
	@Getter @Setter @Accessors(chain=true)
	public static class Simple extends Form.Master implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public Simple(Object object) {
			setObject(object);
			Form.Detail detail = instanciateDetail(org.cyk.utility.common.userinterface.Layout.Type.ADAPTIVE);
			for(Input<?> input : Input.get(detail, object))
				detail.add(input).addBreak();
		}	
	}
	
	@Getter @Setter @Accessors(chain=true)
	public static class Full extends Form.Master implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public Full(Object object) {
			setObject(object);
			Form.Detail detail = instanciateDetail(org.cyk.utility.common.userinterface.Layout.Type.ADAPTIVE);
			detail.add("code").add(new String[]{"image"},4,1).addBreak()
			.add("firstname").addBreak()
			.add("lastname").addBreak()
			.add("birthDate").addBreak();
		}
		
	}

}
