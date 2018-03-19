package org.cyk.playground.ui.primefaces.page;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.common.Constant;
import org.cyk.utility.common.helper.NotificationHelper;
import org.cyk.utility.common.helper.RandomHelper;
import org.cyk.utility.common.helper.NotificationHelper.SeverityType;
import org.cyk.utility.common.userinterface.container.window.Window;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class NotificationsPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected String computePropertyTitle() {
		return "Notifications";
	}
	
	public void oneMessageDefault(){
		oneMessageDefault(NotificationHelper.Notification.Viewer.Type.DEFAULT,Boolean.FALSE);
	}
	
	public void manyMessagesDefault(){
		manyMessagesDefault(NotificationHelper.Notification.Viewer.Type.DEFAULT,Boolean.FALSE);
	}
	
	public void oneMessageInline(){
		oneMessageDefault(NotificationHelper.Notification.Viewer.Type.INLINE,Boolean.FALSE);
	}
	
	public void manyMessagesInline(){
		manyMessagesDefault(NotificationHelper.Notification.Viewer.Type.INLINE,Boolean.FALSE);
	}
	
	public void oneMessageGrowl(){
		oneMessageDefault(NotificationHelper.Notification.Viewer.Type.GROWL,Boolean.FALSE);
	}
	
	public void manyMessagesGrowl(){
		manyMessagesDefault(NotificationHelper.Notification.Viewer.Type.GROWL,Boolean.FALSE);
	}
	
	public void oneMessageDialog(){
		oneMessageDefault(NotificationHelper.Notification.Viewer.Type.DIALOG,Boolean.FALSE);
	}
	
	public void manyMessagesDialog(){
		manyMessagesDefault(NotificationHelper.Notification.Viewer.Type.DIALOG,Boolean.FALSE);
	}
	
	/*****/
	
	public void oneVeryBigMessageDefault(){
		oneMessageDefault(NotificationHelper.Notification.Viewer.Type.DEFAULT,Boolean.TRUE);
	}
	
	public void manyVeryBigMessagesDefault(){
		manyMessagesDefault(NotificationHelper.Notification.Viewer.Type.DEFAULT,Boolean.TRUE);
	}
	
	public void oneVeryBigMessageInline(){
		oneMessageDefault(NotificationHelper.Notification.Viewer.Type.INLINE,Boolean.TRUE);
	}
	
	public void manyVeryBigMessagesInline(){
		manyMessagesDefault(NotificationHelper.Notification.Viewer.Type.INLINE,Boolean.TRUE);
	}
	
	public void oneVeryBigMessageGrowl(){
		oneMessageDefault(NotificationHelper.Notification.Viewer.Type.GROWL,Boolean.TRUE);
	}
	
	public void manyVeryBigMessagesGrowl(){
		manyMessagesDefault(NotificationHelper.Notification.Viewer.Type.GROWL,Boolean.TRUE);
	}
	
	public void oneVeryBigMessageDialog(){
		oneMessageDefault(NotificationHelper.Notification.Viewer.Type.DIALOG,Boolean.TRUE);
	}
	
	public void manyVeryBigMessagesDialog(){
		manyMessagesDefault(NotificationHelper.Notification.Viewer.Type.DIALOG,Boolean.TRUE);
	}
	
	/**/
	
	private void oneMessageDefault(NotificationHelper.Notification.Viewer.Type type,Boolean big){
		NotificationHelper.Notification notification = new NotificationHelper.Notification();
		notification.setDetails("MyDetails"+generateDetails(big)).setSummary("MySummary"+generateSummary(big)).setSeverityType(SeverityType.ERROR);
		NotificationHelper.getInstance().getViewer().setInput(notification).setType(type).execute();
		//notificationDialog.getPropertiesMap().setVisible(CollectionHelper.getInstance().getSize(FacesContext.getCurrentInstance().getMessageList()) > 0);
	}
	
	private void manyMessagesDefault(NotificationHelper.Notification.Viewer.Type type,Boolean big){
		NotificationHelper.Notification notification = new NotificationHelper.Notification();
		notification.setDetails("MyDetails1"+generateDetails(big)).setSummary("MySummary1"+generateSummary(big)).setSeverityType(SeverityType.INFO);
		NotificationHelper.getInstance().getViewer().setInput(notification).setType(type).execute();
		
		notification = new NotificationHelper.Notification();
		notification.setDetails("MyDetails2"+generateDetails(big)).setSummary("MySummary2"+generateSummary(big)).setSeverityType(SeverityType.WARNING);
		NotificationHelper.getInstance().getViewer().setInput(notification).setType(type).execute();
		
		notification = new NotificationHelper.Notification();
		notification.setDetails("MyDetails3"+generateDetails(big)).setSummary("MySummary3"+generateSummary(big)).setSeverityType(SeverityType.ERROR);
		NotificationHelper.getInstance().getViewer().setInput(notification).setType(type).execute();
		
		notification = new NotificationHelper.Notification();
		notification.setDetails("MyDetails4"+generateDetails(big)).setSummary("MySummary4"+generateSummary(big)).setSeverityType(SeverityType.ERROR);
		NotificationHelper.getInstance().getViewer().setInput(notification).setType(type).execute();
		
		notification = new NotificationHelper.Notification();
		notification.setDetails("MyDetails5"+generateDetails(big)).setSummary("MySummary5"+generateSummary(big)).setSeverityType(SeverityType.INFO);
		NotificationHelper.getInstance().getViewer().setInput(notification).setType(type).execute();
		
		//notificationDialog.getPropertiesMap().setVisible(CollectionHelper.getInstance().getSize(FacesContext.getCurrentInstance().getMessageList()) > 0);
	}
	
	private String generateDetails(Boolean big) {
		return generateText(big);
	}
	
	private String generateSummary(Boolean big) {
		return generateText(big);
	}
	
	private String generateText(Boolean big) {
		return big ? RandomHelper.getInstance().getLines(50, 100, 50, 100) : Constant.EMPTY_STRING;
	}
}
