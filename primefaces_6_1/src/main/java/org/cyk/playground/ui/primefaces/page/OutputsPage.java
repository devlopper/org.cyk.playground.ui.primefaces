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
import org.cyk.utility.common.annotation.user.interfaces.Input;
import org.cyk.utility.common.annotation.user.interfaces.InputFile;
import org.cyk.utility.common.helper.FieldHelper;
import org.cyk.utility.common.helper.FileHelper;
import org.cyk.utility.common.helper.FileHelper.File;
import org.cyk.utility.common.userinterface.container.Form;
import org.cyk.utility.common.userinterface.container.window.Window;
import org.cyk.utility.common.userinterface.output.OutputFile;
import org.cyk.utility.common.userinterface.output.OutputText;

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
		Model model = new Model();
		model.setMyInputText("hello world!!!");
		model.setMyInputFile(FileHelper.getInstance().get(ContextListener.class, "image001.png"));
		
		outputText = (OutputText) OutputText.getListener().get(new Form.Detail(), model, FieldHelper.getInstance().get(Model.class, "myInputText"));
		outputFile = (OutputFile) OutputText.getListener().get(new Form.Detail(), model, FieldHelper.getInstance().get(Model.class, "myInputFile"));
		
		
	}
	
	public void submit(){
		//System.out.println("InputsPage.submit() InputText = "+inputText+" , InputPassword = "+inputPassword);
	}
	
	@Getter @Setter
	public static class Model {
		
		@Input private String myInputText;
		@Input private Boolean myInputBooleanButton;
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
		
		@Input @InputFile private File myInputFile;
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
