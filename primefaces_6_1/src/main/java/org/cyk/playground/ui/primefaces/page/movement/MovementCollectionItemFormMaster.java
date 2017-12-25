package org.cyk.playground.ui.primefaces.page.movement;

import java.io.Serializable;
import java.math.BigDecimal;

import org.cyk.playground.ui.primefaces.model.movement.MovementCollectionItem;
import org.cyk.ui.web.primefaces.resources.page.controlpanel.IdentifiableEditPage;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.event.Event;

public class MovementCollectionItemFormMaster extends IdentifiableEditPage.FormMaster implements Serializable {
	private static final long serialVersionUID = -6211058744595898478L;
	
	@Override
	protected void __prepare__() {
		super.__prepare__();
		final Form.Detail detail = getDetail();
		
		detail.setFieldsObjectFromMaster();
		detail.add("movementCollection").addBreak();
		detail.addReadOnly("previousCumul").addBreak();
		detail.add("movementAction").addBreak();
		detail.add("value").addBreak();
		detail.addReadOnly("cumul").addBreak();
		
		Event.instanciateOne(detail, "movementCollection", new String[]{"previousCumul","cumul"}, new Event.CommandAdapter(){
			private static final long serialVersionUID = 1L;
			protected void ____execute____() {
				MovementCollectionItem movementCollectionItem = (MovementCollectionItem) getEventPropertyFormMasterObject();
				movementCollectionItem.setPreviousCumul(movementCollectionItem.getMovementCollection().getValue());
				computeCumul(movementCollectionItem);
			}
		});
		
		Event.instanciateOne(detail, "movementAction", new String[]{"cumul"}, new Event.CommandAdapter(){
			private static final long serialVersionUID = 1L;
			protected void ____execute____() {
				MovementCollectionItem movementCollectionItem = (MovementCollectionItem) getEventPropertyFormMasterObject();
				computeCumul(movementCollectionItem);
			}
		});
		
		Event.instanciateOne(detail, "value", new String[]{"cumul"}, new Event.CommandAdapter(){
			private static final long serialVersionUID = 1L;
			protected void ____execute____() {
				MovementCollectionItem movementCollectionItem = (MovementCollectionItem) getEventPropertyFormMasterObject();
				computeCumul(movementCollectionItem);
			}
		});
	}
	
	private void computeCumul(MovementCollectionItem movementCollectionItem){
		BigDecimal cumul;
		if(movementCollectionItem.getMovementCollection() == null || movementCollectionItem.getMovementAction() == null || movementCollectionItem.getValue() == null){
			cumul = null;
		}else{
			cumul = movementCollectionItem.getMovementCollection().getValue();
			if(movementCollectionItem.getMovementAction().getName().equals("Entrée"))
				cumul = cumul.add(movementCollectionItem.getValue());
			else
				cumul = cumul.subtract(movementCollectionItem.getValue());
		}
		movementCollectionItem.setCumul(cumul);
	}
	
	
	
}
