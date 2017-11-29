package org.cyk.playground.ui.primefaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.cyk.playground.ui.primefaces.model.AbstractIdentified;
import org.cyk.playground.ui.primefaces.model.Country;
import org.cyk.playground.ui.primefaces.model.LocalityType;
import org.cyk.playground.ui.primefaces.model.Location;
import org.cyk.playground.ui.primefaces.model.LocationType;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.playground.ui.primefaces.model.PhoneNumberType;
import org.cyk.playground.ui.primefaces.page.InputsPage;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.Constant.Action;
import org.cyk.utility.common.computation.DataReadConfiguration;
import org.cyk.utility.common.helper.FilterHelper;
import org.cyk.utility.common.userinterface.container.window.LoginWindow;
import org.cyk.utility.common.userinterface.container.window.LoginWindow.Credentials;

public class InstanceHelper implements Serializable {
	private static final long serialVersionUID = 1L;

	public static class Listener extends org.cyk.utility.common.helper.InstanceHelper.Listener.Adapter.Default{
    	private static final long serialVersionUID = 1L;
		
    	@Override
    	public Object getIdentifier(Object instance) {
    		if(instance instanceof AbstractIdentified)
    			return ((AbstractIdentified)instance).getGlobalIdentifier().getCode();
    		return super.getIdentifier(instance);
    	}
    	
		@SuppressWarnings("unchecked")
		@Override
		public <T> Collection<T> get(Class<T> aClass,FilterHelper.Filter<T> filter, DataReadConfiguration dataReadConfiguration) {
			if(filter==null){
				if(InputsPage.MyType.class.equals(aClass))
					return (Collection<T>) InputsPage.MyType.COLLECTION;
				if(Country.class.equals(aClass)){
					return (Collection<T>) Country.COLLECTION;
				}	
				if(LocationType.class.equals(aClass)){
					return (Collection<T>) LocationType.COLLECTION;
				}	
				if(PhoneNumberType.class.equals(aClass)){
					return (Collection<T>) PhoneNumberType.COLLECTION;
				}	
				if(LocalityType.class.equals(aClass)){
					return (Collection<T>) LocalityType.COLLECTION;
				}	
				if(Person.class.equals(aClass)){
					return (Collection<T>) Person.COLLECTION;
				}	
			}else {
				if(InputsPage.MyType.class.equals(aClass))
					return (Collection<T>) InputsPage.MyType.COLLECTION;
				if(Country.class.equals(aClass)){
					List<Country> list;
					String query = (String)filter.getCriterias().get(0).getPreparedValue();
					if(StringUtils.isBlank(query))
						list =  Country.COLLECTION;
					else{
						list = new ArrayList<>();
						for(Country country : Country.COLLECTION)
							if(StringUtils.containsIgnoreCase(country.getCode(), query) || StringUtils.containsIgnoreCase(country.getName(), query))
								list.add(country);
					}
					return (Collection<T>) list;
				}else if(LocationType.class.equals(aClass)){
					List<LocationType> list;
					String query = (String)filter.getCriterias().get(0).getPreparedValue();
					if(StringUtils.isBlank(query))
						list =  LocationType.COLLECTION;
					else{
						list = new ArrayList<>();
						for(LocationType locationType : LocationType.COLLECTION)
							if(StringUtils.containsIgnoreCase(locationType.getCode(), query) || StringUtils.containsIgnoreCase(locationType.getName(), query))
								list.add(locationType);
					}
					return (Collection<T>) list;
				}		
			}
			
			return super.get(aClass,filter, dataReadConfiguration);
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public <T> T getByIdentifier(Class<T> aClass, Object identifier) {
			if(Person.class.equals(aClass))
				return (T) Person.get((String)identifier);
			if(PhoneNumberType.class.equals(aClass))
				return (T) PhoneNumberType.get((String)identifier);
			if(LocationType.class.equals(aClass))
				return (T) LocationType.get((String)identifier);
			if(Location.class.equals(aClass))
				return (T) Location.get((String)identifier);
			if(LocalityType.class.equals(aClass))
				return (T) LocalityType.get((String)identifier);
			return super.getByIdentifier(aClass, identifier);
		}
		
		/*@SuppressWarnings("unchecked")
		@Override
		public <T> Long count(Class<T> aClass,FilterHelper.Filter<T> filter, DataReadConfiguration dataReadConfiguration) {
			if(ClassHelper.getInstance().isInstanceOf(AbstractIdentifiable.class, aClass))
				return inject(BusinessInterfaceLocator.class).injectTyped((Class<AbstractIdentifiable>)aClass).countByFilter((Filter<AbstractIdentifiable>) filter, dataReadConfiguration);
			return super.count(aClass,filter, dataReadConfiguration);
		}*/
		
		@Override
		public Object act(Action action, Object instance) {
			if(Action.LOGIN.equals(action)){
				LoginWindow.Credentials credentials = (Credentials) instance;
				
				return null;
			}
			if(Action.LOGOUT.equals(action)){
				
				return null;
			}
			if(instance instanceof Person){
				if(Constant.Action.CREATE.equals(action))
					Person.COLLECTION.add((Person)instance);
				else if(Constant.Action.DELETE.equals(action))
					Person.COLLECTION.remove((Person)instance);
			}else if(instance instanceof PhoneNumberType){
				if(Constant.Action.CREATE.equals(action))
					PhoneNumberType.COLLECTION.add((PhoneNumberType)instance);
				else if(Constant.Action.DELETE.equals(action))
					PhoneNumberType.COLLECTION.remove((PhoneNumberType)instance);
			}else if(instance instanceof LocationType){
				if(Constant.Action.CREATE.equals(action))
					LocationType.COLLECTION.add((LocationType)instance);
				else if(Constant.Action.DELETE.equals(action))
					LocationType.COLLECTION.remove((LocationType)instance);
			}else if(instance instanceof Location){
				if(Constant.Action.CREATE.equals(action))
					Location.COLLECTION.add((Location)instance);
				else if(Constant.Action.DELETE.equals(action))
					Location.COLLECTION.remove((Location)instance);
			}else if(instance instanceof Country){
				
			}else if(instance instanceof LocalityType){
				if(Constant.Action.CREATE.equals(action))
					LocalityType.COLLECTION.add((LocalityType)instance);
				else if(Constant.Action.DELETE.equals(action))
					LocalityType.COLLECTION.remove((LocalityType)instance);
			}
			return super.act(action, instance);
		}
    }
	
	public static class Label extends org.cyk.utility.common.helper.InstanceHelper.Stringifier.Label.Adapter.Default implements Serializable {
		private static final long serialVersionUID = 1L;
		
		
		
	}
}
