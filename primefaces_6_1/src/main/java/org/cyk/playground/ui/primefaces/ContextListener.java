package org.cyk.playground.ui.primefaces;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.cyk.playground.ui.primefaces.model.File;
import org.cyk.playground.ui.primefaces.model.GlobalIdentifier;
import org.cyk.playground.ui.primefaces.model.Location;
import org.cyk.playground.ui.primefaces.model.LocationForms;
import org.cyk.playground.ui.primefaces.model.Person;
import org.cyk.playground.ui.primefaces.model.PersonForms;

import org.cyk.ui.web.primefaces.resources.PrimefacesResourcesManager;
import org.cyk.ui.web.primefaces.resources.ServletContextListener;
import org.cyk.utility.common.Constant;
import org.cyk.utility.common.helper.ClassHelper;
import org.cyk.utility.common.helper.FileHelper;
import org.cyk.utility.common.helper.InstanceHelper;
import org.cyk.utility.common.userinterface.command.Menu;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.Form.Detail;
import org.cyk.utility.common.userinterface.input.Input;
import org.cyk.utility.common.userinterface.input.InputEditor;
import org.cyk.utility.common.userinterface.input.InputFile;
import org.cyk.utility.common.userinterface.input.InputText;
import org.cyk.utility.common.userinterface.input.InputTextarea;
import org.cyk.utility.common.userinterface.input.choice.InputChoiceOneCombo;
import org.cyk.utility.common.userinterface.input.choice.InputChoiceOneRadio;

@WebListener
public class ContextListener extends ServletContextListener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		super.contextInitialized(servletContextEvent);
		inject(PrimefacesResourcesManager.class).initialize();
		
		Form.Master.setClass(Person.class, Constant.Action.CREATE, PersonForms.Simple.class);
		Form.Master.setClass(Person.class, Constant.Action.CREATE,"full", PersonForms.Full.class);
		
		Form.Master.setClass(Location.class, Constant.Action.CREATE, LocationForms.Simple.class);
		Form.Master.setClass(Location.class, Constant.Action.CREATE,"full", LocationForms.Full.class);
		
		ClassHelper.getInstance().map(Input.Listener.Adapter.Default.class, InputAdapter.class);
		ClassHelper.getInstance().map(Menu.Builder.Adapter.Default.class,MenuBuilder.class);
		
		InstanceHelper.Listener.Adapter.Default.DEFAULT_CLASS = org.cyk.playground.ui.primefaces.InstanceHelper.Listener.class;
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		super.contextDestroyed(servletContextEvent);
	}
	
	/**/
	
	public static class InputAdapter extends org.cyk.ui.web.primefaces.resources.InputAdapter {
		private static final long serialVersionUID = 1L;
		
		@Override
		public Collection<String> getFieldNames(Detail form, Object object) {
			if(object instanceof Person)
				return Arrays.asList("inputTextarea","inputText","inputPassword");
			if(object instanceof GlobalIdentifier)
				return Arrays.asList("code","name","description","otherDetails");
			if(object instanceof Person)
				return Arrays.asList("lastnames","sex","nationality");
			return super.getFieldNames(form, object);
		}
		
		@Override
		public Class<? extends Input<?>> getClass(Detail detail, Object object, Field field) {
			if(object instanceof GlobalIdentifier){
				if(field.getName().equals("code"))
					return InputText.class;
				if(field.getName().equals("image"))
					return InputFile.class;
				if(field.getName().equals("name"))
					return InputText.class;
				if(field.getName().equals("description"))
					return InputTextarea.class;
				if(field.getName().equals("otherDetails"))
					return InputEditor.class;
			}else if(object instanceof Person){
				if(field.getName().equals("lastnames"))
					return InputText.class;
				if(field.getName().equals("sex"))
					return InputChoiceOneRadio.class;
				if(field.getName().equals("nationality"))
					return InputChoiceOneCombo.class;
			}
			return super.getClass(detail, object, field);
		}
		
		public Class<?> getFileClass(){
			return File.class;
		}		
		
		@Override
		public Object getReadableValue(Input<?> input) {
			Object value = super.getReadableValue(input);
			if(value instanceof File){
				File file = (File) value;
				value = new FileHelper.File();
				((FileHelper.File)value).setBytes(file.getBytes());
				((FileHelper.File)value).setMime(file.getMime());
				((FileHelper.File)value).setName(file.getName());
				((FileHelper.File)value).setExtension(file.getExtension());
			}	
			return value;
		}

	}

}
