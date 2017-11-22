package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import org.cyk.playground.ui.primefaces.model.AbstractIdentified;
import org.cyk.utility.common.cdi.AbstractBean;
import org.cyk.utility.common.helper.MapHelper.EntryComponent;

public class MapHelper extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public static class Listener extends org.cyk.utility.common.helper.MapHelper.Listener.Adapter.Default {
		
		private static final long serialVersionUID = 1L;

		@Override
		public Object getAs(EntryComponent entryComponent, Object object) {
			if(object instanceof AbstractIdentified)
				return ((AbstractIdentified)object).getGlobalIdentifier().getCode();
			return super.getAs(entryComponent, object);
		}
		
		@Override
		public String getSeparatorOfValue() {
			return "&";
		}
		
		@Override
		public String getSeparatorOfKeyValue() {
			return "&";
		}
			
	}
	
}
