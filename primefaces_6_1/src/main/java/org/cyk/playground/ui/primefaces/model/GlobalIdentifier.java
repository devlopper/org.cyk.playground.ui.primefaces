package org.cyk.playground.ui.primefaces.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.cyk.utility.common.helper.CriteriaHelper;
import org.cyk.utility.common.helper.FilterHelper;
import org.cyk.utility.common.helper.RandomHelper;
import org.cyk.utility.common.helper.StringHelper;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class GlobalIdentifier {

	private String code;
	private File image;
	private String name;
	private String description;
	private String otherDetails;
	private Period existencePeriod;
	private Location birthLocation;
	private Location deathLocation;
	private Long orderNumber;
	private Boolean usable = RandomHelper.getInstance().getBoolean();

	private Date creationDate = RandomHelper.getInstance().getDate();
	private String owner = RandomHelper.getInstance().getAlphabetic(5);
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	/**/
	
	@Getter @Setter
	public static class Filter extends FilterHelper.Filter<GlobalIdentifier> implements Serializable {
		private static final long serialVersionUID = -1498269103849317057L;

		protected CriteriaHelper.Criteria.String code,name;
		protected CriteriaHelper.Criteria.Number.Long orderNumber;
		
		public Filter(){
			code = instanciateCriteria(CriteriaHelper.Criteria.String.class).setLocation(StringHelper.Location.INSIDE);
			name=instanciateCriteria(CriteriaHelper.Criteria.String.class).setLocation(StringHelper.Location.INSIDE);
			orderNumber = instanciateCriteria(CriteriaHelper.Criteria.Number.Long.class);
		}
				
		public Filter(Filter criterias) {
			super(criterias);
		}

		@Override
		public String toString() {
			return "code = "+code+" , name = "+name+" , orderNumber = "+orderNumber;
		}
	}
}
