/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Admin;

import Business.Admin.Role;
import Business.Admin.UserAccountDirectory;
import Business.Admin.UserAccount;
import Business.Admin.PersonDirectory;
import Business.Admin.Person;
import Business.Admin.ConfigABusiness;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Base64;
import java.io.UnsupportedEncodingException;    
import javax.xml.bind.DatatypeConverter;
/**
 *
 * @author liuch
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private UserAccountDirectory ud;
    private PersonDirectory pd;
    public MainJFrame() {
        initComponents();
        ud = new UserAccountDirectory();
        pd=new PersonDirectory();
        initialize1st();
        ConfigABusiness.getConfig(ud,pd);
      
        
    }
 public void initialize1st()
 {
        Person person=pd.addPerson();
        person.setFirstName("Lora");
        person.setLastName("Liu");
        UserAccount ua=ud.addUserAccount();
        ua.setPerson(person);
        ua.setUserName("Lora");
        String input = "123";
    //   int password=input.hashCode();
      String encoded =DatatypeConverter.printBase64Binary(input.getBytes());
      System.out.println(encoded);

        ua.setPassWord(encoded);
        ua.setRole(Role.System_admin);   
       
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        userProcessContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel1.setText("Log in");

        jLabel2.setText("User name:");

        jLabel3.setText("Password:");

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(134, 134, 134)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                        .addGap(98, 98, 98)
                        .addComponent(jButton1)
                        .addContainerGap(136, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jSplitPane1.setTopComponent(jPanel1);

        userProcessContainer.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(userProcessContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

     String userName=txtName.getText().trim();
     String passWord=txtPassword.getText();
     
     UserAccount account=ud.searchUserAccount(userName);
     if(account!=null)
     { System.out.println(account.getPassWord());
     String decoded= new String(DatatypeConverter.parseBase64Binary(account.getPassWord()));
    
    System.out.println("decoded"+decoded);
     //if(account.getPassWord()==passWord.hashCode())
     if(passWord.equals(decoded))
     {
         System.out.println("password works");
         if(!account.isAccountStatus())
             JOptionPane.showMessageDialog(null, "Account current status is disabled!!!!", "Warning", JOptionPane.WARNING_MESSAGE);
         else{
         if(account.getRole()==Role.System_admin)
                 {
                    AdminWorkAreaJPanel awajp = new AdminWorkAreaJPanel(userProcessContainer, ud, account,pd);
                    userProcessContainer.add("AdminWorkAreaJPanel",awajp);
                    CardLayout layout = (CardLayout)userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
                 }
          if(account.getRole()==Role.HR_dmin)
                 {
                    AdminPersonAreaJPanel awajp = new AdminPersonAreaJPanel(userProcessContainer, ud, account,pd);
                    userProcessContainer.add(" AdminPersonAreaJPanel ",awajp);
                    CardLayout layout = (CardLayout)userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
                 }
     }


     }
     else
        JOptionPane.showMessageDialog(null, "password not correct", "Warning", JOptionPane.WARNING_MESSAGE);
        // TODO add your handling code here:
     }
     else
         JOptionPane.showMessageDialog(null, "Username doesn't exit", "Warning", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPanel userProcessContainer;
    // End of variables declaration//GEN-END:variables
}
