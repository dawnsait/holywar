package com.fasheng.queue.receiver;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

/**
 * @author vongosling 2012-1-9 05:20:12
 */
public class MQReceiverStarter extends AbstractMQReceiverStarter {
    private static final Logger logger = LoggerFactory.getLogger(MQReceiverStarter.class);

    @Override
    protected Collection<AsyncReceiver> acquireAllReceivers() {
        Map<String, AsyncReceiver> allAsyncReceiverBeans = applicationContext
                .getBeansOfType(AsyncReceiver.class);

        logger.info("All AsyncReceiverBeans: {} will start", allAsyncReceiverBeans);

        final Collection<AsyncReceiver> asyncReceivers = allAsyncReceiverBeans.values();
        return asyncReceivers;
    }

    @Override
    protected boolean IsInterestedIn(ApplicationEvent event) {
        return satisfiedEventType(event);
    }
}
