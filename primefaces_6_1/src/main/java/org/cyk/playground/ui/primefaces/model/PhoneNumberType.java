package org.cyk.playground.ui.primefaces.model;

import java.util.ArrayList;
import java.util.Collection;
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
	
	public static List<PhoneNumberType> filter(Collection<PhoneNumberType> phoneNumberTypes,Map<String,Object> map){
		List<PhoneNumberType> temp = null;
		List<PhoneNumberType> filtered = new ArrayList<PhoneNumberType>();
		for(Map.Entry<String, Object> entry : map.entrySet()){
			if("globalFilter".equals(entry.getKey())){
				temp = new ArrayList<PhoneNumberType>(temp == null ? phoneNumberTypes : filtered);
				filtered = new ArrayList<PhoneNumberType>();
				for(PhoneNumberType phoneNumberType : temp)
					if(phoneNumberType.getGlobalIdentifier().getCode().contains((String)entry.getValue()) 
							|| phoneNumberType.getGlobalIdentifier().getName().contains((String)entry.getValue())
							|| phoneNumberType.getGlobalIdentifier().getOwner().contains((String)entry.getValue())
							)
						filtered.add(phoneNumberType);
			}else if("globalIdentifier.code".equals(entry.getKey())){
				temp = new ArrayList<PhoneNumberType>(temp == null ? phoneNumberTypes : filtered);
				filtered = new ArrayList<PhoneNumberType>();
				for(PhoneNumberType phoneNumberType : temp)
					if(phoneNumberType.getGlobalIdentifier().getCode().contains((String)entry.getValue()))
						filtered.add(phoneNumberType);
			}else if("globalIdentifier.name".equals(entry.getKey())){
				temp = new ArrayList<PhoneNumberType>(temp == null ? phoneNumberTypes : filtered);
				filtered = new ArrayList<PhoneNumberType>();
				for(PhoneNumberType phoneNumberType : temp)
					if(phoneNumberType.getGlobalIdentifier().getName().contains((String)entry.getValue()))
						filtered.add(phoneNumberType);
			}else if("globalIdentifier.owner".equals(entry.getKey())){
				temp = new ArrayList<PhoneNumberType>(temp == null ? phoneNumberTypes : filtered);
				filtered = new ArrayList<PhoneNumberType>();
				for(PhoneNumberType phoneNumberType : temp)
					if(phoneNumberType.getGlobalIdentifier().getOwner().contains((String)entry.getValue()))
						filtered.add(phoneNumberType);
			}
			
		}
		filtered = (List<PhoneNumberType>) (temp == null ? phoneNumberTypes : filtered);
		return filtered;
	}

}