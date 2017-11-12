/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Salesperson;

import Business.Admin.UserAccount;
import Business.Market.Customer;
import Business.Market.Market;
import Business.Market.MarketList;
import Business.Market.MarketOffer;
import Business.Market.MarketOfferCatalog;
import Business.SalesPerson.OrderItem;
import Business.SalesPerson.Order;
import Business.SalesPerson.SalesPerson;
import Business.Supplier.Product;
import Business.Supplier.Supplier;
import Business.Supplier.SupplierDirectory;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liuch
 */
public class bookJPanel extends javax.swing.JPanel {

    /**
     * Creates new form bookJPanel
     */
    Customer customer;
    SalesPerson salesPerson;
    SupplierDirectory supplierDirectory;
    JPanel userProcessContainer;
    MarketList markList;
    Market market;
    MarketOfferCatalog marketOfferCatalog;
    Order orderList;
     private Order order;
    private boolean isCheckedOut = false;
    public bookJPanel(Customer customer,SalesPerson salesPerson,SupplierDirectory supplierDirectory,JPanel userProcessContainer,MarketList markList,Market market,MarketOfferCatalog marketOfferCatalog) {
        initComponents();
        orderList=new Order();
        this.customer=customer;
        this.salesPerson=salesPerson;
        this.supplierDirectory=supplierDirectory;
        this.userProcessContainer=userProcessContainer;
        this.markList=markList;
        this.market=market;
        this.marketOfferCatalog=marketOfferCatalog;
        txtCustomerName.setText(customer.getCustomerName());
        txtField.setText(customer.getAddress());
       
        txtMarket.setText(markList.MarketCustomerBelong(customer).getMarketName());
        System.out.println("Market belong to"+markList.MarketCustomerBelong(customer).getMarketName());
        populateSupplierCombo();
        jComboBox1.setSelectedIndex(0);
        if(!isCheckedOut)
        order = new Order();
    }
      public void populateSupplierCombo()
    {
        jComboBox1.removeAllItems();
        
        for(Supplier supplier: supplierDirectory.getSupplierDirectory())
        {
            jComboBox1.addItem(supplier);
        }
        populateTable();
    }
    public void populateTable()
    {
        //int rowCount = jTable1.getRowCount();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
         model.setRowCount(0);
         Supplier supplier=(Supplier)jComboBox1.getSelectedItem();
        for(Product product : supplier.getProductCatalog().getProductCatalog()) {
            MarketOffer marketoffer=marketOfferCatalog.getMarketOfferWithProduct(product,market);
            Object row[] = new Object[6];
            row[0] = product.getProductID();
            row[1] =product.getProductName();
            row[2]=marketoffer.getFloorPrice();
            row[3]=marketoffer.getCellingPrice();
            row[4]=marketoffer;
            row[5]=marketoffer.getAvailible();
            
            model.addRow(row);
        }
    
    }
 public void populateOrderTable()
    {
        
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
          model.setRowCount(0);
        
        for(OrderItem orderItem : orderList.getOrderItemList()) {
          
            Object row[] = new Object[3];
            row[0] = orderItem;
            row[1] =orderItem.getMarketOffer().getProduct().getProductName();
            row[2]=orderItem.getActualPrice();
            model.addRow(row);
        }
    
    }
   public void refreshOrderTable()
    {
        DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
        model.setRowCount(0);
        for(OrderItem oi : order.getOrderItemList())
        {
            
                      Object row[] = new Object[4];
                      row[0] = oi;
                      row[1] =oi.getMarketOffer().getProduct().getProductName();
                       row[2] = oi.getQuantity();
                      row[3] =oi.getActualPrice();
                      model.addRow(row);
                
            
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

        txtCustomerName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtMarket = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        quantitySpinner = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        btnModifyQuantity = new javax.swing.JButton();
        btnRemoveOrderItem = new javax.swing.JButton();
        jSpinner2 = new javax.swing.JSpinner();

        txtCustomerName.setEditable(false);
        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Address:");

        txtField.setEditable(false);

        jLabel1.setText("Customer Name:");

        jLabel3.setText("My Commission");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductID", "Product Name", "Floor Price", "Ceiling Price", "Target Price", "Availibility"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Choose");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Market:");

        txtMarket.setEditable(false);

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ProductID", "Product Name", "Quantity", "Actual Price"
            }
        ));
        jScrollPane2.setViewportView(orderTable);

        jButton2.setText("<<Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Submit Order>>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Total price:");

        jLabel6.setText("Quantity:");

        btnModifyQuantity.setText("Modify Quantity");
        btnModifyQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyQuantityActionPerformed(evt);
            }
        });

        btnRemoveOrderItem.setText("Remove");
        btnRemoveOrderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveOrderItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(226, 226, 226))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel2))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtCustomerName)
                                                .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(55, 55, 55)
                                    .addComponent(jLabel4)
                                    .addGap(35, 35, 35)
                                    .addComponent(txtMarket, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(btnModifyQuantity)
                .addGap(18, 18, 18)
                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(26, 26, 26)
                .addComponent(btnRemoveOrderItem)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtMarket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(btnModifyQuantity)
                    .addComponent(btnRemoveOrderItem)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
      populateTable();   // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

     int selectedRow=jTable1.getSelectedRow();
     if(selectedRow<0)
     {
         JOptionPane.showMessageDialog(null,"Please select");
         return;
     }
     MarketOffer selectedMarketOffer = (MarketOffer)jTable1.getValueAt(selectedRow,4);
     int fetchQty=(Integer)quantitySpinner.getValue();        // TODO add your handling code here:
     if(fetchQty<=0)
     {
         JOptionPane.showMessageDialog(null,"Can't be zero");
         return;
     }
     try{
     double salesPrice = Double.parseDouble(jTextField1.getText());
     if(salesPrice<=selectedMarketOffer.getFloorPrice())
     {
         JOptionPane.showMessageDialog(null, "Can not be less than floorPrice");
         return;
     }
       if(salesPrice>=selectedMarketOffer.getCellingPrice())
     {
         JOptionPane.showMessageDialog(null, "Can not be less than ceilingPrice");
         return;
     }
     if(fetchQty <= selectedMarketOffer.getAvailible())
     {
         boolean alereadyPresent = false;
         for(OrderItem oi : order.getOrderItemList())
         {
             if(oi.getMarketOffer() == selectedMarketOffer)
             {
                 double oldActualPrice=oi.getActualPrice();
                 double newActualPrice =Double.parseDouble(jTextField1.getText());
                 double averageActualPrice = (oldActualPrice*(oi.getQuantity())+fetchQty*newActualPrice)/(oi.getQuantity()+fetchQty);
                 int oldAvail =selectedMarketOffer.getAvailible();
                 int newAvail = oldAvail - fetchQty;
                
                 selectedMarketOffer.setAvailible(newAvail);
                 oi.setQuantity(fetchQty+oi.getQuantity());
                 oi.setActualPrice( averageActualPrice);
                 alereadyPresent = true;
                 populateTable();
                 refreshOrderTable();
                 printTotalPrice();
                 break;
             }
         }
         if(!alereadyPresent)
         {
          int oldAvail = selectedMarketOffer.getAvailible();
          int newAvail = oldAvail - fetchQty;
          selectedMarketOffer.setAvailible(newAvail);
          order.addOrderItem(selectedMarketOffer,fetchQty,salesPrice);
          for(OrderItem orderitem: order.getOrderItemList())
          {
         
              System.out.println("getting order"+orderitem.getActualPrice()+" "+orderitem.getQuantity()+" "+orderitem.getMarketOffer().getProduct().getProductName());
                  }
          populateTable();
          refreshOrderTable();
          printTotalPrice();
         }
         
     }
     else
     {
         JOptionPane.showMessageDialog(null,"Quantity > Availibity","Warning",JOptionPane.WARNING_MESSAGE);
     }
     }
     
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(null,"Invalid");
         return;
     }
        
    }//GEN-LAST:event_jButton1ActionPerformed
  private void printTotalPrice()
  {
      double totalPrice =0;
         for(OrderItem orderItem: order.getOrderItemList())
         {
             totalPrice=totalPrice+orderItem.getActualPrice()*orderItem.getQuantity();
         }
         jTextField2.setText(String.valueOf(totalPrice));
  }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);  // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   if(order.getOrderItemList().size() > 0)
    {
      Date currentTime= new Date();
      order.setOrderDate(currentTime);
      order.setCustomer(customer);
      order.setSalesmanName(salesPerson.getSalesPersonName());
      salesPerson.addOrder(order);
      JOptionPane.showMessageDialog(null, "Order placed successfully");
      order = new Order();
      
      refreshOrderTable();
      populateTable();
       isCheckedOut = true;
    }
    else
    {
            JOptionPane.showMessageDialog(null,"no order placed");
            }
       
     
   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnModifyQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyQuantityActionPerformed

        int selectedRow = orderTable.getSelectedRow();
        if(selectedRow < 0)
        {
            return;
        }
        OrderItem oi = (OrderItem)orderTable.getValueAt(selectedRow,0);
        int currentAvail = oi.getMarketOffer().getAvailible();
        int oldQty = oi.getQuantity();
        int newQty = (Integer)jSpinner2.getValue();
        if(newQty > (currentAvail + oldQty) )
        {
            JOptionPane.showMessageDialog(null,"Quantity is more than availibility");
            return;
        }
        else
        {
            if(newQty <= 0 )
            {
                JOptionPane.showMessageDialog(null,"Quantity can not be zero");
                return;
            }
            oi.setQuantity(newQty);
            oi.getMarketOffer().setAvailible(currentAvail+(oldQty - newQty));
            refreshOrderTable();
            populateTable();
            printTotalPrice();
        }
        // TODO add your handling code here:

    }//GEN-LAST:event_btnModifyQuantityActionPerformed

    private void btnRemoveOrderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveOrderItemActionPerformed

        int row = orderTable.getSelectedRow();
        if(row<0)
        {
            JOptionPane.showMessageDialog(null, "PLS SELECT A ROW");
            return;
        }
        OrderItem oi = (OrderItem)orderTable.getValueAt(row, 0);
        int oldAvail = oi.getMarketOffer().getAvailible();
        int oldQty = oi.getQuantity();
        int newQty = oldAvail + oldQty;
        oi.getMarketOffer().setAvailible(newQty);
        order.RemoveOrderItem(oi);
        JOptionPane.showMessageDialog(null,"OrderITem removed from the cart");
        refreshOrderTable();
        populateTable();
        printTotalPrice();

    }//GEN-LAST:event_btnRemoveOrderItemActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModifyQuantity;
    private javax.swing.JButton btnRemoveOrderItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable orderTable;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtField;
    private javax.swing.JTextField txtMarket;
    // End of variables declaration//GEN-END:variables
}