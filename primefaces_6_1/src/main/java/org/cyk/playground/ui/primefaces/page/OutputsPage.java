package org.cyk.playground.ui.primefaces.page;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.ContextListener;
import org.cyk.playground.ui.primefaces.model.Country;
import org.cyk.utility.common.helper.FileHelper;
import org.cyk.utility.common.helper.FileHelper.File;
import org.cyk.utility.common.userinterface.Image;
import org.cyk.utility.common.userinterface.container.Window;
import org.cyk.utility.common.userinterface.output.OutputFile;
import org.cyk.utility.common.userinterface.output.OutputText;
import org.primefaces.model.ByteArrayContent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Named @ViewScoped @Getter @Setter
public class OutputsPage extends Window implements Serializable {

	private static final long serialVersionUID = 1L;

	private OutputText outputText;
	private OutputFile outputFile;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		outputText = new OutputText();
		outputText.getPropertiesMap().setValue("My val");
		//inputText._setField(new Model(), "myInputText");
	
		outputFile = new OutputFile();
		FileHelper.File file = FileHelper.getInstance().get(ContextListener.class, "image001.png");
		//outputFile.getPropertiesMap().setValue(new ByteArrayContent(file.getBytes(), file.getMime()));
		//outputFile.getPropertiesMap().setStream(Boolean.FALSE);
		
		((Image)outputFile.getPropertiesMap().getThumbnail()).getPropertiesMap().setValue(new ByteArrayContent(file.getBytes(), file.getMime()));
		((Image)outputFile.getPropertiesMap().getThumbnail()).getPropertiesMap().setStream(Boolean.FALSE);
	}
	
	public void submit(){
		//System.out.println("InputsPage.submit() InputText = "+inputText+" , InputPassword = "+inputPassword);
	}
	
	@Getter @Setter
	public static class Model {
		
		private String myInputText;
		private Boolean myInputBooleanButton;
		private Boolean myInputBooleanCheckBox;
		private String myInputChoiceOneComboString;
		private Integer myInputChoiceOneComboInteger;
		private BigDecimal myInputChoiceOneComboBigDecimal;
		private MyEnum myInputChoiceOneComboEnum;
		private Boolean myInputChoiceOneComboBoolean;
		private MyType myInputChoiceOneComboMyType;
		
		private Country myInputChoiceOneListBox;
		private MyType myInputChoiceOneRadio;
		private Country myInputChoiceOneButton;
		private MyType myInputChoiceOneAutoComplete;
		private Country myInputChoiceOneCascadeList;
		
		private MyType myInputChoiceManyAutoComplete;
		private Country myInputChoiceManyButton;
		private MyType myInputChoiceManyCheck;
		private Country myInputChoiceManyCombo;
		private MyType myInputChoiceManyPickList;
		private Country myInputChoiceManyList;
		
		private File myInputFile;
	}
	
	public static enum MyEnum{
		E1,E2,E3,E4,E5,E6,E7
	}
	
	@Getter @Setter @Accessors(chain=true) @AllArgsConstructor
	public static class MyType {
		
		public static Collection<MyType> COLLECTION = new ArrayList<>();
		static {
			COLLECTION.add(new MyType("t1","first instance"));
			COLLECTION.add(new MyType("t2","second instance"));
			COLLECTION.add(new MyType("t3","3rd instance"));
		}
		
		private String code,name;
		
		@Override
		public String toString() {
			return name;
		}
	}
	
	public static final Collection<String> STRINGS = Arrays.asList("string 1","string 2","string 3","string 4","string 5");
	public static final Collection<Integer> INTEGERS = Arrays.asList(1,2,3,4,5,123);
	public static final Collection<BigDecimal> BIG_DECIMALS = Arrays.asList(new BigDecimal(1),new BigDecimal(10),new BigDecimal(123),new BigDecimal(591),new BigDecimal(12));
	
}
