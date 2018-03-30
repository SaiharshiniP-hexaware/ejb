package com.hexa.service;
import javax.ejb.Remote;
@Remote
public interface InterestRemote {
    void setData(double amt,int yrs,float rate);
    double calcSimple();
    double calcCompound();
    void invalidate();
}
