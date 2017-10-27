package org.cyk.playground.ui.primefaces.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Person {

	private String code;
	private String image;
	private String firstname;
	private String lastname;
	private Date birthDate;
	private String birthLocation;
	private Sex sex;
	private Country country;
	
	/**/
	
	public static enum Sex {
		MALE,FEMALE
	}
	
	
}
