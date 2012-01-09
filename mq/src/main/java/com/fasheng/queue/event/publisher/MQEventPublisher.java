package com.fasheng.queue.event.publisher;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.fasheng.queue.event.AsyncEvent;
import com.fasheng.queue.event.sender.AsyncSender;

/**
 * @author vongosling 2012-1-9 05:08:35
 */
public class MQEventPublisher implements EventPublisher {
    private static final Logger logger = LoggerFactory.getLogger(MQEventPublisher.class);
    private AsyncSender         eventSender;

    public boolean publish(AsyncEvent event) {
        boolean result = true;
        //1.delegate task to TransactionSynchronizationManager's afterCompletion method
        if (TransactionSynchronizationManager.isSynchronizationActive()) {
            TransactionSynchronizationManager
                    .registerSynchronization(new MQTransactionSynchronization(event, eventSender));
        } else {
            //2. just do it by manual processing
            logger.info("Publish event: {}", event);
            result = eventSender.send(event);
        }
        return result;
    }

    public void setEventSender(AsyncSender eventSender) {
        this.eventSender = eventSender;
    }

    private final static class MQTransactionSynchronization extends
            TransactionSynchronizationAdapter {

        private final Serializable message;

        private final AsyncSender  asyncSender;

        public MQTransactionSynchronization(Serializable message, AsyncSender sender) {
            this.message = message;
            this.asyncSender = sender;
        }

        @Override
        public void afterCompletion(int status) {
            boolean result = false;
            try {
                if (status == STATUS_COMMITTED) {
                    logger.info("Send message: {}", message);
                    result = this.asyncSender.send(message);
                }
            } catch (Exception e) {
                logger.error("Sending messages error using TransactionSynchronizationManager", e);
            } finally {
                if (!result) {
                    logger.error("Sending messages failed:  {}", message);
                }
            }
        }
    }
}
