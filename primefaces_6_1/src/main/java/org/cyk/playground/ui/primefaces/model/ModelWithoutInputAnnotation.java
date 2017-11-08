package org.cyk.playground.ui.primefaces.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class ModelWithoutInputAnnotation {
	
	private String inputText;
	private String inputTextarea;
	private String inputPassword;
	private String inputEditor;
	private Date inputCalendarDayMonthYear;
	private Date inputCalendarHourMinute;
	private Date inputCalendarDayMonthYearHourMinute;
	private Boolean inputBooleanCheckBox;
	private Boolean inputBooleanButton;
	
	private Byte inputNumberByte;
	private Short inputNumberShort;
	private Integer inputNumberInteger;
	private Long inputNumberLong;
	private Double inputNumberDouble;
	private Float inputNumberFloat;
	private BigDecimal inputNumberBigDecimal;
	
	private Country inputChoiceOneAutoComplete;
	private Country inputChoiceOneCascadeList;
	private Country inputChoiceOneCombo;
	private Country inputChoiceOneListBox;
	private Country inputChoiceOneRadio;
	private Country inputChoiceOneButton;
	
	private List<Country> inputChoiceManyAutoComplete;
	private List<Country> inputChoiceManyButton;
	private List<Country> inputChoiceManyCheck;
	private List<Country> inputChoiceManyCombo;
	private List<Country> inputChoiceManyPickList;
	private List<Country> inputChoiceManyList;
	
	private File inputFile1;
	private File inputFile2;
	private File inputFile3;
	
	/*
	@Input @InputChoice @InputOneChoice @InputOneCombo  private MyEnum enumeration;
	
	@Input @InputChoice @InputOneChoice @InputOneCombo  private Choice choice;
	*/
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
