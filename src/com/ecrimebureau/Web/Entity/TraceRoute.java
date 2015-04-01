/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecrimebureau.Web.Entity;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author e-Crime
 */
public class TraceRoute extends SwingWorker<String, Object> {
    private final String domianOrIP;
    DefaultTableModel model;
    
    
    public TraceRoute(DefaultTableModel model,String domianOrIP){
        this.domianOrIP=domianOrIP;
        this.model = model;
    }
    
    
    private  List<String> get(String url) throws Exception {
            List<String> lt = new ArrayList<String>();
            for(Scanner sc = new Scanner(new URL(url).openStream()); sc.hasNext(); )
               lt.add(sc.nextLine()+'\n');

            return lt;
}
    
    
    @Override
    public String doInBackground(){
        try{
                    for(String i: get("http://api.hackertarget.com/mtr/?q="+domianOrIP.trim())){
                           System.out.println(i);
                           i =i.trim();
                          if(i.startsWith("HOST")|| i.startsWith("Start") ){ continue;}//skip the time and the header

                          String[] da = i.split(" ");

                          List<String> result = new ArrayList<String>();

                          for(String st : da){
                              if (st != null && !st.isEmpty()){
                                  result.add(st);
                              }
                          }

                           this.model.insertRow(model.getRowCount(), result.toArray(new String[result.size()]));


                    }
            
        } catch (Exception e) {
              e.printStackTrace();
        }
        return "";
    }
    
    @Override
    public void done(){
        
    }
    
}
