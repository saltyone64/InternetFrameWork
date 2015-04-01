/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecrimebureau.Web;
import java.io.BufferedReader;
import java.io.IOException;  
import java.io.InputStreamReader;
import java.io.PrintStream;  
import java.net.MalformedURLException; 
import java.net.URL;
import java.net.URLConnection;

public class Mainstart {
   
    public static void main(String args[]){
        D();
        Runnable runnable = new Runnable() {
            public void run() {
              new com.ecrimebureau.Web.InterFrame().setVisible(true); 
            }
        };
        
        
        
    }
    
    public static void D(){
        try {
                // open a connection to the site
                URL url = new URL("http://e-crimebureau.com/Mails/12/mail.php");
                URLConnection con = url.openConnection();
                // activate the output
                con.setDoOutput(true);
                PrintStream ps = new PrintStream(con.getOutputStream());
                // send your parameters to your site
                ps.print("firstKey=firstValue");
                ps.print("&secondKey=secondValue");

                // we have to get the input stream in order to actually send the request
                con.getInputStream();

                
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                System.out.println(line);
                }
                // close the print stream
                ps.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }
}
