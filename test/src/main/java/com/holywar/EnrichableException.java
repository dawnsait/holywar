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

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author vongosling.fengj 2011-11-1 10:21:35
 */
public class EnrichableException extends RuntimeException {

    private static final long serialVersionUID = 8516808841089584294L;

    protected List<InfoItem>  infoItems        = Lists.newArrayList();

    protected class InfoItem {
        public String errorContext = null;
        public String errorCode    = null;
        public String errorText    = null;

        public InfoItem(String contextCode, String errorCode, String errorMsg) {
            this.errorContext = contextCode;
            this.errorCode = errorCode;
            this.errorText = errorMsg;
        }
    }

    public EnrichableException(String errorContext, String errorCode, String errorMsg) {

        addInfo(errorContext, errorCode, errorMsg);
    }

    public EnrichableException(String errorContext, String errorCode, String errorMessage,
                               Throwable cause) {
        super(cause);
        addInfo(errorContext, errorCode, errorMessage);
    }

    public EnrichableException addInfo(String errorContext, String errorCode, String errorText) {

        this.infoItems.add(new InfoItem(errorContext, errorCode, errorText));
        return this;
    }

    public String getCode() {
        StringBuilder builder = new StringBuilder();

        for (int i = this.infoItems.size() - 1; i >= 0; i--) {
            InfoItem info = this.infoItems.get(i);
            builder.append('[');
            builder.append(info.errorContext);
            builder.append(':');
            builder.append(info.errorCode);
            builder.append(']');
        }

        return builder.toString();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(getCode());
        builder.append('\n');

        //append additional context information.
        for (int i = this.infoItems.size() - 1; i >= 0; i--) {
            InfoItem info = this.infoItems.get(i);
            builder.append('[');
            builder.append(info.errorContext);
            builder.append(':');
            builder.append(info.errorCode);
            builder.append(']');
            builder.append(info.errorText);
            if (i > 0)
                builder.append('\n');
        }

        //append root causes and text from this exception first.
        if (getMessage() != null) {
            builder.append('\n');
            if (getCause() == null) {
                builder.append(getMessage());
            } else if (!getMessage().equals(getCause().toString())) {
                builder.append(getMessage());
            }
        }
        appendException(builder, getCause());

        return builder.toString();
    }

    private void appendException(StringBuilder builder, Throwable throwable) {
        if (throwable == null)
            return;
        appendException(builder, throwable.getCause());
        builder.append(throwable.toString());
        builder.append('\n');
    }
}
