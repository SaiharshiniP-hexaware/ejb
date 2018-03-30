
package com.hexa.service;

import javax.ejb.Remote;

@Remote
public interface ProductRemote {
   public Product getProduct(int pid); 
}
