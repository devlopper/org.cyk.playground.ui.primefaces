package org.cyk.playground.ui.primefaces.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.cyk.utility.common.helper.FilterHelper;
import org.cyk.utility.common.helper.RandomHelper;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Article extends AbstractIdentified {

	private static final String[] NAMES = {"Omo","Javel","Riz","Installation decodeur","Parabole SAT","Papier hygienique"
			,"Ventillateur","Robot","Moteur AZ30","Tomate","Tapis"};
	public static final List<Article> COLLECTION;
	static {
		COLLECTION = (List<Article>) instanciateManyRandomly(20);
	}
	
	private BigDecimal unitPrice;
	
	@Override
	public String toString() {
		return getName();
	}
	
	/**/
	
	public static Article instanciateOneRandomly(String name){
		String code;
		if(StringUtils.isBlank(name)){
			code = RandomHelper.getInstance().getAlphabetic(5).toUpperCase();
			name = RandomHelper.getInstance().getAlphabetic(15);
		}else
			code = StringUtils.removeAll(name.toUpperCase()," ");
		Article article = new Article();
		article.setGlobalIdentifier(new GlobalIdentifier());
		article.getGlobalIdentifier().setCode(code);
		article.getGlobalIdentifier().setName(name);
		article.getGlobalIdentifier().setDescription(RandomHelper.getInstance().getLines(2, 5, 3, 10));
		article.setUnitPrice(new BigDecimal(RandomHelper.getInstance().getInteger(1, 10000)));
		return article;
	}
	
	public static Collection<Article> instanciateManyRandomly(Integer count){
		Collection<Article> articles = new ArrayList<>();
		for(String name : NAMES)
		//for(Integer index = 0 ; index < count ; index ++)
			articles.add(instanciateOneRandomly(name));
		return articles;
	}

	public static Article get(String code,Collection<Article> articles) {
		for(Article article : articles)
			if(article.getCode().equals(code))
				return article;
		return null;
	}
	
	public static Article get(String code) {
		return get(code,COLLECTION);
	}
	
	/**/
	
	@Getter @Setter
	public static class Filter extends AbstractIdentified.Filter<Article> implements Serializable {
		private static final long serialVersionUID = -1498269103849317057L;

		protected GlobalIdentifier.Filter globalIdentifier = new GlobalIdentifier.Filter();
		
		public Filter() {
			addCriterias(globalIdentifier);
		}
		
		public Filter(Filter criterias) {
			super(criterias);
		}
		
		@Override
		public FilterHelper.Filter<Article> set(String string) {
			globalIdentifier.set(string);
			return super.set(string);
		}
	}
	
	public static List<Article> filter(Filter filter,Collection<Article> persons){
		Map<String,Object> map = new HashMap<>();
		
		map.put("globalIdentifier.code", filter.getGlobalIdentifier().getCode().getPreparedValue());
		map.put("globalIdentifier.name", filter.getGlobalIdentifier().getName().getPreparedValue());
		
		List<Article> filtered = new ArrayList<Article>();
		for(Article person : persons){
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
	
	public static List<Article> filter(Filter filter){
		return filter(filter,COLLECTION);
	}
}
