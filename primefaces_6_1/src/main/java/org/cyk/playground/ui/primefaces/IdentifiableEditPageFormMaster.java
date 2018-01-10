package org.cyk.playground.ui.primefaces;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.ArrayUtils;
import org.cyk.playground.ui.primefaces.model.Article;
import org.cyk.playground.ui.primefaces.model.Order;
import org.cyk.playground.ui.primefaces.model.OrderItem;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.ui.web.primefaces.resources.page.controlpanel.IdentifiableEditPage;
import org.cyk.utility.common.helper.CollectionHelper;
import org.cyk.utility.common.helper.NumberHelper;
import org.cyk.utility.common.helper.RandomHelper;
import org.cyk.utility.common.userinterface.RequestHelper;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.event.Event;
import org.cyk.utility.common.userinterface.output.OutputText;

public class IdentifiableEditPageFormMaster extends IdentifiableEditPage.FormMaster implements Serializable {
	private static final long serialVersionUID = -6211058744595898478L;
	
	@SuppressWarnings("unchecked")
	@Override
	protected void __prepare__() {
		super.__prepare__();
		Form.Detail detail = getDetail();
		detail.setFieldsObjectFromMaster();
		
		if(Person.class.equals(getPropertiesMap().getActionOnClass())){
			detail.setFieldsObjectFromMaster("globalIdentifier");
			detail.add("code");
			detail.add("image",1,3).addBreak();
			detail.add("name").addBreak();
			detail.setFieldsObjectFromMaster();
			detail.add("lastnames").addBreak();
			detail.add("nationality");
			detail.add("sex").addBreak();
			detail.setFieldsObjectFromMaster("globalIdentifier");
			detail.add("description").addBreak();
		}else if(Order.class.equals(getPropertiesMap().getActionOnClass())){
			detail.addReadOnly("amount");
			
			/**/
			DataTable dataTable = instanciateDataTable(OrderItem.class,Article.class,new DataTable.Cell.Listener.Adapter.Default(){
				private static final long serialVersionUID = 1L;
				public DataTable.Cell instanciateOne(DataTable.Column column, DataTable.Row row) {
					final DataTable.Cell cell = super.instanciateOne(column, row);
					
					if(ArrayUtils.contains(new String[]{"quantity","reduction"},column.getPropertiesMap().getFieldName())){
						Event.instanciateOne(cell, new String[]{"amount"},new String[]{"amount"}, new Event.CommandAdapter(){
							private static final long serialVersionUID = 1L;
							protected void ____execute____() {
								OrderItem orderItem = (OrderItem) getEventPropertyCellRowValue();
								computeAmount(orderItem);
								((OutputText)((DataTable)cell.getColumn().getPropertiesMap().getDataTable()).getColumn("amount").getPropertiesMap().getFooter())
									.getPropertiesMap().setValue(orderItem.getOrder().getAmount());
							}
						});
					}
					return cell;
				}
			}
			,Boolean.TRUE,"article.unitPrice","quantity","reduction","amount");
			
			dataTable.getColumn("article.unitPrice").setCellValueType(DataTable.Cell.ValueType.TEXT);
			dataTable.getColumn("amount").setCellValueType(DataTable.Cell.ValueType.TEXT);
			//((OutputText)dataTable.getColumn("amount").getPropertiesMap().getFooter()).getPropertiesMap().setValue(StringHelper.getInstance().get("total", new Object[]{}));
			dataTable.getPropertiesMap().setOnPrepareAddColumnAction(true);
			dataTable.prepare();
			dataTable.build();
			
			//((DataTable.Columns)dataTable.getPropertiesMap().getColumns()).getPropertiesMap().setFooterRendered(Boolean.FALSE);
			
			((CollectionHelper.Instance<Object>)dataTable.getPropertiesMap().getRowsCollectionInstance()).addListener(
				new CollectionHelper.Instance.Listener.Adapter<Object>(){
					private static final long serialVersionUID = 1L;
					
					public void addOne(CollectionHelper.Instance<Object> instance, Object element, Object source, Object sourceObject) {
						DataTable.Row row = (DataTable.Row) element;
						OrderItem orderItem = (OrderItem) row.getPropertiesMap().getValue();
						orderItem.setCode(RandomHelper.getInstance().getAlphabetic(3));
						orderItem.setName(RandomHelper.getInstance().getAlphabetic(3));
						orderItem.setOrder((Order) getObject());
						
					}
					
					public void removeOne(CollectionHelper.Instance<Object> instance, Object element) {
						
					}
					
				}
				);
		}else if(OrderItem.class.equals(getPropertiesMap().getActionOnClass())){
			((OrderItem)detail.getMaster().getObject()).setOrder(RequestHelper.getInstance().getParameterAsInstance(Order.class));
			((OrderItem)detail.getMaster().getObject()).setArticle(RequestHelper.getInstance().getParameterAsInstance(Article.class));
			
			detail.add("order").addBreak();
			detail.add("article").addBreak();
			detail.add("quantity").addBreak();
			detail.add("amount").addBreak();	
		}
		
	}
	
	private void computeAmount(OrderItem orderItem){
		if(orderItem.getAmount()!=null)
			orderItem.getOrder().setAmount(orderItem.getOrder().getAmount().subtract(orderItem.getAmount()));
		
		if(orderItem.getQuantity() == null)
			orderItem.setAmount(null);
		else
			orderItem.setAmount(orderItem.getArticle().getUnitPrice()
				.multiply( NumberHelper.getInstance().get(BigDecimal.class,orderItem.getQuantity()))
				.subtract( NumberHelper.getInstance().get(BigDecimal.class,orderItem.getReduction(),BigDecimal.ZERO))
				);
		
		if(orderItem.getOrder().getAmount()==null)
			orderItem.getOrder().setAmount(orderItem.getAmount());
		else
			orderItem.getOrder().setAmount(orderItem.getOrder().getAmount().add(orderItem.getAmount()));
	}
}
