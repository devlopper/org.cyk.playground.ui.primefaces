package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.common.userinterface.command.Command;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class CommandsPage implements Serializable {

	private static final long serialVersionUID = 1L;

	private Command command;
	
	public CommandsPage() {
		command = new Command();
		command.getPropertiesMap().setRendered(Boolean.TRUE);
		command.getPropertiesMap().setValue("MyButton");
		command.getPropertiesMap().setOnClick("alert('Yes I am')");
		command.getPropertiesMap().setType("button");
	}
	
}
