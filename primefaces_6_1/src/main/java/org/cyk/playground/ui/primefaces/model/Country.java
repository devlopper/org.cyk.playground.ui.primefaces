package org.cyk.playground.ui.primefaces.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Country extends AbstractIdentified {
	
	public static final List<Country> COLLECTION = new ArrayList<>();
	static {
		COLLECTION.add(new Country().setCode("CI").setName("Côte d'Ivoire"));
		COLLECTION.add(new Country().setCode("BK").setName("Burkina Faso"));
		COLLECTION.add(new Country().setCode("TG").setName("Togo"));
		COLLECTION.add(new Country().setCode("FR").setName("France"));
		COLLECTION.add(new Country().setCode("BG").setName("Belgique"));
		COLLECTION.add(new Country().setCode("USA").setName("Etats unis"));
		COLLECTION.add(new Country().setCode("CA").setName("Canada"));
		COLLECTION.add(new Country().setCode("BR").setName("Brésil"));
		COLLECTION.add(new Country().setCode("AG").setName("Argentine"));
		COLLECTION.add(new Country().setCode("PR").setName("Pérou"));
		COLLECTION.add(new Country().setCode("NIG").setName("Nigéria"));
		COLLECTION.add(new Country().setCode("NIGER").setName("Niger"));
		COLLECTION.add(new Country().setCode("GH").setName("Ghana"));
		COLLECTION.add(new Country().setCode("MAL").setName("Mali"));
		COLLECTION.add(new Country().setCode("GUI").setName("Guinée"));
		COLLECTION.add(new Country().setCode("SA").setName("Afrique de sud"));
	}
	
	@Override
	public Country setName(String name) {
		return (Country) super.setName(name);
	}
	
	@Override
	public Country setCode(String code) {
		return (Country) super.setCode(code);
	}

}