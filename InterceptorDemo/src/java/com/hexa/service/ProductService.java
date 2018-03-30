
package com.hexa.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;



@Stateless(name="pbean1",mappedName="pbean2")
@Interceptors({MyInterceptor.class})

public class ProductService implements ProductRemote{
private static Map<Integer,Product> map;
static {
    map=new HashMap<>();
    map.put(1001,new Product(1001,"acer",23000));
    map.put(1002,new Product(1002,"ibm",43000));
    map.put(1003,new Product(1003,"hp",33000));
}
    @Override
    public Product getProduct(int pid) {
        System.out.println("Inside get Product method");
     return  map.get(pid);   
     }
    
   
}
