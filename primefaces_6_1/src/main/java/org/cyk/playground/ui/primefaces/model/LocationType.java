package org.cyk.playground.ui.primefaces.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class LocationType extends AbstractIdentified {
	
	public static final List<LocationType> COLLECTION = new ArrayList<>();
	static {
		COLLECTION.add(new LocationType().setCode("HOME").setName("Maison"));
		COLLECTION.add(new LocationType().setCode("OFFICE").setName("Bureau"));
	}
	
	@Override
	public LocationType setName(String name) {
		return (LocationType) super.setName(name);
	}
	
	@Override
	public LocationType setCode(String code) {
		return (LocationType) super.setCode(code);
	}
	
	public static LocationType get(String code) {
		for(LocationType locationType : COLLECTION)
			if(locationType.getCode().equals(code))
				return locationType;
		return null;
	}
	
	@Getter @Setter
	public static class Filter extends AbstractIdentified.Filter<LocationType> implements Serializable {
		private static final long serialVersionUID = -1498269103849317057L;

	}
	
	public static List<LocationType> filter(Filter filter,Collection<LocationType> locationTypes){
		Map<String,Object> map = new HashMap<>();
		
		map.put("globalIdentifier.code", filter.getGlobalIdentifier().getCode().getPreparedValue());
		map.put("globalIdentifier.name", filter.getGlobalIdentifier().getName().getPreparedValue());
		
		List<LocationType> filtered = new ArrayList<LocationType>();
		for(LocationType locationType : locationTypes){
			for(Map.Entry<String, Object> entry : map.entrySet()){
				if("globalIdentifier.code".equals(entry.getKey()) && locationType.getGlobalIdentifier().getCode().contains((String)entry.getValue())){
					filtered.add(locationType);
					break;
				}else if("globalIdentifier.name".equals(entry.getKey()) && locationType.getGlobalIdentifier().getName().contains((String)entry.getValue())){
					filtered.add(locationType);
					break;
				}
			}	
		}
		
		return filtered;
	}
	
	public static List<LocationType> filter(Filter filter){
		return filter(filter,COLLECTION);
	}

}