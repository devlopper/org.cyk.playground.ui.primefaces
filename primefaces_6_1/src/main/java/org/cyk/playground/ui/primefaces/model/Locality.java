package org.cyk.playground.ui.primefaces.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Locality extends AbstractIdentifiedTreeTyped<Locality,LocalityType> {
	
	public static final List<Locality> COLLECTION = new ArrayList<>();
	static {
		COLLECTION.add(new Locality().setCode("AF").setName("Afrique").setType(LocalityType.get("CONT")));
		COLLECTION.add(new Locality().setCode("AM").setName("Amérique").setType(LocalityType.get("CONT")));
		COLLECTION.add(new Locality().setCode("E").setName("Europe").setType(LocalityType.get("CONT")));
		COLLECTION.add(new Locality().setCode("AS").setName("Asie").setType(LocalityType.get("CONT")));
		COLLECTION.add(new Locality().setCode("O").setName("Océanie").setType(LocalityType.get("CONT")));
		
		COLLECTION.add(new Locality().setCode("CI").setName("Côte d'Ivoire").setParent(Locality.get("AF")).setType(LocalityType.get("COUN")));
		COLLECTION.add(new Locality().setCode("TG").setName("Togo").setParent(Locality.get("AF")).setType(LocalityType.get("COUN")));
		COLLECTION.add(new Locality().setCode("BK").setName("Burkina Faso").setParent(Locality.get("AF")).setType(LocalityType.get("COUN")));
		
		COLLECTION.add(new Locality().setCode("LAG").setName("Lagunes").setParent(Locality.get("CI")).setType(LocalityType.get("REG")));
		COLLECTION.add(new Locality().setCode("GBEKE").setName("Gbêkê").setParent(Locality.get("CI")).setType(LocalityType.get("REG")));
		
		COLLECTION.add(new Locality().setCode("ABJ").setName("Abidjan").setParent(Locality.get("LAG")).setType(LocalityType.get("CITY")));
		COLLECTION.add(new Locality().setCode("BIN").setName("Bingerville").setParent(Locality.get("LAG")).setType(LocalityType.get("CITY")));
		COLLECTION.add(new Locality().setCode("DAB").setName("Dabou").setParent(Locality.get("LAG")).setType(LocalityType.get("CITY")));
		
		COLLECTION.add(new Locality().setCode("ADJ").setName("Adjamé").setParent(Locality.get("ABJ")).setType(LocalityType.get("COM")));
		COLLECTION.add(new Locality().setCode("MAR").setName("Marcory").setParent(Locality.get("ABJ")).setType(LocalityType.get("COM")));
		COLLECTION.add(new Locality().setCode("COC").setName("Cocody").setParent(Locality.get("ABJ")).setType(LocalityType.get("COM")));
		COLLECTION.add(new Locality().setCode("TR").setName("Treichville").setParent(Locality.get("ABJ")).setType(LocalityType.get("COM")));
		COLLECTION.add(new Locality().setCode("AT").setName("Attécoubé").setParent(Locality.get("ABJ")).setType(LocalityType.get("COM")));
	}
	
	@Override
	public Locality setName(String name) {
		return (Locality) super.setName(name);
	}
	
	@Override
	public Locality setCode(String code) {
		return (Locality) super.setCode(code);
	}
	
	@Override
	public Locality setParent(Locality parent) {
		return (Locality) super.setParent(parent);
	}
	
	@Override
	public Locality setType(LocalityType type) {
		return (Locality) super.setType(type);
	}
	
	public static Locality get(String code) {
		for(Locality localityType : COLLECTION)
			if(localityType.getCode().equals(code))
				return localityType;
		return null;
	}

}