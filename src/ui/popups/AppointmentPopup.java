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
public class AppointmentPopup extends javax.swing.JFrame {

    /**
     * Creates new form cPop
     */
    public AppointmentPopup() {
        initComponents();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nLabel = new javax.swing.JLabel();
        n1 = new javax.swing.JTextField();
        n2 = new javax.swing.JTextField();
        aLabel = new javax.swing.JLabel();
        saveP = new javax.swing.JButton();
        sdLabel = new javax.swing.JLabel();
        edLabel = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        a2 = new javax.swing.JTextField();
        edLabel1 = new javax.swing.JLabel();
        a3 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(119, 120, 119));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nLabel.setText("Name:");
        getContentPane().add(nLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        n1.setText("jTextField1");
        getContentPane().add(n1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 64, 195, -1));

        n2.setText("jTextField2");
        getContentPane().add(n2, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 64, 195, -1));

        aLabel.setText("Address:");
        getContentPane().add(aLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

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

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 286, -1));

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 286, -1));

        a2.setText("jTextField3");
        getContentPane().add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 573, -1));

        edLabel1.setText("End Date:");
        getContentPane().add(edLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 20));

        a3.setText("jTextField3");
        getContentPane().add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 573, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void savePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePActionPerformed
        var triton = TritonDB.getInstance();
        var c_ID = "00001";
        var empID = "7783349";
        var eID = "55666";
        var aLocation = a2.getText();
        var estimate = Integer.getInteger(a3.getText());
        var sDate = jDateChooser1.getDate();
        var eDate = jDateChooser2.getDate();
        var aID = triton.selectMax("Appointment", "aID") + 1;
        //var insertion = "INSERT INTO (aId, fName, lName, sDate, eDate, aLocation, estimate)\n";
        //insertion += 
        System.out.print(String.format("VALUES(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",%d)"
                , aID, sDate, eDate,aLocation, estimate));
        triton.executeUpdate(String.format("INSERT INTO Appointment(aID, c_ID, empID, eID, sDate, eDate,aLocation, estimate)"
                + "\n VALUES(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",%d)", aID, c_ID, empID,eID, sDate, eDate,aLocation, estimate));

        setVisible(false);
    
    }//GEN-LAST:event_savePActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a2;
    private javax.swing.JTextField a3;
    private javax.swing.JLabel aLabel;
    private javax.swing.JLabel edLabel;
    private javax.swing.JLabel edLabel1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JTextField n1;
    private javax.swing.JTextField n2;
    private javax.swing.JLabel nLabel;
    private javax.swing.JButton saveP;
    private javax.swing.JLabel sdLabel;
    // End of variables declaration//GEN-END:variables
}
