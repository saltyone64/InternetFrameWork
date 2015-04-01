/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecrimebureau.Web;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author e-Crime
 */
public class FileChooser {
  
    
    public static File fileChoosers(int mode){
         JFileChooser fileopen = new JFileChooser();
         fileopen.setFileSelectionMode(mode);
          //FileFilter filter = new FileNameExtensionFilter("c files", "c");
         // fileopen.addChoosableFileFilter(filter);
         // fileopen.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
          File file=null; //the returned selected files
                  
          int ret = fileopen.showDialog(null, "Select file");

          if (ret == JFileChooser.APPROVE_OPTION) {
             file = fileopen.getSelectedFile();
            System.out.println(file);
            }
          return file;
      }
}
