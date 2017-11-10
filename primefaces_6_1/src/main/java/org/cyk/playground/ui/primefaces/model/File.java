package org.cyk.playground.ui.primefaces.model;

import java.util.ArrayList;
import java.util.Collection;

import org.cyk.utility.common.Constant;
import org.cyk.utility.common.helper.CollectionHelper;
import org.cyk.utility.common.helper.FileHelper;
import org.cyk.utility.common.helper.StringHelper;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class File {

	private byte[] bytes;
	private String mime,name,extension;
	
	public File() {}
	
	public File(FileHelper.File file) {
		bytes = file.getBytes();
		mime = file.getMime();
		name = file.getName();
		extension = file.getExtension();
	}
	
	@Override
	public String toString() {
		Collection<String> tokens = new ArrayList<>();
		if(StringHelper.getInstance().isNotBlank(name))
			tokens.add("name = "+name);
		if(StringHelper.getInstance().isNotBlank(extension))
			tokens.add("extension = "+extension);
		if(StringHelper.getInstance().isNotBlank(mime))
			tokens.add("mime = "+mime);
		return CollectionHelper.getInstance().isEmpty(tokens) ? super.toString() : StringHelper.getInstance().concatenate(tokens, Constant.CHARACTER_COMA);
	}
}
