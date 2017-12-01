package org.cyk.playground.ui.primefaces.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
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

}