/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.popups;

import cosc456_project.TritonDB;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author trwil
 */
public class AppointmentPopup extends javax.swing.JFrame {

    /**
     * Creates new form cPop
     */
    private Hashtable<Integer, String> clientIdByIndex = new Hashtable<Integer, String>();
    private Hashtable<Integer, String> employeeIdByIndex = new Hashtable<Integer, String>();
    
    public AppointmentPopup() {
        initComponents();
    }
    
     @Override
    public void setVisible(boolean visible){
        super.setVisible(visible);
        if (visible)
            updateClientComboBox();
    }
    
    public void updateClientComboBox(){
        clientComboBox.removeAll();
        clientIdByIndex.clear();
        var triton = TritonDB.getInstance();
        try{
           var result = triton.executeQuery("SELECT cID FROM Client");
           var clientIDs = triton.getResultRows(result);
           var index = 0;
           for(var row : clientIDs){
               var cID = row[0];
               var idType = triton.getResultRows(triton.executeQuery("SELECT is_Res, is_Bus FROM Client_Type WHERE cID = " + cID));
               var isResidential = idType[0][0].equals("1");
               var isBusiness = idType[0][1].equals("1");
               var clientName = "";
               
               if (isResidential){
                   var resNameRows = triton.getResultRows(triton.executeQuery("SELECT fName, lName FROM Residential WHERE cID = " + cID));
                   var firstName = resNameRows[0][0];
                   var lastName = resNameRows[0][1];
                   clientName = firstName + " " + lastName;
               }
               else if (isBusiness){
                   var resNameRows = triton.getResultRows(triton.executeQuery("SELECT bName FROM Business WHERE cID = " + cID));
                   var bName = resNameRows[0][0] + " (business)";
                   clientName = bName;
               }
               if (!clientName.isEmpty()){
                   clientComboBox.addItem(clientName);
                   clientIdByIndex.put(index, cID);
                   index++;
               }
           }
           
           result = triton.executeQuery("SELECT empID, fName, lName FROM Employees");
           var employeeData = triton.getResultRows(result);
           index = 0;
           for (var row : employeeData){
               employeeComboBox.addItem(row[1] + " " + row[2]);
               employeeIdByIndex.put(index, row[0]);
               index++;
           }
           
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nLabel = new javax.swing.JLabel();
        aLabel = new javax.swing.JLabel();
        saveP = new javax.swing.JButton();
        sdLabel = new javax.swing.JLabel();
        edLabel = new javax.swing.JLabel();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        endDateChooser = new com.toedter.calendar.JDateChooser();
        addressField = new javax.swing.JTextField();
        edLabel1 = new javax.swing.JLabel();
        estimateField = new javax.swing.JTextField();
        clientComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        employeeComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(119, 120, 119));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nLabel.setText("Client:");
        getContentPane().add(nLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        aLabel.setText("Address:");
        getContentPane().add(aLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        saveP.setText("Save");
        saveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePActionPerformed(evt);
            }
        });
        getContentPane().add(saveP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 140, -1));

        sdLabel.setText("Start Date:");
        getContentPane().add(sdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 20));

        edLabel.setText("Estimate:");
        getContentPane().add(edLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 20));

        startDateChooser.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(startDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 286, -1));

        endDateChooser.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(endDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 286, -1));
        getContentPane().add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 573, -1));

        edLabel1.setText("End Date:");
        getContentPane().add(edLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 20));
        getContentPane().add(estimateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 573, -1));

        getContentPane().add(clientComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 490, -1));

        jLabel1.setText("Employee:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        getContentPane().add(employeeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 490, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void savePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePActionPerformed
        /*
        var triton = TritonDB.getInstance();
        var c_ID = "00001";
        var empID = "7783349";
        var eID = "55666";
        var aLocation = addressField.getText();
        var estimate = Integer.getInteger(estimateField.getText());
        var sDate = startDateChooser.getDate();
        var eDate = endDateChooser.getDate();
        var aID = triton.selectMax("Appointment", "aID") + 1;*/
        //setVisible(false);
    }//GEN-LAST:event_savePActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aLabel;
    private javax.swing.JTextField addressField;
    private javax.swing.JComboBox<String> clientComboBox;
    private javax.swing.JLabel edLabel;
    private javax.swing.JLabel edLabel1;
    private javax.swing.JComboBox<String> employeeComboBox;
    private com.toedter.calendar.JDateChooser endDateChooser;
    private javax.swing.JTextField estimateField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nLabel;
    private javax.swing.JButton saveP;
    private javax.swing.JLabel sdLabel;
    private com.toedter.calendar.JDateChooser startDateChooser;
    // End of variables declaration//GEN-END:variables
}
