package org.cyk.playground.ui.primefaces;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.cyk.playground.ui.primefaces.model.AbstractIdentified;
import org.cyk.playground.ui.primefaces.model.Article;
import org.cyk.playground.ui.primefaces.model.Country;
import org.cyk.playground.ui.primefaces.model.Locality;
import org.cyk.playground.ui.primefaces.model.LocalityType;
import org.cyk.playground.ui.primefaces.model.Location;
import org.cyk.playground.ui.primefaces.model.LocationType;
import org.cyk.playground.ui.primefaces.model.Order;
import org.cyk.playground.ui.primefaces.model.OrderItem;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.playground.ui.primefaces.model.PhoneNumberType;
import org.cyk.playground.ui.primefaces.model.movement.MovementAction;
import org.cyk.playground.ui.primefaces.model.movement.MovementCollection;
import org.cyk.playground.ui.primefaces.model.movement.MovementCollectionItem;
import org.cyk.playground.ui.primefaces.page.InputsPage;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.Constant.Action;
import org.cyk.utility.common.computation.DataReadConfiguration;
import org.cyk.utility.common.helper.ClassHelper;
import org.cyk.utility.common.helper.FieldHelper;
import org.cyk.utility.common.helper.FilterHelper;
import org.cyk.utility.common.helper.FilterHelper.Filter;

public class InstanceHelper implements Serializable {
	private static final long serialVersionUID = 1L;

	public static class Listener extends org.cyk.ui.web.api.resources.helper.InstanceHelper.Listener{
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
				
				if(ClassHelper.getInstance().isInstanceOf(AbstractIdentified.class, aClass))
					return (Collection<T>) FieldHelper.getInstance().readStatic(FieldHelper.getInstance().get(aClass, "COLLECTION"));
				
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
				}else if(Person.class.equals(aClass))
					return (Collection<T>) Person.filter((Person.Filter)filter);
				else if(Order.class.equals(aClass))
					return (Collection<T>) Order.filter((Order.Filter)filter);
				else if(OrderItem.class.equals(aClass))
					return (Collection<T>) OrderItem.filter((OrderItem.Filter)filter);
				else if(Article.class.equals(aClass))
					return (Collection<T>) Article.filter((Article.Filter)filter);
				else if(MovementAction.class.equals(aClass))
					return (Collection<T>) MovementAction.filter((MovementAction.Filter)filter);
				else if(MovementCollection.class.equals(aClass))
					return (Collection<T>) MovementCollection.filter((MovementCollection.Filter)filter);
				else if(MovementCollectionItem.class.equals(aClass))
					return (Collection<T>) MovementCollectionItem.filter((MovementCollectionItem.Filter)filter);
			
			}
			
			return super.get(aClass,filter, dataReadConfiguration);
		}
		
		@Override
		public <T> Long count(Class<T> aClass, Filter<T> filter, DataReadConfiguration dataReadConfiguration) {
			if(filter==null){
				
			}else{
				if(Person.class.equals(aClass))
					return new Long(Person.filter((Person.Filter)filter).size());
				if(Order.class.equals(aClass))
					return new Long(Order.filter((Order.Filter)filter).size());
				if(OrderItem.class.equals(aClass))
					return new Long(OrderItem.filter((OrderItem.Filter)filter).size());
				if(Article.class.equals(aClass))
					return new Long(Article.filter((Article.Filter)filter).size());
				
				if(MovementAction.class.equals(aClass))
					return new Long(MovementAction.filter((MovementAction.Filter)filter).size());
				if(MovementCollection.class.equals(aClass))
					return new Long(MovementCollection.filter((MovementCollection.Filter)filter).size());
				if(MovementCollectionItem.class.equals(aClass))
					return new Long(MovementCollectionItem.filter((MovementCollectionItem.Filter)filter).size());
			}
			return super.count(aClass, filter, dataReadConfiguration);
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
			if(Locality.class.equals(aClass))
				return (T) Locality.get((String)identifier);
			if(Country.class.equals(aClass))
				return (T) Country.get((String)identifier);
			if(Order.class.equals(aClass))
				return (T) Order.get((String)identifier);
			if(OrderItem.class.equals(aClass))
				return (T) OrderItem.get((String)identifier);
			if(Article.class.equals(aClass))
				return (T) Article.get((String)identifier);
			
			if(MovementAction.class.equals(aClass))
				return (T) MovementAction.get((String)identifier);
			if(MovementCollection.class.equals(aClass))
				return (T) MovementCollection.get((String)identifier);
			if(MovementCollectionItem.class.equals(aClass))
				return (T) MovementCollectionItem.get((String)identifier);
			
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
			}else if(instance instanceof Locality){
				if(Constant.Action.CREATE.equals(action))
					Locality.COLLECTION.add((Locality)instance);
				else if(Constant.Action.DELETE.equals(action))
					Locality.COLLECTION.remove((Locality)instance);
			}else if(instance instanceof Article){
				if(Constant.Action.CREATE.equals(action))
					Article.COLLECTION.add((Article)instance);
				else if(Constant.Action.DELETE.equals(action))
					Article.COLLECTION.remove((Article)instance);
			}else if(instance instanceof Order){
				if(Constant.Action.CREATE.equals(action)){
					Order.COLLECTION.add((Order)instance);
					OrderItem.COLLECTION.addAll(((Order)instance).getOrderItems().getElements());
				}else if(Constant.Action.DELETE.equals(action)){
					Order.COLLECTION.remove((Order)instance);
					OrderItem.COLLECTION.removeAll(((Order)instance).getOrderItems().getElements());
				}
			}else if(instance instanceof MovementCollection){
				if(Constant.Action.CREATE.equals(action))
					MovementCollection.COLLECTION.add((MovementCollection)instance);
				else if(Constant.Action.DELETE.equals(action))
					MovementCollection.COLLECTION.remove((MovementCollection)instance);
			}else if(instance instanceof MovementCollectionItem){
				if(Constant.Action.CREATE.equals(action))
					MovementCollectionItem.COLLECTION.add((MovementCollectionItem)instance);
				else if(Constant.Action.DELETE.equals(action))
					MovementCollectionItem.COLLECTION.remove((MovementCollectionItem)instance);
			}
			return super.act(action, instance);
		}
	
		@Override
		public <T> T computeChanges(T instance) {
			super.computeChanges(instance);
			if(instance instanceof MovementCollectionItem){
				MovementCollectionItem movementCollectionItem = (MovementCollectionItem) instance;
				if(movementCollectionItem.getMovementCollection() == null)
					movementCollectionItem.setPreviousCumul(null);
				else
					movementCollectionItem.setPreviousCumul(movementCollectionItem.getMovementCollection().getValue());
				
				BigDecimal cumul;
				if(movementCollectionItem.getMovementCollection() == null || movementCollectionItem.getMovementAction() == null || movementCollectionItem.getValue() == null){
					cumul = null;
				}else{
					cumul = movementCollectionItem.getMovementCollection().getValue();
					if(movementCollectionItem.getMovementAction().getName().equals("Entrée"))
						cumul = cumul.add(movementCollectionItem.getValue());
					else
						cumul = cumul.subtract(movementCollectionItem.getValue());
				}
				movementCollectionItem.setCumul(cumul);
			}
			return instance;
		}
    }
	
	public static class Label extends org.cyk.utility.common.helper.InstanceHelper.Stringifier.Label.Adapter.Default implements Serializable {
		private static final long serialVersionUID = 1L;
		
		
		
	}
}
