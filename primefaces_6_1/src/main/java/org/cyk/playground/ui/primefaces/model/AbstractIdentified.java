package org.cyk.playground.ui.primefaces.model;

import java.io.Serializable;
import java.util.Collection;

import org.cyk.utility.common.helper.CollectionHelper;
import org.cyk.utility.common.helper.FilterHelper;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public abstract class AbstractIdentified implements Comparable<AbstractIdentified> {

	private GlobalIdentifier globalIdentifier = new GlobalIdentifier();

	public AbstractIdentified setCode(String code) {
		globalIdentifier.setCode(code);
		return this;
	}

	public AbstractIdentified setName(String name) {
		globalIdentifier.setName(name);
		return this;
	}
	
	public AbstractIdentified setUsable(Boolean usable) {
		globalIdentifier.setUsable(usable);
		return this;
	}

	public String getCode() {
		return globalIdentifier.getCode();
	}

	public String getName() {
		return globalIdentifier.getName();
	}
	
	public Boolean getUsable() {
		return globalIdentifier.getUsable();
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	/**/
	
	@Getter @Setter
	public static class Filter<T extends AbstractIdentified> extends FilterHelper.Filter<T> implements Serializable {
		private static final long serialVersionUID = -1498269103849317057L;

		protected GlobalIdentifier.Filter globalIdentifier = new GlobalIdentifier.Filter();
		
		public Filter() {
			addCriterias(globalIdentifier);
		}
		
		public Filter(Filter<T> criterias) {
			super(criterias);
		}
		
		@Override
		public FilterHelper.Filter<T> set(String string) {
			globalIdentifier.set(string);
			return super.set(string);
		}
		
		@Override
		public FilterHelper.Filter<T> setExcluded(Collection<T> excluded) {
			FilterHelper.Filter<T> filter =  super.setExcluded(excluded);
			if(CollectionHelper.getInstance().isEmpty(excluded))
				globalIdentifier.setExcluded(null);
			else
				for(AbstractIdentified identifiable : excluded){
					if(identifiable.getGlobalIdentifier()!=null)
						//globalIdentifier.addExcluded(identifiable.getGlobalIdentifier());
						this.globalIdentifier.getCode().addExcluded(identifiable.getCode());
				}
			return filter;
		}

	}
	
	@Override
	public int compareTo(AbstractIdentified o) {
		return globalIdentifier.getName().compareTo(o.getGlobalIdentifier().getName());
	}
	
}
