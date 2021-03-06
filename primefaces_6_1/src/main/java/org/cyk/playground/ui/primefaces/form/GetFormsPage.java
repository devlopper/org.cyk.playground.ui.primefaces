package org.cyk.playground.ui.primefaces.form;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.Location;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.ui.web.primefaces.resources.PrimefacesResourcesManager;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.helper.TimeHelper;
import org.cyk.utility.common.userinterface.container.form.Form;
import org.cyk.utility.common.userinterface.container.window.Window;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Named @ViewScoped @Getter @Setter
public class GetFormsPage extends Window implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Form personFormSimple;
	private Form personFormFull;
	private Form locationFormSimple;
	private Form locationFormFull;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Get Forms");
		
		//personFormSimple = Form.Master.get(this,new Person(), Constant.Action.CREATE).setSubmitCommandActionAdapterClass(SubmitCommandActionAdapter.class)
		//		.setLabelFromIdentifier("myformlabel").build();
		//personFormFull = Form.Master.get(this,new Person(), Constant.Action.CREATE,"full").setSubmitCommandActionAdapterClass(SubmitCommandActionAdapter.class)
		//		.setLabelFromIdentifier("myformlabel").build();
		
		//locationFormSimple = Form.Master.get(this,new Location(), Constant.Action.CREATE).setSubmitCommandActionAdapterClass(SubmitCommandActionAdapter.class)
		//		.setLabelFromIdentifier("myformlabel").build();
		//locationFormFull = Form.Master.get(this,new Location(), Constant.Action.CREATE,"full").setSubmitCommandActionAdapterClass(SubmitCommandActionAdapter.class)
		//		.setLabelFromIdentifier("myformlabel").build();
		
		PrimefacesResourcesManager.setInteractivityBlocker(personFormSimple, Boolean.FALSE);
		PrimefacesResourcesManager.setInteractivityBlocker(personFormFull, Boolean.FALSE);
		
		personFormSimple.getSubmitCommand().getPropertiesMap().setAsync(Boolean.TRUE);
		personFormFull.getSubmitCommand().getPropertiesMap().setAsync(Boolean.TRUE);
		
	}

	@Getter @Setter @Accessors(chain=true)
	public static class SubmitCommandActionAdapter extends org.cyk.utility.common.userinterface.container.form.Form.SubmitCommandActionAdapter implements Serializable{
		private static final long serialVersionUID = 1L;

		@Override
		protected Object __execute__() {
			//super.__execute__();
			System.out.println("FormsPage.SubmitCommandActionAdapter.__execute__() : CALL BUSINESS SERVICE to handle data : "+getInput());
			TimeHelper.getInstance().pause(1000 * 5);
			System.out.println("DONE!!!");
			return null;
		}
		
		/*@Override
		public Boolean getIsConfirmable() {
			return Boolean.TRUE;
		}*/
		
		
	}
}
