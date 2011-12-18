package com.fasheng.service.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author vongosling.fengj 2011-12-12 09:40:40
 */
public abstract class BaseDTO implements Serializable {

    private static final long serialVersionUID = 8995346561768156845L;

    /**
     * @see java.lang.Object#toString
     */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof BaseDTO)) {
            return false;
        }
        return new EqualsBuilder().appendSuper(super.equals(object)).isEquals();
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(208989125, 784658211).appendSuper(super.hashCode()).toHashCode();
    }

}
