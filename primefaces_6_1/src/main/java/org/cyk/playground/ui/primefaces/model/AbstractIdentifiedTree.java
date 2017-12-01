package org.cyk.playground.ui.primefaces.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public abstract class AbstractIdentifiedTree<T> extends AbstractIdentified {

	private T parent;

	
	
}
