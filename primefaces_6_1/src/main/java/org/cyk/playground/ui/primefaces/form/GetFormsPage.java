package org.cyk.playground.ui.primefaces.form;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.Location;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.ui.web.primefaces.resources.PrimefacesResourcesManager;
import org.cyk.ui.web.primefaces.resources.page.Page;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.helper.TimeHelper;
import org.cyk.utility.common.userinterface.container.Form;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Named @ViewScoped @Getter @Setter
public class GetFormsPage extends Page implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Form.Master personFormSimple;
	private Form.Master personFormFull;
	private Form.Master locationFormSimple;
	private Form.Master locationFormFull;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		getPropertiesMap().setTitle("Get Forms");
		
		personFormSimple = Form.Master.get(new Person(), Constant.Action.CREATE).setSubmitCommandActionAdapterClass(SubmitCommandActionAdapter.class)
				.setLabelFromIdentifier("myformlabel").build();
		personFormFull = Form.Master.get(new Person(), Constant.Action.CREATE,"full").setSubmitCommandActionAdapterClass(SubmitCommandActionAdapter.class)
				.setLabelFromIdentifier("myformlabel").build();
		
		locationFormSimple = Form.Master.get(new Location(), Constant.Action.CREATE).setSubmitCommandActionAdapterClass(SubmitCommandActionAdapter.class)
				.setLabelFromIdentifier("myformlabel").build();
		locationFormFull = Form.Master.get(new Location(), Constant.Action.CREATE,"full").setSubmitCommandActionAdapterClass(SubmitCommandActionAdapter.class)
				.setLabelFromIdentifier("myformlabel").build();
		
		PrimefacesResourcesManager.setInteractivityBlocker(personFormSimple, Boolean.FALSE);
		PrimefacesResourcesManager.setInteractivityBlocker(personFormFull, Boolean.FALSE);
		
		personFormSimple.getSubmitCommand().getPropertiesMap().setAsync(Boolean.TRUE);
		personFormFull.getSubmitCommand().getPropertiesMap().setAsync(Boolean.TRUE);
		
	}

	@Getter @Setter @Accessors(chain=true)
	public static class SubmitCommandActionAdapter extends org.cyk.utility.common.userinterface.container.Form.Master.SubmitCommandActionAdapter implements Serializable{
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
