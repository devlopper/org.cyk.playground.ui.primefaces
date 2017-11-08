package org.cyk.playground.ui.primefaces.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Period {

	private Date from;
	private Date to;
	
	public static final String FIELD_FROM = "from";
	public static final String FIELD_TO = "to";
}
