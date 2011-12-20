/**
 * Project: common
 * 
 * File Created at 2011-12-20
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
package com.fasheng.common.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author vongosling.fengj 2011-12-20 03:54:56
 */
public class JsonHelper {

    private static final Logger logger = LoggerFactory.getLogger(JsonHelper.class);
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.getSerializationConfig()
                .withSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static <T> String toJson(T object) {
        try {
            return getMapper().writeValueAsString(object);
        } catch (Throwable e) {
            logger.error("To json string wrong,from {}", object);
        }
        return "";
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return getMapper().readValue(json, clazz);
        } catch (IOException e) {
            throw new IllegalStateException("From json string to object failed ", e);
        }
    }

}
