package org.cyk.playground.ui.primefaces.page.datatable;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.AbstractIdentified;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.ui.web.primefaces.resources.PrimefacesResourcesManager;
import org.cyk.utility.common.helper.TimeHelper;
import org.cyk.utility.common.userinterface.Component;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.window.Window;
import org.cyk.utility.common.userinterface.event.Event;
import org.primefaces.model.SortOrder;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class DataTablesStatusPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private DataTable personDataTable1,personDataTable2,personDataTable3,personDataTable4,personDataTable5;
	private Integer page = 3;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Data tables Status");
		
		createPersons();
				
	}
	
	private void createPersons(){
		String[] fieldNames = new String[]{"globalIdentifier.code","globalIdentifier.name","lastnames"};
		personDataTable1 = createDataTable(Person.class, fieldNames, page,Boolean.TRUE,Boolean.FALSE);
		personDataTable2 = createDataTable(Person.class, fieldNames, page,Boolean.FALSE,Boolean.FALSE);
		personDataTable3 = createDataTable(Person.class, fieldNames, page,Boolean.FALSE,Boolean.FALSE);
		personDataTable4 = createDataTable(Person.class, fieldNames, page,Boolean.FALSE,Boolean.TRUE);
		personDataTable5 = createDataTable(Person.class, fieldNames, page,Boolean.FALSE,Boolean.TRUE);
	}
	
	private <T extends AbstractIdentified> DataTable createDataTable(Class<T> aClass,String[] fieldNames,Integer page,Boolean global,Boolean asynchron){
		DataTable dataTable = new DataTable();
		
		dataTable.setActionOnClass(aClass);
		dataTable.addColumnsByFieldNames(fieldNames);
		dataTable.getPropertiesMap().setRows(page);
		dataTable.getPropertiesMap().setPaginator(Boolean.TRUE);
		dataTable.getPropertiesMap().setLazy(Boolean.TRUE);
		dataTable.prepare();
		dataTable.build();
		
		dataTable.getPropertiesMap().setValue(new LazyDataModel<T>(dataTable));
		
		if(!Boolean.TRUE.equals(global)){
			Event event = new Event();
			event.getPropertiesMap().setEvent("page");
			event.getPropertiesMap().setGlobal(Boolean.FALSE);
			event.getPropertiesMap().setAsync(asynchron);
			dataTable.getPropertiesMap().setOnPageEventComponent(event);
			
			PrimefacesResourcesManager.setInteractivityBlockerNotGlobal(dataTable, event);	
		}
		
		return dataTable;
	}
	
	/**/
	
	public static class LazyDataModel<T extends AbstractIdentified> extends DataTablesLazyPage.LazyDataModel<T> implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public LazyDataModel(Component component) {
			super(component);
		}
		
		@Override
		protected List<T> __load__(int first, int pageSize, String sortField, SortOrder sortOrder,Map<String, Object> filters) {
			TimeHelper.getInstance().pause(1000 * 3);
			return super.__load__(first, pageSize, sortField, sortOrder, filters);
		}
		
	}
}
