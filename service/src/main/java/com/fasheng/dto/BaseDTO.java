package com.fasheng.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class BaseDTO implements Serializable {

	private static final long serialVersionUID = 8995346561768156845L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.DEFAULT_STYLE);
	}

}
