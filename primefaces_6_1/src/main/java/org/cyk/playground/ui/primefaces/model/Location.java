package org.cyk.playground.ui.primefaces.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Location extends AbstractIdentified {

	private Country country;
	private String address;
	
	public static final String FIELD_COUNTRY = "country";
	public static final String FIELD_ADDRESS = "address";
	
}
