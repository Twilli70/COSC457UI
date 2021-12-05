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
public class EmployeePopup extends javax.swing.JFrame {

    /**
     * Creates new form cPop
     */
    public EmployeePopup() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        aLabel = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        a2 = new javax.swing.JTextField();
        cLabel = new javax.swing.JLabel();
        c1 = new javax.swing.JTextField();
        sLabel = new javax.swing.JLabel();
        s1 = new javax.swing.JTextField();
        zLabel = new javax.swing.JLabel();
        zipField = new javax.swing.JTextField();
        sexLabel = new javax.swing.JLabel();
        sexField = new javax.swing.JTextField();
        saveP = new javax.swing.JButton();

        setBackground(new java.awt.Color(119, 120, 119));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nLabel.setText("Name:");
        getContentPane().add(nLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 56, -1, -1));
        getContentPane().add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 53, 195, -1));
        getContentPane().add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 53, 195, -1));

        aLabel.setText("Address:");
        getContentPane().add(aLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        addressField.setText("jTextField3");
        getContentPane().add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 107, 408, -1));

        a2.setText("jTextField7");
        getContentPane().add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 145, 408, -1));

        cLabel.setText("City:");
        getContentPane().add(cLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 213, -1, 10));

        c1.setText("jTextField4");
        getContentPane().add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 208, 197, -1));

        sLabel.setText("State:");
        getContentPane().add(sLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 264, -1, -1));

        s1.setText("jTextField5");
        getContentPane().add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 261, 197, -1));

        zLabel.setText("Zip:");
        getContentPane().add(zLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 321, -1, -1));
        getContentPane().add(zipField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 318, 197, -1));

        sexLabel.setText("Sex:");
        getContentPane().add(sexLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 369, -1, 20));
        getContentPane().add(sexField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 369, 145, -1));

        saveP.setText("Save");
        saveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePActionPerformed(evt);
            }
        });
        getContentPane().add(saveP, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 432, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void savePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePActionPerformed
        var triton = TritonDB.getInstance();
        var fName = firstNameField.getText();
        var lName = lastNameField.getText();
        var sex = sexField.getText();
        var address = addressField.getText();
        var empID = triton.selectMax("Employees", "empID") + 1;
        triton.insertStringInto("Employees", new String[]{"empID","fName", "lName", "sex", "address"}, new String[]{empID, fName, lName, sex, address});
        setVisible(false);
    }//GEN-LAST:event_savePActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a2;
    private javax.swing.JLabel aLabel;
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField c1;
    private javax.swing.JLabel cLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel nLabel;
    private javax.swing.JTextField s1;
    private javax.swing.JLabel sLabel;
    private javax.swing.JButton saveP;
    private javax.swing.JTextField sexField;
    private javax.swing.JLabel sexLabel;
    private javax.swing.JLabel zLabel;
    private javax.swing.JTextField zipField;
    // End of variables declaration//GEN-END:variables
}
