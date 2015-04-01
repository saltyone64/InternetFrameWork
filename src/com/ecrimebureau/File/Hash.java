/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecrimebureau.File;

import com.ecrimebureau.Web.FileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.text.DecimalFormat;

import java.util.Collection;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

/**
 *
 * @author e-Crime
 */
public class Hash extends SwingWorker<String, Object>{
    JTextArea jTA;
    String algorithim;
    String path;
    JProgressBar jProgressBar;
    JInternalFrame jInternalFrame;
    boolean isDirectory=false;
    
    public Hash(JInternalFrame jInternalFrame,JTextArea jTA,String alg,JProgressBar jProgressBar){
        this.jTA = jTA;
        this.algorithim=alg;
        this.path=path;
        this.jProgressBar =jProgressBar;
        jProgressBar.setStringPainted(true);
        this.jInternalFrame = jInternalFrame;
        jProgressBar.setMinimum(0);
          
         jProgressBar.setValue(jProgressBar.getMinimum()); //
    }
      
    
 
      
     private  void gethash(){   
           
           File f = FileChooser.fileChoosers(JFileChooser.FILES_AND_DIRECTORIES);//new File(this.path);
           
           this.path = f.getAbsolutePath();
           
           if (f.isFile()){
           
                    try{  
                        jInternalFrame.setTitle("Hashing a Single File (1)"); 
                         String hash = getChecksum(path, algorithim); //or "SHA-256", "SHA-384", "SHA-512,SHA1" 
                         jTA.append(hash+" -> "+path+"\n");
                         System.out.println(hash);  
                          
                          
                    }catch(Exception e){  
                         System.out.println("An error occured. hashing -> " + path +"\n"); 
                         jTA.append("An error occured. hashing -> " + path +"\n");
                    }  
           }
           
           else if (f.isDirectory()){
                    isDirectory=true;
               
                    Collection files = FileUtils.listFiles(f,new RegexFileFilter("^(.*?)"),DirectoryFileFilter.DIRECTORY);
                    
                        int totalNumberofFiles = files.size();
                        int startprogress = 1;
                        
                        jProgressBar.setMaximum(100);
                        jInternalFrame.setTitle("Hashing " + totalNumberofFiles + " Files");  
                
                   for(Object i: files.toArray(new File[]{})){
                                 try{  
                                     String hash = getChecksum(i.toString(), algorithim); //or "SHA-256", "SHA-384", "SHA-512,SHA1"  
                                     System.out.println(hash+" -> "+i.toString()+"\n"); 
                                     jTA.append(hash+" -> "+i.toString()+"\n");
                                     
                                     //for the progress bar
                                     int percentageCompleted =(int)Math.round(startprogress * 100.0/totalNumberofFiles);
                                      
                                     jProgressBar.setValue(percentageCompleted); //set the progress bar value
                                                                
                                     jProgressBar.setString(String.valueOf(percentageCompleted)+"%");//the display string
                                     startprogress++; //increase the value
                                     //end progress bar
                                     
                         }catch(Exception e){  
                              System.out.println("An error occured. hashing -> " + i.toString() +"\n"); 
                                jTA.append("An error occured. hashing -> " + i.toString() +"\n");
                         }  
                    }
           }
      }  
     
     
   private  String getChecksum(String filename, String algo) throws Exception {
       System.out.println("File size =" + new File(filename).length());
       byte[] b = createChecksum(filename, algo);
       
      String result = "";  
      for (int i=0; i < b.length; i++) {  
           result +=Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
          
      }  
      return result;  
 }  
     
    
   private  byte[] createChecksum(String filename, String algo) throws Exception{  
                InputStream fis = new FileInputStream(filename);  
                byte[] buffer = new byte[1024];  
                  int percentageCompleted;
                  long totalbytes=0;
                 
                 if(isDirectory==false){
                         totalbytes =new File(filename).length();
                         jProgressBar.setMaximum(100);
                 }
              
      
                MessageDigest complete = MessageDigest.getInstance(algo); //One of the following "SHA-1", "SHA-256", "SHA-384", and "SHA-512"  
                int numRead;  
                long readbyte=0;
                do {  
                     numRead = fis.read(buffer);  
                    
                     
                     if (numRead > 0) {  
                          complete.update(buffer, 0, numRead); 
                          
                          
                           if(isDirectory==false){
                               
                               DecimalFormat df = new DecimalFormat("0.00");
                               df.setRoundingMode(RoundingMode.HALF_EVEN);
                               String a=df.format(((readbyte+=numRead) * 100.0)/(totalbytes*2));
                               percentageCompleted=(int) Math.round(Double.parseDouble(a)); 
                                   System.out.println(readbyte+=numRead);
                             
                              int pervalue=percentageCompleted;
                              if(!(pervalue>100)){
                                    jProgressBar.setValue(percentageCompleted);
                                    jProgressBar.setString(String.valueOf(percentageCompleted)+"%");
                                    
                               }else{
                               
                               jProgressBar.setValue(100);
                               jProgressBar.setString(100+"%");
                               }
//                              
                        }
                           
                           
                     }  
                } while (numRead != -1);  
                fis.close();  
                return complete.digest();  
 }  
   
   
   
      
      
      
      
      @Override
      public String doInBackground(){
          gethash();
          return "";
      }
      
       @Override
      public void done(){
          
    
      }
      
      
    
}
