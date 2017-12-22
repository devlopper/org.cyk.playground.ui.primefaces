package org.cyk.playground.ui.primefaces.page.crud;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.Article;
import org.cyk.playground.ui.primefaces.model.Order;
import org.cyk.playground.ui.primefaces.model.OrderItem;
import org.cyk.playground.ui.primefaces.page.datatable.DataTablesMasterDetailInputPage.SubmitCommandActionAdapter;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.helper.CollectionHelper;
import org.cyk.utility.common.helper.NumberHelper;
import org.cyk.utility.common.helper.RandomHelper;
import org.cyk.utility.common.userinterface.Component;
import org.cyk.utility.common.userinterface.Layout;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.command.Command;
import org.cyk.utility.common.userinterface.command.RemoteCommand;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.window.EditWindow;
import org.cyk.utility.common.userinterface.event.Event;
import org.cyk.utility.common.userinterface.output.OutputText;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Named @ViewScoped @Getter @Setter
public class OrderEditPage extends EditWindow implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		
		/*
		
		dataTable = form.instanciateDataTable(OrderItem.class,Article.class,new DataTable.Cell.Listener.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			public DataTable.Cell instanciateOne(DataTable.Column column, final DataTable.Row row) {
				final DataTable.Cell cell = super.instanciateOne(column, row);
				if("quantity".equals(column.getPropertiesMap().getFieldName())){
					cell.getInput()._setPropertyEvent("blur", null, "@(form)", new Event.CommandAdapter(){
						protected void ____execute____() {
							cell.getInput().write();
							OutputText amountOutputText =  (OutputText) row.getCell("amount").getPropertiesMap().getValue();
							OrderItem orderItem = (OrderItem)row.getPropertiesMap().getValue();
							orderItem.setAmount(orderItem.getArticle().getUnitPrice()
									.multiply( NumberHelper.getInstance().get(BigDecimal.class,cell.getInput().getValue()))
									.subtract( NumberHelper.getInstance().get(BigDecimal.class,orderItem.getReduce(),BigDecimal.ZERO) ));
							
							amountOutputText.getPropertiesMap().setValue( orderItem.getAmount() );
						}
					});
				}else if("reduce".equals(column.getPropertiesMap().getFieldName())){
					cell.getInput()._setPropertyEvent("blur", null, "@(form)", new Event.CommandAdapter(){
						protected void ____execute____() {
							cell.getInput().write();
							OutputText amountOutputText =  (OutputText) row.getCell("amount").getPropertiesMap().getValue();
							OrderItem orderItem = (OrderItem)row.getPropertiesMap().getValue();
							orderItem.setAmount(orderItem.getArticle().getUnitPrice()
									.multiply(NumberHelper.getInstance().get(BigDecimal.class,orderItem.getQuantity(),BigDecimal.ONE)) 
									.subtract(NumberHelper.getInstance().get(BigDecimal.class,cell.getInput().getValue())));
							
							amountOutputText.getPropertiesMap().setValue( orderItem.getAmount() );
						}
					});
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
					orderItem.setOrder((Order) form.getObject());
					
				}
				
			}
			);
			
		*/
	}
	
	@Getter @Setter @Accessors(chain=true)
	public static class FormMaster extends Form.Master implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Override
		protected void __prepare__() {
			super.__prepare__();
			DataTable dataTable = instanciateDataTable(OrderItem.class,Article.class,new DataTable.Cell.Listener.Adapter.Default(){
				private static final long serialVersionUID = 1L;
				public DataTable.Cell instanciateOne(DataTable.Column column, final DataTable.Row row) {
					final DataTable.Cell cell = super.instanciateOne(column, row);
					if("quantity".equals(column.getPropertiesMap().getFieldName())){
						cell.getInput()._setPropertyEvent("blur", null, "@(form)", new Event.CommandAdapter(){
							protected void ____execute____() {
								cell.getInput().write();
								OutputText amountOutputText =  (OutputText) row.getCell("amount").getPropertiesMap().getValue();
								OrderItem orderItem = (OrderItem)row.getPropertiesMap().getValue();
								orderItem.setAmount(orderItem.getArticle().getUnitPrice()
										.multiply( NumberHelper.getInstance().get(BigDecimal.class,cell.getInput().getValue()))
										.subtract( NumberHelper.getInstance().get(BigDecimal.class,orderItem.getReduce(),BigDecimal.ZERO) ));
								
								amountOutputText.getPropertiesMap().setValue( orderItem.getAmount() );
							}
						});
					}else if("reduce".equals(column.getPropertiesMap().getFieldName())){
						cell.getInput()._setPropertyEvent("blur", null, "@(form)", new Event.CommandAdapter(){
							protected void ____execute____() {
								cell.getInput().write();
								OutputText amountOutputText =  (OutputText) row.getCell("amount").getPropertiesMap().getValue();
								OrderItem orderItem = (OrderItem)row.getPropertiesMap().getValue();
								orderItem.setAmount(orderItem.getArticle().getUnitPrice()
										.multiply(NumberHelper.getInstance().get(BigDecimal.class,orderItem.getQuantity(),BigDecimal.ONE)) 
										.subtract(NumberHelper.getInstance().get(BigDecimal.class,cell.getInput().getValue())));
								
								amountOutputText.getPropertiesMap().setValue( orderItem.getAmount() );
							}
						});
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
						orderItem.setOrder((Order) FormMaster.this.getObject());
						
					}
					
				}
				);
			System.out.println("OrderEditPage.FormMaster.__prepare__()");
		}
		
		@Override
		public Master build() {
			Master master =  super.build();
			DataTable dataTable = instanciateDataTable(OrderItem.class,Article.class,new DataTable.Cell.Listener.Adapter.Default(){
				private static final long serialVersionUID = 1L;
				public DataTable.Cell instanciateOne(DataTable.Column column, final DataTable.Row row) {
					final DataTable.Cell cell = super.instanciateOne(column, row);
					if("quantity".equals(column.getPropertiesMap().getFieldName())){
						cell.getInput()._setPropertyEvent("blur", null, "@(form)", new Event.CommandAdapter(){
							protected void ____execute____() {
								cell.getInput().write();
								OutputText amountOutputText =  (OutputText) row.getCell("amount").getPropertiesMap().getValue();
								OrderItem orderItem = (OrderItem)row.getPropertiesMap().getValue();
								orderItem.setAmount(orderItem.getArticle().getUnitPrice()
										.multiply( NumberHelper.getInstance().get(BigDecimal.class,cell.getInput().getValue()))
										.subtract( NumberHelper.getInstance().get(BigDecimal.class,orderItem.getReduce(),BigDecimal.ZERO) ));
								
								amountOutputText.getPropertiesMap().setValue( orderItem.getAmount() );
							}
						});
					}else if("reduce".equals(column.getPropertiesMap().getFieldName())){
						cell.getInput()._setPropertyEvent("blur", null, "@(form)", new Event.CommandAdapter(){
							protected void ____execute____() {
								cell.getInput().write();
								OutputText amountOutputText =  (OutputText) row.getCell("amount").getPropertiesMap().getValue();
								OrderItem orderItem = (OrderItem)row.getPropertiesMap().getValue();
								orderItem.setAmount(orderItem.getArticle().getUnitPrice()
										.multiply(NumberHelper.getInstance().get(BigDecimal.class,orderItem.getQuantity(),BigDecimal.ONE)) 
										.subtract(NumberHelper.getInstance().get(BigDecimal.class,cell.getInput().getValue())));
								
								amountOutputText.getPropertiesMap().setValue( orderItem.getAmount() );
							}
						});
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
						orderItem.setOrder((Order) FormMaster.this.getObject());
						
					}
					
				}
				);
			System.out.println("OrderEditPage.FormMaster.build()");
			return master;
		}
		
	}
		
}
