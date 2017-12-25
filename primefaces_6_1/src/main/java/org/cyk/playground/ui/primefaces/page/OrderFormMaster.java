package org.cyk.playground.ui.primefaces.page;

import java.io.Serializable;
import java.math.BigDecimal;

import org.cyk.playground.ui.primefaces.model.Article;
import org.cyk.playground.ui.primefaces.model.Order;
import org.cyk.playground.ui.primefaces.model.OrderItem;
import org.cyk.ui.web.primefaces.resources.page.controlpanel.IdentifiableEditPage;
import org.cyk.utility.common.helper.CollectionHelper;
import org.cyk.utility.common.helper.NumberHelper;
import org.cyk.utility.common.helper.RandomHelper;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.event.Event;

public class OrderFormMaster extends IdentifiableEditPage.FormMaster implements Serializable {
	private static final long serialVersionUID = -6211058744595898478L;
	
	@Override
	protected void __prepare__() {
		super.__prepare__();
		Form.Detail detail = getDetail();
		detail.setFieldsObjectFromMaster();
		detail.add("amount");
		
		/**/
		DataTable dataTable = instanciateDataTable(OrderItem.class,Article.class,new DataTable.Cell.Listener.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			public DataTable.Cell instanciateOne(DataTable.Column column, DataTable.Row row) {
				final DataTable.Cell cell = super.instanciateOne(column, row);
				
				if("quantity".equals(column.getPropertiesMap().getFieldName())){
					Event.instanciateBuilder(cell, new String[]{"amount"}, new Event.CommandAdapter(){
						private static final long serialVersionUID = 1L;
						protected void ____execute____() {
							OrderItem orderItem = (OrderItem) getEventPropertyCellRowValue();
							computeAmount(orderItem);
						}
					},null,"blur").execute();
				}else if("reduce".equals(column.getPropertiesMap().getFieldName())){
					Event.instanciateBuilder(cell, new String[]{"amount"}, new Event.CommandAdapter(){
						private static final long serialVersionUID = 1L;
						protected void ____execute____() {
							OrderItem orderItem = (OrderItem) getEventPropertyCellRowValue();
							computeAmount(orderItem);
						}
					},null,"blur").execute();
				}
				return cell;
			}
		}
		,Boolean.TRUE,"article.unitPrice","quantity","reduce","amount");
		
		dataTable.getColumn("article.unitPrice").setCellValueType(DataTable.Cell.ValueType.TEXT);
		dataTable.getColumn("amount").setCellValueType(DataTable.Cell.ValueType.TEXT);
		dataTable.setOnPrepareAddColumnAction(true);
		dataTable.prepare();
		dataTable.build();
		//System.out.println( ((Command)orderItemDataTable1.getPropertiesMap().getAddCommandComponent()).getPropertiesMap() );
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
				
			}
			);
	}
	
	private void computeAmount(OrderItem orderItem){
		if(orderItem.getQuantity() == null)
			orderItem.setAmount(null);
		else
			orderItem.setAmount(orderItem.getArticle().getUnitPrice()
				.multiply( NumberHelper.getInstance().get(BigDecimal.class,orderItem.getQuantity()))
				.subtract( NumberHelper.getInstance().get(BigDecimal.class,orderItem.getReduce(),BigDecimal.ZERO))
				);
	}
	
}
