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
public class Order extends AbstractIdentified {

	public static final List<Order> COLLECTION;
	static {
		COLLECTION = (List<Order>) instanciateManyRandomly(3);
	}
	
	private BigDecimal amount;
	private CollectionHelper.Instance<OrderItem> orderItems = new CollectionHelper.Instance<>();
	
	@Override
	public String toString() {
		return getCode();
	}
	
	/**/
	
	public static Order instanciateOneRandomly(){
		Order order = new Order();
		order.setGlobalIdentifier(new GlobalIdentifier());
		order.getGlobalIdentifier().setCode("ORD"+RandomHelper.getInstance().getNumeric(5));
		order.getGlobalIdentifier().setName(RandomHelper.getInstance().getAlphabetic(15));
		order.getGlobalIdentifier().setDescription(RandomHelper.getInstance().getLines(2, 5, 3, 10));
		order.setAmount(new BigDecimal(RandomHelper.getInstance().getInteger(1, 10000)));
		return order;
	}
	
	public static Collection<Order> instanciateManyRandomly(Integer count){
		Collection<Order> orders = new ArrayList<>();
		for(Integer index = 0 ; index < count ; index ++)
			orders.add(instanciateOneRandomly());
		return orders;
	}

	public static Order get(String code,Collection<Order> orders) {
		for(Order order : orders)
			if(order.getCode().equals(code))
				return order;
		return null;
	}
	
	public static Order get(String code) {
		return get(code,COLLECTION);
	}
	
	/**/
	
	@Getter @Setter
	public static class Filter extends AbstractIdentified.Filter<Order> implements Serializable {
		private static final long serialVersionUID = -1498269103849317057L;

		protected GlobalIdentifier.Filter globalIdentifier = new GlobalIdentifier.Filter();
		
		public Filter() {
			addCriterias(globalIdentifier);
		}
		
		public Filter(Filter criterias) {
			super(criterias);
		}
		
		@Override
		public FilterHelper.Filter<Order> set(String string) {
			globalIdentifier.set(string);
			return super.set(string);
		}
	}
	
	public static List<Order> filter(Filter filter,Collection<Order> persons){
		Map<String,Object> map = new HashMap<>();
		
		map.put("globalIdentifier.code", filter.getGlobalIdentifier().getCode().getPreparedValue());
		map.put("globalIdentifier.name", filter.getGlobalIdentifier().getName().getPreparedValue());
		
		List<Order> filtered = new ArrayList<Order>();
		for(Order person : persons){
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
	
	public static List<Order> filter(Filter filter){
		return filter(filter,COLLECTION);
	}
}
