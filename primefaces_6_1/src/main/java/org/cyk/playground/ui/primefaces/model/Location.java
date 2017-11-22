package org.cyk.playground.ui.primefaces.model;

import java.util.ArrayList;
import java.util.List;

import org.cyk.playground.ui.primefaces.ContextListener;
import org.cyk.utility.common.helper.FileHelper;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Location extends AbstractIdentified {

	public static final List<Location> COLLECTION = new ArrayList<>();
	static {
		create("CI", "Côte d'Ivoire","country_ci.png");
		create("FR", "France","country_fr.png");
	}
	
	private Country country;
	private String address;
	private LocationType type;
	
	public static final String FIELD_COUNTRY = "country";
	public static final String FIELD_ADDRESS = "address";
	public static final String FIELD_TYPE = "type";
	
	public static Location get(String code) {
		for(Location location : COLLECTION)
			if(location.getCode().equals(code))
				return location;
		return null;
	}
	
	public static void create(String code,String name,String image){
		Location location = new Location();
		location.setGlobalIdentifier(new GlobalIdentifier());
		location.getGlobalIdentifier().setCode(code);
		location.getGlobalIdentifier().setName(name);
		location.getGlobalIdentifier().setImage(new File(FileHelper.getInstance().get(ContextListener.class, image)));
		COLLECTION.add(location);
	}
}
