package org.cyk.playground.ui.primefaces.page.datatable;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.enterprise.context.SessionScoped;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.cyk.playground.ui.primefaces.model.Article;
import org.cyk.playground.ui.primefaces.model.Order;
import org.cyk.playground.ui.primefaces.model.OrderItem;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.helper.CollectionHelper;
import org.cyk.utility.common.helper.CollectionHelper.Instance;
import org.cyk.utility.common.helper.CommandHelper;
import org.cyk.utility.common.helper.ClassHelper;
import org.cyk.utility.common.helper.FieldHelper;
import org.cyk.utility.common.helper.NumberHelper;
import org.cyk.utility.common.helper.RandomHelper;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.collection.DataTable.Row;
import org.cyk.utility.common.userinterface.command.Command;
import org.cyk.utility.common.userinterface.command.RemoteCommand;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.window.Window;
import org.cyk.utility.common.userinterface.event.Event;
import org.cyk.utility.common.userinterface.output.OutputText;

import lombok.Getter;
import lombok.Setter;

@javax.inject.Named 
@javax.faces.view.ViewScoped 
//@javax.enterprise.context.SessionScoped
@Getter @Setter
public class DataTablesMasterDetailInputPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Form.Master orderForm;
	private DataTable orderItemDataTable1,orderItemDataTable2,orderItemDataTable3;
	
	@SuppressWarnings("unchecked")
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Data tables Master Detail Input");
		
		//Master form
		orderForm = new Form.Master(this,new Order(),Constant.Action.CREATE,SubmitCommandActionAdapter.class);
		Form.Detail detail = orderForm.getDetail();
		if(detail == null)
			detail = orderForm.instanciateDetail();
		detail.setFieldsObjectFromMaster("globalIdentifier");
		detail.add("code");
		//detail.add("name");
		detail.setFieldsObjectFromMaster();
		detail.add("amount");
		orderForm.prepare();
		orderForm.build();
		
		//Details
		orderItemDataTable1 = orderForm.instanciateDataTable(OrderItem.class,Article.class,new DataTable.Cell.Listener.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			public DataTable.Cell instanciateOne(DataTable.Column column, final DataTable.Row row) {
				final DataTable.Cell cell = super.instanciateOne(column, row);
				if("quantity".equals(column.getPropertiesMap().getFieldName())){
					cell.getInput()._setPropertyEvent("blur", null, "@(form)", new Event.CommandAdapter(){
						protected void ____execute____() {
							cell.getInput().write();
							OutputText amountOutputText =  (OutputText) row.getCell("amount").getPropertiesMap().getValue();
							OrderItem orderItem = (OrderItem)row.getPropertiesMap().getValue();
							amountOutputText.getPropertiesMap().setValue( orderItem.getArticle().getUnitPrice()
									.multiply( NumberHelper.getInstance().get(BigDecimal.class,cell.getInput().getValue()))
									.subtract( NumberHelper.getInstance().get(BigDecimal.class,orderItem.getReduce(),BigDecimal.ZERO) ) );
						}
					});
				}else if("reduce".equals(column.getPropertiesMap().getFieldName())){
					cell.getInput()._setPropertyEvent("blur", null, "@(form)", new Event.CommandAdapter(){
						protected void ____execute____() {
							cell.getInput().write();
							OutputText amountOutputText =  (OutputText) row.getCell("amount").getPropertiesMap().getValue();
							OrderItem orderItem = (OrderItem)row.getPropertiesMap().getValue();
							System.out.println("RED "+orderItem.getArticle().getUnitPrice()
									+" : "+NumberHelper.getInstance().get(BigDecimal.class,orderItem.getQuantity(),BigDecimal.ONE)
									+" : "+NumberHelper.getInstance().get(BigDecimal.class,cell.getInput().getValue()));
							
							amountOutputText.getPropertiesMap().setValue( orderItem.getArticle().getUnitPrice()
									.multiply(NumberHelper.getInstance().get(BigDecimal.class,orderItem.getQuantity(),BigDecimal.ONE)) 
									.subtract(NumberHelper.getInstance().get(BigDecimal.class,cell.getInput().getValue())) );
						}
					});
				}
				return cell;
			}
		}
		,Boolean.TRUE,"article.unitPrice","quantity","reduce","amount");
		orderItemDataTable1.getColumn("article.unitPrice").setCellValueType(DataTable.Cell.ValueType.TEXT);
		orderItemDataTable1.getColumn("amount").setCellValueType(DataTable.Cell.ValueType.TEXT);
		orderItemDataTable1.setOnPrepareAddColumnAction(true);
		orderItemDataTable1.prepare();
		orderItemDataTable1.build();
		//System.out.println( ((Command)orderItemDataTable1.getPropertiesMap().getAddCommandComponent()).getPropertiesMap() );
		((CollectionHelper.Instance<Object>)orderItemDataTable1.getPropertiesMap().getRowsCollectionInstance()).addListener(
			new CollectionHelper.Instance.Listener.Adapter<Object>(){
				private static final long serialVersionUID = 1L;
				
				public void addOne(CollectionHelper.Instance<Object> instance, Object element, Object source, Object sourceObject) {
					DataTable.Row row = (DataTable.Row) element;
					OrderItem orderItem = (OrderItem) row.getPropertiesMap().getValue();
					orderItem.setQuantity(new BigDecimal(RandomHelper.getInstance().getInteger(1, 5)));
					
					Command command = (Command) row.getPropertiesMap().getRemoveCommandComponent();
					RemoteCommand remoteCommand = (RemoteCommand) command.getPropertiesMap().getRemoteCommand();
					
				}
				
			}
			);
		
		//System.out.println(((Command)orderItemDataTable1.getPropertiesMap().getAddCommandComponent()).getPropertiesMap());
		//System.out.println(orderForm.getSubmitCommand().getPropertiesMap().getProcess()+" / "+orderForm.getSubmitCommand().getPropertiesMap().getUpdate());
	}
	
	/**/
	
	public static class SubmitCommandActionAdapter extends Form.Master.SubmitCommandActionAdapter {
		private static final long serialVersionUID = 1L;
		
		@Override
		protected void processOnSuccess() {
			super.processOnSuccess();
			//System.out.println("DataTablesMasterDetailInputPage.SubmitCommandActionAdapter.processOnSuccess()");
			for(OrderItem orderItem : ((Order)form.getObject()).getOrderItems().getElements())
				System.out.println(ToStringBuilder.reflectionToString(orderItem, ToStringStyle.SHORT_PREFIX_STYLE));
		}
		
	}
	
}
