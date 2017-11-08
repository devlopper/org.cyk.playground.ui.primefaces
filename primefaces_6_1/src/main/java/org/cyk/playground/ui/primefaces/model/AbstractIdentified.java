package org.cyk.playground.ui.primefaces.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public abstract class AbstractIdentified {

	private GlobalIdentifier globalIdentifier = new GlobalIdentifier();

	public AbstractIdentified setCode(String code) {
		globalIdentifier.setCode(code);
		return this;
	}

	public AbstractIdentified setName(String name) {
		globalIdentifier.setName(name);
		return this;
	}

	public String getCode() {
		return globalIdentifier.getCode();
	}

	public String getName() {
		return globalIdentifier.getName();
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
}
