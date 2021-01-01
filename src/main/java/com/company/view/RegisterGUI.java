/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view;

import com.company.helper.Helper;
import com.company.inter.Context;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import com.company.inter.PatientDaoInter;

/**
 *
 * @author Eminov
 */
public class RegisterGUI extends javax.swing.JFrame {

    private PatientDaoInter userDao = Context.instancePatientDao();

    /**
     * Creates new form RegisterGUI
     */
    public RegisterGUI() {
        initComponents();
        Helper.centerWindow(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblusrnm = new javax.swing.JTextField();
        txtusrnm = new javax.swing.JTextField();
        lblusrnm1 = new javax.swing.JTextField();
        lblusrnm2 = new javax.swing.JTextField();
        txtnmsrnm = new javax.swing.JTextField();
        btnregister = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();
        lblusrnm3 = new javax.swing.JTextField();
        txtpassconfirm = new javax.swing.JPasswordField();
        cbshowpass = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(209, 209, 219));
        jPanel1.setMaximumSize(new java.awt.Dimension(330, 401));

        lblusrnm.setEditable(false);
        lblusrnm.setBackground(new java.awt.Color(209, 209, 219));
        lblusrnm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblusrnm.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lblusrnm.setText("         username");
        lblusrnm.setBorder(null);
        lblusrnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblusrnmActionPerformed(evt);
            }
        });

        txtusrnm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtusrnm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtusrnm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtusrnmMouseClicked(evt);
            }
        });
        txtusrnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusrnmActionPerformed(evt);
            }
        });

        lblusrnm1.setEditable(false);
        lblusrnm1.setBackground(new java.awt.Color(209, 209, 219));
        lblusrnm1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblusrnm1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lblusrnm1.setText("password");
        lblusrnm1.setBorder(null);
        lblusrnm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblusrnm1ActionPerformed(evt);
            }
        });

        lblusrnm2.setEditable(false);
        lblusrnm2.setBackground(new java.awt.Color(209, 209, 219));
        lblusrnm2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblusrnm2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lblusrnm2.setText("Name Surname");
        lblusrnm2.setBorder(null);
        lblusrnm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblusrnm2ActionPerformed(evt);
            }
        });

        txtnmsrnm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtnmsrnm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnmsrnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmsrnmActionPerformed(evt);
            }
        });

        btnregister.setBackground(new java.awt.Color(0, 51, 204));
        btnregister.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnregister.setForeground(new java.awt.Color(0, 0, 204));
        btnregister.setText("Register");
        btnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregisterActionPerformed(evt);
            }
        });

        btnback.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnback.setForeground(new java.awt.Color(0, 0, 204));
        btnback.setText("< Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        txtpass.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });

        lblusrnm3.setEditable(false);
        lblusrnm3.setBackground(new java.awt.Color(209, 209, 219));
        lblusrnm3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblusrnm3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lblusrnm3.setText("confirm password");
        lblusrnm3.setBorder(null);
        lblusrnm3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblusrnm3ActionPerformed(evt);
            }
        });

        txtpassconfirm.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpassconfirm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtpassconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassconfirmActionPerformed(evt);
            }
        });

        cbshowpass.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbshowpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbshowpassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnmsrnm, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(lblusrnm, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtusrnm, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                    .addComponent(txtpass)
                                    .addComponent(txtpassconfirm))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                .addComponent(cbshowpass))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnregister, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblusrnm3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblusrnm2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblusrnm1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblusrnm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnmsrnm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(lblusrnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtusrnm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblusrnm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbshowpass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(lblusrnm3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtpassconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnregister, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblusrnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblusrnmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblusrnmActionPerformed

    private void txtusrnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusrnmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusrnmActionPerformed

    private void lblusrnm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblusrnm1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblusrnm1ActionPerformed

    private void lblusrnm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblusrnm2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblusrnm2ActionPerformed

    private void txtnmsrnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmsrnmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmsrnmActionPerformed

    private void btnregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregisterActionPerformed
        if (txtnmsrnm.getText().length() == 0 || txtusrnm.getText().length() == 0 || txtpass.getText().length() == 0 || txtpassconfirm.getText().length() == 0) {
            Helper.showMsg("fill");
        } else {
            if (txtpass.getText().equals(txtpassconfirm.getText())) {
                boolean control = userDao.register(txtnmsrnm.getText(), txtusrnm.getText(), txtpass.getText());
                if (control) {
                    Helper.showMsg("success");
                    LoginGUI login = new LoginGUI();
                    login.setVisible(true);
                    dispose();
                } else {
                    txtpass.setText(null);
                    txtpassconfirm.setText(null);
                    txtusrnm.setForeground(Color.red);

                    //Helper.showMsg("error");
                }
            } else {
                Helper.showMsg("code verification is wrong!");
                txtpass.setText(null);
                txtpassconfirm.setText(null);
            }
        }
    }//GEN-LAST:event_btnregisterActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        LoginGUI login = new LoginGUI();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void txtusrnmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusrnmMouseClicked
        txtusrnm.setForeground(Color.black);
    }//GEN-LAST:event_txtusrnmMouseClicked

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassActionPerformed

    private void lblusrnm3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblusrnm3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblusrnm3ActionPerformed

    private void txtpassconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassconfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassconfirmActionPerformed

    private void cbshowpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbshowpassActionPerformed
        
        cbshowpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox cb = (JCheckBox) e.getSource();
                if(cb.isSelected()){
                    System.out.println("indi goster");
                    txtpass.setEchoChar((char)0);
                    txtpassconfirm.setEchoChar((char)0);
                }else{
                    System.out.println("indi gosterme");
                    txtpass.setEchoChar('*');
                    txtpassconfirm.setEchoChar('*');
                }
            }
        });
    }//GEN-LAST:event_cbshowpassActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegisterGUI frame = new RegisterGUI();
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnregister;
    private javax.swing.JCheckBox cbshowpass;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lblusrnm;
    private javax.swing.JTextField lblusrnm1;
    private javax.swing.JTextField lblusrnm2;
    private javax.swing.JTextField lblusrnm3;
    private javax.swing.JTextField txtnmsrnm;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JPasswordField txtpassconfirm;
    private javax.swing.JTextField txtusrnm;
    // End of variables declaration//GEN-END:variables
}