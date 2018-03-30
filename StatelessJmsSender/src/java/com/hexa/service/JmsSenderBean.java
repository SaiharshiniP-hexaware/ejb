package com.hexa.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless(name="jbean1",mappedName="jbean2")

public class JmsSenderBean implements JmsSendRemote{
@Resource(mappedName="java:comp/DefaultJMSConnectionFactory")
private ConnectionFactory cf;
@Resource(mappedName="myqueue")
private Queue que;
    @Override
    public String sendMsg(String msg) {
        try{
        Connection con = cf.createConnection();
            Session ses=con.createSession();
            MessageProducer prod=ses.createProducer(que);
            TextMessage tm = ses.createTextMessage(msg);
            prod.send(tm);
            ses.close();
            con.close();
        return "your message is produced at the queue";
        }catch(Exception e ) {
            System.out.println(e.getMessage());
        return "Your message is not produced at the queue";
    }
    }

    @Override
    public String sendMsg2(Emp emp){ //(int eid, String ename) 
    try{
        Connection con = cf.createConnection();
            Session ses=con.createSession();
            MessageProducer prod=ses.createProducer(que);
            //Emp emp=new Emp();
            //emp.setEid(eid);
            //emp.setEname(ename);
            //ObjectMessage mm = ses.createObjectMessage(emp);
            //prod.send(mm);
            ses.close();
            con.close();
        return "your message is produced at the queue";
        }catch(Exception e ) {
            System.out.println(e.getMessage());
        return "Your message is not produced at the queue";
    }
    }

  
}
