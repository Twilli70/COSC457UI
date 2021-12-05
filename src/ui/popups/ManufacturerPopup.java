/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.popups;

import cosc456_project.TritonDB;

/**
 *
 * @author trwil
 */
public class ManufacturerPopup extends javax.swing.JFrame {

    /**
     * Creates new form cPop
     */
    public ManufacturerPopup() {
        initComponents();
    }
public void insertIntoDB(String mName){        
        var triton = TritonDB.getInstance();
        var mID = triton.selectMax("Manufacturer", "mID") + 1;
        var insert = "INSERT INTO Manufacturer(mID,mName)\n";
        insert += String.format("VALUES('%s', '%s')", mID, mName);
        System.out.print(insert);
        triton.executeUpdate(insert);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nLabel = new javax.swing.JLabel();
        manTextField = new javax.swing.JTextField();
        saveP = new javax.swing.JButton();

        setBackground(new java.awt.Color(119, 120, 119));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nLabel.setText("Name:");
        getContentPane().add(nLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 192, -1, -1));

        manTextField.setText("jTextField1");
        getContentPane().add(manTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 189, 429, -1));

        saveP.setText("Save");
        saveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePActionPerformed(evt);
            }
        });
        getContentPane().add(saveP, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 290, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void savePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePActionPerformed
         var triton = TritonDB.getInstance();
        var mName = manTextField.getText();
      
        insertIntoDB(mName);
        setVisible(false);
    }//GEN-LAST:event_savePActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField manTextField;
    private javax.swing.JLabel nLabel;
    private javax.swing.JButton saveP;
    // End of variables declaration//GEN-END:variables
}
