package org.cyk.playground.ui.primefaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.cyk.playground.ui.primefaces.model.Country;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.playground.ui.primefaces.page.InputsPage;
import org.cyk.utility.common.computation.DataReadConfiguration;
import org.cyk.utility.common.helper.FilterHelper;

public class InstanceHelper implements Serializable {
	private static final long serialVersionUID = 1L;

	public static class Listener extends org.cyk.utility.common.helper.InstanceHelper.Listener.Adapter.Default{
    	private static final long serialVersionUID = 1L;
		
    	@Override
    	public Object getIdentifier(Object instance) {
    		if(instance instanceof Country)
    			return ((Country)instance).getCode();
    		if(instance instanceof Person)
    			return ((Person)instance).getGlobalIdentifier().getCode();
    		return super.getIdentifier(instance);
    	}
    	
		@SuppressWarnings("unchecked")
		@Override
		public <T> Collection<T> get(Class<T> aClass,FilterHelper.Filter<T> filter, DataReadConfiguration dataReadConfiguration) {
			if(filter==null){
				if(InputsPage.MyType.class.equals(aClass))
					return (Collection<T>) InputsPage.MyType.COLLECTION;
				if(Country.class.equals(aClass)){
					return (Collection<T>) Country.LIST;
				}	
			}else {
				if(InputsPage.MyType.class.equals(aClass))
					return (Collection<T>) InputsPage.MyType.COLLECTION;
				if(Country.class.equals(aClass)){
					List<Country> list;
					String query = (String)filter.getCriterias().get(0).getPreparedValue();
					if(StringUtils.isBlank(query))
						list =  Country.LIST;
					else{
						list = new ArrayList<>();
						for(Country country : Country.LIST)
							if(StringUtils.containsIgnoreCase(country.getCode(), query) || StringUtils.containsIgnoreCase(country.getName(), query))
								list.add(country);
					}
					return (Collection<T>) list;
				}	
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
