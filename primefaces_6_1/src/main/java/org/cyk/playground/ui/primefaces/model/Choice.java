package org.cyk.playground.ui.primefaces.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Choice {
	
	public static final List<Choice> LIST = new ArrayList<>();
	static {
		LIST.add(new Choice().setCode("C1").setName("First"));
		LIST.add(new Choice().setCode("C2").setName("Second"));
		LIST.add(new Choice().setCode("C3").setName("Third"));
	}
	
	private String code,name;
	
}