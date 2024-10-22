package com.chamara.war_that_saves;

import jakarta.jms.TextMessage;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.jms.JmsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component( "saveSMS")
public class SaveSMS implements Processor {

    @Autowired
    EmployeeRepository repo;

    @Override
    public void process(Exchange exchange) throws Exception {
        if(exchange.getMessage() instanceof JmsMessage message){
            if(message.getJmsMessage() instanceof TextMessage textMessage){
                String text = textMessage.getText();
                Employee employee = new Employee();
                employee.setName(text.split(",")[3]);
                Random rand = new Random();
                employee.setAge(rand.nextInt((80 - 30) + 1) +30);
                repo.save(employee);
            }
        }

    }
}
