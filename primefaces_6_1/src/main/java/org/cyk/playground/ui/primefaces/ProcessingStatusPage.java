package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.ui.web.primefaces.resources.page.Page;
import org.cyk.utility.common.helper.TimeHelper;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class ProcessingStatusPage extends Page implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Processing status");
	}
	
	public void unknownDuration(){
		System.out.println("ProcessingStatusPage.unknownDuration() START");
		TimeHelper.getInstance().pause(1000 * 3);
		System.out.println("ProcessingStatusPage.unknownDuration() DONE");
	}
	
	public void knownDuration(){
		System.out.println("ProcessingStatusPage.knownDuration()");
		TimeHelper.getInstance().pause(1000 * 3);
	}
	
	public void unknownElements(){
		System.out.println("ProcessingStatusPage.unknownElements()");
		TimeHelper.getInstance().pause(1000 * 3);
	}
	
	public void knownElements(){
		System.out.println("ProcessingStatusPage.knownElements()");
		TimeHelper.getInstance().pause(1000 * 3);
	}
	
}
