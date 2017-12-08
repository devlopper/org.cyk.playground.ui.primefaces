package org.cyk.playground.ui.primefaces.page.datatable;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import org.cyk.playground.ui.primefaces.model.AbstractIdentified;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.utility.common.userinterface.collection.DataTable;
import org.cyk.utility.common.userinterface.container.window.Window;

@Named @ViewScoped @Getter @Setter
public class DataTablesPagingPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private DataTable emptyPersons,emptyPersonsPaginated,threePersons,threePersonsPaginated
		,hundredPersons,hundredPersonsPaginated;
	private Integer page = 5;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Data tables Paging");
		
		createPersons();
				
	}
	
	private void createPersons(){
		String[] fieldNames = new String[]{"globalIdentifier.code","globalIdentifier.name","lastnames"};
		emptyPersons = createDataTable(Person.class, fieldNames, null, null);
		emptyPersonsPaginated = createDataTable(Person.class, fieldNames, page,null);
		
		threePersons = createDataTable(Person.class, fieldNames, null, PERSONS_3);
		threePersonsPaginated = createDataTable(Person.class, fieldNames, page,PERSONS_3);
		
		hundredPersons = createDataTable(Person.class, fieldNames, null, PERSONS_100);
		hundredPersonsPaginated = createDataTable(Person.class, fieldNames, page,PERSONS_100);
	}
	
	private <T extends AbstractIdentified> DataTable createDataTable(Class<T> aClass,String[] fieldNames,Integer page,final Collection<T> collection){
		DataTable dataTable = new DataTable();
		
		dataTable.setActionOnClass(aClass);
		dataTable.addColumnsByFieldNames(fieldNames);
		dataTable.getPropertiesMap().setRows(page);
		dataTable.getPropertiesMap().setPaginator(page != null);
		
		dataTable.prepare();
		dataTable.build();
		
		dataTable.addManyRow(collection);
		return dataTable;
	}
	
	/**/
	
	private static final Collection<Person> PERSONS_3 = Person.instanciateManyRandomly(3);
	private static final Collection<Person> PERSONS_100 = Person.instanciateManyRandomly(100);
	
}
