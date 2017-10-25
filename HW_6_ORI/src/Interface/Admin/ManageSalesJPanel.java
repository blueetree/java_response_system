/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Admin;

import Business.Admin.UserAccountDirectory;
import Business.Admin.UserAccount;
import Business.Admin.PersonDirectory;
import Business.Market.*;
import Business.SalesPerson.*;
import Business.Supplier.Supplier;
import Business.Supplier.SupplierDirectory;
import Interface.Supplier.SearchResultJPanel;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liuch
 */
public class ManageSalesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private JPanel userProcessContainer;
    private UserAccountDirectory ud;
    private SalesPersonDirectory spd;
    private SupplierDirectory sd;
    private UserAccount account;
    private PersonDirectory pd;
    private MarketList ml;
    public ManageSalesJPanel(JPanel userProcessContainer,SalesPersonDirectory spd,SupplierDirectory sd,UserAccount account,PersonDirectory pd) {
        initComponents();
        this.spd=spd;
        this.sd = sd;
        this.account=account;
        this.userProcessContainer=userProcessContainer;
        this.pd=pd;
        //revenue totals
        int totalsRevenue = 0;
        int totalMissed = 0;
        for(SalesPerson salesPerson :spd.getSalesPersonDirectory()){
            for(Order order : salesPerson.getOrderList().getOrderList()){
                int target = Integer.parseInt(order.getMarketOffer().getTargetPrice());
                int value = order.getMarketOffer().getProduct().getProductValue();
                totalsRevenue = totalsRevenue + order.getActualPrice()-value;
                totalMissed = totalMissed + order.getActualPrice()-target;
           }
        }
       txtTotals.setText(String.valueOf(totalsRevenue));
       //missed revenue
       txtMissed.setText(String.valueOf(totalMissed));
        //end
        //revenue by market+Top 10 sales persons  by revenues  broken  down by market
        populateRevenueTable();
        //Sales persons  with consist above target sales
        populateAboveTargetTable();
        //Sales person  with below total order target sales
        populateBelowTargetTable();
        //Top 3 products consistently sold above market target price
        populateProductTable();
        //In all of the cases above calculate the gap between target and actual. 
        //???
        
    }
  public void populateRevenueTable(){
      //revenue by market
        int rowCount = tblRevenue.getRowCount();
        DefaultTableModel model = (DefaultTableModel) tblRevenue.getModel();
        for(int i=rowCount-1;i>=0;i--){
            model.removeRow(i);
        }
        
        for (Market market : ml.getMarketList()){
           int marketRevenue = 0;
           int missedRevenue = 0;
           Object row[] = new Object[4];
           row[0] = market;
           row[1] = market.getMarketName();
        for (SalesPerson salesPerson :spd.getSalesPersonDirectory()) {
            
            for(Order order : salesPerson.getOrderList().getOrderList()){
           if(order.getMarketOffer().getMarket().getMarketID().equals(market.getMarketID())){
               int value = order.getMarketOffer().getProduct().getProductValue();
               int target = Integer.parseInt(order.getMarketOffer().getTargetPrice());
               marketRevenue = marketRevenue + order.getActualPrice()-value;
               missedRevenue = missedRevenue + order.getActualPrice()-target;
              } 
            }
          }
        row[2]=marketRevenue;
        row[3]=missedRevenue;
        model.addRow(row);
        }
       //end
      
    }
  
    public void populateProductTable(){
         //Top 3 products
        int rowCount = tblProduct.getRowCount();
        DefaultTableModel model = (DefaultTableModel)tblProduct.getModel();
        for(int i=rowCount-1;i>=0;i--){
            model.removeRow(i);
        }
        ArrayList<String> belowProductID = new ArrayList<>();
        for(SalesPerson sp : spd.getSalesPersonDirectory()){
            for(Order order : sp.getOrderList().getOrderList()){
                if(order.getActualPrice()<Integer.parseInt(order.getMarketOffer().getTargetPrice())){
                    belowProductID.add(order.getMarketOffer().getProduct().getProductID());
                    
                }
            }
        }
        boolean equal = false;
        boolean repeat = false;
        for(SalesPerson sp : spd.getSalesPersonDirectory()){
            for(Order order : sp.getOrderList().getOrderList()){
                for(String belowProduct : belowProductID){
                    if(order.getMarketOffer().getProduct().getProductID().equals(belowProduct)){
                       equal = true; 
                    }
                }
              
                if(!equal){
                    Object row[] = new Object[2];
                    row[0] = order.getMarketOffer().getProduct();
                    row[1] = order.getMarketOffer().getProduct().getProductName();
                    for(int i = 0; i<rowCount; i++){
                     row[i].equals(row[0]);
                     repeat = true;
                    }
                   if(!repeat){
                       model.addRow(row);
                   }
                }
            }
        }
    }
    public void populateAboveTargetTable(){
        int rowCount = tblAboveTarget.getRowCount();
        DefaultTableModel model = (DefaultTableModel)tblAboveTarget.getModel();
        for(int i=rowCount-1;i>=0;i--){
            model.removeRow(i);
        }
        boolean above = true;
        for (SalesPerson sp: spd.getSalesPersonDirectory()){
            for(Order order : sp.getOrderList().getOrderList()){
                if(order.getActualPrice()<=Integer.parseInt(order.getMarketOffer().getTargetPrice())){
                    above = false;
                }
            }
            if(above){
               Object row[] = new Object[2];
               row[0] = sp;
               row[1] = sp.getSalesPersonName();
               model.addRow(row);
            }
            
        }
    }
    public void populateBelowTargetTable(){
        int rowCount = tblBelowTarget.getRowCount();
        DefaultTableModel model = (DefaultTableModel)tblBelowTarget.getModel();
        for(int i=rowCount-1;i>=0;i--){
            model.removeRow(i);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRevenue = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTotals = new javax.swing.JTextField();
        btnTopByMarket = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAboveTarget = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBelowTarget = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtMissed = new javax.swing.JTextField();

        tblRevenue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Market ID", "Market Name", "Revenue", "Missed Revenue"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRevenue);
        if (tblRevenue.getColumnModel().getColumnCount() > 0) {
            tblRevenue.getColumnModel().getColumn(0).setResizable(false);
            tblRevenue.getColumnModel().getColumn(1).setResizable(false);
            tblRevenue.getColumnModel().getColumn(2).setResizable(false);
            tblRevenue.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Monitor Sales Performance");

        jLabel2.setText("Total Revenue");

        btnTopByMarket.setText("View Top 10 SalesPerson in this Market >>");
        btnTopByMarket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopByMarketActionPerformed(evt);
            }
        });

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Product ID", "Product Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProduct);
        if (tblProduct.getColumnModel().getColumnCount() > 0) {
            tblProduct.getColumnModel().getColumn(0).setResizable(false);
            tblProduct.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel3.setText("Top 3 products - sold above market target price");

        jLabel4.setText("Sales persons with consist above target sales");

        tblAboveTarget.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SalesPerson ID", "SalesPerson Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblAboveTarget);
        if (tblAboveTarget.getColumnModel().getColumnCount() > 0) {
            tblAboveTarget.getColumnModel().getColumn(0).setResizable(false);
            tblAboveTarget.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel5.setText("Sales person with below total order target sales");

        tblBelowTarget.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SalesPerson ID", "SalesPerson Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblBelowTarget);
        if (tblBelowTarget.getColumnModel().getColumnCount() > 0) {
            tblBelowTarget.getColumnModel().getColumn(0).setResizable(false);
            tblBelowTarget.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel6.setText("Missed Revenue");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(30, 30, 30)
                            .addComponent(txtTotals, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnTopByMarket)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtMissed, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTotals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(226, 226, 226))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtMissed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTopByMarket)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTopByMarketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopByMarketActionPerformed
        // TODO add your handling code here:
        int row = tblRevenue.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
                 Market market = (Market)tblRevenue.getValueAt(row, 0);
                 Top10JPanel tp = new Top10JPanel(userProcessContainer,market,spd);
                 userProcessContainer.add("Top10JPanel",tp);
                 CardLayout layout = (CardLayout)userProcessContainer.getLayout();
                layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnTopByMarketActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTopByMarket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblAboveTarget;
    private javax.swing.JTable tblBelowTarget;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTable tblRevenue;
    private javax.swing.JTextField txtMissed;
    private javax.swing.JTextField txtTotals;
    // End of variables declaration//GEN-END:variables
}
