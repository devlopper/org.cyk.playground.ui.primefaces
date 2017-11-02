package org.cyk.playground.ui.primefaces.model;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Person {

	@NotNull 
	private String code;
	private String image;
	@NotNull 
	private String firstname;
	private String lastname;
	private /*Date*/String birthDate;
	private String birthLocation;
	private Sex sex;
	private Country country;
	
}
