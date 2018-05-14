package org.cyk.playground.ui.primefaces.page;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.PhoneNumberType;
import org.cyk.ui.web.primefaces.resources.PrimefacesResourcesManager;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.helper.CommandHelper;
import org.cyk.utility.common.helper.TimeHelper;
import org.cyk.utility.common.userinterface.command.Command;
import org.cyk.utility.common.userinterface.container.form.Form;
import org.cyk.utility.common.userinterface.container.window.Window;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class ProcessingStatusPage extends Window implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Command commandSend1;
	private Form form1;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Processing status");
		
		commandSend1 = new Command();
		commandSend1.getPropertiesMap().setValue("Send 1");
		commandSend1.setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			@Override
			protected Object __execute__() {
				TimeHelper.getInstance().pause(1000 * 5);
				System.out.println("ProcessingStatusPage.initialisation().new Default() {...}.__execute__()");
				return null;
			}
		});
		
		form1 = new Form();
		form1.setParent(this);
		form1._setPropertyAction(Constant.Action.CREATE);
		form1.setObject(new PhoneNumberType());
		form1.getDetail().setFieldsObjectFromMaster();
		form1.getDetail().add("globalIdentifier.code");
		form1.getDetail().add("globalIdentifier.name");
		form1.prepare().build();
		form1.getSubmitCommand().setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			@Override
			protected Object __execute__() {
				TimeHelper.getInstance().pause(1000 * 5);
				System.out.println("ProcessingStatusPage.initialisation().new Default() {...}.__execute__()");
				return null;
			}
		});
		System.out.println("ProcessingStatusPage.initialisation() : "+form1.getSubmitCommand().getPropertiesMap());
		PrimefacesResourcesManager.setInteractivityBlocker(form1, Boolean.FALSE);
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
