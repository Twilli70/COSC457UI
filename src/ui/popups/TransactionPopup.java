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
public class TransactionPopup extends Popup {

    /**
     * Creates new form cPop
     */
    private Hashtable<Integer,String> clientIdByIndex = new Hashtable<Integer,String>();
    
    public TransactionPopup() {
        initComponents();
    }
    
    @Override
    public void setVisible(boolean visible){
        super.setVisible(visible);
        if (!visible){
            equipmentCostLabel.setText("");
            laborCostLabel.setText("");
            servicePlanCostLabel.setText("");
        }
          
    }
    
    public void updateAppointmentComboBox(){
        appIDComboBox.removeAll();
        clientIdByIndex.clear();
        var triton = TritonDB.getInstance();
        try{
           var clients = new ArrayList<String>();
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
               var appointmentData = triton.getResultRows(triton.executeQuery("SELECT sDate, aLocation, aID FROM Appointment WHERE c_ID = " + cID));
               if (appointmentData != null && !clientName.isEmpty()){
                   var aID = appointmentData[0][2];
                   appIDComboBox.addItem(String.format("With %s on %s at %s", clientName, appointmentData[0][0], appointmentData[0][1]));
                   clientIdByIndex.put(index, aID);
                   index++;
               }

           }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void insertIntoDB(String aID, int equipCost, int laborCost, int spCost){        
        var triton = TritonDB.getInstance();
        var tID = triton.selectMax("Transactions", "tID") + 1;
        var insert = "INSERT INTO Transactions(tID, aID, EquipCost, LaborCost, SPCost)\n";
        insert += String.format("VALUES('%s', '%s', %d, %d, %d)", tID, aID, equipCost, laborCost, spCost);
        triton.executeUpdate(insert);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Alabel = new javax.swing.JLabel();
        saveP = new javax.swing.JButton();
        eqCost = new javax.swing.JLabel();
        equipmentCostLabel = new javax.swing.JTextField();
        lcLabel = new javax.swing.JLabel();
        laborCostLabel = new javax.swing.JTextField();
        spLabel = new javax.swing.JLabel();
        servicePlanCostLabel = new javax.swing.JTextField();
        appIDComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(119, 120, 119));
        setBounds(new java.awt.Rectangle(0, 0, 700, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Alabel.setText("Appointment: ");
        getContentPane().add(Alabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 76, -1, -1));

        saveP.setText("Save");
        saveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePActionPerformed(evt);
            }
        });
        getContentPane().add(saveP, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 317, 140, -1));

        eqCost.setText("Equipment Cost:");
        getContentPane().add(eqCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 130, -1, -1));
        getContentPane().add(equipmentCostLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 127, 500, -1));

        lcLabel.setText("Labor Cost:");
        getContentPane().add(lcLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 194, -1, -1));
        getContentPane().add(laborCostLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 191, 500, -1));

        spLabel.setText("Service Plan Cost:");
        getContentPane().add(spLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 262, -1, -1));
        getContentPane().add(servicePlanCostLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 259, 500, -1));

        getContentPane().add(appIDComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 500, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void savePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePActionPerformed
        var aID = clientIdByIndex.get(appIDComboBox.getSelectedIndex());
        var equipCost = Integer.parseInt(equipmentCostLabel.getText());
        var laborCost = Integer.parseInt(laborCostLabel.getText());
        var SPCost = Integer.parseInt(servicePlanCostLabel.getText());
        
        insertIntoDB(aID, equipCost, laborCost, SPCost);
        setVisible(false);
        save();
    }//GEN-LAST:event_savePActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Alabel;
    private javax.swing.JComboBox<String> appIDComboBox;
    private javax.swing.JLabel eqCost;
    private javax.swing.JTextField equipmentCostLabel;
    private javax.swing.JTextField laborCostLabel;
    private javax.swing.JLabel lcLabel;
    private javax.swing.JButton saveP;
    private javax.swing.JTextField servicePlanCostLabel;
    private javax.swing.JLabel spLabel;
    // End of variables declaration//GEN-END:variables
}
