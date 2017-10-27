package org.cyk.playground.ui.primefaces.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Country {
	
	public static final List<Country> LIST = new ArrayList<>();
	static {
		LIST.add(new Country().setCode("CI").setName("Cote d'Ivoire"));
		LIST.add(new Country().setCode("BK").setName("Burkina Faso"));
		LIST.add(new Country().setCode("TG").setName("Togo"));
	}
	
	private String code,name;
	
}