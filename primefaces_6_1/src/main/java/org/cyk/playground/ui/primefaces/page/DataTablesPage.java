package org.cyk.playground.ui.primefaces.page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import org.cyk.playground.ui.primefaces.model.AbstractIdentified;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.collection.DataTable.Row;
import org.cyk.utility.common.userinterface.container.window.Window;
import org.primefaces.model.SortOrder;

@Named @ViewScoped @Getter @Setter
public class DataTablesPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private DataTable emptyPersons,emptyPersonsPaginated,emptyPersonsLazy,threePersons,threePersonsPaginated,threePersonsLazy
		,hundredPersons,hundredPersonsPaginated,hundredPersonsLazy;
	private Integer page = 5;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Data tables");
		
		createPersons();
				
	}
	
	private void createPersons(){
		String[] fieldNames = new String[]{"globalIdentifier.code","globalIdentifier.name","lastnames"};
		emptyPersons = createDataTable(Person.class, fieldNames, null, null);
		emptyPersonsPaginated = createDataTable(Person.class, fieldNames, page,null);
		emptyPersonsLazy = createDataTable(Person.class, fieldNames, page);

		threePersons = createDataTable(Person.class, fieldNames, null, PERSONS_3);
		threePersonsPaginated = createDataTable(Person.class, fieldNames, page,PERSONS_3);
		threePersonsLazy = createDataTable(Person.class, fieldNames, page,PERSONS_3,Boolean.TRUE);
		
		hundredPersons = createDataTable(Person.class, fieldNames, null, PERSONS_100);
		hundredPersonsPaginated = createDataTable(Person.class, fieldNames, page,PERSONS_100);
		hundredPersonsLazy = createDataTable(Person.class, fieldNames, page,PERSONS_100,Boolean.TRUE);
	}
	
	private <T extends AbstractIdentified> DataTable createDataTable(Class<T> aClass,String[] fieldNames,Integer page,Collection<T> collection,Boolean lazy){
		DataTable dataTable = new DataTable(aClass);
		dataTable.addColumnsByFieldNames(fieldNames);
		
		dataTable.getPropertiesMap().setRows(page);
		dataTable.getPropertiesMap().setPaginator(page != null);
		dataTable.getPropertiesMap().setLazy(lazy);
		dataTable.build();
		if(Boolean.TRUE.equals(lazy))
			dataTable.getPropertiesMap().setValue(new LazyDataModel<T>((List<T>) collection));
		else
			dataTable.addManyRow(collection);
		return dataTable;
	}
	
	private <T extends AbstractIdentified> DataTable createDataTable(Class<T> aClass,String[] fieldNames,Integer page,Collection<T> collection){
		return createDataTable(aClass, fieldNames, page, collection, Boolean.FALSE);
	}
	
	private <T extends AbstractIdentified> DataTable createDataTable(Class<T> aClass,String[] fieldNames,Integer page){
		return createDataTable(aClass, fieldNames, page, null, Boolean.TRUE);
	}
	
	/**/
	
	public static class LazyDataModel<T extends AbstractIdentified> extends org.primefaces.model.LazyDataModel<DataTable.Row> implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private List<T> records;
		
		public LazyDataModel(List<T> records) {
			this.records = records;
		}
		/*
		@Override
		public Object getRowKey(DataTable.Row row) {
			return ((AbstractIdentified)row.getPropertiesMap().getValue()).getCode();
		}
		
		@Override
		public DataTable.Row getRowData(String rowKey) {
			return (T) Person.get(rowKey,(Collection<Person>) records);
		}
		*/
		@Override
		public List<DataTable.Row> load(int first, int pageSize, String sortField,SortOrder sortOrder, Map<String, Object> filters) {
			if(records==null)
				return null;
			List<T> p = records.subList(first, first + pageSize > records.size() ? records.size() -1 : first + pageSize);
			setRowCount(records.size());
			return (List<Row>) DataTable.Row.instanciateMany(p);
		}
		
		
		
	}
	
	/**/
	
	private static final Collection<Person> PERSONS_3 = Person.instanciateManyRandomly(3);
	private static final Collection<Person> PERSONS_100 = Person.instanciateManyRandomly(100);
	
}
