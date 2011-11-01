/**
 * Project: test
 *
 * File Created at 2011-11-1
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
package com.holywar;

/**
 * @author vongosling.fengj 2011-11-1 ÉÏÎç10:18:49
 */
public interface ExceptionHandler {

    void handle(String contextCode, String errorCode, String errorMsg, Throwable t);

    void raise(String contextCode, String errorCode, String errorMsg);
}
