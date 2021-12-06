/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.popups;

import cosc456_project.TritonDB;
import java.util.ArrayList;
import java.util.Hashtable;

public class ClientPopup extends javax.swing.JFrame {
    
    
private Hashtable<Integer,String> clientIdByIndex = new Hashtable<Integer,String>();


    public ClientPopup() {
        initComponents();
    }


    public void insertIntoDB(String phone_number, String cAddr, String cEmail){        
       var triton = TritonDB.getInstance();
       var cID = triton.selectMax("Client", "cID") + 1;
       var insert = "INSERT INTO Client(cID, phone_number, cAddr, cEmail)\n";
       insert += String.format("VALUES('%s', '%s', '%s', '%s')", cID, phone_number, cAddr, cEmail);
       triton.executeUpdate(insert);
    }
        
    public void insertIntoBDB( String bName){        
        var triton = TritonDB.getInstance();
        var cID = triton.selectMax("Client", "cID") + 1;
        var insert = "INSERT INTO Business(cID, bName)\n";
        insert += String.format("VALUES('%s', '%s')", cID,bName);
        triton.executeUpdate(insert);
    }

    public void insertIntoRDB( String fName, String lName){        
       var triton = TritonDB.getInstance();
       var cID = triton.selectMax("Client", "cID") + 1;
       var insert = "INSERT INTO Residential(fName, lName)\n";
       insert += String.format("VALUES('%s', '%s')", cID,fName, lName);
       triton.executeUpdate(insert);
    }
    public void insertIntoCTRDB(){        
       var triton = TritonDB.getInstance();
       var cID = triton.selectMax("Client", "cID") + 1;
       int is_Bus  = 0;
       int is_Res = 1;
       var insert = "INSERT INTO Client_Type(cID, is_Res, is_Bus)\n";
       insert += String.format("VALUES('%s', %d, %d)", cID,is_Res,is_Bus);
       triton.executeUpdate(insert);
    }
    public void insertIntoCTBDB(){        
       var triton = TritonDB.getInstance();
       var cID = triton.selectMax("Client", "cID") + 1;
       int is_Bus  = 1;
       int is_Res =0;
       var insert = "INSERT INTO Client_Type(cID, is_Res, is_Bus)\n";
        
       insert += String.format("VALUES('%s', %d, %d)", cID,is_Res,is_Bus);
       triton.executeUpdate(insert);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        aLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        saveP = new javax.swing.JButton();
        resCheckBox = new javax.swing.JCheckBox();
        busCheckBox = new javax.swing.JCheckBox();
        pnLabel = new javax.swing.JLabel();
        phoneNumberField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(119, 120, 119));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nLabel.setText("Name:");
        getContentPane().add(nLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 67, -1, -1));

        firstNameField.setText("jTextField1");
        getContentPane().add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 64, 195, -1));

        lastNameField.setText("jTextField2");
        getContentPane().add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 64, 195, -1));

        aLabel.setText("Address:");
        getContentPane().add(aLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 121, -1, -1));

        addressTextField.setText("jTextField3");
        getContentPane().add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 118, 494, -1));

        saveP.setText("Save");
        saveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePActionPerformed(evt);
            }
        });
        getContentPane().add(saveP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 140, -1));

        resCheckBox.setText("Residential");
        resCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(resCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 23, 96, -1));

        busCheckBox.setText("Business");
        busCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(busCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 23, 99, -1));

        pnLabel.setText("Phone Number:");
        getContentPane().add(pnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 20));

        phoneNumberField.setText("jTextField1");
        getContentPane().add(phoneNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 230, -1));

        emailLabel.setText("Emaill:");
        getContentPane().add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 227, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void busCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busCheckBoxActionPerformed
        lastNameField.setVisible(false);
        var bName = firstNameField.getText();
        
        insertIntoBDB(bName);
        insertIntoCTBDB();        
        
    }//GEN-LAST:event_busCheckBoxActionPerformed

    private void savePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePActionPerformed
  
        
        var phone_number = phoneNumberField.getText();
        var cAddr = addressTextField.getText();
        var cEmail = emailField.getText();
      
        insertIntoDB(phone_number,cAddr,cEmail);
        setVisible(false);
    }//GEN-LAST:event_savePActionPerformed

    private void resCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resCheckBoxActionPerformed
       
        firstNameField.setVisible(true);
        lastNameField.setVisible(true);
        var fName = firstNameField.getText();
        var lName = lastNameField.getText();
        insertIntoRDB(fName,lName);
        insertIntoCTRDB();
    }//GEN-LAST:event_resCheckBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JCheckBox busCheckBox;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel nLabel;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JLabel pnLabel;
    private javax.swing.JCheckBox resCheckBox;
    private javax.swing.JButton saveP;
    // End of variables declaration//GEN-END:variables
}
