package org.cyk.playground.ui.primefaces.page.datatable;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.cyk.playground.ui.primefaces.model.Article;
import org.cyk.playground.ui.primefaces.model.Order;
import org.cyk.playground.ui.primefaces.model.OrderItem;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.helper.CollectionHelper.Instance;
import org.cyk.utility.common.helper.ClassHelper;
import org.cyk.utility.common.helper.FieldHelper;
import org.cyk.utility.common.helper.RandomHelper;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.command.Command;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.window.Window;

import lombok.Getter;
import lombok.Setter;

@javax.inject.Named @javax.faces.view.ViewScoped 
@Getter @Setter
public class DataTablesMasterDetailInputPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Form.Master orderForm;
	private DataTable orderItemDataTable;
	
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
		orderItemDataTable = orderForm.instanciateDataTable();
		orderItemDataTable.getPropertiesMap().setActionOnClass(OrderItem.class);
		orderItemDataTable.getPropertiesMap().setChoiceValueClass(Article.class);
		orderItemDataTable.getPropertiesMap().setAddCommandComponentActionAdapterClass(AddCommandComponentActionAdapter.class);
		
		orderItemDataTable.addColumnsByFieldNames(new String[]{/*"globalIdentifier.code","globalIdentifier.name",*/"article","quantity","amount"});
		
		orderItemDataTable.getColumn("article").setCellValueType(DataTable.Cell.ValueType.TEXT);
		((Command)orderItemDataTable.getPropertiesMap().getAddCommandComponent()).getPropertiesMap().setInputValueIsNotRequired(Boolean.TRUE);
		
		orderItemDataTable.prepare();
		orderItemDataTable.build();
		
		//System.out.println(((Command)orderItemDataTable.getPropertiesMap().getAddCommandComponent()).getPropertiesMap());
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
	
	public static class AddCommandComponentActionAdapter extends DataTable.AddCommandComponentActionAdapter {
		private static final long serialVersionUID = 1L;
		
		@Override
		protected void listenObjectCreated(Object object,Object source) {
			super.listenObjectCreated(object,source);
			
			//((OrderItem)object).setArticle((Article) source);
			((OrderItem)object).setQuantity(new BigDecimal(RandomHelper.getInstance().getInteger(1, 5)));
		}
		
		/*@Override
		protected Instance<?> getDestinationCollection() {
			return ((Order)dataTable.getForm().getMaster().getObject()).getOrderItems();
		}*/
		
	}
	
}
