package org.cyk.playground.ui.primefaces.model;

import org.cyk.utility.common.annotation.user.interfaces.Input;
import org.cyk.utility.common.annotation.user.interfaces.InputFile;
import org.cyk.utility.common.annotation.user.interfaces.InputText;
import org.cyk.utility.common.helper.FileHelper.File;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class AllOutputs {
	
	@Input @InputText private String outputText;

	@Input @InputFile private File outputFile1;
	@Input @InputFile private File outputFile2;
	@Input @InputFile private File outputFile3;
	@Input @InputFile private File outputFile4;
	
}
