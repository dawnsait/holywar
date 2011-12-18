/**
 * Project: service
 * 
 * File Created at 2011-12-12
 * $Id$
 * 
 * Copyright 2011 Alibaba.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package com.fasheng.service.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author vongosling.fengj 2011-12-12 09:41:03
 */
public abstract class BaseDO<K> {

    public static final String ID           = "id";
    public static final String GMT_CREATE   = "gmtCreate";
    public static final String GMT_MODIFIED = "gmtModified";
    public static final String CREATOR      = "creator";
    public static final String MODIFIER     = "modifier";
    public static final String IS_DELETED   = "isDeleted";

    protected K                id;
    protected Date             gmtCreate    = new Date();
    protected Date             gmtModified  = new Date();
    protected String           creator      = "sys";
    protected String           modifier     = "sys";
    protected Byte             isDeleted    = 'n';

    /**
     * @return the id
     */
    public K getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(K id) {
        this.id = id;
    }

    /**
     * @return the gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate the gmtCreate to set
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return the gmtModified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified the gmtModified to set
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return the modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * @param modifier the modifier to set
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * @return the isDeleted
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the isDeleted to set
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

}
