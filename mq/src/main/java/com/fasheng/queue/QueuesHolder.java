package com.fasheng.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;

import com.google.common.collect.MapMaker;

/**
 * @author vongosling 2012-1-9 02:33:19
 */
@ManagedResource(objectName = QueuesHolder.QUEUEHOLDER_MBEAN_NAME, description = "Queues Holder Bean")
public class QueuesHolder {
    /**
     * QueueManagerע�������.
     */
    public static final String                          QUEUEHOLDER_MBEAN_NAME = "Fasheng:type=QueueManagement,name=queueHolder";

    @SuppressWarnings("unchecked")
    private static ConcurrentMap<String, BlockingQueue> queueMap               = new MapMaker()
                                                                                       .concurrencyLevel(
                                                                                               32)
                                                                                       .makeMap();                               //��Ϣ����

    private static int                                  queueSize              = Integer.MAX_VALUE;

    /**
     * ����queueName�����Ϣ���еľ�̬����. ����Ϣ���л�������, ���Զ����д���.
     */
    @SuppressWarnings("unchecked")
    public static <T> BlockingQueue<T> getQueue(String queueName) {
        BlockingQueue<T> queue = queueMap.get(queueName);

        if (queue == null) {
            BlockingQueue<T> newQueue = new LinkedBlockingQueue<T>(queueSize);

            //���֮ǰ��Ϣ���л�������,�����¶��в�����Null.���򷵻�֮ǰ��ֵ.
            queue = queueMap.putIfAbsent(queueName, newQueue);
            if (queue == null) {
                queue = newQueue;
            }
        }
        return queue;
    }

    /**
     * ����queueName�����Ϣ������δ������Ϣ������,֧�ֻ���JMX��ѯ.
     */
    @ManagedOperation(description = "Get message count in queue")
    @ManagedOperationParameters( { @ManagedOperationParameter(name = "queueName", description = "Queue name") })
    public static int getQueueLength(String queueName) {
        return getQueue(queueName).size();
    }

    /**
     * ����ÿ�����е���󳤶�, Ĭ��ΪInteger���ֵ, ����ʱ���ı��Ѵ������е���󳤶�.
     */
    public void setQueueSize(int queueSize) {
        QueuesHolder.queueSize = queueSize; //NOSONAR
    }
}
