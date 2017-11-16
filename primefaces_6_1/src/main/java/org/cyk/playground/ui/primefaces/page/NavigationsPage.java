package org.cyk.playground.ui.primefaces.page;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.common.Properties;
import org.cyk.utility.common.helper.CommandHelper;
import org.cyk.utility.common.helper.JavaScriptHelper;
import org.cyk.utility.common.helper.JavaScriptHelper.Script.Window.Navigate;
import org.cyk.utility.common.helper.UniformResourceLocatorHelper;
import org.cyk.utility.common.userinterface.command.Command;
import org.cyk.utility.common.userinterface.container.Window;
import org.cyk.utility.common.userinterface.panel.ConfirmationDialog;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class NavigationsPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;

	private Command commandClientGoWithoutPreviousGiven,commandClientGoWithPreviousGiven,commandClientGoWithoutPreviousSpecific,commandClientGoWithPreviousSpecific
		,commandServerGoBackToGivenPrevious,commandServerGoBackToSpecificPrevious;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		notificationDialog.getPropertiesMap();
		
		commandClientGoWithoutPreviousGiven = new Command();
		commandClientGoWithoutPreviousGiven.getPropertiesMap().setValue("Go without previous - Given");
		commandClientGoWithoutPreviousGiven.getPropertiesMap().setOnClick(new JavaScriptHelper.Script.Window.Navigate.Adapter
				.Default().setUniformResourceLocatorStringifier("gotogivenprevious", new Object[]{}).execute());
		commandClientGoWithoutPreviousGiven.getPropertiesMap().setType("button");
		
		commandClientGoWithPreviousGiven = new Command();
		commandClientGoWithPreviousGiven.getPropertiesMap().setValue("Go with previous - Given");
		JavaScriptHelper.Script.Window.Navigate navigate = (Navigate) new JavaScriptHelper.Script.Window.Navigate.Adapter
				.Default().setUniformResourceLocatorStringifier("gotogivenprevious", new Object[]{UniformResourceLocatorHelper.QueryParameter.Name.URL_PREVIOUS
						,requestComponent.getPropertiesMap().getUniformResourceLocator()});
		commandClientGoWithPreviousGiven.getPropertiesMap().setOnClick(navigate.execute());
		commandClientGoWithPreviousGiven.getPropertiesMap().setType("button");
		
		commandClientGoWithoutPreviousSpecific = new Command();
		commandClientGoWithoutPreviousSpecific.getPropertiesMap().setValue("Go without previous - Specific");
		commandClientGoWithoutPreviousSpecific.getPropertiesMap().setOnClick(new JavaScriptHelper.Script.Window.Navigate.Adapter
				.Default().setUniformResourceLocatorStringifier("gotospecificprevious", new Object[]{}).execute());
		commandClientGoWithoutPreviousSpecific.getPropertiesMap().setType("button");
		
		commandClientGoWithPreviousSpecific = new Command();
		commandClientGoWithPreviousSpecific.getPropertiesMap().setValue("Go with previous - Specific");
		navigate = (Navigate) new JavaScriptHelper.Script.Window.Navigate.Adapter
				.Default().setUniformResourceLocatorStringifier("gotospecificprevious", new Object[]{UniformResourceLocatorHelper.QueryParameter.Name.URL_PREVIOUS
						,requestComponent.getPropertiesMap().getUniformResourceLocator()});
		commandClientGoWithPreviousSpecific.getPropertiesMap().setOnClick(navigate.execute());
		commandClientGoWithPreviousSpecific.getPropertiesMap().setType("button");
		
		commandServerGoBackToGivenPrevious = new Command();
		commandServerGoBackToGivenPrevious.getPropertiesMap().setValue("Go back to given previous");
		commandServerGoBackToGivenPrevious.setAction((org.cyk.utility.common.helper.CommandHelper.Command) new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void processOnSuccess() {
				super.processOnSuccess();				
				notificationDialog.getOkCommand().addJavaScriptGoToUniformResourceLocatorOnEvent(Properties.ON_CLICK);
			}
		}.setIsImplemented(Boolean.TRUE).setIsNotifiableOnStatusSuccess(Boolean.TRUE));
		
		commandServerGoBackToSpecificPrevious = new Command();
		commandServerGoBackToSpecificPrevious.getPropertiesMap().setValue("Go back to specific previous");
		commandServerGoBackToSpecificPrevious.setAction((org.cyk.utility.common.helper.CommandHelper.Command) new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void processOnSuccess() {
				super.processOnSuccess();	
				notificationDialog.getOkCommand().addJavaScriptGoToUniformResourceLocatorOnEvent(Properties.ON_CLICK
						,new UniformResourceLocatorHelper.Stringifier.Adapter.Default().setPathIdentifier(UniformResourceLocatorHelper.getInstance()
								.getPathIdentifierDestination("gotospecificprevious")).execute()
						);
			}
		}.setIsImplemented(Boolean.TRUE).setIsNotifiableOnStatusSuccess(Boolean.TRUE));
		
		confirmationDialog = new ConfirmationDialog();
		
		
		
		
	}
	
}
