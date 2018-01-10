package org.cyk.playground.ui.primefaces.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public static PhoneNumberType get(String code) {
		for(PhoneNumberType phoneNumberType : COLLECTION)
			if(phoneNumberType.getCode().equals(code))
				return phoneNumberType;
		return null;
	}
	
	/**/
	
	@Getter @Setter
	public static class Filter extends AbstractIdentified.Filter<PhoneNumberType> implements Serializable {
		private static final long serialVersionUID = -1498269103849317057L;

	}
	
	public static List<PhoneNumberType> filter(Filter filter,Collection<PhoneNumberType> phoneNumberTypes){
		Map<String,Object> map = new HashMap<>();
		
		map.put("globalIdentifier.code", filter.getGlobalIdentifier().getCode().getPreparedValue());
		map.put("globalIdentifier.name", filter.getGlobalIdentifier().getName().getPreparedValue());
		
		List<PhoneNumberType> filtered = new ArrayList<PhoneNumberType>();
		for(PhoneNumberType phoneNumberType : phoneNumberTypes){
			for(Map.Entry<String, Object> entry : map.entrySet()){
				if("globalIdentifier.code".equals(entry.getKey()) && phoneNumberType.getGlobalIdentifier().getCode().contains((String)entry.getValue())){
					filtered.add(phoneNumberType);
					break;
				}else if("globalIdentifier.name".equals(entry.getKey()) && phoneNumberType.getGlobalIdentifier().getName().contains((String)entry.getValue())){
					filtered.add(phoneNumberType);
					break;
				}
			}	
		}
		
		return filtered;
	}
	
	public static List<PhoneNumberType> filter(Filter filter){
		return filter(filter,COLLECTION);
	}

}