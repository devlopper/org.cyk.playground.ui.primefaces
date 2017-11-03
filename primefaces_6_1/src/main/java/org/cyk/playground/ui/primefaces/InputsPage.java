package org.cyk.playground.ui.primefaces;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.playground.ui.primefaces.model.Country;
import org.cyk.ui.web.primefaces.resources.page.Page;
import org.cyk.utility.common.helper.FileHelper.File;
import org.cyk.utility.common.userinterface.input.InputBooleanButton;
import org.cyk.utility.common.userinterface.input.InputBooleanCheckBox;
import org.cyk.utility.common.userinterface.input.InputFile;
import org.cyk.utility.common.userinterface.input.InputText;
import org.cyk.utility.common.userinterface.input.choice.InputChoiceManyAutoComplete;
import org.cyk.utility.common.userinterface.input.choice.InputChoiceManyButton;
import org.cyk.utility.common.userinterface.input.choice.InputChoiceManyCheck;
import org.cyk.utility.common.userinterface.input.choice.InputChoiceManyCombo;
import org.cyk.utility.common.userinterface.input.choice.InputChoiceManyList;
import org.cyk.utility.common.userinterface.input.choice.InputChoiceManyPickList;
import org.cyk.utility.common.userinterface.input.choice.InputChoiceOneAutoComplete;
import org.cyk.utility.common.userinterface.input.choice.InputChoiceOneButton;
import org.cyk.utility.common.userinterface.input.choice.InputChoiceOneCascadeList;
import org.cyk.utility.common.userinterface.input.choice.InputChoiceOneCombo;
import org.cyk.utility.common.userinterface.input.choice.InputChoiceOneList;
import org.cyk.utility.common.userinterface.input.choice.InputChoiceOneRadio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Named @ViewScoped @Getter @Setter
public class InputsPage extends Page implements Serializable {

	private static final long serialVersionUID = 1L;

	private InputText inputText;
	private InputBooleanButton inputBooleanButton;
	private InputBooleanCheckBox inputBooleanCheckBox;
	private InputChoiceOneCombo inputChoiceOneComboString;
	private InputChoiceOneCombo inputChoiceOneComboInteger;
	private InputChoiceOneCombo inputChoiceOneComboBigDecimal;
	private InputChoiceOneCombo inputChoiceOneComboEnum;
	private InputChoiceOneCombo inputChoiceOneComboBoolean;
	private InputChoiceOneCombo inputChoiceOneComboMyType;
	
	private InputChoiceOneList inputChoiceOneListBox;
	private InputChoiceOneRadio inputChoiceOneRadio;
	private InputChoiceOneButton inputChoiceOneButton;
	private InputChoiceOneAutoComplete inputChoiceOneAutoComplete;
	private InputChoiceOneCascadeList inputChoiceOneCascadeList;
	
	private InputChoiceManyAutoComplete inputChoiceManyAutoComplete;
	private InputChoiceManyButton inputChoiceManyButton;
	private InputChoiceManyCheck inputChoiceManyCheck;
	private InputChoiceManyCombo inputChoiceManyCombo;
	private InputChoiceManyPickList inputChoiceManyPickList;
	private InputChoiceManyList inputChoiceManyList;
	
	private InputFile inputFile;
	
	@Override
	protected void initialisation() {
		super.initialisation();
		inputText = new InputText();
		inputText.setField(new Model(), "myInputText");
	
		//inputText.getPropertiesMap().setOnChange("alert('it has changed')");
		//inputText.getPropertiesMap().setOnClick("alert('it has been clicked')");
		
		inputBooleanButton = new InputBooleanButton();
		inputBooleanButton.setField(new Model(), "myInputBooleanButton");
		
		inputBooleanCheckBox = new InputBooleanCheckBox();
		inputBooleanCheckBox.setField(new Model(), "myInputBooleanCheckBox");
		
		inputChoiceOneComboString = new InputChoiceOneCombo().setField(new Model(), "myInputChoiceOneComboString",STRINGS);
		inputChoiceOneComboInteger = new InputChoiceOneCombo().setField(new Model(), "myInputChoiceOneComboInteger",INTEGERS);
		inputChoiceOneComboBigDecimal = new InputChoiceOneCombo().setField(new Model(), "myInputChoiceOneComboBigDecimal",BIG_DECIMALS);
		inputChoiceOneComboEnum = new InputChoiceOneCombo().setField(new Model(), "myInputChoiceOneComboEnum");
		inputChoiceOneComboBoolean = new InputChoiceOneCombo().setField(new Model(), "myInputChoiceOneComboBoolean");
		inputChoiceOneComboMyType = new InputChoiceOneCombo().setField(new Model(), "myInputChoiceOneComboMyType");
		
		inputChoiceOneListBox = new InputChoiceOneList().setField(new Model(), "myInputChoiceOneListBox");
		inputChoiceOneRadio = new InputChoiceOneRadio().setField(new Model(), "myInputChoiceOneRadio");
		inputChoiceOneButton = new InputChoiceOneButton().setField(new Model(), "myInputChoiceOneButton");
		inputChoiceOneAutoComplete = new InputChoiceOneAutoComplete().setField(new Model(), "myInputChoiceOneAutoComplete");
		inputChoiceOneCascadeList = new InputChoiceOneCascadeList().setField(new Model(), "myInputChoiceOneCascadeList");
		
		inputChoiceManyAutoComplete = new InputChoiceManyAutoComplete().setField(new Model(), "myInputChoiceManyAutoComplete");
		inputChoiceManyButton = new InputChoiceManyButton().setField(new Model(), "myInputChoiceManyButton");
		inputChoiceManyCheck = new InputChoiceManyCheck().setField(new Model(), "myInputChoiceManyCheck");
		inputChoiceManyCombo = new InputChoiceManyCombo().setField(new Model(), "myInputChoiceManyCombo");
		inputChoiceManyList = new InputChoiceManyList().setField(new Model(), "myInputChoiceManyPickList");
		inputChoiceManyPickList = new InputChoiceManyPickList().setField(new Model(), "myInputChoiceManyList");
		 
		inputFile = new InputFile().setField(new Model(), "myInputFile");
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
