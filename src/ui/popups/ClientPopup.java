/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.popups;

/**
 *
 * @author trwil
 */
public class ClientPopup extends javax.swing.JFrame {

    /**
     * Creates new form cPop
     */
    public ClientPopup() {
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
        a1 = new javax.swing.JTextField();
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

        a1.setText("jTextField3");
        getContentPane().add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 118, 494, -1));

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
        // TODO add your handling code here:
    }//GEN-LAST:event_busCheckBoxActionPerformed

    private void savePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePActionPerformed

    }//GEN-LAST:event_savePActionPerformed

    private void resCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resCheckBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a1;
    private javax.swing.JLabel aLabel;
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
