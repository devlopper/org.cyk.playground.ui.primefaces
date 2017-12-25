package org.cyk.playground.ui.primefaces.model.movement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cyk.playground.ui.primefaces.model.AbstractIdentified;
import org.cyk.playground.ui.primefaces.model.GlobalIdentifier;
import org.cyk.utility.common.helper.FilterHelper;
import org.cyk.utility.common.helper.RandomHelper;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class MovementCollectionItem extends AbstractIdentified {

	public static final List<MovementCollectionItem> COLLECTION;
	static {
		COLLECTION = (List<MovementCollectionItem>) instanciateManyRandomly(5);
	}
	
	private MovementCollection movementCollection;
	private MovementAction movementAction;
	private BigDecimal value;
	private BigDecimal previousCumul;
	private BigDecimal cumul;
	
	@Override
	public String toString() {
		return getCode();
	}
	
	/**/
	
	public static MovementCollectionItem instanciateOneRandomly(){
		MovementCollectionItem movementCollectionItem = new MovementCollectionItem();
		movementCollectionItem.setGlobalIdentifier(new GlobalIdentifier());
		movementCollectionItem.getGlobalIdentifier().setCode(RandomHelper.getInstance().getAlphabetic(5));
		movementCollectionItem.getGlobalIdentifier().setName(RandomHelper.getInstance().getAlphabetic(15));
		movementCollectionItem.getGlobalIdentifier().setDescription(RandomHelper.getInstance().getLines(2, 5, 3, 10));
		movementCollectionItem.setMovementCollection(RandomHelper.getInstance().getElement(MovementCollection.COLLECTION));
		movementCollectionItem.setMovementAction(RandomHelper.getInstance().getElement(MovementAction.COLLECTION));
		movementCollectionItem.setValue(new BigDecimal(RandomHelper.getInstance().getInteger(1, 10000)));
		return movementCollectionItem;
	}
	
	public static Collection<MovementCollectionItem> instanciateManyRandomly(Integer count){
		Collection<MovementCollectionItem> movementCollectionItems = new ArrayList<>();
		for(Integer index = 0 ; index < count ; index ++)
			movementCollectionItems.add(instanciateOneRandomly());
		return movementCollectionItems;
	}

	public static MovementCollectionItem get(String code,Collection<MovementCollectionItem> movementCollectionItems) {
		for(MovementCollectionItem movementCollectionItem : movementCollectionItems)
			if(movementCollectionItem.getCode().equals(code))
				return movementCollectionItem;
		return null;
	}
	
	public static MovementCollectionItem get(String code) {
		return get(code,COLLECTION);
	}
	
	/**/
	
	@Getter @Setter
	public static class Filter extends AbstractIdentified.Filter<MovementCollectionItem> implements Serializable {
		private static final long serialVersionUID = -1498269103849317057L;

		protected GlobalIdentifier.Filter globalIdentifier = new GlobalIdentifier.Filter();
		
		public Filter() {
			addCriterias(globalIdentifier);
		}
		
		public Filter(Filter criterias) {
			super(criterias);
		}
		
		@Override
		public FilterHelper.Filter<MovementCollectionItem> set(String string) {
			globalIdentifier.set(string);
			return super.set(string);
		}
	}
	
	public static List<MovementCollectionItem> filter(Filter filter,Collection<MovementCollectionItem> persons){
		Map<String,Object> map = new HashMap<>();
		
		map.put("globalIdentifier.code", filter.getGlobalIdentifier().getCode().getPreparedValue());
		map.put("globalIdentifier.name", filter.getGlobalIdentifier().getName().getPreparedValue());
		
		List<MovementCollectionItem> filtered = new ArrayList<MovementCollectionItem>();
		for(MovementCollectionItem person : persons){
			for(Map.Entry<String, Object> entry : map.entrySet()){
				if("globalIdentifier.code".equals(entry.getKey()) && person.getGlobalIdentifier().getCode().contains((String)entry.getValue())){
					filtered.add(person);
					break;
				}else if("globalIdentifier.name".equals(entry.getKey()) && person.getGlobalIdentifier().getName().contains((String)entry.getValue())){
					filtered.add(person);
					break;
				}
			}	
		}
		
		return filtered;
	}
	
	public static List<MovementCollectionItem> filter(Filter filter){
		return filter(filter,COLLECTION);
	}
}
