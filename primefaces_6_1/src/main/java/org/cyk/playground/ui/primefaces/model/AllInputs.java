package org.cyk.playground.ui.primefaces.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.cyk.utility.common.annotation.user.interfaces.Input;
import org.cyk.utility.common.annotation.user.interfaces.InputManyAutoComplete;
import org.cyk.utility.common.annotation.user.interfaces.InputOneAutoComplete;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class AllInputs {
	/*
	@Input @InputText private String inputText;
	
	@Input @InputTextarea private String inputTextarea;
	
	@Input @InputPassword private String inputPassword;
	
	@Input @InputEditor private String inputEditor;
	*/
	/*
	@Input @InputCalendar(format=Format.DATE_SHORT) private Date inputCalendarDayMonthYear;
	
	@Input @InputCalendar(format=Format.TIME) private Date inputCalendarHourMinute;
	
	@Input @InputCalendar(format=Format.DATETIME_SHORT) private Date inputCalendarDayMonthYearHourMinute;
	*/
	/*
	@Input @InputBooleanCheck private Boolean inputBooleanCheckBox;
	
	@Input @InputBooleanButton private Boolean inputBooleanButton;
	*/
	/*
	@Input @InputNumber private Byte inputNumberByte;
	@Input @InputNumber private Short inputNumberShort;
	@Input @InputNumber private Integer inputNumberInteger;
	@Input @InputNumber private Long inputNumberLong;
	@Input @InputNumber private Double inputNumberDouble;
	@Input @InputNumber private Float inputNumberFloat;
	@Input @InputNumber private BigDecimal inputNumberBigDecimal;
	*/
	/*
	*/@Input @InputOneAutoComplete private Country inputChoiceOneAutoComplete;
	/*@Input @InputOneCascadeList private Country inputChoiceOneCascadeList;
	@Input @InputOneCombo private Country inputChoiceOneCombo;
	@Input @InputOneList private Country inputChoiceOneListBox;
	@Input @InputOneRadio private Country inputChoiceOneRadio;
	@Input @InputOneButton private Country inputChoiceOneButton;
	*/
	
	@Input @InputManyAutoComplete private List<Country> inputChoiceManyAutoComplete;
	/*@Input @InputManyButton private List<Country> inputChoiceManyButton;
	@Input @InputManyCheck private List<Country> inputChoiceManyCheck;
	@Input @InputManyCombo private List<Country> inputChoiceManyCombo;
	@Input @InputManyPickList private List<Country> inputChoiceManyPickList;
	@Input @InputManyList private List<Country> inputChoiceManyList;
	*/
	/*
	@Input @InputFile private File inputFile;
	*/
	/*
	@Input @InputChoice @InputOneChoice @InputOneCombo  private MyEnum enumeration;
	
	@Input @InputChoice @InputOneChoice @InputOneCombo  private Choice choice;
	*/
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
