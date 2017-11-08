package org.cyk.playground.ui.primefaces.page;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.cyk.ui.web.primefaces.resources.page.Page;
import org.cyk.utility.common.helper.FileHelper.File;
import org.cyk.utility.common.userinterface.input.InputFile;
import org.primefaces.model.UploadedFile;

import lombok.Getter;
import lombok.Setter;

//@Named @ViewScoped 
@ManagedBean
@Getter @Setter
public class FileUploadPage extends Page implements Serializable {

	private static final long serialVersionUID = 1L;

	private InputFile inputFile;
	private UploadedFile file;
	
	@Override
	protected void initialisation() {
		super.initialisation();

		inputFile = new InputFile().setField(new Model(), "myInputFile");
	}
	
	public void submit(){
		//System.out.println("InputsPage.submit() InputText = "+inputText+" , InputPassword = "+inputPassword);
		System.out.println("FileUploadPage.submit() : "+file.getFileName());
	}
	
	@Getter @Setter
	public static class Model {
		
		private File myInputFile;
	}
	
}
