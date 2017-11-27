package org.cyk.playground.ui.primefaces.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.cyk.utility.common.helper.RandomHelper;

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

	private Date creationDate = RandomHelper.getInstance().getDate();
	private String owner = RandomHelper.getInstance().getAlphabetic(5);
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
