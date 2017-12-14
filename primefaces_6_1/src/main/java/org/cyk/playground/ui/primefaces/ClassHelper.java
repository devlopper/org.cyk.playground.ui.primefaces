package org.cyk.playground.ui.primefaces;

import java.io.Serializable;

import org.cyk.playground.ui.primefaces.model.AbstractIdentifiedTree;

public class ClassHelper implements Serializable {
	private static final long serialVersionUID = 1L;

	public static class Listener extends org.cyk.utility.common.helper.ClassHelper.Listener.Adapter.Default{
    	private static final long serialVersionUID = 1L;
		
    	@Override
    	public String getIdentifierFieldName(Class<?> aClass) {
    		return "globalIdentifier.code";
    	}
    	
    	@Override
    	public Boolean isHierarchy(Class<?> aClass) {
    		return org.cyk.utility.common.helper.ClassHelper.getInstance().isInstanceOf(AbstractIdentifiedTree.class, aClass);
    	}
    	
    	/*@Override
    	public Boolean isIdentified(Class<?> aClass) {
    		return org.cyk.utility.common.helper.ClassHelper.getInstance().isInstanceOf(AbstractIdentified.class, aClass);
    	}*/
    	
    }
	
	
}
