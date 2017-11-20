package org.cyk.playground.ui.primefaces.page;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.common.helper.NotificationHelper;
import org.cyk.utility.common.helper.NotificationHelper.SeverityType;
import org.cyk.utility.common.userinterface.container.window.Window;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class NotificationsPage extends Window implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Notifications");
	}
	
	public void oneMessageDefault(){
		oneMessageDefault(NotificationHelper.Notification.Viewer.Type.DEFAULT);
	}
	
	public void manyMessagesDefault(){
		manyMessagesDefault(NotificationHelper.Notification.Viewer.Type.DEFAULT);
	}
	
	public void oneMessageInline(){
		oneMessageDefault(NotificationHelper.Notification.Viewer.Type.INLINE);
	}
	
	public void manyMessagesInline(){
		manyMessagesDefault(NotificationHelper.Notification.Viewer.Type.INLINE);
	}
	
	public void oneMessageGrowl(){
		oneMessageDefault(NotificationHelper.Notification.Viewer.Type.GROWL);
	}
	
	public void manyMessagesGrowl(){
		manyMessagesDefault(NotificationHelper.Notification.Viewer.Type.GROWL);
	}
	
	public void oneMessageDialog(){
		oneMessageDefault(NotificationHelper.Notification.Viewer.Type.DIALOG);
	}
	
	public void manyMessagesDialog(){
		manyMessagesDefault(NotificationHelper.Notification.Viewer.Type.DIALOG);
	}
	
	/**/
	
	private void oneMessageDefault(NotificationHelper.Notification.Viewer.Type type){
		NotificationHelper.Notification notification = new NotificationHelper.Notification();
		notification.setDetails("MyDetails").setSummary("MySummary").setSeverityType(SeverityType.ERROR);
		NotificationHelper.getInstance().getViewer().setInput(notification).setType(type).execute();
		//notificationDialog.getPropertiesMap().setVisible(CollectionHelper.getInstance().getSize(FacesContext.getCurrentInstance().getMessageList()) > 0);
	}
	
	private void manyMessagesDefault(NotificationHelper.Notification.Viewer.Type type){
		NotificationHelper.Notification notification = new NotificationHelper.Notification();
		notification.setDetails("MyDetails1").setSummary("MySummary1").setSeverityType(SeverityType.INFO);
		NotificationHelper.getInstance().getViewer().setInput(notification).setType(type).execute();
		
		notification = new NotificationHelper.Notification();
		notification.setDetails("MyDetails2").setSummary("MySummary2").setSeverityType(SeverityType.WARNING);
		NotificationHelper.getInstance().getViewer().setInput(notification).setType(type).execute();
		
		notification = new NotificationHelper.Notification();
		notification.setDetails("MyDetails3").setSummary("MySummary3").setSeverityType(SeverityType.ERROR);
		NotificationHelper.getInstance().getViewer().setInput(notification).setType(type).execute();
		
		notification = new NotificationHelper.Notification();
		notification.setDetails("MyDetails4").setSummary("MySummary4").setSeverityType(SeverityType.ERROR);
		NotificationHelper.getInstance().getViewer().setInput(notification).setType(type).execute();
		
		notification = new NotificationHelper.Notification();
		notification.setDetails("MyDetails5").setSummary("MySummary5").setSeverityType(SeverityType.INFO);
		NotificationHelper.getInstance().getViewer().setInput(notification).setType(type).execute();
		
		//notificationDialog.getPropertiesMap().setVisible(CollectionHelper.getInstance().getSize(FacesContext.getCurrentInstance().getMessageList()) > 0);
	}
	
}
