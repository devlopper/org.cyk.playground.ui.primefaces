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
import org.cyk.utility.common.helper.CollectionHelper;
import org.cyk.utility.common.helper.RandomHelper;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class MovementCollection extends AbstractIdentified {

	public static final List<MovementCollection> COLLECTION;
	static {
		COLLECTION = (List<MovementCollection>) instanciateManyRandomly(3);
	}
	
	private BigDecimal value;
	private CollectionHelper.Instance<MovementCollectionItem> movementCollectionItems = new CollectionHelper.Instance<>();
	
	@Override
	public String toString() {
		return getCode();
	}
	
	/**/
	
	public static MovementCollection instanciateOneRandomly(){
		MovementCollection movementCollection = new MovementCollection();
		movementCollection.setGlobalIdentifier(new GlobalIdentifier());
		movementCollection.getGlobalIdentifier().setCode("MOV"+RandomHelper.getInstance().getNumeric(5));
		movementCollection.getGlobalIdentifier().setName(RandomHelper.getInstance().getAlphabetic(15));
		movementCollection.getGlobalIdentifier().setDescription(RandomHelper.getInstance().getLines(2, 5, 3, 10));
		movementCollection.setValue(new BigDecimal(RandomHelper.getInstance().getInteger(1, 10000)));
		return movementCollection;
	}
	
	public static Collection<MovementCollection> instanciateManyRandomly(Integer count){
		Collection<MovementCollection> movementCollections = new ArrayList<>();
		for(Integer index = 0 ; index < count ; index ++)
			movementCollections.add(instanciateOneRandomly());
		return movementCollections;
	}

	public static MovementCollection get(String code,Collection<MovementCollection> movementCollections) {
		for(MovementCollection movementCollection : movementCollections)
			if(movementCollection.getCode().equals(code))
				return movementCollection;
		return null;
	}
	
	public static MovementCollection get(String code) {
		return get(code,COLLECTION);
	}
	
	/**/
	
	@Getter @Setter
	public static class Filter extends AbstractIdentified.Filter<MovementCollection> implements Serializable {
		private static final long serialVersionUID = -1498269103849317057L;

		
	}
	
	public static List<MovementCollection> filter(Filter filter,Collection<MovementCollection> persons){
		Map<String,Object> map = new HashMap<>();
		
		map.put("globalIdentifier.code", filter.getGlobalIdentifier().getCode().getPreparedValue());
		map.put("globalIdentifier.name", filter.getGlobalIdentifier().getName().getPreparedValue());
		
		List<MovementCollection> filtered = new ArrayList<MovementCollection>();
		for(MovementCollection person : persons){
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
	
	public static List<MovementCollection> filter(Filter filter){
		return filter(filter,COLLECTION);
	}
}
