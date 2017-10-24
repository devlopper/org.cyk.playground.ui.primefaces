package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.ui.web.primefaces.resources.page.Page;
import org.cyk.utility.common.helper.CollectionHelper;
import org.cyk.utility.common.helper.NotificationHelper;
import org.cyk.utility.common.helper.NotificationHelper.SeverityType;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class NotificationsPage extends Page implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Notifications");
		
		notificationsDialog.getPropertiesMap().setIdentifier("id123456");
		notificationsDialog.getPropertiesMap().setHeader("HEADER");
		notificationsDialog.getPropertiesMap().setModal(Boolean.TRUE);
		notificationsDialog.getPropertiesMap().setAppendTo("@(body)");
		//notificationsDialog.getPropertiesMap().setVisible("#{not empty facesContext.messageList}");
		notificationsDialog.getPropertiesMap().setDraggable(Boolean.TRUE);
		notificationsDialog.getPropertiesMap().setResizable(Boolean.TRUE);
		notificationsDialog.getPropertiesMap().setClosable(Boolean.TRUE);
		notificationsDialog.getPropertiesMap().setCloseOnEscape(Boolean.TRUE);
	}
	
	public void oneMessageError(){
		NotificationHelper.Notification notification = new NotificationHelper.Notification();
		notification.setDetails("MyDetails").setSummary("MySummary").setSeverityType(SeverityType.ERROR);
		NotificationHelper.getInstance().getViewer().setInput(notification).setType(NotificationHelper.Notification.Viewer.Type.INLINE).execute();
		notificationsDialog.getPropertiesMap().setVisible(CollectionHelper.getInstance().getSize(FacesContext.getCurrentInstance().getMessageList()) > 0);
	}
	
	public void manyMessagesError(){
		
	}
	
}
