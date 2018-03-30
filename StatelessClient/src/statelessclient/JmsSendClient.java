package statelessclient;

import com.hexa.service.Emp;
import com.hexa.service.JmsSendRemote;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsSendClient {
    public static void main(String args[]) throws NamingException{
         
    System.out.println("client started");
        Properties props=new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("org.omg.CORBA.ORBInitialHost","localhost");
               props.setProperty("org.omg.CORBA.ORBInitialPort","3700");
       //using serailinitcontextfactory only the port is connected to jndi
               Context ctx=new InitialContext(props);
              JmsSendRemote ser=(JmsSendRemote) ctx.lookup("jbean2");
              System.out.println(ser.sendMsg("welcome harshini"));
              Emp emp=new Emp();
              emp.setEid(39793);
              emp.setEname("harshini");
              System.out.println(ser.sendMsg2(emp));
             // System.out.println(ser.sendMsg2(39793,"harshini"));
    }
}
