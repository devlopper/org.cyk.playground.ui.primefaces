package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.ui.web.primefaces.resources.page.Page;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class WindowsPage extends Page implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("MyTITLE");
		getPropertiesMap().setFullPage(Boolean.TRUE);
		getPropertiesMap().setInclude("/org.cyk.ui.web.primefaces/include/page/default2.xhtml");
	}
	
}
