
package com.hexa.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;


@MessageDriven(mappedName="mbean1",activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "myqueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MdbDemo1 implements MessageListener {
    
    public MdbDemo1() {
    }
    
    @Override
    public void onMessage(Message message) {
       
        try {
            if(message instanceof TextMessage){
           TextMessage tm=(TextMessage)message;
            System.out.println("received from the queue"+ tm.getText());
            }
            else{
                ObjectMessage om=(ObjectMessage)message;
                Emp emp=(Emp)om.getObject();
                System.out.println("received object message is"+emp.getEid()+""+emp.getEname());
                //this received message can be used for furthur processing like storing it in database.
            }
            } catch (JMSException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
