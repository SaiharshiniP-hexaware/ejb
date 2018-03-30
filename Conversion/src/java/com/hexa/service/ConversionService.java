/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hexa.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 *
 * @author Hvuser
 */
@Stateless(name="conversionbean1",mappedName="conversionbean2")
public class ConversionService implements ConversionRemote {
    public ConversionService() {
        System.out.println("constructor is intialized");
    }

  
    @PostConstruct
    public void myinit(){
        System.out.println("init has started");
    }
    @Override
    public double converting(double celsiustemp) {
        double far;
        far=1.8*(celsiustemp)+32;
        return far;
    }
    @PreDestroy
    public void mydestroy() {
        System.out.println("destroy will be started");
    }
}
