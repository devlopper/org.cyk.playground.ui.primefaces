package org.cyk.playground.ui.primefaces.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.cyk.utility.common.annotation.user.interfaces.Input;
import org.cyk.utility.common.annotation.user.interfaces.InputBooleanButton;
import org.cyk.utility.common.annotation.user.interfaces.InputBooleanCheck;
import org.cyk.utility.common.annotation.user.interfaces.InputCalendar;
import org.cyk.utility.common.annotation.user.interfaces.InputCalendar.Format;
import org.cyk.utility.common.annotation.user.interfaces.InputEditor;
import org.cyk.utility.common.annotation.user.interfaces.InputFile;
import org.cyk.utility.common.annotation.user.interfaces.InputManyAutoComplete;
import org.cyk.utility.common.annotation.user.interfaces.InputManyButton;
import org.cyk.utility.common.annotation.user.interfaces.InputManyCheck;
import org.cyk.utility.common.annotation.user.interfaces.InputManyCombo;
import org.cyk.utility.common.annotation.user.interfaces.InputManyList;
import org.cyk.utility.common.annotation.user.interfaces.InputManyPickList;
import org.cyk.utility.common.annotation.user.interfaces.InputNumber;
import org.cyk.utility.common.annotation.user.interfaces.InputOneAutoComplete;
import org.cyk.utility.common.annotation.user.interfaces.InputOneButton;
import org.cyk.utility.common.annotation.user.interfaces.InputOneCascadeList;
import org.cyk.utility.common.annotation.user.interfaces.InputOneCombo;
import org.cyk.utility.common.annotation.user.interfaces.InputOneList;
import org.cyk.utility.common.annotation.user.interfaces.InputOneRadio;
import org.cyk.utility.common.annotation.user.interfaces.InputPassword;
import org.cyk.utility.common.annotation.user.interfaces.InputText;
import org.cyk.utility.common.annotation.user.interfaces.InputTextarea;
import org.cyk.utility.common.helper.FileHelper.File;

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
	
	
	@Input @InputCalendar(format=Format.DATE_SHORT) private Date inputCalendarDayMonthYear;
	@Input @InputCalendar(format=Format.TIME) private Date inputCalendarHourMinute;
	@Input @InputCalendar(format=Format.DATETIME_SHORT) private Date inputCalendarDayMonthYearHourMinute;
	
	
	@Input @InputBooleanCheck private Boolean inputBooleanCheckBox;
	
	@Input @InputBooleanButton private Boolean inputBooleanButton;
	
	@Input @InputNumber private Byte inputNumberByte;
	@Input @InputNumber private Short inputNumberShort;
	@Input @InputNumber private Integer inputNumberInteger;
	@Input @InputNumber private Long inputNumberLong;
	@Input @InputNumber private Double inputNumberDouble;
	@Input @InputNumber private Float inputNumberFloat;
	@Input @InputNumber private BigDecimal inputNumberBigDecimal;
	
	@Input @InputOneAutoComplete private Country inputChoiceOneAutoComplete;
	@Input @InputOneCascadeList private Country inputChoiceOneCascadeList;
	@Input @InputOneCombo private Country inputChoiceOneCombo;
	@Input @InputOneList private Country inputChoiceOneListBox;
	@Input @InputOneRadio private Country inputChoiceOneRadio;
	@Input @InputOneButton private Country inputChoiceOneButton;
	
	@Input @InputManyAutoComplete private List<Country> inputChoiceManyAutoComplete;
	@Input @InputManyButton private List<Country> inputChoiceManyButton;
	@Input @InputManyCheck private List<Country> inputChoiceManyCheck;
	@Input @InputManyCombo private List<Country> inputChoiceManyCombo;
	@Input @InputManyPickList private List<Country> inputChoiceManyPickList;
	@Input @InputManyList private List<Country> inputChoiceManyList;
	
	*/
	@Input @InputFile private File inputFile1;
	@Input @InputFile private File inputFile2;
	@Input @InputFile private File inputFile3;
	
	/*
	@Input @InputChoice @InputOneChoice @InputOneCombo  private MyEnum enumeration;
	
	@Input @InputChoice @InputOneChoice @InputOneCombo  private Choice choice;
	*/
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
