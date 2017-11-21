package org.cyk.playground.ui.primefaces.model;

import java.util.ArrayList;
import java.util.List;

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

}