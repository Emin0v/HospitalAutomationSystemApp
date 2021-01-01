package com.company.view;

import com.company.helper.Helper;
import com.company.inter.AppointmentDaoInter;
import com.company.inter.Context;
import com.company.inter.DoctorDaoInter;
import com.company.inter.WorkhourDaoInter;
import com.company.model.Appointment;
import com.company.model.Doctor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eminov
 */
public class DoctorGUI extends javax.swing.JFrame {

    private static Doctor doctor = null;
    DoctorDaoInter doctorDao = Context.instanceDoctorDao();
    WorkhourDaoInter workhour = Context.instanceWorkhourDao();
    AppointmentDaoInter appointDao = Context.instanceAppointmentDao();
    private DefaultTableModel whourModel;
    private Object[] whourData = null;
    private int selectPatientId = 0;
    private String selectPatientName = null;
    private DefaultTableModel appointModel = null;
    private Object[] appointData = null;

    /**
     * Creates new form DoctorGUI
     */
    public DoctorGUI(Doctor doctor) {
        DoctorGUI.doctor = doctor;
        initComponents();
        Helper.centerWindow(this);

        whourModel();
        appointModel();
        
        btndeleteEnableDisable();
        lbldoctorwel.setText(lbldoctorwel.getText() + " " + doctor.getName());
    }

    private void whourModel() {
        whourModel = new DefaultTableModel();
        Object[] colwhour = new Object[2];
        colwhour[0] = "ID";
        colwhour[1] = "Date";
        whourModel.setColumnIdentifiers(colwhour);
        whourData = new Object[2];
        for (int i = 0; i < workhour.getWorkhourList(doctor.getId()).size(); i++) {
            whourData[0] = workhour.getWorkhourList(doctor.getId()).get(i).getId();
            whourData[1] = workhour.getWorkhourList(doctor.getId()).get(i).getWorkDate();
            whourModel.addRow(whourData);
        }

        tblwhour.setModel(whourModel);

    }

    private void updateWhourModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tblwhour.getModel();
        clearModel.setRowCount(0);
        for (int i = 0; i < workhour.getWorkhourList(doctor.getId()).size(); i++) {
            whourData[0] = workhour.getWorkhourList(doctor.getId()).get(i).getId();
            whourData[1] = workhour.getWorkhourList(doctor.getId()).get(i).getWorkDate();
            whourModel.addRow(whourData);
        }
    }

    private void appointModel() {
        appointModel = new DefaultTableModel();
        Object[] colAppoint = new Object[3];
        colAppoint[0] = "ID";
        colAppoint[1] = "Patient";
        colAppoint[2] = "Date";

        appointModel.setColumnIdentifiers(colAppoint);
        appointData = new Object[3];

        for (int i = 0; i < appointDao.getDoctorList(doctor.getId()).size(); i++) {
            appointData[0] = appointDao.getDoctorList(doctor.getId()).get(i).getId();
            appointData[1] = appointDao.getDoctorList(doctor.getId()).get(i).getPatientId().getName();
            appointData[2] = appointDao.getDoctorList(doctor.getId()).get(i).getAppDate();
            appointModel.addRow(appointData);
        }

        tblmydate.setModel(appointModel);
        tblmydate.getColumnModel().getColumn(0).setPreferredWidth(3);
    }

    private void updateAppointModel(int patient_id) {
        DefaultTableModel clearModel = (DefaultTableModel) tblmydate.getModel();
        clearModel.setRowCount(0);
        for (int i = 0; i < appointDao.getDoctorList(patient_id).size(); i++) {
            appointData[0] = appointDao.getDoctorList(patient_id).get(i).getId();
            appointData[1] = appointDao.getDoctorList(patient_id).get(i).getPatientId().getName();
            appointData[2] = appointDao.getDoctorList(patient_id).get(i).getAppDate();
            appointModel.addRow(appointData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbldoctorwel = new javax.swing.JLabel();
        lblimage = new javax.swing.JLabel();
        btndoctorexit = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        selectdate = new datechooser.beans.DateChooserCombo();
        selecttime = new javax.swing.JComboBox<>();
        btnaddhour = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblwhour = new javax.swing.JTable();
        btndeletewhour = new javax.swing.JButton();
        pnlmydate = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblmydate = new javax.swing.JTable();
        btndeleteappoint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbldoctorwel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldoctorwel.setText("Welcome");
        jPanel1.add(lbldoctorwel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 21, 238, 28));

        lblimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/abc.png"))); // NOI18N
        lblimage.setText("jLabel1");
        jPanel1.add(lblimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 11, 114, -1));

        btndoctorexit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndoctorexit.setText("Exit");
        btndoctorexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoctorexitActionPerformed(evt);
            }
        });
        jPanel1.add(btndoctorexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 22, 105, 28));

        jPanel2.setBackground(new java.awt.Color(161, 185, 207));

        selectdate.setCurrentView(new datechooser.view.appearance.AppearancesList("Bordered",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));

    selecttime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", " " }));
    selecttime.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            selecttimeActionPerformed(evt);
        }
    });

    btnaddhour.setBackground(new java.awt.Color(204, 204, 204));
    btnaddhour.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    btnaddhour.setText("Add");
    btnaddhour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    btnaddhour.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnaddhourMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnaddhourMouseExited(evt);
        }
    });
    btnaddhour.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnaddhourActionPerformed(evt);
        }
    });

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
    jScrollPane1.setViewportView(tblwhour);

    btndeletewhour.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    btndeletewhour.setText("Delete");
    btndeletewhour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    btndeletewhour.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btndeletewhourActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(selectdate, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addComponent(selecttime, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnaddhour, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btndeletewhour, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(26, 26, 26)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(selectdate, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selecttime)
                    .addComponent(btndeletewhour, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaddhour, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jTabbedPane1.addTab("working hours", jPanel2);

    pnlmydate.setBackground(new java.awt.Color(161, 185, 207));

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
    jScrollPane2.setViewportView(tblmydate);

    btndeleteappoint.setText("Delete");
    btndeleteappoint.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btndeleteappointActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pnlmydateLayout = new javax.swing.GroupLayout(pnlmydate);
    pnlmydate.setLayout(pnlmydateLayout);
    pnlmydateLayout.setHorizontalGroup(
        pnlmydateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlmydateLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btndeleteappoint)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnlmydateLayout.setVerticalGroup(
        pnlmydateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmydateLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        .addGroup(pnlmydateLayout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addComponent(btndeleteappoint)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jTabbedPane1.addTab("my date", pnlmydate);

    jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, -1));

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

    private void selecttimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecttimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selecttimeActionPerformed

    private void btnaddhourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddhourActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String date = "";
        try {
//            System.out.println("date=" + selectdate.getText());
            Date dt = new SimpleDateFormat("MM/dd/yyyy").parse(selectdate.getText());
            date = sdf.format(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (date.length() == 0) {
            Helper.showMsg("please select date ");
        } else {
            String time = " " + selecttime.getSelectedItem().toString() + ":00";
            String selectDate = date + time;
            boolean control = doctorDao.addWhour(doctor.getId(), doctor.getName(), selectDate);
            if (control) {
                Helper.showMsg("success");
            } else {
                Helper.showMsg("error");
            }
            updateWhourModel();
        }

    }//GEN-LAST:event_btnaddhourActionPerformed

    private void btndeletewhourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletewhourActionPerformed
        int selectedRow = tblwhour.getSelectedRow();
        if (selectedRow >= 0) {
            String selectRow = tblwhour.getModel().getValueAt(selectedRow, 0).toString();
            int id = Integer.parseInt(selectRow);
            boolean control = doctorDao.deleteWhour(id);
            if (control) {
                Helper.showMsg("success");
                updateWhourModel();
            } else {
                Helper.showMsg("error");
            }

        } else {
            Helper.showMsg(" please select date ");
        }

    }//GEN-LAST:event_btndeletewhourActionPerformed

    private void btndoctorexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoctorexitActionPerformed
        if (Helper.confirm("do you want exit ?")) {
            LoginGUI login = new LoginGUI();
            login.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btndoctorexitActionPerformed

    private void btnaddhourMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddhourMouseEntered
        btnaddhour.setSize(btnaddhour.getWidth() + 5, btnaddhour.getHeight() + 5);
        btnaddhour.setBackground(Color.getHSBColor(102, 153, 255));

    }//GEN-LAST:event_btnaddhourMouseEntered

    private void btnaddhourMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddhourMouseExited
        btnaddhour.setSize(btnaddhour.getWidth() - 5, btnaddhour.getHeight() - 5);
        btnaddhour.setBackground(Color.getHSBColor(204, 204, 204));

    }//GEN-LAST:event_btnaddhourMouseExited

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
            int selectedId2 = selectedId;
            boolean control = appointDao.deleteAppointment(selectedId);
            if (control) {
                Helper.showMsg("success");
                updateAppointModel(doctor.getId());

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
            java.util.logging.Logger.getLogger(DoctorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DoctorGUI frame = new DoctorGUI(doctor);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddhour;
    private javax.swing.JButton btndeleteappoint;
    private javax.swing.JButton btndeletewhour;
    private javax.swing.JButton btndoctorexit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbldoctorwel;
    private javax.swing.JLabel lblimage;
    private javax.swing.JPanel pnlmydate;
    private datechooser.beans.DateChooserCombo selectdate;
    private javax.swing.JComboBox<String> selecttime;
    private javax.swing.JTable tblmydate;
    private javax.swing.JTable tblwhour;
    // End of variables declaration//GEN-END:variables
}
