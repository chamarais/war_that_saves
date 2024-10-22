package com.chamara.war_that_saves;

import com.ibm.mq.jakarta.jms.MQConnectionFactory;
import jakarta.jms.JMSException;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class Configurations {


    @Bean(name = "wmq")
    public JmsComponent wmq() throws JMSException {
        log.info("wmq is starting");
        JmsComponent wmq = new JmsComponent();
        wmq.setAsyncStartListener(true);
        wmq.setAsyncStopListener(true);
        wmq.setPassword("passw0rd");
        wmq.setUsername("app");
        wmq.setAsyncConsumer(false);
        wmq.setMaxConcurrentConsumers(100);
        wmq.setConcurrentConsumers(100);
        MQConnectionFactory mqConnectionFactory = getMqConnectionFactory();
        wmq.setConnectionFactory(mqConnectionFactory);
        return wmq;
    }

    private static MQConnectionFactory getMqConnectionFactory() throws JMSException {
        MQConnectionFactory mqConnectionFactory = new MQConnectionFactory();
        mqConnectionFactory.setTransportType(1);
        mqConnectionFactory.setHostName("192.168.18.86");
        mqConnectionFactory.setPort(1414);
        mqConnectionFactory.setQueueManager("QM1");
        mqConnectionFactory.setChannel("DEV.APP.SVRCONN");
        return mqConnectionFactory;
    }

    @Bean(name = "vendor")
    public JmsComponent vendor() throws JMSException {
        JmsComponent wmq = new JmsComponent();
        wmq.setAsyncStartListener(true);
        wmq.setAsyncStopListener(true);
        MQConnectionFactory mqConnectionFactory = getMqConnectionFactory();
        wmq.setAsyncConsumer(true);
        wmq.setConnectionFactory(mqConnectionFactory);
        wmq.setPassword("passw0rd");
        wmq.setUsername("app");
        return wmq;
    }
}
