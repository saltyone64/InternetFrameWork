/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecrimebureau.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author e-Crime
 */
public class Prefetch {

    JTextArea jTextArea;
    List<String> command = new ArrayList<>();

    public Prefetch(JTextArea jTextArea, File prefetchfile) {

        this.jTextArea = jTextArea;

        command.add("prefetchInfo.exe");
        command.add(prefetchfile.getAbsolutePath());
    }

    public void getInfo() {
       // File file = FileChooser.fileChoosers();

       // Command cmd = new Command(this.jTextArea, this.command);
        // cmd.execute();
        List<String> result = new ArrayList<>();
        try {

            String s = null;

            ProcessBuilder pb = new ProcessBuilder(command);
            pb.directory(new File("Tools")); //contains all the tools

            Process process = pb.start();
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                jTextArea.append(s + "\n");
                System.out.println(s);
            }

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                jTextArea.append(s + "\n");
                System.out.println(s);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
