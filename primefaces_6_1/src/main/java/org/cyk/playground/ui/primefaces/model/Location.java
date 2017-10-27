package org.cyk.playground.ui.primefaces.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Location {

	private Country country;
	private String address;
	private String otherDetails;
	
}
