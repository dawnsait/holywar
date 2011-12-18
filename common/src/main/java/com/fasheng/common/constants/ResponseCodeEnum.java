/**
 * Project: service
 * 
 * File Created at 2011-12-15
 * $Id$
 * 
 * Copyright 2011 FashengOL Croporation Limited.
 * All rights reserved.
 *
 */
package com.fasheng.common.constants;

/**
 * TODO Comment of ResponseCodeEnum
 * 
 * @author ZY
 */
public enum ResponseCodeEnum {

    SUCCESS(1000, "OK"),
    DB_ERROR(2000, "db error");
    
    Integer code;
    String  description;
    
    /**
     * @param code
     * @param description
     */
    private ResponseCodeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
    
    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

}
