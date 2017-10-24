package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.ui.web.primefaces.resources.page.Page;
import org.cyk.utility.common.helper.CommandHelper;
import org.cyk.utility.common.helper.ThrowableHelper;
import org.cyk.utility.common.userinterface.command.Command;
import org.cyk.utility.common.userinterface.event.Confirm;
import org.cyk.utility.common.userinterface.panel.ConfirmationDialog;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class CommandsPage extends Page implements Serializable {
	private static final long serialVersionUID = 1L;

	private Command commandClient,commandServer,commandClientServer,commandClientServerClient,commandServerClient;
	
	private Command defaultCommand,successCommand,failureCommand,customSuccessMessageCommand,customFailureMessageCommand,parameterCommand,successConfirmableCommand
		,failureConfirmableCommand;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		commandClient = new Command();
		commandClient.getPropertiesMap().setValue("Client");
		commandClient.getPropertiesMap().setOnClick("alert('Processing on client only')");
		commandClient.getPropertiesMap().setType("button");
		
		commandServer = new Command();
		commandServer.getPropertiesMap().setValue("Server");
		commandServer.setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			@Override
			protected Object __execute__() {
				System.out.println("Server processing only");
				return super.__execute__();
			}
		});
		
		commandClientServer = new Command();
		commandClientServer.getPropertiesMap().setValue("Client Server");
		commandClientServer.getPropertiesMap().setOnClick("alert('Processing on client first')");
		commandClientServer.setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			@Override
			protected Object __execute__() {
				System.out.println("Server processing second");
				return super.__execute__();
			}
		});
		
		commandClientServerClient = new Command();
		commandClientServerClient.getPropertiesMap().setValue("Client Server Client");
		commandClientServerClient.getPropertiesMap().setOnClick("alert('Processing on client first')");
		commandClientServerClient.getPropertiesMap().setOnComplete("alert('Processing on client third')");
		commandClientServerClient.setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			@Override
			protected Object __execute__() {
				System.out.println("Server processing second");
				return super.__execute__();
			}
		});
		
		commandServerClient = new Command();
		commandServerClient.getPropertiesMap().setValue("Server Client");
		commandServerClient.getPropertiesMap().setOnComplete("alert('Processing on client second')");
		commandServerClient.setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			@Override
			protected Object __execute__() {
				System.out.println("Server processing first");
				return super.__execute__();
			}
		});
		
		/**/
		
		defaultCommand = new Command();
		defaultCommand.getPropertiesMap().setValue("Default").setIcon("ui-icon-trash");
		defaultCommand.setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			@Override
			protected Object __execute__() {
				System.out.println("CommandsPage.initialisation().new Default() {...}.__execute__() 0");
				return super.__execute__();
			}
		});
		
		successCommand = new Command();
		successCommand.getPropertiesMap().setValue("Success").setIcon("ui-icon-trash");
		successCommand.setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			@Override
			protected Object __execute__() {
				System.out.println("CommandsPage.initialisation().new Default() {...}.__execute__()");
				return super.__execute__();
			}
		});
		successCommand.getAction().setIsNotifiableOnStatusSuccess(Boolean.TRUE);
		successCommand.setConfirm(new Confirm());
		
		failureCommand = new Command();
		failureCommand.setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			protected Object __execute__() {ThrowableHelper.getInstance().throw_("!!!ERROR!!!"); return null;}
		}).getPropertiesMap().setValue("Failure").setIcon("ui-icon-trash");
		
		customSuccessMessageCommand = new Command();
		customSuccessMessageCommand.setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			protected Object __execute__() {return null;}
		}).getPropertiesMap().setValue("Custom Success Message").setIcon("ui-icon-trash");
		customSuccessMessageCommand.getAction().setIsNotifiableOnStatusSuccess(Boolean.TRUE)
			.setStatusNotificationStringIdentifier(CommandHelper.Command.Status.SUCCESS, "my_success_message_string_dentifier");
		
		customFailureMessageCommand = new Command();
		customFailureMessageCommand.setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			protected Object __execute__() {ThrowableHelper.getInstance().throw_("!!!ERROR!!!"); return null;}
		}).getPropertiesMap().setValue("Custom Failure Message").setIcon("ui-icon-trash");
		customFailureMessageCommand.getAction().setStatusNotificationStringIdentifier(CommandHelper.Command.Status.FAILURE, "my_failure_message_string_dentifier");
		
		parameterCommand = new Command();
		parameterCommand.setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			protected Object __execute__() {
				System.out.println(getInput());
				return null;
			}
		}).getPropertiesMap().setValue("Parameter").setIcon("ui-icon-trash");
		
		successConfirmableCommand = new Command();
		successConfirmableCommand.setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			protected Object __execute__() {return null;}
		}).getPropertiesMap().setValue("Confirm Success").setIcon("ui-icon-trash");
		successConfirmableCommand.getAction().setIsNotifiableOnStatusSuccess(Boolean.TRUE).setIsConfirmable(Boolean.TRUE);
		
		failureConfirmableCommand = new Command();
		failureConfirmableCommand.setAction(new CommandHelper.Command.Adapter.Default(){
			private static final long serialVersionUID = 1L;
			protected Object __execute__() {ThrowableHelper.getInstance().throw_("!!!ERROR!!!"); return null;}
		}).getPropertiesMap().setValue("Confirm Failure").setIcon("ui-icon-trash");
		failureConfirmableCommand.getAction().setIsConfirmable(Boolean.TRUE);
		
		
		confirmationDialog = new ConfirmationDialog();
	}
	
}
