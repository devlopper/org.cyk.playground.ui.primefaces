package org.cyk.playground.ui.primefaces.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class PhoneNumberType extends AbstractIdentified {
	
	public static final List<PhoneNumberType> COLLECTION = new ArrayList<>();
	static {
		COLLECTION.add(new PhoneNumberType().setCode("LAND").setName("Fixe"));
		COLLECTION.add(new PhoneNumberType().setCode("MOBILE").setName("Mobile"));
	}
	
	@Override
	public PhoneNumberType setName(String name) {
		return (PhoneNumberType) super.setName(name);
	}
	
	@Override
	public PhoneNumberType setCode(String code) {
		return (PhoneNumberType) super.setCode(code);
	}

}