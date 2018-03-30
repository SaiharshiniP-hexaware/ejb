package statelessclient;

import com.hexa.service.InterestSerRemote;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StatelessClient {
    
    public static void main(String[] args) throws NamingException {
        
        System.out.println("client started");
        Properties props=new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("org.omg.CORBA.ORBInitialHost","172.25.207.118");
               props.setProperty("org.omg.CORBA.ORBInitialPort","3700");
       //using serailinitcontextfactory only the port is connected to jndi
               Context ctx=new InitialContext(props);
               InterestSerRemote ser=(InterestSerRemote)ctx.lookup("interestbean2");
            
               double si=ser.calcSimple(5000,2,2.5f);
               System.out.println("simple int"+si);
               double ci=ser.calcCompound(5000,2,2.5f);
               System.out.println("compound interest"+ci);
    }
                      
    
}
