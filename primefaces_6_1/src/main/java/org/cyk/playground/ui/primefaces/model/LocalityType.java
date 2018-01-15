package org.cyk.playground.ui.primefaces.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cyk.utility.common.annotation.FieldOverride;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @FieldOverride(name="parent",type=LocalityType.class)
public class LocalityType extends AbstractIdentifiedTree<LocalityType> {
	
	public static final List<LocalityType> COLLECTION = new ArrayList<>();
	static {
		COLLECTION.add(new LocalityType().setCode("CONT").setName("Continent"));
		COLLECTION.add(new LocalityType().setCode("COUN").setName("Country").setParent(get("CONT")));
		COLLECTION.add(new LocalityType().setCode("REG").setName("Region").setParent(get("COUN")));
		COLLECTION.add(new LocalityType().setCode("CITY").setName("City").setParent(get("REG")));
		COLLECTION.add(new LocalityType().setCode("COM").setName("Commune").setParent(get("CITY")));
	}
	
	@Override
	public LocalityType setName(String name) {
		return (LocalityType) super.setName(name);
	}
	
	@Override
	public LocalityType setCode(String code) {
		return (LocalityType) super.setCode(code);
	}
	
	@Override
	public LocalityType setParent(LocalityType parent) {
		return (LocalityType) super.setParent(parent);
	}
	
	public static LocalityType get(String code) {
		for(LocalityType localityType : COLLECTION)
			if(localityType.getCode().equals(code))
				return localityType;
		return null;
	}
	
	public static Collection<LocalityType> getRoots(){
		return getByParent(null);
	}
	
	public static Collection<LocalityType> getByParent(LocalityType parent){
		Collection<LocalityType> localityTypes = new ArrayList<>();
		for(LocalityType index : COLLECTION)
			if(index.getParent() == parent)
				localityTypes.add(index);
		return localityTypes;
	}
	
	public static List<LocalityType> filter(Filter filter,Collection<LocalityType> localityTypes){
		Map<String,Object> map = new HashMap<>();
		
		map.put("globalIdentifier.code", filter.getGlobalIdentifier().getCode().getPreparedValue());
		map.put("globalIdentifier.name", filter.getGlobalIdentifier().getName().getPreparedValue());
		
		List<LocalityType> filtered = new ArrayList<LocalityType>();
		for(LocalityType localityType : localityTypes){
			for(Map.Entry<String, Object> entry : map.entrySet()){
				if("globalIdentifier.code".equals(entry.getKey()) && localityType.getGlobalIdentifier().getCode().contains((String)entry.getValue())){
					filtered.add(localityType);
					break;
				}else if("globalIdentifier.name".equals(entry.getKey()) && localityType.getGlobalIdentifier().getName().contains((String)entry.getValue())){
					filtered.add(localityType);
					break;
				}
			}	
		}
		
		return filtered;
	}
	
	public static List<LocalityType> filter(Filter filter){
		return filter(filter,COLLECTION);
	}
	
	public static void remove(LocalityType localityType){
		for(LocalityType index : COLLECTION)
			if(index.getParent()!=null && index.getParent().getCode().equals(localityType.getCode()))
				index.setParent(localityType.getParent());
		COLLECTION.remove(localityType);
	}
	
	/**/
	
	@Getter @Setter
	public static class Filter extends AbstractIdentified.Filter<LocalityType> implements Serializable {
		private static final long serialVersionUID = -1498269103849317057L;

	}

}