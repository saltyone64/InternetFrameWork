/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecrimebureau.Web.Entity;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author e-Crime
 */
public class Ping {
    List<String> cmds;
    JTextArea jTextArea;
    public Ping(JTextArea jTextArea,List<String> cmd){
        
//         List<String> command = new ArrayList<String>();
//              command.add("ping.exe");
//              command.add("-n");
//              command.add("5");
//              command.add(IP);
              
        this.cmds = cmd;
        this.jTextArea = jTextArea;     
    }
    
    public void begin(){
       Command cmd = new Command(this.jTextArea,this.cmds);
       cmd.execute();
       
    }
}
