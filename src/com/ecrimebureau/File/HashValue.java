/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecrimebureau.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException; //

/**
 *
 * @author e-Crime
 */
public class HashValue {
    
    
       public static String getChecksum(File file, String algo) throws Exception {  
      byte[] b = createChecksum(file, algo);  
      String result = "";  
      for (int i=0; i < b.length; i++) {  
           result +=  
                     Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );  
      }  
      return result;  
 }  
     
     
      private static byte[] createChecksum(File file, String algo) throws Exception{  
                InputStream fis = new FileInputStream(file);  
                byte[] buffer = new byte[1024];  
                MessageDigest complete = MessageDigest.getInstance(algo); //One of the following "SHA-1", "SHA-256", "SHA-384", and "SHA-512"  
                int numRead;  
                do {  
                     numRead = fis.read(buffer);  
                     if (numRead > 0) {  
                          complete.update(buffer, 0, numRead);  
                     }  
                } while (numRead != -1);  
                fis.close();  
                return complete.digest();  
 }  
      
      
      
      public static String getChecksum(String plaintext,String algo) throws NoSuchAlgorithmException {
          
          MessageDigest complete = MessageDigest.getInstance(algo);
          complete.update(plaintext.getBytes());
        
        
        
          byte[] b = complete.digest();
                    String result = "";  
                for (int i=0; i < b.length; i++) {  
                     result +=  
                               Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );  
                }  
                return result;  

      }
     
      
}
