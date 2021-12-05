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

        sexLabel.setText("Sex:");
        getContentPane().add(sexLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 20));
        getContentPane().add(sexField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 90, -1));

        saveP.setText("Save");
        saveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePActionPerformed(evt);
            }
        });
        getContentPane().add(saveP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 140, -1));
    }// </editor-fold>//GEN-END:initComponents
public void insertIntoDB(String fName, String lName,String Sex,String Address){        
        var triton = TritonDB.getInstance();
        var empID = triton.selectMax("Employees", "empID") + 1;
        var insert = "INSERT INTO Employees(empID,fName,lName,Sex,Address)\n";
        insert += String.format("VALUES('%s', '%s','%s','%s','%s')", empID, fName, lName,Sex, Address);
        System.out.print(insert);
        triton.executeUpdate(insert);
        
}
    private void savePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePActionPerformed
        var triton = TritonDB.getInstance();
        var fName = firstNameField.getText();
        var lName = lastNameField.getText();
        var Sex = sexField.getText();
        var Address = addressField.getText();
        
        insertIntoDB(fName, lName, Sex, Address);
        setVisible(false);
    }//GEN-LAST:event_savePActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aLabel;
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel nLabel;
    private javax.swing.JButton saveP;
    private javax.swing.JTextField sexField;
    private javax.swing.JLabel sexLabel;
    // End of variables declaration//GEN-END:variables
}
