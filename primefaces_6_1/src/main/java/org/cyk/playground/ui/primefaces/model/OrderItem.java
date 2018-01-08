package org.cyk.playground.ui.primefaces.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cyk.utility.common.helper.CollectionHelper;
import org.cyk.utility.common.helper.FilterHelper;
import org.cyk.utility.common.helper.RandomHelper;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class OrderItem extends AbstractIdentified {

	public static final List<OrderItem> COLLECTION;
	static {
		COLLECTION = (List<OrderItem>) instanciateManyRandomly(10);
	}
	
	private Order order;
	private Article article;
	private BigDecimal quantity,reduction,amount;
	
	@Override
	public String toString() {
		return getCode();
	}
	
	/**/
	
	public static OrderItem instanciateOneRandomly(){
		OrderItem orderItem = new OrderItem();
		orderItem.setGlobalIdentifier(new GlobalIdentifier());
		orderItem.setArticle(RandomHelper.getInstance().getElement(Article.COLLECTION));
		orderItem.getGlobalIdentifier().setCode(RandomHelper.getInstance().getAlphabetic(5));
		orderItem.getGlobalIdentifier().setName(orderItem.getArticle().getName());
		orderItem.getGlobalIdentifier().setDescription(RandomHelper.getInstance().getLines(2, 5, 3, 10));
		orderItem.setOrder(RandomHelper.getInstance().getElement(Order.COLLECTION));
		orderItem.setQuantity(new BigDecimal(RandomHelper.getInstance().getInteger(1, 20)));
		orderItem.setReduction(new BigDecimal(RandomHelper.getInstance().getInteger(1, 10000)));
		orderItem.setAmount(new BigDecimal(RandomHelper.getInstance().getInteger(1, 10000)));
		return orderItem;
	}
	
	public static Collection<OrderItem> instanciateManyRandomly(Integer count){
		Collection<OrderItem> orderItems = new ArrayList<>();
		for(Integer index = 0 ; index < count ; index ++)
			orderItems.add(instanciateOneRandomly());
		return orderItems;
	}

	public static OrderItem get(String code,Collection<OrderItem> orderItems) {
		for(OrderItem orderItem : orderItems)
			if(orderItem.getCode().equals(code))
				return orderItem;
		return null;
	}
	
	public static OrderItem get(String code) {
		return get(code,COLLECTION);
	}
	
	/**/
	
	@Getter @Setter
	public static class Filter extends AbstractIdentified.Filter<OrderItem> implements Serializable {
		private static final long serialVersionUID = -1498269103849317057L;

		protected GlobalIdentifier.Filter globalIdentifier = new GlobalIdentifier.Filter();
		
		public Filter() {
			addCriterias(globalIdentifier);
		}
		
		public Filter(Filter criterias) {
			super(criterias);
		}
		
		@Override
		public FilterHelper.Filter<OrderItem> set(String string) {
			globalIdentifier.set(string);
			return super.set(string);
		}
	}
	
	public static List<OrderItem> filter(Filter filter,Collection<OrderItem> orderItems){
		Map<String,Object> map = new HashMap<>();
		
		map.put("globalIdentifier.code", filter.getGlobalIdentifier().getCode().getPreparedValue());
		map.put("globalIdentifier.name", filter.getGlobalIdentifier().getName().getPreparedValue());
		
		List<OrderItem> filtered = new ArrayList<OrderItem>();
		for(OrderItem orderItem : orderItems){
			if(CollectionHelper.getInstance().isEmpty(filter.getMasters()) || CollectionHelper.getInstance().contains(filter.getMasters(), orderItem.getOrder()))
				for(Map.Entry<String, Object> entry : map.entrySet()){
					if("globalIdentifier.code".equals(entry.getKey()) && orderItem.getGlobalIdentifier().getCode().contains((String)entry.getValue())){
						filtered.add(orderItem);
						break;
					}else if("globalIdentifier.name".equals(entry.getKey()) && orderItem.getGlobalIdentifier().getName().contains((String)entry.getValue())){
						filtered.add(orderItem);
						break;
					}
				}	
		}
		
		return filtered;
	}
	
	public static List<OrderItem> filter(Filter filter){
		return filter(filter,COLLECTION);
	}
}
