package com.company.view;

import com.company.helper.Helper;
import com.company.helper.Item;
import com.company.inter.ClinicDaoInter;
import com.company.inter.Context;
import com.company.inter.SurgeonDaoInter;
import com.company.model.Clinic;
import com.company.model.Surgeon;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eminov
 */
public class SurgeonGUI extends javax.swing.JFrame {

    private DefaultTableModel doctorModel = null;
    private Object[] doctorData = null;
    private JPopupMenu clinicMenu;
    private DefaultTableModel clinicModel = null;
    private Object[] clinicData = null;
    private DefaultTableModel workerModel = null;
    private Object[] workerData = null;

    static Surgeon surgeon = new Surgeon();
    SurgeonDaoInter sdi = Context.instanceSurgeonDao();
    static Clinic clinic = new Clinic();
    ClinicDaoInter cdi = Context.instanceClinicDao();

    public SurgeonGUI(Surgeon srg) throws Exception {
        initComponents();
        Helper.centerWindow(this);
        header();
        // create model
        doctorModel();
        clinicModel();
        workerModel();

        fillTxtUserId();
        updateDoctorInModel();

        //------------------
        for (int i = 0; i < sdi.getDoctorList().size(); i++) {
            selectdoctor.addItem(new Item(sdi.getDoctorList().get(i).getId(), sdi.getDoctorList().get(i).getName()));
        }

        selectdoctor.addActionListener(e -> {
            JComboBox c = (JComboBox) e.getSource();
            Item item = (Item) c.getSelectedItem();
            System.out.println(item.getKey() + " : " + item.getValue());
        });

        //--------------------
        // PopupMenu 
        selectRowClinicWithMouse();
        popupUpdateAndDeleteMenu();
        tblclinic.setComponentPopupMenu(clinicMenu);

    }

    private void header() {
        lblwel.setText(lblwel.getText() + " " + surgeon.getName() + " !");
    }

    private void selectRowClinicWithMouse() {
        tblclinic.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selectedRow = tblclinic.rowAtPoint(point);
                tblclinic.addRowSelectionInterval(selectedRow, selectedRow);
            }

        });
    }

    private void popupUpdateAndDeleteMenu() {
        clinicMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("update");
        JMenuItem deleteMenu = new JMenuItem("delete");
        clinicMenu.add(updateMenu);
        clinicMenu.add(deleteMenu);

        updateMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectId = Integer.parseInt(tblclinic.getValueAt(tblclinic.getSelectedRow(), 0).toString());
                try {
                    Clinic selectClinic = cdi.getFetch(selectId);
                    UpdateClinicGUI updateGUI = new UpdateClinicGUI(selectClinic);
                    updateGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    updateGUI.setVisible(true);

                    updateGUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            try {
                                updateClinicModel();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    });

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.confirm("sure")) {
                    int selectId = Integer.parseInt(tblclinic.getValueAt(tblclinic.getSelectedRow(), 0).toString());
                    try {
                        if (cdi.deleteClinic(selectId)) {
                            Helper.showMsg("success");
                            updateClinicModel();
                        } else {
                            Helper.showMsg("error");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    private void fillTxtUserId() {
        tbldoctormngr.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    txtuserid.setText(tbldoctormngr.getValueAt(tbldoctormngr.getSelectedRow(), 0).toString());
                } catch (Exception ex) {

                }
            }
        });
    }

    private void updateDoctorInModel() {
        tbldoctormngr.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int selectId = Integer.parseInt(tbldoctormngr.getValueAt(tbldoctormngr.getSelectedRow(), 0).toString());
                    String selectName = tbldoctormngr.getValueAt(tbldoctormngr.getSelectedRow(), 1).toString();
                    String selectUsername = tbldoctormngr.getValueAt(tbldoctormngr.getSelectedRow(), 2).toString();
                    String selectPassword = tbldoctormngr.getValueAt(tbldoctormngr.getSelectedRow(), 3).toString();

                    boolean control = sdi.updateDoctor(selectId, selectUsername, selectPassword, selectName);
                    if (control) {
                        Helper.showMsg("success");
                    }
                }
            }
        });
    }

    private void workerModel() throws Exception {
        workerModel = new DefaultTableModel();
        Object[] colWorkModel = new Object[2];
        colWorkModel[0] = "ID";
        colWorkModel[1] = "Name";
        workerModel.setColumnIdentifiers(colWorkModel);

        workerData = new Object[2];

    }

    private void clinicModel() throws Exception {
        clinicModel = new DefaultTableModel();
        Object[] colClinicModel = new Object[2];
        colClinicModel[0] = "ID";
        colClinicModel[1] = "Name";
        clinicModel.setColumnIdentifiers(colClinicModel);

        clinicData = new Object[4];
        for (int i = 0; i < cdi.getList().size(); i++) {
            clinicData[0] = cdi.getList().get(i).getId();
            clinicData[1] = cdi.getList().get(i).getName();

            clinicModel.addRow(clinicData);
        }
        tblclinic.setModel(clinicModel);
    }

    private void doctorModel() throws SQLException {
        doctorModel = new DefaultTableModel();
        Object[] colDoctorName = new Object[4];
        colDoctorName[0] = "ID";
        colDoctorName[1] = "Name Surname";
        colDoctorName[2] = "Username";
        colDoctorName[3] = "Password";
        doctorModel.setColumnIdentifiers(colDoctorName);
        doctorData = new Object[4];

        for (int i = 0; i < sdi.getDoctorList().size(); i++) {
            doctorData[0] = sdi.getDoctorList().get(i).getId();
            doctorData[1] = sdi.getDoctorList().get(i).getName();
            doctorData[2] = sdi.getDoctorList().get(i).getUsername();
            doctorData[3] = sdi.getDoctorList().get(i).getPassword();
            doctorModel.addRow(doctorData);
        }

        tbldoctormngr.setModel(doctorModel);
    }

    private void updateDoctorModel() throws SQLException {
        DefaultTableModel clearModel = (DefaultTableModel) tbldoctormngr.getModel();
        clearModel.setRowCount(0);
        for (int i = 0; i < sdi.getDoctorList().size(); i++) {
            doctorData[0] = sdi.getDoctorList().get(i).getId();
            doctorData[1] = sdi.getDoctorList().get(i).getName();
            doctorData[2] = sdi.getDoctorList().get(i).getUsername();
            doctorData[3] = sdi.getDoctorList().get(i).getPassword();
            doctorModel.addRow(doctorData);
        }

    }

    public void updateClinicModel() throws Exception {
        DefaultTableModel clearModel = (DefaultTableModel) tblclinic.getModel();
        clearModel.setRowCount(0);
        for (int i = 0; i < cdi.getList().size(); i++) {
            clinicData[0] = cdi.getList().get(i).getId();
            clinicData[1] = cdi.getList().get(i).getName();
            clinicModel.addRow(clinicData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlsurgeon = new javax.swing.JPanel();
        lblwel = new javax.swing.JLabel();
        btnexit = new javax.swing.JButton();
        pnlclinic = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        txtnmsrnm = new javax.swing.JTextField();
        lblusrnm = new javax.swing.JTextField();
        txtusrnm = new javax.swing.JTextField();
        lblpass = new javax.swing.JTextField();
        txtpass = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        lblpass1 = new javax.swing.JTextField();
        txtuserid = new javax.swing.JTextField();
        btndelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        scrpanedoctor = new javax.swing.JScrollPane();
        tbldoctormngr = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        scrllpaneclinic = new javax.swing.JScrollPane();
        tblclinic = new javax.swing.JTable();
        txtclinicname = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        btnclinicadd = new javax.swing.JButton();
        scpaneworker = new javax.swing.JScrollPane();
        tblworker = new javax.swing.JTable();
        selectdoctor = new javax.swing.JComboBox<>();
        btnaddworker = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        btnselectclinic = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        pnlsurgeon.setBackground(new java.awt.Color(255, 255, 255));
        pnlsurgeon.setPreferredSize(new java.awt.Dimension(700, 500));

        lblwel.setBackground(new java.awt.Color(255, 255, 255));
        lblwel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblwel.setText("Welcome");

        btnexit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(128, 143, 174));

        jTextField1.setBackground(new java.awt.Color(128, 143, 174));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1.setText("       name   surname");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        lblusrnm.setBackground(new java.awt.Color(128, 143, 174));
        lblusrnm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblusrnm.setText("         username");
        lblusrnm.setBorder(null);
        lblusrnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblusrnmActionPerformed(evt);
            }
        });

        lblpass.setBackground(new java.awt.Color(128, 143, 174));
        lblpass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass.setText("         password");
        lblpass.setBorder(null);
        lblpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblpassActionPerformed(evt);
            }
        });

        btnadd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        lblpass1.setBackground(new java.awt.Color(128, 143, 174));
        lblpass1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass1.setText("         User :  Id");
        lblpass1.setBorder(null);
        lblpass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblpass1ActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        tbldoctormngr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        scrpanedoctor.setViewportView(tbldoctormngr);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrpanedoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnmsrnm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblusrnm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btndelete)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblpass1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtuserid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtusrnm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnmsrnm, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblusrnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtusrnm, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btnadd)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblpass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtuserid, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btndelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrpanedoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlclinic.addTab("doctor manager", jPanel1);

        jPanel2.setBackground(new java.awt.Color(128, 143, 178));

        tblclinic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrllpaneclinic.setViewportView(tblclinic);

        jTextField2.setBackground(new java.awt.Color(128, 143, 178));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField2.setText("Clinic Name");
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        btnclinicadd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnclinicadd.setText("Add");
        btnclinicadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclinicaddActionPerformed(evt);
            }
        });

        scpaneworker.setBackground(new java.awt.Color(204, 204, 255));

        tblworker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scpaneworker.setViewportView(tblworker);

        selectdoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectdoctorActionPerformed(evt);
            }
        });

        btnaddworker.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnaddworker.setText("Add");
        btnaddworker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddworkerActionPerformed(evt);
            }
        });

        jTextField3.setBackground(new java.awt.Color(128, 143, 178));
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField3.setText("Clinic Name :");
        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        btnselectclinic.setBackground(new java.awt.Color(204, 204, 255));
        btnselectclinic.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnselectclinic.setForeground(new java.awt.Color(0, 102, 255));
        btnselectclinic.setText("Select");
        btnselectclinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselectclinicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrllpaneclinic, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtclinicname)
                                        .addComponent(btnclinicadd, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectdoctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnaddworker, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                                    .addComponent(btnselectclinic, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpaneworker, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtclinicname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnclinicadd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnselectclinic, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectdoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnaddworker, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrllpaneclinic, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(scpaneworker, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pnlclinic.addTab("clinic", jPanel2);

        javax.swing.GroupLayout pnlsurgeonLayout = new javax.swing.GroupLayout(pnlsurgeon);
        pnlsurgeon.setLayout(pnlsurgeonLayout);
        pnlsurgeonLayout.setHorizontalGroup(
            pnlsurgeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlsurgeonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlsurgeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlclinic)
                    .addGroup(pnlsurgeonLayout.createSequentialGroup()
                        .addComponent(lblwel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlsurgeonLayout.setVerticalGroup(
            pnlsurgeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlsurgeonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlsurgeonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblwel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(pnlclinic, javax.swing.GroupLayout.PREFERRED_SIZE, 424, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlsurgeon, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlsurgeon, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void lblusrnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblusrnmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblusrnmActionPerformed

    private void lblpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblpassActionPerformed

    private void lblpass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblpass1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblpass1ActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        if (txtnmsrnm.getText().length() == 0 || txtusrnm.getText().length() == 0 || txtpass.getText().length() == 0) {
            Helper.showMsg("fill");
        } else {
            try {
                boolean control = sdi.addDoctor(txtusrnm.getText(), txtpass.getText(), txtnmsrnm.getText());
                if (control) {
                    Helper.showMsg("success");
                    txtnmsrnm.setText(null);
                    txtusrnm.setText(null);
                    txtpass.setText(null);
                    updateDoctorModel();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnaddActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        if (txtuserid.getText().length() == 0) {
            Helper.showMsg("select a doctor");
        } else {
            if (Helper.confirm("sure")) {
                int selectId = Integer.parseInt(txtuserid.getText());
                try {
                    boolean control = sdi.deleteDoctor(selectId);
                    if (control) {
                        Helper.showMsg("success");
                        txtuserid.setText(null);
                        updateDoctorModel();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_btndeleteActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void btnclinicaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclinicaddActionPerformed
        if (txtclinicname.getText().length() == 0) {
            Helper.showMsg("fill");
        } else {
            try {
                if (cdi.addClinic(txtclinicname.getText())) {
                    Helper.showMsg("success");
                    txtclinicname.setText(null);
                    updateClinicModel();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnclinicaddActionPerformed

    private void btnaddworkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddworkerActionPerformed

        int selectedRow = tblclinic.getSelectedRow();
        if (selectedRow >= 0) {
            String selectRowIdStr = tblclinic.getModel().getValueAt(selectedRow, 0).toString();
            Integer selectRowId = Integer.parseInt(selectRowIdStr);
            Item doctorItem = (Item) selectdoctor.getSelectedItem();
            boolean control = sdi.addWorker(doctorItem.getKey(), selectRowId);

            if (control) {
                Helper.showMsg("success");
                DefaultTableModel clearModel = (DefaultTableModel) tblworker.getModel();
                clearModel.setRowCount(0);

                for (int i = 0; i < sdi.getClinicDoctorList(selectRowId).size(); i++) {
                    workerData[0] = sdi.getClinicDoctorList(selectRowId).get(i).getId();
                    workerData[1] = sdi.getClinicDoctorList(selectRowId).get(i).getName();
                    workerModel.addRow(workerData);
                }

                tblworker.setModel(workerModel);
            } else {
                Helper.showMsg("error");
            }

        } else {
            Helper.showMsg("Please select clinic !");
        }


    }//GEN-LAST:event_btnaddworkerActionPerformed

    private void selectdoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectdoctorActionPerformed


    }//GEN-LAST:event_selectdoctorActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btnselectclinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselectclinicActionPerformed
        int selectedRow = tblclinic.getSelectedRow();
        if (selectedRow >= 0) {
            String selectRowIdStr = tblclinic.getModel().getValueAt(selectedRow, 0).toString();
            Integer selectRowId = Integer.parseInt(selectRowIdStr);

            DefaultTableModel clearModel = (DefaultTableModel) tblworker.getModel();
            clearModel.setRowCount(0);

            for (int i = 0; i < sdi.getClinicDoctorList(selectRowId).size(); i++) {
                workerData[0] = sdi.getClinicDoctorList(selectRowId).get(i).getId();
                workerData[1] = sdi.getClinicDoctorList(selectRowId).get(i).getName();
                workerModel.addRow(workerData);
            }

            tblworker.setModel(workerModel);
        } else {
            Helper.showMsg("Please select clinic !");
        }

    }//GEN-LAST:event_btnselectclinicActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
         if (Helper.confirm("do you want exit ?")) {
            LoginGUI login = new LoginGUI();
            login.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnexitActionPerformed

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
            java.util.logging.Logger.getLogger(SurgeonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SurgeonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SurgeonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SurgeonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SurgeonGUI frame = new SurgeonGUI(surgeon);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnaddworker;
    private javax.swing.JButton btnclinicadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnselectclinic;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField lblpass;
    private javax.swing.JTextField lblpass1;
    private javax.swing.JTextField lblusrnm;
    private javax.swing.JLabel lblwel;
    private javax.swing.JTabbedPane pnlclinic;
    private javax.swing.JPanel pnlsurgeon;
    private javax.swing.JScrollPane scpaneworker;
    private javax.swing.JScrollPane scrllpaneclinic;
    private javax.swing.JScrollPane scrpanedoctor;
    private javax.swing.JComboBox<Object> selectdoctor;
    private javax.swing.JTable tblclinic;
    private javax.swing.JTable tbldoctormngr;
    private javax.swing.JTable tblworker;
    private javax.swing.JTextField txtclinicname;
    private javax.swing.JTextField txtnmsrnm;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtuserid;
    private javax.swing.JTextField txtusrnm;
    // End of variables declaration//GEN-END:variables
}
