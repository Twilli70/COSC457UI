/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.popups;

import cosc456_project.TritonDB;
import java.util.ArrayList;
import java.util.Hashtable;


public class EquipmentPopup extends javax.swing.JFrame {

    private Hashtable<Integer,String> manIdByIndex = new Hashtable<Integer,String>();

    public EquipmentPopup() {
        initComponents();
    }

  
      @Override
    public void setVisible(boolean visible){
        super.setVisible(visible);
        if (visible)
            updateManufacturerComboBox();
    }
    
    public void updateManufacturerComboBox(){
        manIDComboBox.removeAll();
        manIdByIndex.clear();
        var triton = TritonDB.getInstance();
        try{
           var manufacturers = new ArrayList<String>();
           var result = triton.executeQuery("SELECT mID FROM Manufacturer");
           var manufacturerIDs = triton.getResultRows(result);
           var index = 0;
           for(var row : manufacturerIDs){
               var mID = row[0];
               //var mName = "";
         
               var manData = triton.getResultRows(triton.executeQuery("SELECT mID, mName FROM Manufacturer WHERE mID = " + mID));
               if (manData != null ){
                   manIDComboBox.addItem(String.format("ManufacturerID: %s ManufacturerName: %s ", manData[0][0], manData[0][1]));
                   manIdByIndex.put(index, mID);
                   index++;
               }

           }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mLabel = new javax.swing.JLabel();
        equipmentNameField = new javax.swing.JTextField();
        eqCost = new javax.swing.JLabel();
        equipmentCostField = new javax.swing.JTextField();
        eqType = new javax.swing.JLabel();
        equipmentTypeField = new javax.swing.JTextField();
        invLabel = new javax.swing.JLabel();
        inventoryField = new javax.swing.JTextField();
        saveP = new javax.swing.JButton();
        eqLabel1 = new javax.swing.JLabel();
        manIDComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(119, 120, 119));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mLabel.setText("Manufacturer:");
        getContentPane().add(mLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        equipmentNameField.setText("jTextField1");
        getContentPane().add(equipmentNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 430, -1));

        eqCost.setText("Equipment Cost:");
        getContentPane().add(eqCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        equipmentCostField.setText("jTextField3");
        getContentPane().add(equipmentCostField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 430, -1));

        eqType.setText("Equipment Type:");
        getContentPane().add(eqType, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 10));

        equipmentTypeField.setText("jTextField4");
        getContentPane().add(equipmentTypeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 430, -1));

        invLabel.setText("Inventory:");
        getContentPane().add(invLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        inventoryField.setText("jTextField5");
        getContentPane().add(inventoryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 440, -1));

        saveP.setText("Save");
        saveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePActionPerformed(evt);
            }
        });
        getContentPane().add(saveP, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 430, 140, -1));

        eqLabel1.setText("Equipment Name:");
        getContentPane().add(eqLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        getContentPane().add(manIDComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 430, -1));
    }// </editor-fold>//GEN-END:initComponents
   public void insertIntoDB(String mID, String eName, int eCost, String eType, int eStock){        
        var triton = TritonDB.getInstance();
        var eID = triton.selectMax("Equipment", "eID") + 1;
        var insert = "INSERT INTO Equipment(mID, eID, eName, eCost, eType, eStock)\n";
        insert += String.format("VALUES('%s', '%s','%s', %d, '%s', %d)", mID, eID, eName, eCost, eType, eStock);
        System.out.print(insert);
        triton.executeUpdate(insert);
    }
    private void savePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePActionPerformed
        var triton = TritonDB.getInstance();
        var mID = manIdByIndex.get(manIDComboBox.getSelectedIndex());
        var eName = equipmentNameField.getText();
        var eCost = Integer.parseInt(equipmentCostField.getText());
        var eType = equipmentTypeField.getText();
        var eStock = Integer.parseInt(inventoryField.getText());
        insertIntoDB(mID,eName,eCost, eType, eStock);
       
        setVisible(false);
    }//GEN-LAST:event_savePActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eqCost;
    private javax.swing.JLabel eqLabel1;
    private javax.swing.JLabel eqType;
    private javax.swing.JTextField equipmentCostField;
    private javax.swing.JTextField equipmentNameField;
    private javax.swing.JTextField equipmentTypeField;
    private javax.swing.JLabel invLabel;
    private javax.swing.JTextField inventoryField;
    private javax.swing.JLabel mLabel;
    private javax.swing.JComboBox<String> manIDComboBox;
    private javax.swing.JButton saveP;
    // End of variables declaration//GEN-END:variables
}
