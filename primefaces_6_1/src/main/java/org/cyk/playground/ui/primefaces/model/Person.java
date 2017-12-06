package org.cyk.playground.ui.primefaces.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.cyk.playground.ui.primefaces.ContextListener;
import org.cyk.utility.common.helper.FileHelper;
import org.cyk.utility.common.helper.RandomHelper;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Person extends AbstractIdentified {

	public static final List<Person> COLLECTION = new ArrayList<>();
	static {
		create("P001", "Komenan", "Yao Christian","image001.png");
		create("P002", "Gnangnan", "Sandrine Méliane","image002.png");
	}
	
	private String lastnames;
	private Sex sex;
	private Country nationality;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	/**/
	
	public static void create(String code,String firstname,String lastnames,String image){
		Person person = new Person();
		person.setGlobalIdentifier(new GlobalIdentifier());
		person.getGlobalIdentifier().setCode(code);
		person.getGlobalIdentifier().setName(firstname);
		person.setLastnames(lastnames);
		person.getGlobalIdentifier().setImage(new File(FileHelper.getInstance().get(ContextListener.class, image)));
		COLLECTION.add(person);
	}
	
	public static Person instanciateOneRandomly(){
		RandomHelper.Person randomPerson = RandomHelper.getInstance().getPerson();
		Person person = new Person();
		person.setGlobalIdentifier(new GlobalIdentifier());
		person.getGlobalIdentifier().setCode(RandomHelper.getInstance().getAlphabetic(5));
		person.getGlobalIdentifier().setName(randomPerson.getFirstname());
		person.setLastnames(randomPerson.getLastname());
		person.getGlobalIdentifier().setImage(new File(randomPerson.getHeadOnlyPhoto()));
		person.getGlobalIdentifier().setUsable(RandomHelper.getInstance().getBoolean());
		//person.getGlobalIdentifier().setCreationDate(RandomHelper.getInstance().getDate());
		person.setNationality(RandomHelper.getInstance().getElement(Country.COLLECTION));
		//person.getGlobalIdentifier().setOwner(RandomHelper.getInstance().getAlphabetic(5));
		return person;
	}
	
	public static Collection<Person> instanciateManyRandomly(Integer count){
		Collection<Person> persons = new ArrayList<>();
		for(Integer index = 0 ; index < count ; index ++)
			persons.add(instanciateOneRandomly());
		return persons;
	}

	public static Person get(String code,Collection<Person> persons) {
		for(Person person : persons)
			if(person.getCode().equals(code))
				return person;
		return null;
	}
	
	public static Person get(String code) {
		return get(code,COLLECTION);
	}
}
