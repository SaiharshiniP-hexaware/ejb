
package com.hexa.service;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MyInterceptor {
@AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        String mtd=ctx.getMethod().getName();
        String cls=ctx.getTarget().getClass().getSimpleName();
        System.out.println("logged"+mtd + " of class "+ cls);
        Object[] arr=ctx.getParameters();
        int pid=(int)arr[0];
        if(pid>=1001 && pid<=1003){
        Object obj=ctx.proceed();
          System.out.println("logged out "+mtd + " of class "+ cls);
          return obj;
    }
        return null;
}
}
