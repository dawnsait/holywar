package com.fasheng.common.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.MDC;

/**
 * @author von gosling 2012-1-9 03:17:09
 */
public class TraceUtils {

    public static final String TRACE_ID_KEY    = "traceId";
    public static final int    TRACE_ID_LENGTH = 8;

    /**
     * 开始Trace,生成本次Trace的ID,并放入MDC.
     */
    public static void beginTrace() {
        String traceId = RandomStringUtils.randomAlphanumeric(TRACE_ID_LENGTH);
        MDC.put(TRACE_ID_KEY, traceId);
    }

    /**
     * 开始Trace, 将traceId放入MDC.
     */
    public static void beginTrace(String traceId) {
        MDC.put(TRACE_ID_KEY, traceId);
    }

    /**
     * 结束一次Trace. 清除traceId.
     */
    public static void endTrace() {
        MDC.remove(TRACE_ID_KEY);
    }
}
