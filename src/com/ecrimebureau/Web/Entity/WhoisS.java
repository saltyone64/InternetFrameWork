/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecrimebureau.Web.Entity;

import java.io.IOException;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import org.apache.commons.net.whois.WhoisClient;
/**
 *
 * @author e-Crime
 */
public class WhoisS extends SwingWorker<String, Object>{
    
    private static Pattern pattern;
	private Matcher matcher;
        private String domainName;
        private JTextArea jTextArea;
        
        public  WhoisS(JTextArea jTextArea,String domainName){
            this.domainName = domainName;
            this.jTextArea = jTextArea;
        }
        
        
	// regex whois parser
	private static final String WHOIS_SERVER_PATTERN = "Whois Server:\\s(.*)";
	static {
		pattern = Pattern.compile(WHOIS_SERVER_PATTERN);
	}
 
	private  String begin() {
            String result;
 
		
                result=getWhois(this.domainName);
		System.out.println(result);
 
		System.out.println("Done");
 
                return result;
	}
 
	// example google.com
	public String getWhois(String domainName) {
 
		StringBuilder result = new StringBuilder("");
 
		WhoisClient whois = new WhoisClient();
		try {
 
		  whois.connect(WhoisClient.DEFAULT_HOST);
 
		  // whois =google.com
		  String whoisData1 = whois.query("=" + domainName);
 
		  // append first result
		  result.append(whoisData1);
		  whois.disconnect();
 
		  // get the google.com whois server - whois.markmonitor.com
		  String whoisServerUrl = getWhoisServer(whoisData1);
		  if (!whoisServerUrl.equals("")) {
 
			// whois -h whois.markmonitor.com google.com
			String whoisData2 = 
                            queryWithWhoisServer(domainName, whoisServerUrl);
 
			// append 2nd result
			result.append(whoisData2);
		  }
 
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		return result.toString();
 
	}
 
	private String queryWithWhoisServer(String domainName, String whoisServer) {
 
		String result = "";
		WhoisClient whois = new WhoisClient();
		try {
 
			whois.connect(whoisServer);
			result = whois.query(domainName);
			whois.disconnect();
 
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		return result;
 
	}
 
	private String getWhoisServer(String whois) {
 
		String result = "";
 
		matcher = pattern.matcher(whois);
 
		// get last whois server
		while (matcher.find()) {
			result = matcher.group(1);
		}
		return result;
	}
    
        
        @Override
        public String doInBackground(){
            return begin();
        }
        
        @Override
        public void done(){
             try {
              jTextArea.setText(get());
           } catch (Exception ignore) {
           }
        }

}
    
    


