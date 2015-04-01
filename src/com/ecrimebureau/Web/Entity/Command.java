/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecrimebureau.Web.Entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 *
 * @author e-Crime
 */
public class Command  extends SwingWorker<String, Object>{
        JTextArea jTA;
        List<String> command;
     List<String> output = new ArrayList<String>();
     
        public  Command(JTextArea jTextArea,List<String> command){
          this.jTA = jTextArea;
          this.command = command;

        }
        
        public Command(List<String> command){
          this.command = command;
          this.jTA = new JTextArea();//create a dummy textarea since we dont need it
        }
     
    
        
        @Override
       public String doInBackground() throws IOException {
           
           List<String> result = new ArrayList<>();
          
           
           String s = null;
              

              ProcessBuilder pb = new ProcessBuilder(command);
              pb.directory(new File("Tools"));
              Process process = pb.start();

              BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
              BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

              // read the output from the command
              System.out.println("Here is the standard output of the command:\n");
              while ((s = stdInput.readLine()) != null)
              {
                  jTA.append(s+"\n");
                System.out.println(s);
              }

              // read any errors from the attempted command
              System.out.println("Here is the standard error of the command (if any):\n");
              while ((s = stdError.readLine()) != null)
              {
                   jTA.append(s+"\n");
                   System.out.println(s);
                 
              }
        
           
           
           return "";
       }
       
       
       
       
       
        @Override
       protected void done() {
           
           }
       }
   
    

