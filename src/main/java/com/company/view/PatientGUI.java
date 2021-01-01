/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view;

import com.company.helper.Helper;
import com.company.helper.Item;
import com.company.inter.AppointmentDaoInter;
import com.company.inter.ClinicDaoInter;
import com.company.inter.Context;
import com.company.inter.SurgeonDaoInter;
import com.company.inter.WorkhourDaoInter;
import com.company.model.Appointment;
import com.company.model.Patient;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import com.company.inter.PatientDaoInter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Eminov
 */
public class PatientGUI extends javax.swing.JFrame {

    private PatientDaoInter patientDao = Context.instancePatientDao();
    private ClinicDaoInter clinicDao = Context.instanceClinicDao();
    private SurgeonDaoInter sdi = Context.instanceSurgeonDao();
    private WorkhourDaoInter hour = Context.instanceWorkhourDao();
    private AppointmentDaoInter appointDao = Context.instanceAppointmentDao();
    private static Patient patient = new Patient();
    private DefaultTableModel doctorModel = null;
    private Object[] doctorData = null;
    private DefaultTableModel whourModel = null;
    private Object[] whourData = null;
    private int selectDoctorId = 0;
    private String selectDoctorName = null;
    private DefaultTableModel appointModel = null;
    private Object[] appointData = null;

    /**
     * Creates new form PatientGUI
     */
    public PatientGUI(Patient patient) {
        this.patient = patient;
        initComponents();
        Helper.centerWindow(this);
        showClinic();
        doctorModel();
        whourModel();
        appointModel();
        btndeleteEnableDisable();

        lblwel.setText(lblwel.getText() + " " + patient.getName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblwel = new javax.swing.JLabel();
        btnexit = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jcrollpanedoctor = new javax.swing.JScrollPane();
        tbldoctorlist = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        cmbclinicname = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        asdfasdfasdf = new javax.swing.JScrollPane();
        tblwhour = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        btnselect = new javax.swing.JButton();
        btnaddappoint = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        asfgasgsag = new javax.swing.JScrollPane();
        tblmydate = new javax.swing.JTable();
        btndeleteappoint = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblwel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblwel.setText("Welcome");

        btnexit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(161, 185, 207));

        tbldoctorlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jcrollpanedoctor.setViewportView(tbldoctorlist);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(161, 185, 207));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField1.setText("Doctor List");
        jTextField1.setBorder(null);

        cmbclinicname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbclinicnameActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(161, 185, 207));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField2.setText("Clinic Name");
        jTextField2.setBorder(null);

        tblwhour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        asdfasdfasdf.setViewportView(tblwhour);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(161, 185, 207));
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField3.setText("  Appointment Date");
        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        btnselect.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnselect.setForeground(new java.awt.Color(51, 51, 255));
        btnselect.setText("Select");
        btnselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselectActionPerformed(evt);
            }
        });

        btnaddappoint.setBackground(new java.awt.Color(153, 153, 153));
        btnaddappoint.setText("make an appointment");
        btnaddappoint.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnaddappoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddappointActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcrollpanedoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnselect, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbclinicname, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnaddappoint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(asdfasdfasdf, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcrollpanedoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asdfasdfasdf, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbclinicname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnselect, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnaddappoint, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Appointment", jPanel2);

        jPanel3.setBackground(new java.awt.Color(161, 185, 207));

        tblmydate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        asfgasgsag.setViewportView(tblmydate);

        btndeleteappoint.setText("Delete");
        btndeleteappoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteappointActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(asfgasgsag, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndeleteappoint)
                .addGap(3, 3, 3))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(asfgasgsag, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btndeleteappoint)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("my date", jPanel3);

        jButton1.setForeground(new java.awt.Color(51, 102, 255));
        jButton1.setText("Help");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblwel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblwel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showClinic() {
        cmbclinicname.addItem("...select clinic...");
        for (int i = 0; i < clinicDao.getList().size(); i++) {
            cmbclinicname.addItem(new Item(clinicDao.getList().get(i).getId(), clinicDao.getList().get(i).getName()));

        }
    }

    private void doctorModel() {
        doctorModel = new DefaultTableModel();
        Object[] colDoctor = new Object[2];
        colDoctor[0] = "ID";
        colDoctor[1] = "Name Surname";

        doctorModel.setColumnIdentifiers(colDoctor);
        doctorData = new Object[2];

        cmbclinicname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbclinicname.getSelectedIndex() != 0) {
                    JComboBox c = (JComboBox) e.getSource();
                    Item item = (Item) c.getSelectedItem();
                    DefaultTableModel clearModel = (DefaultTableModel) tbldoctorlist.getModel();
                    clearModel.setRowCount(0);

                    for (int i = 0; i < clinicDao.getClinicDoctorList(item.getKey()).size(); i++) {
                        doctorData[0] = clinicDao.getClinicDoctorList(item.getKey()).get(i).getId();
                        doctorData[1] = clinicDao.getClinicDoctorList(item.getKey()).get(i).getName();
                        doctorModel.addRow(doctorData);
                    }
                    tbldoctorlist.getColumnModel().getColumn(0).setPreferredWidth(3);
                    tbldoctorlist.setModel(doctorModel);

                    cmbclinicname.setBackground(Color.red);
                } else {
                    DefaultTableModel clearModel = (DefaultTableModel) tbldoctorlist.getModel();
                    clearModel.setRowCount(0);
                }
            }
        });

        tbldoctorlist.setModel(doctorModel);
    }

    private void whourModel() {
        whourModel = new DefaultTableModel();
        Object[] colDoctor = new Object[2];
        colDoctor[0] = "ID";
        colDoctor[1] = "Date";

        whourModel.setColumnIdentifiers(colDoctor);
        whourData = new Object[2];

        tblwhour.setModel(whourModel);
        tblwhour.getColumnModel().getColumn(0).setPreferredWidth(3);
    }

    private void appointModel() {
        appointModel = new DefaultTableModel();
        Object[] colAppoint = new Object[3];
        colAppoint[0] = "ID";
        colAppoint[1] = "Doctor";
        colAppoint[2] = "Date";

        appointModel.setColumnIdentifiers(colAppoint);
        appointData = new Object[3];

        for (int i = 0; i < appointDao.getPatientList(patient.getId()).size(); i++) {
            appointData[0] = appointDao.getPatientList(patient.getId()).get(i).getId();
            appointData[1] = appointDao.getPatientList(patient.getId()).get(i).getDoctorId().getName();
            appointData[2] = appointDao.getPatientList(patient.getId()).get(i).getAppDate();
            appointModel.addRow(appointData);
        }

        tblmydate.setModel(appointModel);
        tblmydate.getColumnModel().getColumn(0).setPreferredWidth(3);
    }

    private void updateAppointModel(int patient_id) {
        DefaultTableModel clearModel = (DefaultTableModel) tblmydate.getModel();
        clearModel.setRowCount(0);
        for (int i = 0; i < appointDao.getPatientList(patient_id).size(); i++) {
            appointData[0] = appointDao.getPatientList(patient_id).get(i).getId();
            appointData[1] = appointDao.getPatientList(patient_id).get(i).getDoctorId().getName();
            appointData[2] = appointDao.getPatientList(patient_id).get(i).getAppDate();
            appointModel.addRow(appointData);
        }
    }

    private void updateWhourModel(int doctor_id) {
        DefaultTableModel clearModel = (DefaultTableModel) tblwhour.getModel();
        clearModel.setRowCount(0);
        for (int i = 0; i < hour.getWorkhourList(doctor_id).size(); i++) {
            whourData[0] = hour.getWorkhourList(doctor_id).get(i).getId();
            whourData[1] = hour.getWorkhourList(doctor_id).get(i).getWorkDate();

            whourModel.addRow(whourData);
        }
    }

//    private void updateDoctorModel(int id) {
//        DefaultTableModel clearModel = (DefaultTableModel) tbldoctorlist.getModel();
//        clearModel.setRowCount(0);
//
//        for (int i = 0; i < clinicDao.getClinicDoctorList(item.getKey()).size(); i++) {
//            doctorData[0] = clinicDao.getClinicDoctorList(item.getKey()).get(i).getId();
//            doctorData[1] = clinicDao.getClinicDoctorList(item.getKey()).get(i).getName();
//            doctorModel.addRow(doctorData);
//        }
//    }

    private void cmbclinicnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbclinicnameActionPerformed

    }//GEN-LAST:event_cmbclinicnameActionPerformed

    private void btnselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselectActionPerformed
        int row = tbldoctorlist.getSelectedRow();
        if (row >= 0) {
            String value = tbldoctorlist.getModel().getValueAt(row, 0).toString();
            int id = Integer.parseInt(value);
            updateWhourModel(id);
            tblwhour.setModel(whourModel);
            selectDoctorId = id;
            selectDoctorName = tbldoctorlist.getModel().getValueAt(row, 1).toString();

        } else {
            Helper.showMsg("Please select doctor from list ");
        }

    }//GEN-LAST:event_btnselectActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        if (Helper.confirm("do you want exit ?")) {
            LoginGUI login = new LoginGUI();
            login.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnexitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HelpPatientGUI frame = new HelpPatientGUI();
        frame.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnaddappointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddappointActionPerformed
        btnaddappoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblwhour.getSelectedRow();
                if (selectedRow >= 0) {
                    String date = tblwhour.getModel().getValueAt(selectedRow, 1).toString();
                    boolean control = appointDao.addAppointment(selectDoctorId, patient.getId(), date);
                    if (control) {
                        Helper.showMsg("success");
                        hour.updatePassiveWorkhourStatus(selectDoctorId, date);
                        updateWhourModel(selectDoctorId);
                        updateAppointModel(patient.getId());
                    } else {
                        Helper.showMsg("error");
                    }

                } else {
                    Helper.showMsg("please select free date ");
                }
            }
        });
    }//GEN-LAST:event_btnaddappointActionPerformed
    private void btndeleteEnableDisable() {
        btndeleteappoint.setEnabled(false);
        tblmydate.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                btndeleteappoint.setEnabled(true);
            }
        });

    }

    private void btndeleteappointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteappointActionPerformed
        int selectedRow = tblmydate.getSelectedRow();

        if (selectedRow >= 0) {
            String selectedIdStr = tblmydate.getModel().getValueAt(selectedRow, 0).toString();
            int selectedId = Integer.parseInt(selectedIdStr);
            int selectedId2=selectedId;
            boolean control = appointDao.deleteAppointment(selectedId);
            if (control) {
                Helper.showMsg("success");
                updateAppointModel(patient.getId());
                try{
                Appointment appoint = appointDao.getList(selectedId2);
                updateWhourModel(appoint.getDoctorId().getId());
                }catch(Exception ex){
                }
            } else {
                Helper.showMsg("error");
            }
        }
//        else {
//            Helper.showMsg("Please select clinic !");
//        }

    }//GEN-LAST:event_btndeleteappointActionPerformed

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
            java.util.logging.Logger.getLogger(PatientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PatientGUI frame = new PatientGUI(patient);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane asdfasdfasdf;
    private javax.swing.JScrollPane asfgasgsag;
    private javax.swing.JButton btnaddappoint;
    private javax.swing.JButton btndeleteappoint;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnselect;
    private javax.swing.JComboBox<Object> cmbclinicname;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JScrollPane jcrollpanedoctor;
    private javax.swing.JLabel lblwel;
    private javax.swing.JTable tbldoctorlist;
    private javax.swing.JTable tblmydate;
    private javax.swing.JTable tblwhour;
    // End of variables declaration//GEN-END:variables
}
