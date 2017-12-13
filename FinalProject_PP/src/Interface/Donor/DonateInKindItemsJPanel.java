/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Donor;

import Business.Area.Area;
import Business.Country.Country;
import Business.District.District;
import Business.EcoSystem;
import Business.MaterialList.Item;
import Business.MaterialList.RequestItem;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jiahuanli
 */
public class DonateInKindItemsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DonateInKindItemsJPanel
     */
    JPanel donorContainer;
    UserAccount account;
    EcoSystem system;

    WorkQueue workQueue;

    public DonateInKindItemsJPanel(JPanel donorContainer, UserAccount account, EcoSystem system) {
        initComponents();

        this.donorContainer = donorContainer;
        this.account = account;
        this.system = system;

        populateCbxCountry();

        workQueue = new WorkQueue();

    }

    public void populateCbxCountry() {
        cbxCountry1.removeAllItems();
        cbxCountry2.removeAllItems();
        cbxCountry3.removeAllItems();
        for (Country country : system.getCountryList()) {
            cbxCountry1.addItem(country);
            cbxCountry2.addItem(country);
            cbxCountry3.addItem(country);
        }
    }

    public void populateCbxDistrict2(Country country) {
        cbxDistrict2.removeAllItems();
        for (District district : country.getDistrictDirectory().getDistrictList()) {
            cbxDistrict2.addItem(district);
        }
    }

    public void populateCbxDistrict3(Country country) {
        cbxDistrict3.removeAllItems();
        for (District district : country.getDistrictDirectory().getDistrictList()) {
            cbxDistrict3.addItem(district);
        }
    }

    public void populateDistrictNeedingList(District district) {

        int rc = tblNeeding2.getModel().getRowCount() - 1;
        while (rc >= 0) {
            ((DefaultTableModel) tblNeeding2.getModel()).removeRow(rc);
            rc = rc - 1;
        }

        for (WorkRequest workRequest : district.getWorkQueue().getWorkRequestList()) {
//            if (workRequest.getSender().getRole().equals("Purchase")) {
            Object[] row = new Object[2];
            row[0] = workRequest.getItem();
            row[1] = workRequest.getItem().getQuantity();
            ((DefaultTableModel) tblNeeding2.getModel()).addRow(row);

//            }
        }
    }

    public void populateCountryNeedingList(Country country) {
        int rc = tblNeeding1.getModel().getRowCount() - 1;
        while (rc >= 0) {
            ((DefaultTableModel) tblNeeding1.getModel()).removeRow(rc);
            rc = rc - 1;
        }

        for (WorkRequest workRequest : country.getWorkQueue().getWorkRequestList()) {
//            if (workRequest.getSender().getRole().equals("Purchase")) {
            Object[] row = new Object[2];
            row[0] = workRequest.getItem();
            row[1] = workRequest.getItem().getQuantity();
            ((DefaultTableModel) tblNeeding1.getModel()).addRow(row);

//            }
        }

    }

    public void populateCbxItem(District district) {
        cbxItem.removeAllItems();
        if (cbxDonateChoose.getSelectedItem().equals("Country")) {
            for (Item item : ((Country) cbxCountry3.getSelectedItem()).getItemDirectory().getItemList()) {
                cbxItem.addItem(item);
            }
        } else if (cbxDonateChoose.getSelectedItem().equals("District")) {
            for (Item item : ((District) cbxDistrict3.getSelectedItem()).getItemDirectory().getItemList()) {
                cbxItem.addItem(item);
            }
        }
    }

    public void populateDonateBucket() {

        int rc = tblDonateBucket.getModel().getRowCount() - 1;
        while (rc >= 0) {
            ((DefaultTableModel) tblDonateBucket.getModel()).removeRow(rc);
            rc = rc - 1;
        }

        for (WorkRequest workRequest : workQueue.getWorkRequestList()) {
            Object[] row = new Object[5];
            row[0] = workRequest.getItem().getName();
            row[1] = workRequest.getItem().getQuantity();
            row[2] = workRequest.getSender().getUsername();
            row[3] = workRequest.getSender().getPerson().getName();
            row[4] = workRequest.getDestination();

            ((DefaultTableModel) tblDonateBucket.getModel()).addRow(row);
        }

    }

    public void clearDonateBucket() {
        DefaultTableModel dtm = (DefaultTableModel) tblDonateBucket.getModel();
        dtm.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNeeding1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAddItem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxItem = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDonateBucket = new javax.swing.JTable();
        btnDonate = new javax.swing.JButton();
        cbxCountry1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jspQuantity = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        btnSearchCountryNeed = new javax.swing.JButton();
        cbxCountry2 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cbxDistrict2 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNeeding2 = new javax.swing.JTable();
        btnSearchDistrictNeed = new javax.swing.JButton();
        cbxCountry3 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        cbxDistrict3 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxDonateChoose = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Donate in-kind items");

        tblNeeding1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNeeding1);
        if (tblNeeding1.getColumnModel().getColumnCount() > 0) {
            tblNeeding1.getColumnModel().getColumn(0).setResizable(false);
            tblNeeding1.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setText("Item");
        jLabel2.setEnabled(false);

        btnAddItem.setText("Add To Donate Bucket");
        btnAddItem.setEnabled(false);
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        jLabel3.setText("Donate bucket");
        jLabel3.setEnabled(false);

        jLabel5.setText("Quantity");
        jLabel5.setEnabled(false);

        cbxItem.setEnabled(false);
        cbxItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxItemActionPerformed(evt);
            }
        });

        jScrollPane2.setEnabled(false);

        tblDonateBucket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDonateBucket);
        if (tblDonateBucket.getColumnModel().getColumnCount() > 0) {
            tblDonateBucket.getColumnModel().getColumn(0).setResizable(false);
            tblDonateBucket.getColumnModel().getColumn(1).setResizable(false);
        }

        btnDonate.setText("Donate");
        btnDonate.setEnabled(false);
        btnDonate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonateActionPerformed(evt);
            }
        });

        cbxCountry1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "type" }));
        cbxCountry1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCountry1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Country");

        jspQuantity.setEnabled(false);

        jLabel9.setText("Country Needing List");

        btnSearchCountryNeed.setText("Search Needing List");
        btnSearchCountryNeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCountryNeedActionPerformed(evt);
            }
        });

        cbxCountry2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "type" }));
        cbxCountry2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCountry2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Country");

        cbxDistrict2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "type" }));
        cbxDistrict2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDistrict2ActionPerformed(evt);
            }
        });

        jLabel12.setText("District");

        jLabel13.setText("District Needing List");

        tblNeeding2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblNeeding2);
        if (tblNeeding2.getColumnModel().getColumnCount() > 0) {
            tblNeeding2.getColumnModel().getColumn(0).setResizable(false);
            tblNeeding2.getColumnModel().getColumn(1).setResizable(false);
        }

        btnSearchDistrictNeed.setText("Search Needing List");
        btnSearchDistrictNeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDistrictNeedActionPerformed(evt);
            }
        });

        cbxCountry3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "type" }));
        cbxCountry3.setEnabled(false);
        cbxCountry3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCountry3ActionPerformed(evt);
            }
        });

        jLabel15.setText("Country");
        jLabel15.setEnabled(false);

        cbxDistrict3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "type" }));
        cbxDistrict3.setEnabled(false);
        cbxDistrict3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDistrict3ActionPerformed(evt);
            }
        });

        jLabel16.setText("District");
        jLabel16.setEnabled(false);

        jLabel6.setText("Donate To :");

        cbxDonateChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Country", "District" }));
        cbxDonateChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDonateChooseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(cbxCountry2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(cbxDistrict2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSearchDistrictNeed))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel13)
                                .addGap(119, 119, 119))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(134, 134, 134)
                        .addComponent(btnDonate)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel16)
                                                .addGap(48, 48, 48)
                                                .addComponent(jLabel2))))
                                    .addComponent(cbxDonateChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbxCountry3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxDistrict3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxItem, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jspQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAddItem))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSearchCountryNeed)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbxCountry1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addGap(24, 24, 24)))
                .addComponent(jLabel4)
                .addGap(196, 196, 196))
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(303, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 66, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(cbxCountry1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSearchCountryNeed))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxDonateChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxCountry3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxDistrict3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jspQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddItem))))
                        .addGap(47, 47, 47)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(cbxCountry2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(cbxDistrict2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearchDistrictNeed))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnDonate)))
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchCountryNeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCountryNeedActionPerformed
        Country country1 = (Country) cbxCountry1.getSelectedItem();
        populateCountryNeedingList(country1);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchCountryNeedActionPerformed

    private void cbxCountry1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCountry1ActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_cbxCountry1ActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        Item item = (Item) cbxItem.getSelectedItem();
        RequestItem requestItem = new RequestItem();
        requestItem.setName(item.getName());
        requestItem.setPrice(item.getPrice());
        requestItem.setQuantity((Integer) jspQuantity.getValue());
        WorkRequest workRequest = new WorkRequest();
        workRequest.setItem(requestItem);
        workRequest.setSender(account);
        if (cbxDonateChoose.getSelectedItem().equals("District")) {
            workRequest.setDestination(((District) cbxDistrict3.getSelectedItem()).getName());
        } else if (cbxDonateChoose.getSelectedItem().equals("Country")) {
            workRequest.setDestination(((Country) cbxCountry3.getSelectedItem()).getName());
        }
        workQueue.getWorkRequestList().add(workRequest);
        populateDonateBucket();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnDonateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonateActionPerformed
        if (cbxDonateChoose.getSelectedItem().equals("District")) {
            for (Item item : ((District) cbxDistrict3.getSelectedItem()).getItemDirectory().getItemList()) {
                for (WorkRequest workRequest : workQueue.getWorkRequestList()) {
                    if (item.getName().equals(workRequest.getItem().getName())) {
                        item.setQuantity(item.getQuantity() + workRequest.getItem().getQuantity());
                    }
                }
            }
            for (WorkRequest workRequest : workQueue.getWorkRequestList()) {
                system.getWorkQueue().getWorkRequestList().add(workRequest);
            }
            clearDonateBucket();
            JOptionPane.showMessageDialog(null, "Donate To District Successfully!", "Successfully", JOptionPane.INFORMATION_MESSAGE);
        } else if (cbxDonateChoose.getSelectedItem().equals("Country")) {
            for (Item item : ((Country) cbxCountry3.getSelectedItem()).getItemDirectory().getItemList()) {
                for (WorkRequest workRequest : workQueue.getWorkRequestList()) {
                    if (item.getName().equals(workRequest.getItem().getName())) {
                        item.setQuantity(item.getQuantity() + workRequest.getItem().getQuantity());
                    }
                }
            }
            for (WorkRequest workRequest : workQueue.getWorkRequestList()) {
                system.getWorkQueue().getWorkRequestList().add(workRequest);
            }
            clearDonateBucket();
            JOptionPane.showMessageDialog(null, "Donate To Country Successfully!", "Successfully", JOptionPane.INFORMATION_MESSAGE);

        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnDonateActionPerformed

    private void cbxItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxItemActionPerformed

    private void cbxCountry2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCountry2ActionPerformed
        Country country = (Country) cbxCountry1.getSelectedItem();
        if (country != null) {
            populateCbxDistrict2(country);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCountry2ActionPerformed

    private void cbxDistrict2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDistrict2ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDistrict2ActionPerformed

    private void btnSearchDistrictNeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDistrictNeedActionPerformed
        District district2 = (District) cbxDistrict2.getSelectedItem();
        populateDistrictNeedingList(district2);
// TODO add your handling code here:
    }//GEN-LAST:event_btnSearchDistrictNeedActionPerformed

    private void cbxCountry3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCountry3ActionPerformed
        Country country = (Country) cbxCountry1.getSelectedItem();
        if (country != null) {
            populateCbxDistrict3(country);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_cbxCountry3ActionPerformed

    private void cbxDistrict3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDistrict3ActionPerformed
        District district = (District) cbxDistrict3.getSelectedItem();
        if (district != null) {
            populateCbxItem(district);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDistrict3ActionPerformed

    private void cbxDonateChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDonateChooseActionPerformed
        if (cbxDonateChoose.getSelectedItem().equals("Country")) {
            cbxCountry3.setEnabled(true);
            cbxDistrict3.setEnabled(false);
            cbxItem.setEnabled(true);
            jspQuantity.setEnabled(true);
            btnAddItem.setEnabled(true);
            tblDonateBucket.setEnabled(true);
            btnDonate.setEnabled(true);
        } else if (cbxDonateChoose.getSelectedItem().equals("District")) {
            cbxCountry3.setEnabled(true);
            cbxDistrict3.setEnabled(true);
            cbxItem.setEnabled(true);
            jspQuantity.setEnabled(true);
            btnAddItem.setEnabled(true);
            tblDonateBucket.setEnabled(true);
            btnDonate.setEnabled(true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDonateChooseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnDonate;
    private javax.swing.JButton btnSearchCountryNeed;
    private javax.swing.JButton btnSearchDistrictNeed;
    private javax.swing.JComboBox cbxCountry1;
    private javax.swing.JComboBox cbxCountry2;
    private javax.swing.JComboBox cbxCountry3;
    private javax.swing.JComboBox cbxDistrict2;
    private javax.swing.JComboBox cbxDistrict3;
    private javax.swing.JComboBox<String> cbxDonateChoose;
    private javax.swing.JComboBox cbxItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jspQuantity;
    private javax.swing.JTable tblDonateBucket;
    private javax.swing.JTable tblNeeding1;
    private javax.swing.JTable tblNeeding2;
    // End of variables declaration//GEN-END:variables
}
