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
public class EquipmentPopup extends javax.swing.JFrame {

    /**
     * Creates new form cPop
     */
    public EquipmentPopup() {
        initComponents();
    }

  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eqLabel = new javax.swing.JLabel();
        eq1 = new javax.swing.JTextField();
        eqCost = new javax.swing.JLabel();
        eq2 = new javax.swing.JTextField();
        eqType = new javax.swing.JLabel();
        eq3 = new javax.swing.JTextField();
        invLabel = new javax.swing.JLabel();
        inv1 = new javax.swing.JTextField();
        saveP = new javax.swing.JButton();

        setBackground(new java.awt.Color(119, 120, 119));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eqLabel.setText("Equipment Name:");
        getContentPane().add(eqLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        eq1.setText("jTextField1");
        getContentPane().add(eq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 195, -1));

        eqCost.setText("Equipment Cost:");
        getContentPane().add(eqCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        eq2.setText("jTextField3");
        getContentPane().add(eq2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 195, -1));

        eqType.setText("Equipment Type:");
        getContentPane().add(eqType, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 10));

        eq3.setText("jTextField4");
        getContentPane().add(eq3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 197, -1));

        invLabel.setText("Inventory:");
        getContentPane().add(invLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        inv1.setText("jTextField5");
        getContentPane().add(inv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 197, -1));

        saveP.setText("Save");
        saveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePActionPerformed(evt);
            }
        });
        getContentPane().add(saveP, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 430, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void savePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePActionPerformed
          var triton = TritonDB.getInstance();
        var eName = eq1.getText();
        var eCost = eq2.getText();
        var eType = eq3.getText();
        var eStock = inv1.getText();
        var eID = triton.selectMax("Equipment", "eID") + 1;
        
        triton.executeUpdate(String.format("INSERT INTO (eId, eName, eCost, eType, eStock)\n VALUES(%s,%s,%d,%s,%d)",eName, eID, eCost, eType, eStock));
       
        setVisible(false);
    }//GEN-LAST:event_savePActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField eq1;
    private javax.swing.JTextField eq2;
    private javax.swing.JTextField eq3;
    private javax.swing.JLabel eqCost;
    private javax.swing.JLabel eqLabel;
    private javax.swing.JLabel eqType;
    private javax.swing.JTextField inv1;
    private javax.swing.JLabel invLabel;
    private javax.swing.JButton saveP;
    // End of variables declaration//GEN-END:variables
}
