/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecrimebureau.Web;

//import javax.swing.ImageIcon;

import com.ecrimebureau.Web.Entity.Command;
import java.io.File;
import java.util.ArrayList;
import java.util.List;





/**
 *
 * @author e-Crime
 */
public class InterFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public InterFrame() {
        initComponents();
        
         //ImageIcon ic = new ImageIcon(getClass().getResource("image/6adc_logo.png"));
         //jLabel1.setIcon(ic);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jButton4 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel5 = new javax.swing.JPanel();
        jBping = new javax.swing.JButton();
        jBwhois = new javax.swing.JButton();
        jBtraceRoute = new javax.swing.JButton();
        jBdsnRecords = new javax.swing.JButton();
        jBNSLookUp = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jBtnPrefetch = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("InterFrame By Philemon Hini");

        jSplitPane1.setDividerLocation(200);

        jPanel5.setLayout(new java.awt.GridLayout(6, 0));

        jBping.setText("Ping");
        jBping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpingActionPerformed(evt);
            }
        });
        jPanel5.add(jBping);

        jBwhois.setText("Whois");
        jBwhois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBwhoisActionPerformed(evt);
            }
        });
        jPanel5.add(jBwhois);

        jBtraceRoute.setText("TraceRoute");
        jBtraceRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtraceRouteActionPerformed(evt);
            }
        });
        jPanel5.add(jBtraceRoute);

        jBdsnRecords.setText("DNS Records");
        jBdsnRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBdsnRecordsActionPerformed(evt);
            }
        });
        jPanel5.add(jBdsnRecords);

        jBNSLookUp.setText("Network Lookup");
        jBNSLookUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNSLookUpActionPerformed(evt);
            }
        });
        jPanel5.add(jBNSLookUp);

        jButton7.setText("Spam Blacklist Check");
        jPanel5.add(jButton7);

        jSplitPane1.setLeftComponent(jPanel5);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jDesktopPane1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        jTabbedPane1.addTab("Probe Tools", jPanel4);

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jSplitPane2.setDividerLocation(200);

        jPanel7.setLayout(new java.awt.GridLayout(6, 1));

        jButton1.setText("Hash");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1);

        jBtnPrefetch.setText("Prefetch Info");
        jBtnPrefetch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPrefetchActionPerformed(evt);
            }
        });
        jPanel7.add(jBtnPrefetch);

        jButton3.setText("Process Monitor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3);

        jButton5.setText("Process Explorer");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton5);

        jButton6.setText("jButton5");
        jPanel7.add(jButton6);

        jButton8.setText("jButton5");
        jPanel7.add(jButton8);

        jSplitPane2.setLeftComponent(jPanel7);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(jDesktopPane2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane2.addTab("tab1", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Inestigate E-mails", jPanel1);

        jMenu2.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenu2.add(jMenuItem1);

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");
        jMenu4.add(jMenu5);

        jMenu2.add(jMenu4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBNSLookUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNSLookUpActionPerformed
       JIFNSLookUp Inf = new JIFNSLookUp();
        jDesktopPane1.add(Inf);
        Inf.show();
    }//GEN-LAST:event_jBNSLookUpActionPerformed

    private void jBdsnRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBdsnRecordsActionPerformed
        JIFDNSRecord Inf = new JIFDNSRecord();
        jDesktopPane1.add(Inf);
        Inf.show();
    }//GEN-LAST:event_jBdsnRecordsActionPerformed

    private void jBtraceRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtraceRouteActionPerformed
        JIFTrace Inf = new JIFTrace();
        jDesktopPane1.add(Inf);
        Inf.show();
    }//GEN-LAST:event_jBtraceRouteActionPerformed

    private void jBwhoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBwhoisActionPerformed
        JIFWhois Inf = new JIFWhois();
        jDesktopPane1.add(Inf);
        Inf.show();
    }//GEN-LAST:event_jBwhoisActionPerformed
      
    private void jBpingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBpingActionPerformed

        JIFPing Inf = new JIFPing();
        
        jDesktopPane1.add(Inf);
       Inf.show();
        
                
    }//GEN-LAST:event_jBpingActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JIFHash jIFHash  = new JIFHash();
        jDesktopPane2.add(jIFHash);
        jIFHash.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBtnPrefetchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPrefetchActionPerformed
    JIFPrefetch jIFpf  = new JIFPrefetch();
        jDesktopPane2.add(jIFpf);
        jIFpf.show();
    }//GEN-LAST:event_jBtnPrefetchActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        List<String> cmd = new ArrayList<>();
        try{
        cmd.add("Procmon.exe");
        
      Command command = new Command(cmd);
      command.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         List<String> cmd = new ArrayList<>();
        try{
        cmd.add("Procexp.exe");
        
      Command command = new Command(cmd);
      command.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
     
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBNSLookUp;
    private javax.swing.JButton jBdsnRecords;
    private javax.swing.JButton jBping;
    private javax.swing.JButton jBtnPrefetch;
    private javax.swing.JButton jBtraceRoute;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jBwhois;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
