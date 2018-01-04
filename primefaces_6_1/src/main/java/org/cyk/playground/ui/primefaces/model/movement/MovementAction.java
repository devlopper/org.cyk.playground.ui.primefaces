package org.cyk.playground.ui.primefaces.model.movement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.cyk.playground.ui.primefaces.model.AbstractIdentified;
import org.cyk.playground.ui.primefaces.model.GlobalIdentifier;
import org.cyk.utility.common.helper.FilterHelper;
import org.cyk.utility.common.helper.RandomHelper;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class MovementAction extends AbstractIdentified {

	public static MovementAction IN = instanciateOneRandomly("Entrée");
	public static MovementAction OUT = instanciateOneRandomly("Sortie");
	
	private static final String[] NAMES = {"Entrée","Sortie"};
	public static final List<MovementAction> COLLECTION;
	static {
		//COLLECTION = (List<MovementAction>) instanciateManyRandomly(20);
		IN.setCode("IN");
		OUT.setCode("OUT");
		
		COLLECTION = new ArrayList<MovementAction>();
		COLLECTION.add(IN);
		COLLECTION.add(OUT);
	}
	
	private BigDecimal unitPrice;
	
	@Override
	public String toString() {
		return getName();
	}
	
	/**/
	
	public static MovementAction instanciateOneRandomly(String name){
		String code;
		if(StringUtils.isBlank(name)){
			code = RandomHelper.getInstance().getAlphabetic(5).toUpperCase();
			name = RandomHelper.getInstance().getAlphabetic(15);
		}else
			code = StringUtils.removeAll(name.toUpperCase()," ");
		MovementAction article = new MovementAction();
		article.setGlobalIdentifier(new GlobalIdentifier());
		article.getGlobalIdentifier().setCode(code);
		article.getGlobalIdentifier().setName(name);
		article.getGlobalIdentifier().setDescription(RandomHelper.getInstance().getLines(2, 5, 3, 10));
		article.setUnitPrice(new BigDecimal(RandomHelper.getInstance().getInteger(1, 10000)));
		return article;
	}
	
	public static Collection<MovementAction> instanciateManyRandomly(Integer count){
		Collection<MovementAction> articles = new ArrayList<>();
		for(String name : NAMES)
		//for(Integer index = 0 ; index < count ; index ++)
			articles.add(instanciateOneRandomly(name));
		return articles;
	}

	public static MovementAction get(String code,Collection<MovementAction> articles) {
		for(MovementAction article : articles)
			if(article.getCode().equals(code))
				return article;
		return null;
	}
	
	public static MovementAction get(String code) {
		return get(code,COLLECTION);
	}
	
	/**/
	
	@Getter @Setter
	public static class Filter extends AbstractIdentified.Filter<MovementAction> implements Serializable {
		private static final long serialVersionUID = -1498269103849317057L;

		protected GlobalIdentifier.Filter globalIdentifier = new GlobalIdentifier.Filter();
		
		public Filter() {
			addCriterias(globalIdentifier);
		}
		
		public Filter(Filter criterias) {
			super(criterias);
		}
		
		@Override
		public FilterHelper.Filter<MovementAction> set(String string) {
			globalIdentifier.set(string);
			return super.set(string);
		}
	}
	
	public static List<MovementAction> filter(Filter filter,Collection<MovementAction> persons){
		Map<String,Object> map = new HashMap<>();
		
		map.put("globalIdentifier.code", filter.getGlobalIdentifier().getCode().getPreparedValue());
		map.put("globalIdentifier.name", filter.getGlobalIdentifier().getName().getPreparedValue());
		
		List<MovementAction> filtered = new ArrayList<MovementAction>();
		for(MovementAction person : persons){
			for(Map.Entry<String, Object> entry : map.entrySet()){
				if("globalIdentifier.code".equals(entry.getKey()) && person.getGlobalIdentifier().getCode().contains((String)entry.getValue())){
					filtered.add(person);
					break;
				}else if("globalIdentifier.name".equals(entry.getKey()) && person.getGlobalIdentifier().getName().contains((String)entry.getValue())){
					filtered.add(person);
					break;
				}
			}	
		}
		
		return filtered;
	}
	
	public static List<MovementAction> filter(Filter filter){
		return filter(filter,COLLECTION);
	}
}
