/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Admin.Country;

import Interface.Command.*;
import Business.Area.Area;
import Business.Country.Country;
import Business.District.District;
import Business.MaterialList.InventoryItem;
import Business.MaterialList.Item;
import Business.Person.Person;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jiahuanli
 */
public class AdjustJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdjustJPanel
     */
    JPanel CommandContainer;
    Country country;

    AdjustJPanel(JPanel CommandContainer, Country country) {
        initComponents();
        this.CommandContainer = CommandContainer;
        this.country = country;
        lblMoney.setText(String.valueOf(country.getMoney()));
        populatecbx1();
        populatecbx2();
        cost();
    }
    public void cost(){
        
        District district = (District)cbxArea2.getSelectedItem();
        double distance;
        if(cbxArea1.getSelectedItem().equals(country)){
        double temp = Math.pow(country.getLocation_x()-district.getLocation_x(), 2) + Math.pow(country.getLocation_y()-district.getLocation_y(), 2);
        distance = Math.sqrt(temp);

        }else{
        District district1 = (District)cbxArea1.getSelectedItem();
        System.out.println("else-district1.getLocation_x():"+district1.getLocation_x()+"  district.getLocation_x(): "+district.getLocation_x());
        double temp = Math.pow(district1.getLocation_x()-district.getLocation_x(), 2) + Math.pow(district1.getLocation_y()-district.getLocation_y(), 2);
        distance = Math.sqrt(temp);

        }
        System.out.println("inside cost-distance:"+distance);
        txtCost.setText(String.valueOf(Math.round(distance)));
        
    }


    public void populatecbx1() {
        cbxArea1.removeAllItems();

        for (District district : country.getDistrictDirectory().getDistrictList()) {
            cbxArea1.addItem(district);
        }
        cbxArea1.addItem(country);
    }

    public void populatecbx2() {
        cbxArea2.removeAllItems();

        for (District district : country.getDistrictDirectory().getDistrictList()) {
            cbxArea2.addItem(district);
            System.out.println("inside-cb2-district:"+district);
        }
    }

    public void populateMaterial1() {
        System.out.println("inside populateMaterial1");
        DefaultTableModel dtm = (DefaultTableModel) tblMaterial1.getModel();
        dtm.setRowCount(0);
        if(cbxArea1.getSelectedItem().equals(country)){
                for (Item item : country.getItemDirectory().getItemList()) {
                    Object row[] = new Object[2];
                    row[0] = item;
                    row[1] = item.getQuantity();
                    dtm.addRow(row);
                }
         }else{
        for (District district : country.getDistrictDirectory().getDistrictList()) {
            if (cbxArea1.getSelectedItem().equals(district)) {
                for (Item item : district.getItemDirectory().getItemList()) {
                    Object row[] = new Object[2];
                    row[0] = item;
                    row[1] = item.getQuantity();
                    dtm.addRow(row);
                }
            }
        }
        }
    }

    public void populateMaterial2() {
        DefaultTableModel dtm = (DefaultTableModel) tblMaterial2.getModel();
        dtm.setRowCount(0);
        for (District district : country.getDistrictDirectory().getDistrictList()) {
            if (cbxArea2.getSelectedItem().equals(district)) {
                for (Item item : district.getItemDirectory().getItemList()) {
                    Object row[] = new Object[2];
                    row[0] = item.getName();
                    row[1] = item.getQuantity();
                    dtm.addRow(row);
                }
            }
        }
    }

    public void populateRequest() {
        DefaultTableModel dtm = (DefaultTableModel) tblRequest.getModel();
        dtm.setRowCount(0);
        District cbdistrict = (District)cbxArea2.getSelectedItem();
        Object near=null;
        Double nearDistance = 100000000000.0;
        for (WorkRequest workRequest : cbdistrict.getWorkQueue().getWorkRequestList()) {
            Object row[] = new Object[3];
            row[0] = workRequest;
            row[1] = workRequest.getItem().getQuantity();
            //nearest district
            for(Item copItem:country.getItemDirectory().getItemList()){
                    if(copItem.getName().equals(workRequest.getItem().getName())){
                       near = country;
                       double temp1 = Math.pow(country.getLocation_x()-cbdistrict.getLocation_x(), 2) + Math.pow(country.getLocation_y()-cbdistrict.getLocation_y(), 2);
                       nearDistance = Math.sqrt(temp1);
                    }
                }
            for(District copDistrict : country.getDistrictDirectory().getDistrictList()){
             double distance;
             double temp = Math.pow(copDistrict.getLocation_x()-cbdistrict.getLocation_x(), 2) + Math.pow(copDistrict.getLocation_y()-cbdistrict.getLocation_y(), 2);
             distance = Math.sqrt(temp);
             if(nearDistance >=distance&& distance!=0){
                for(Item copItem:copDistrict.getItemDirectory().getItemList()){
                    if(copItem.getName().equals(workRequest.getItem().getName())){
                       near = copDistrict;
                       nearDistance = distance; 
                    }
                }
             
             }
            }
            
            row[2]=near;
            //end
            dtm.addRow(row);
        }
    }
    


    public double distance(District a, District b) {
        double distance = (a.getLocation_x() - b.getLocation_x()) * (a.getLocation_x() - b.getLocation_x()) + (a.getLocation_y() - b.getLocation_y()) * (a.getLocation_y() - b.getLocation_y());
        double n = Math.sqrt(distance);
        return n;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMaterial1 = new javax.swing.JTable();
        cbxArea1 = new javax.swing.JComboBox();
        cbxArea2 = new javax.swing.JComboBox();
        btnTransferM = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblMaterial2 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        lblMoney = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblMaterial1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMaterial1);
        if (tblMaterial1.getColumnModel().getColumnCount() > 0) {
            tblMaterial1.getColumnModel().getColumn(0).setResizable(false);
            tblMaterial1.getColumnModel().getColumn(1).setResizable(false);
        }

        cbxArea1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxArea1ActionPerformed(evt);
            }
        });

        cbxArea2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxArea2ActionPerformed(evt);
            }
        });

        btnTransferM.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        btnTransferM.setText("Transfer");
        btnTransferM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferMActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        jLabel8.setText("Amount");

        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });

        tblMaterial2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblMaterial2);
        if (tblMaterial2.getColumnModel().getColumnCount() > 0) {
            tblMaterial2.getColumnModel().getColumn(0).setResizable(false);
            tblMaterial2.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel10.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        jLabel10.setText("From");

        jLabel11.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        jLabel11.setText("To");

        jLabel9.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        jLabel9.setText("Cost");

        txtCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostActionPerformed(evt);
            }
        });

        lblMoney.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        lblMoney.setText("jLabel4");

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        jLabel4.setText("Money");

        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Amount", "Nearest District"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRequestMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblRequest);
        if (tblRequest.getColumnModel().getColumnCount() > 0) {
            tblRequest.getColumnModel().getColumn(0).setResizable(false);
            tblRequest.getColumnModel().getColumn(1).setResizable(false);
            tblRequest.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        jLabel5.setText("Request List");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel9))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(btnTransferM, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbxArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(jLabel11)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbxArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 43, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel8, jLabel9});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblMoney))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(cbxArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(cbxArea2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTransferM)))
                .addGap(74, 74, 74)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxArea1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxArea1ActionPerformed
        System.out.println("inside cbxArea1ActionPerformed");
        populateMaterial1();
        if(cbxArea2.getSelectedItem()!=null){
            cost();
        }
        

        // TODO add your handling code here:
    }//GEN-LAST:event_cbxArea1ActionPerformed

    private void cbxArea2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxArea2ActionPerformed
        populateMaterial2();
        cost();
        populateRequest();
        //txtCost.setText(String.valueOf(distance() * 5));
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxArea2ActionPerformed

    private void btnTransferMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferMActionPerformed
        int selectedRow = tblMaterial1.getSelectedRow();
        District districtto = null;
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row first", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (Double.parseDouble(txtCost.getText())>country.getMoney()) {
            JOptionPane.showMessageDialog(null, "The country does not have enough money to make the transfer", "Warning", JOptionPane.WARNING_MESSAGE);
        }  else if (txtAmount.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter Amount", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            districtto = (District)cbxArea2.getSelectedItem();
           
            Item item = (Item) tblMaterial1.getValueAt(selectedRow, 0);
            Item fromItemTemp = new InventoryItem();
            Item toItemTemp = new InventoryItem();
            boolean equal = false;
            for(Item toitem : districtto.getItemDirectory().getItemList()){
                if(toitem.getName().equals(item.getName())){
                    if(item.getQuantity()>=Integer.parseInt(txtAmount.getText())){

                    toitem.setQuantity(toitem.getQuantity()+Integer.parseInt(txtAmount.getText()));
                    //districtfrom.getItemDirectory().getItemList().remove(item);
                    int qua = item.getQuantity()-Integer.parseInt(txtAmount.getText());
                    item.setQuantity(qua);
                    fromItemTemp = item;
                    
                    //districtfrom.getItemDirectory().getItemList().add(item);
                    equal = true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Don't have enough stock", "Warning", JOptionPane.WARNING_MESSAGE);

                    }
                }
            }
                
                if(!equal){
                    if(item.getQuantity()>=Integer.parseInt(txtAmount.getText())){
                    Item newitem = new InventoryItem();
                    newitem.setName(item.getName());
                    newitem.setPrice(item.getPrice());
                    newitem.setQuantity(Integer.parseInt(txtAmount.getText()));
                    toItemTemp = newitem;
                    item.setQuantity(item.getQuantity()-Integer.parseInt(txtAmount.getText()));
                    fromItemTemp = item;
                    //districtto.getItemDirectory().getItemList().add(newitem);
                    //districtfrom.getItemDirectory().getItemList().remove(item);
                    
                    //districtfrom.getItemDirectory().getItemList().add(item);
                    }else{
                        JOptionPane.showMessageDialog(null, "Don't have enough stock", "Warning", JOptionPane.WARNING_MESSAGE);

                    }
                }
               
            
            //districtfrom.getItemDirectory().getItemList().add(fromItemTemp);
            if(!equal){
            districtto.getItemDirectory().getItemList().add(toItemTemp);
            }
            for(WorkRequest workRequest : districtto.getWorkQueue().getWorkRequestList()){
                if(workRequest.getItem().getName().equals(item.getName())){
                   if(workRequest.getItem().getQuantity()<=Integer.parseInt(txtAmount.getText())){
                       districtto.getWorkQueue().getWorkRequestList().remove(workRequest);
                   }else{
                       workRequest.getItem().setQuantity(workRequest.getItem().getQuantity()-Integer.parseInt(txtAmount.getText()));
                   }
                }
            }
            JOptionPane.showMessageDialog(null, "Transfer Complete!");
            country.setMoney(country.getMoney()-Double.parseDouble(txtCost.getText()));
            lblMoney.setText(String.valueOf(country.getMoney()));
            populateMaterial1();
            populateMaterial2();
            populateRequest();
        // TODO add your handling code here:
        
        }
    }//GEN-LAST:event_btnTransferMActionPerformed

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtAmountActionPerformed

    private void txtCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostActionPerformed

    private void tblRequestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRequestMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            int selectedRow = tblRequest.getSelectedRow();
             Object targetPlace =tblRequest.getValueAt(selectedRow, 2);
             cbxArea1.setSelectedItem(targetPlace);
        }
    }//GEN-LAST:event_tblRequestMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTransferM;
    private javax.swing.JComboBox cbxArea1;
    private javax.swing.JComboBox cbxArea2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblMoney;
    private javax.swing.JTable tblMaterial1;
    private javax.swing.JTable tblMaterial2;
    private javax.swing.JTable tblRequest;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCost;
    // End of variables declaration//GEN-END:variables
}
