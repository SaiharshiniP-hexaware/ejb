/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statelessclient;

import com.hexa.service.ConversionRemote;
import com.hexa.service.InterestSerRemote;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Hvuser
 */
public class Conversion {
    public static void main(String args[]) throws NamingException{
    System.out.println("client started");
        Properties props=new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("org.omg.CORBA.ORBInitialHost","localhost");
               props.setProperty("org.omg.CORBA.ORBInitialPort","3700");
       //using serailinitcontextfactory only the port is connected to jndi
               Context ctx=new InitialContext(props);
               ConversionRemote ser=(ConversionRemote)ctx.lookup("java:global/Conversion/conversionbean1");
            
               double di = ser.converting(100);
               System.out.println(" celcius to farenheit"+di);
               
}
}