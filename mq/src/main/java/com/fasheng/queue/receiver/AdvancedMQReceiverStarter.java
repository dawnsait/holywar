package com.fasheng.queue.receiver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

/**
 * Invoke MQ {@link com.fasheng.queue.client.AsyncReceiver#start()} after
 * specified spring application event, such as
 * {@link org.springframework.context.event.ContextRefreshedEvent} to make sure
 * all wokers can have all references prepared, expecially esb client. This
 * starter can specified {@link AsyncReceiver} those need to start.<br>
 * Host ip is a whitelist, if it's empty, those receivers will start on every
 * host. if the ip white list contains 127.0.0.1, all host can start.
 * 
 * @author von gosling 2012-1-9 05:17:44
 */
public class AdvancedMQReceiverStarter extends AbstractMQReceiverStarter {
    private static final Logger logger       = LoggerFactory
                                                     .getLogger(AdvancedMQReceiverStarter.class);
    private static String       loopbackAddr = "127.0.0.1";

    private Collection<String>  receivers;
    private Collection<String>  hostWhiteList;

    @Override
    protected Collection<AsyncReceiver> acquireAllReceivers() {
        Assert.notEmpty(receivers);

        logger.info("Receivers {} will start", receivers);

        return Collections2.transform(receivers, new Function<String, AsyncReceiver>() {
            public AsyncReceiver apply(String from) {
                return (AsyncReceiver) applicationContext.getBean(from, AsyncReceiver.class);
            }
        });
    }

    @Override
    protected boolean IsInterestedIn(ApplicationEvent event) {
        return satisfiedEventType(event) && satisfiedIpAddress();
    }

    private boolean satisfiedIpAddress() {
        String hostIp = getHostIp();

        logger.info("this host ip is  {}, host wihite list is {}", hostIp, hostWhiteList);

        boolean ipAllowed = true;
        if (!CollectionUtils.isEmpty(hostWhiteList)) {
            ipAllowed = hostWhiteList.contains(hostIp) || hostWhiteList.contains(loopbackAddr);
        }
        return ipAllowed;
    }

    private String getHostIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(Collection<String> receivers) {
        this.receivers = receivers;
    }

    public void setHostWhiteList(Collection<String> hostWhiteList) {
        this.hostWhiteList = hostWhiteList;
    }
}
