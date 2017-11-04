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
		LIST.add(new Country().setCode("CI").setName("Côte d'Ivoire"));
		LIST.add(new Country().setCode("BK").setName("Burkina Faso"));
		LIST.add(new Country().setCode("TG").setName("Togo"));
		LIST.add(new Country().setCode("FR").setName("France"));
		LIST.add(new Country().setCode("BG").setName("Belgique"));
		LIST.add(new Country().setCode("USA").setName("Etats unis"));
		LIST.add(new Country().setCode("CA").setName("Canada"));
		LIST.add(new Country().setCode("BR").setName("Brésil"));
		LIST.add(new Country().setCode("AG").setName("Argentine"));
		LIST.add(new Country().setCode("PR").setName("Pérou"));
		LIST.add(new Country().setCode("NIG").setName("Nigéria"));
		LIST.add(new Country().setCode("NIGER").setName("Niger"));
		LIST.add(new Country().setCode("GH").setName("Ghana"));
		LIST.add(new Country().setCode("MAL").setName("Mali"));
		LIST.add(new Country().setCode("GUI").setName("Guinée"));
		LIST.add(new Country().setCode("SA").setName("Afrique de sud"));
	}
	
	private String code,name;
	
	@Override
	public String toString() {
		return name;
	}
}