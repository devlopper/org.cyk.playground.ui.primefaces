package org.cyk.playground.ui.primefaces.page.datatable;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.cyk.playground.ui.primefaces.model.Article;
import org.cyk.playground.ui.primefaces.model.Order;
import org.cyk.playground.ui.primefaces.model.OrderItem;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.helper.CollectionHelper;
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
		orderItemDataTable1 = orderForm.instanciateDataTable(OrderItem.class,Article.class,"quantity","amount");
		orderItemDataTable1.prepare();
		orderItemDataTable1.build();
		
		((CollectionHelper.Instance<Object>)orderItemDataTable1.getPropertiesMap().getRowsCollectionInstance()).addListener(
			new CollectionHelper.Instance.Listener.Adapter<Object>(){
				private static final long serialVersionUID = 1L;
				
				public void addOne(CollectionHelper.Instance<Object> instance, Object element, Object source, Object sourceObject) {
					OrderItem orderItem = (OrderItem) ((DataTable.Row)element).getPropertiesMap().getValue();
					orderItem.setQuantity(new BigDecimal(RandomHelper.getInstance().getInteger(1, 5)));
				}
				
			}
			);
		
		//System.out.println(((Command)orderItemDataTable.getPropertiesMap().getAddCommandComponent()).getPropertiesMap());
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
