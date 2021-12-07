/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.popups;

import cosc456_project.TritonDB;
import java.util.ArrayList;
import java.util.Hashtable;

public class ClientPopup extends Popup {

    private Hashtable<Integer, String> clientIdByIndex = new Hashtable<Integer, String>();
    private String clientID;

    public ClientPopup() {
        initComponents();
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        clientTypeComboBox.setEnabled(true);

        if (visible) {
            for (var dbe : databases) {
                var db = dbe.getTable();
                var selectedRow = db.getSelectedRow();
                if (selectedRow != -1 && isEditMode) {
                    clientTypeComboBox.setEnabled(false);

                    for (var i = 0; i < db.getColumnCount(); i++) {
                        // setDataComponent is a function you need to override
                        // Once you override it you can update the fields with the new data
                        var columnName = db.getColumnName(i);
                        var cellValue = (String) db.getValueAt(selectedRow, i);
                        setDataComponent(columnName, cellValue);

                        // Store primary key(s) for later use
                        if (columnName.equals("cID")) {
                            clientID = cellValue;
                            try {
                                var triton = TritonDB.getInstance();
                                var result = triton.executeQuery("SELECT * FROM Client WHERE cID = " + cellValue);
                                var rows = triton.getResultRows(result);
                                var columns = triton.getResultColumns(result);
                                for (var j = 0; j < columns.length; j++) {
                                    setDataComponent(columns[j], rows[0][j]);
                                }
                                result = triton.executeQuery("SELECT * FROM Client_Type WHERE cID = " + cellValue);
                                rows = triton.getResultRows(result);
                                columns = triton.getResultColumns(result);
                                for (var j = 0; j < columns.length; j++) {
                                    setDataComponent(columns[j], rows[0][j]);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                }
            }

        } else if (!visible) {
            addressTextField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            emailField.setText("");
            phoneNumberField.setText("");
        }

    }

    public void setDataComponent(String columnName, String cellValue) {
        if (columnName.equals("fName") || columnName.equals("bName")) {
            firstNameField.setText(cellValue);
        } else if (columnName.equals("lName")) {
            lastNameField.setText(cellValue);
        } else if (columnName.equals("phone_number")) {
            phoneNumberField.setText(cellValue);
        } else if (columnName.equals("cADDR")) {
            addressTextField.setText(cellValue);
        } else if (columnName.equals("cEmail")) {
            emailField.setText(cellValue);
        } else if (columnName.equals("is_Res")) {
            if (cellValue.equals("1")) {
                clientTypeComboBox.setSelectedIndex(0);
            }
        } else if (columnName.equals("is_Bus")) {
            if (cellValue.equals("1")) {
                clientTypeComboBox.setSelectedIndex(1);
            }
        }

    }

    public void insertIntoDB(String phone_number, String cAddr, String cEmail) {
        var triton = TritonDB.getInstance();
        var cID = Integer.parseInt(triton.selectMax("Client", "cID")) + 1;
        var insert = "INSERT INTO Client(cID, phone_number, cAddr, cEmail)\n";
        insert += String.format("VALUES('%d', '%s', '%s', '%s')", cID, phone_number, cAddr, cEmail);
        triton.executeUpdate(insert);
    }

    public void insertIntoBDB(String cID, String bName) {
        var triton = TritonDB.getInstance();
        var insert = "INSERT INTO Business(cID, bName)\n";
        insert += String.format("VALUES('%s', '%s')", cID, bName);
        triton.executeUpdate(insert);
    }

    public void insertIntoRDB(String cID, String fName, String lName) {
        var triton = TritonDB.getInstance();
        var insert = "INSERT INTO Residential(cID, fName, lName)\n";
        insert += String.format("VALUES('%s', '%s', '%s')", cID, fName, lName);
        triton.executeUpdate(insert);
    }

    public void insertIntoClientTypeDB(String cID, boolean isResidential) {
        var triton = TritonDB.getInstance();
        int is_Bus = 0;
        int is_Res = 0;

        if (isResidential) {
            is_Res = 1;
        } else {
            is_Bus = 1;
        }

        var insert = "INSERT INTO Client_Type(cID, is_Res, is_Bus)\n";
        insert += String.format("VALUES('%s', %d, %d)", cID, is_Res, is_Bus);
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
        pnLabel = new javax.swing.JLabel();
        phoneNumberField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        clientTypeComboBox = new javax.swing.JComboBox<>();
        nLabel1 = new javax.swing.JLabel();

        setTitle("Add Client");
        setBackground(new java.awt.Color(119, 120, 119));
        setBounds(new java.awt.Rectangle(0, 0, 600, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nLabel.setText("Client Type:");
        getContentPane().add(nLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        getContentPane().add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 64, 195, -1));
        getContentPane().add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 64, 195, -1));

        aLabel.setText("Address:");
        getContentPane().add(aLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 121, -1, -1));
        getContentPane().add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 118, 494, -1));

        saveP.setText("Save");
        saveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePActionPerformed(evt);
            }
        });
        getContentPane().add(saveP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 140, -1));

        pnLabel.setText("Phone Number:");
        getContentPane().add(pnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 20));
        getContentPane().add(phoneNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 230, -1));

        emailLabel.setText("Emaill:");
        getContentPane().add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 227, -1));

        clientTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Residential", "Business" }));
        clientTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientTypeComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(clientTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 150, -1));

        nLabel1.setText("Name:");
        getContentPane().add(nLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 67, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void savePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePActionPerformed
        var phone_number = phoneNumberField.getText();
        var cAddr = addressTextField.getText();
        var cEmail = emailField.getText();
        var fName = firstNameField.getText();
        var lName = lastNameField.getText();
        var clientType = clientTypeComboBox.getSelectedIndex();
        var triton = TritonDB.getInstance();

        if (!isEditMode) {
            System.out.println(triton.selectMax("Client", "cID"));
      
            var clientInt = Integer.parseInt(triton.selectMax("Client", "cID")) + 1;
            var cID = String.format("%d", clientInt);
            var insert = "INSERT INTO Client(cID, phone_number, cAddr, cEmail)\n";
            insert += String.format("VALUES('%s', '%s', '%s', '%s')", cID, phone_number, cAddr, cEmail);
            triton.executeUpdate(insert);

            if (clientType == 0) {
                insertIntoRDB(cID, fName, lName);
                insertIntoClientTypeDB(cID, true);
            } else if (clientType == 1) {
                insertIntoBDB(cID, fName);
                insertIntoClientTypeDB(cID, false);
            }
        } else {
            var insert = "UPDATE Client\n";
            insert += String.format("SET phone_number = '%s', cADDR = '%s', cEmail = '%s'", phone_number, cAddr, cEmail);
            insert += "WHERE cID = " + clientID;
            triton.executeUpdate(insert);

            var is_Res = clientType == 0 ? "1" : "0";
            var is_Bus = clientType == 1 ? "1" : "0";
            insert = "UPDATE Client_Type\n";
            insert += String.format("SET is_Res = '%s', is_Bus = '%s'", is_Res, is_Bus);
            insert += "\nWHERE cID = " + clientID;
            triton.executeUpdate(insert);

            if (is_Res.equals("1")) {
                insert = "UPDATE Residential\n";
                insert += String.format("SET fName = '%s', lName = '%s'", fName, lName);
                insert += "\nWHERE cID = " + clientID;
                triton.executeUpdate(insert);
            } else if (is_Bus.equals("1")) {
                insert = "UPDATE Business";
                insert += String.format("SET fName = '%s', lName = '%s'", fName, lName);
                insert += "\nWHERE cID = " + clientID;
                triton.executeUpdate(insert);
            }
        }

        setVisible(false);
        save();
    }//GEN-LAST:event_savePActionPerformed

    private void clientTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientTypeComboBoxActionPerformed
        var clientType = clientTypeComboBox.getSelectedIndex();
        // If Resedential
        if (clientType == 0) {
            firstNameField.setVisible(true);
            lastNameField.setVisible(true);
        } // If Business
        else if (clientType == 1) {
            lastNameField.setVisible(false);
        }
    }//GEN-LAST:event_clientTypeComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JComboBox<String> clientTypeComboBox;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel nLabel;
    private javax.swing.JLabel nLabel1;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JLabel pnLabel;
    private javax.swing.JButton saveP;
    // End of variables declaration//GEN-END:variables
}
