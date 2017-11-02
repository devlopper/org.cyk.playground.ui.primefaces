package org.cyk.playground.ui.primefaces;

import java.io.Serializable;
import java.util.Collection;

import org.cyk.playground.ui.primefaces.model.Country;
import org.cyk.utility.common.computation.DataReadConfiguration;
import org.cyk.utility.common.helper.FilterHelper;

public class InstanceHelper implements Serializable {
	private static final long serialVersionUID = 1L;

	public static class Listener extends org.cyk.utility.common.helper.InstanceHelper.Listener.Adapter.Default{
    	private static final long serialVersionUID = 1L;
		
		@SuppressWarnings("unchecked")
		@Override
		public <T> Collection<T> get(Class<T> aClass,FilterHelper.Filter<T> filter, DataReadConfiguration dataReadConfiguration) {
			if(InputsPage.MyType.class.equals(aClass))
				return (Collection<T>) InputsPage.MyType.COLLECTION;
			if(Country.class.equals(aClass)){
				return (Collection<T>) Country.LIST;
			}
			return super.get(aClass,filter, dataReadConfiguration);
		}
		
		/*@SuppressWarnings("unchecked")
		@Override
		public <T> Long count(Class<T> aClass,FilterHelper.Filter<T> filter, DataReadConfiguration dataReadConfiguration) {
			if(ClassHelper.getInstance().isInstanceOf(AbstractIdentifiable.class, aClass))
				return inject(BusinessInterfaceLocator.class).injectTyped((Class<AbstractIdentifiable>)aClass).countByFilter((Filter<AbstractIdentifiable>) filter, dataReadConfiguration);
			return super.count(aClass,filter, dataReadConfiguration);
		}*/
    }
	
	public static class Label extends org.cyk.utility.common.helper.InstanceHelper.Stringifier.Label.Adapter.Default implements Serializable {
		private static final long serialVersionUID = 1L;
		
		
		
	}
}
