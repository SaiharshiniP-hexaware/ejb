/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statelessclient;

import com.hexa.service.Product;
import com.hexa.service.ProductRemote;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Hvuser
 */
public class ProductClient {
    public static void main(String args[])throws NamingException{
          System.out.println("client started");
        Properties props=new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("org.omg.CORBA.ORBInitialHost","localhost");
               props.setProperty("org.omg.CORBA.ORBInitialPort","3700");
       //using serailinitcontextfactory only the port is connected to jndi
               Context ctx=new InitialContext(props);
               ProductRemote ser=(ProductRemote)ctx.lookup("pbean2");
               Product prod=ser.getProduct(1009);
               if(prod!=null){
               System.out.println(prod.getPid()+" "+prod.getPname()
               +""+prod.getPrice());
    }else{
            System.out.println("No Such Product Found");
}
    
}
}