/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecrimebureau.Web.Entity;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 *
 * @author e-Crime
 */
public class NsLookUp extends SwingWorker<String, Object> {

 JTextArea jTextArea;
 String ip;

public NsLookUp(JTextArea jTextArea,String ip){
     this.jTextArea = jTextArea;
     this.ip=ip;
}


  public  void begin() {
    
    if (!ip.isEmpty()) { 
       jTextArea.append(this.ip +"\n");
        lookup(ip);
      
    } 


  } 
  
  
  
  

  private  void lookup(String s) {

    InetAddress thisComputer;
    byte[] address;

    // get the bytes of the IP address
    try {
      thisComputer = InetAddress.getByName(s);
      address = thisComputer.getAddress();
    } catch (UnknownHostException ue) {
      System.out.println("Cannot find host " + s);
      this.jTextArea.append("Cannot find host " + s);
      return;
    }

    if (isHostname(s)) {
      // Print the IP address
      for (int i = 0; i < address.length; i++) {
        int unsignedByte = address[i] < 0 ? address[i] + 256
            : address[i];
        System.out.print(unsignedByte + ".");
        this.jTextArea.append(unsignedByte + ".");
      }
      System.out.println();
    } else { // this is an IP address
      try {
          this.jTextArea.append(InetAddress.getByName(s).toString());
        System.out.println(InetAddress.getByName(s));
      } catch (UnknownHostException e) {
        System.out.println("Could not lookup the address " + s);
        this.jTextArea.append("Could not lookup the address " + s);
      }
    }

  } // end lookup

  private static boolean isHostname(String s) {

    char[] ca = s.toCharArray();
    // if we see a character that is neither a digit nor a period
    // then s is probably a hostname
    for (int i = 0; i < ca.length; i++) {
      if (!Character.isDigit(ca[i])) {
        if (ca[i] != '.') {
          return true;
        }
      }
    }

    // Everything was either a digit or a period
    // so s looks like an IP address in dotted quad format
    return false;

  } // end isHostName
  
  
  @Override
  public String doInBackground(){
      begin();
      
      return "";
  }
  
  
    @Override
  public void done(){
      
    
  }
  

} // end javalookup


