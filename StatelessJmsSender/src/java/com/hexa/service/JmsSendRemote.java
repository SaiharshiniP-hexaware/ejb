package com.hexa.service;

import javax.ejb.Remote;

@Remote
public interface JmsSendRemote {
    public String sendMsg(String msg);
    //public String sendMsg2(int eid,String ename);
    public String sendMsg2(Emp emp);
}
