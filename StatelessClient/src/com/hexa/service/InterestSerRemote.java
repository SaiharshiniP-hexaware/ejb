/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hexa.service;

import javax.ejb.Remote;

/**
 *
 * @author Hvuser
 */
@Remote //remote clients must access the interface so we annotate with remote.
public interface InterestSerRemote {
    double calcSimple(double p,int n,float rate); 
   double calcCompound(double amt,int years,float rate);
}
