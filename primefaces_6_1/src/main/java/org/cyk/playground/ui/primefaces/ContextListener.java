package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.cyk.playground.ui.primefaces.model.Location;
import org.cyk.playground.ui.primefaces.model.LocationForms;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.playground.ui.primefaces.model.PersonForms;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.userinterface.container.Form;

@WebListener
public class ContextListener implements ServletContextListener , Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Form.Master.setClass(Person.class, Constant.Action.CREATE, PersonForms.Simple.class);
		Form.Master.setClass(Person.class, Constant.Action.CREATE,"full", PersonForms.Full.class);
		
		Form.Master.setClass(Location.class, Constant.Action.CREATE, LocationForms.Simple.class);
		Form.Master.setClass(Location.class, Constant.Action.CREATE,"full", LocationForms.Full.class);
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		
	}

}
