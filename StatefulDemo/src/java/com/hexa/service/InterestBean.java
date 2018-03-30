
package com.hexa.service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful(name="ibean1",mappedName="ibean2")

public class InterestBean implements InterestRemote
{
private double amt;
private int yrs;
private float rate;
private String bname;
public static int i;
public InterestBean(){
    bname="hexa"+i;
    ++i;
    System.out.println("construct");
}
@PostConstruct 
public void myinit(){
    System.out.println("post constructor");
}
@PreDestroy
public void mydestroy(){
    System.out.println("pre destroy");
}
@PrePassivate
public void mypassivate(){
    System.out.println("pre passivate");
}
@PostActivate
public void myactivate(){
    System.out.println("post activate");
}
    @Override
    public void setData(double amt, int yrs, float rate) {
       this.amt=amt;
       this.yrs=yrs;
       this.rate=rate;
    }

    @Override
    public double calcSimple() {
         return amt*yrs*rate/100;
    }

    @Override
    public double calcCompound() {
       double ci=amt*Math.pow((1+rate/100),yrs)-amt;
       return ci;
    }

    @Override
    @Remove
    public void invalidate() {
        System.out.println("bean is yet to be removed");
    }

    @Override
    public String getBname() {
    return bname;
    }

    
 
    
}