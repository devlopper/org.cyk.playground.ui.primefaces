package org.cyk.playground.ui.primefaces;

import java.io.Serializable;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.cyk.playground.ui.primefaces.model.Article;
import org.cyk.playground.ui.primefaces.model.Order;
import org.cyk.playground.ui.primefaces.model.OrderItem;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.playground.ui.primefaces.model.movement.MovementCollectionItem;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.Constant.Action;
import org.cyk.utility.common.helper.CollectionHelper;
import org.cyk.utility.common.helper.CollectionHelper.Instance;
import org.cyk.utility.common.helper.RandomHelper;
import org.cyk.utility.common.userinterface.Component;
import org.cyk.utility.common.userinterface.RequestHelper;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.event.Event;
import org.cyk.utility.common.userinterface.output.OutputText;

public class IdentifiableEditPageFormMaster extends org.cyk.ui.web.primefaces.resources.page.controlpanel.IdentifiableEditPageFormMaster implements Serializable {
	private static final long serialVersionUID = -6211058744595898478L;
	
	@Override
	protected void ____add____() {
		if(Person.class.equals(getPropertiesMap().getActionOnClass())){
			getDetail().setFieldsObjectFromMaster("globalIdentifier");
			getDetail().add("code");
			getDetail().add("image",1,3).addBreak();
			getDetail().add("name").addBreak();
			getDetail().setFieldsObjectFromMaster();
			getDetail().add("lastnames").addBreak();
			getDetail().add("nationality");
			getDetail().add("sex").addBreak();
			getDetail().setFieldsObjectFromMaster("globalIdentifier");
			getDetail().add("description").addBreak();
		}else
			super.____add____();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void __prepare__() {
		super.__prepare__();
		Form.Detail detail = getDetail();
		detail.setFieldsObjectFromMaster();
		
		if(Person.class.equals(getPropertiesMap().getActionOnClass())){
			
		}else if(Order.class.equals(getPropertiesMap().getActionOnClass())){
			detail.addReadOnly("amount");
			
			/**/
			DataTable dataTable = instanciateDataTable(OrderItem.class,Article.class,new DataTable.Cell.Listener.Adapter.Default(){
				private static final long serialVersionUID = 1L;
				public DataTable.Cell instanciateOne(DataTable.Column column, DataTable.Row row) {
					final DataTable.Cell cell = super.instanciateOne(column, row);
					
					if(ArrayUtils.contains(new String[]{"quantity","reduction"},column.getPropertiesMap().getFieldName())){
						Event.instanciateOne(cell, new String[]{"amount"},new String[]{"amount"});
					}
					return cell;
				}
			}
			,Boolean.TRUE);
			dataTable.addColumnListener(new CollectionHelper.Instance.Listener.Adapter<Component>(){
				private static final long serialVersionUID = 1L;

				@Override
				public void addOne(Instance<Component> instance, Component element, Object source,Object sourceObject) {
					super.addOne(instance, element, source, sourceObject);
					if(element instanceof DataTable.Column){
						DataTable.Column column = (DataTable.Column)element;
						if("article.unitPrice".equals(column.getPropertiesMap().getFieldName()))
							column.setCellValueType(DataTable.Cell.ValueType.TEXT);
						if("amount".equals(column.getPropertiesMap().getFieldName()))
							column.setCellValueType(DataTable.Cell.ValueType.TEXT);
					}
				}
			});
			
			dataTable.getPropertiesMap().setOnPrepareAddColumnAction(Boolean.TRUE);
			dataTable.getPropertyRowPropertiesPropertyRemoveCommandProperties().setUpdatedFieldNames(Arrays.asList("amount"));
			dataTable.getPropertyRowPropertiesPropertyRemoveCommandProperties().setUpdatedColumnFieldNames(Arrays.asList("amount"));
			dataTable.prepare();
			dataTable.build();
						
			((OutputText)dataTable.getColumn("amount").getPropertiesMap().getFooter()).getPropertiesMap().setValue(((Order)detail.getMaster().getObject()).getAmount());
			//((DataTable.Columns)dataTable.getPropertiesMap().getColumns()).getPropertiesMap().setFooterRendered(Boolean.FALSE);
			if(Constant.Action.isCreateOrUpdate((Action) getPropertiesMap().getAction())){
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
		}else if(OrderItem.class.equals(getPropertiesMap().getActionOnClass())){
			((OrderItem)detail.getMaster().getObject()).setOrder(RequestHelper.getInstance().getParameterAsInstance(Order.class));
			((OrderItem)detail.getMaster().getObject()).setArticle(RequestHelper.getInstance().getParameterAsInstance(Article.class));
			
			detail.add("order").addBreak();
			detail.add("article").addBreak();
			detail.add("quantity").addBreak();
			detail.add("amount").addBreak();	
		}else if(MovementCollectionItem.class.equals(getPropertiesMap().getActionOnClass())){
			detail.add("movementCollection").addBreak();
			detail.addReadOnly("previousCumul").addBreak();
			detail.add("movementAction").addBreak();
			detail.add("value").addBreak();
			detail.addReadOnly("cumul").addBreak();
			
			detail.addEvent("movementCollection", new String[]{"previousCumul","cumul"});
			detail.addEvent("movementAction", new String[]{"cumul"});
			detail.addEvent("value", new String[]{"cumul"});
			
			//OutputText outputText = 
			//((Event)detail.getControlByFieldName("movementCollection").getPropertiesMap().getEvent()).getPropertiesMap()
			//	.setUpdate("@(."+ detail.getControlByFieldName("previousCumul").getPropertiesMap().getIdentifierAsStyleClass() +")");
			
			//System.out.println("IdentifiableEditPageFormMaster.__prepare__() : "+((Event)detail.getControlByFieldName("movementCollection").getPropertiesMap().getEvent()).getPropertiesMap()
			//	.getUpdate());
			
			//((Event)detail.getControlByFieldName("movementCollection").getPropertiesMap().getEvent()).getPropertiesMap()
			//.setUpdate("@(form)");
		}
		
	}
	
}
