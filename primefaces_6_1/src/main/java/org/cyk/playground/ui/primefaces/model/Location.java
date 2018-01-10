package org.cyk.playground.ui.primefaces.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public static void create(String code,String name,String image){
		Location location = new Location();
		location.setGlobalIdentifier(new GlobalIdentifier());
		location.getGlobalIdentifier().setCode(code);
		location.getGlobalIdentifier().setName(name);
		location.getGlobalIdentifier().setImage(new File(FileHelper.getInstance().get(ContextListener.class, image)));
		COLLECTION.add(location);
	}
	
	public static Location get(String code,Collection<Location> locations) {
		for(Location location : locations)
			if(location.getCode().equals(code))
				return location;
		return null;
	}
	
	public static Location get(String code) {
		return get(code,COLLECTION);
	}
	
	@Getter @Setter
	public static class Filter extends AbstractIdentified.Filter<Location> implements Serializable {
		private static final long serialVersionUID = -1498269103849317057L;

	}
	
	public static List<Location> filter(Filter filter,Collection<Location> locations){
		Map<String,Object> map = new HashMap<>();
		
		map.put("globalIdentifier.code", filter.getGlobalIdentifier().getCode().getPreparedValue());
		map.put("globalIdentifier.name", filter.getGlobalIdentifier().getName().getPreparedValue());
		
		List<Location> filtered = new ArrayList<Location>();
		for(Location location : locations){
			for(Map.Entry<String, Object> entry : map.entrySet()){
				if("globalIdentifier.code".equals(entry.getKey()) && location.getGlobalIdentifier().getCode().contains((String)entry.getValue())){
					filtered.add(location);
					break;
				}else if("globalIdentifier.name".equals(entry.getKey()) && location.getGlobalIdentifier().getName().contains((String)entry.getValue())){
					filtered.add(location);
					break;
				}
			}	
		}
		
		return filtered;
	}
	
	public static List<Location> filter(Filter filter){
		return filter(filter,COLLECTION);
	}
}
