/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.popups;

import cosc456_project.TritonDB;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author trwil
 */
public class ServiceplanPopup extends Popup {

    /**
     * Creates new form cPop
     */
    private String cID;
    private String sDatePk;
    private Hashtable<Integer, String> clientIdByIndex = new Hashtable<Integer, String>();

    public ServiceplanPopup() {
        initComponents();
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            clientComboBox.setEnabled(true);
            startDateChooser.setEnabled(true);
            updateClientComboBox();
            var db = databases.get(0).getTable();
            var selectedRow = db.getSelectedRow();
            if (selectedRow != -1 && isEditMode) {
                clientComboBox.setEnabled(false);
                startDateChooser.setEnabled(false);
                for (var i = 0; i < db.getColumnCount(); i++) {
                    // setDataComponent is a function you need to override
                    // Once you override it you can update the fields with the new data
                    var columnName = db.getColumnName(i);
                    var cellValue = (String) db.getValueAt(selectedRow, i);
                    setDataComponent(columnName, cellValue);

                    // Store primary key(s) for later use
                    if (columnName.equals("cID")) {
                        cID = cellValue;
                    } else if (columnName.equals("sDate")) {
                        sDatePk = cellValue;
                    }
                }
            }
        }
        if (!visible) {
            servicePlanCostField.setText("");
        }
    }

    @Override
    public void setDataComponent(String columnName, String cellValue) {
        if (columnName.equals("cID")) {
            for (var i = 0; i < billCycleComboBox.getItemCount(); i++) {
                if (clientIdByIndex.get(i).equals(cellValue)) {
                    billCycleComboBox.setSelectedIndex(i);
                    break;
                }
            }
        } else if (columnName.equals("billCycle")) {
            for (var i = 0; i < billCycleComboBox.getItemCount(); i++) {
                if (billCycleComboBox.getItemAt(i).equals(cellValue)) {
                    billCycleComboBox.setSelectedIndex(i);
                    break;
                }
            }
        } else if (columnName.equals("price")) {
            servicePlanCostField.setText(cellValue);
        } else if (columnName.equals("sDate")) {
            try {
                startDateChooser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(cellValue));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (columnName.equals("eDate")) {
            try {
                endDateChooser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(cellValue));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void insertToDB(String cID, String sDateString, String eDateString, int price, String billCycle) {
        var triton = TritonDB.getInstance();
        var insert = "INSERT INTO Service_Plan(cID, sDate, eDate, price, billCycle)";
        insert += String.format("VALUES('%s', '%s', '%s', %d, '%s')", cID, sDateString, eDateString, price, billCycle);
        triton.executeUpdate(insert);
    }

    public void updateClientComboBox() {
        clientComboBox.removeAll();
        clientIdByIndex.clear();
        var triton = TritonDB.getInstance();
        try {
            var result = triton.executeQuery("SELECT cID FROM Client");
            var clientIDs = triton.getResultRows(result);
            var index = 0;
            for (var row : clientIDs) {
                var cID = row[0];
                var idType = triton.getResultRows(triton.executeQuery("SELECT is_Res, is_Bus FROM Client_Type WHERE cID = " + cID));
                var isResidential = idType[0][0].equals("1");
                var isBusiness = idType[0][1].equals("1");
                var clientName = "";

                if (isResidential) {
                    var resNameRows = triton.getResultRows(triton.executeQuery("SELECT fName, lName FROM Residential WHERE cID = " + cID));
                    var firstName = resNameRows[0][0];
                    var lastName = resNameRows[0][1];
                    clientName = firstName + " " + lastName;
                } else if (isBusiness) {
                    var resNameRows = triton.getResultRows(triton.executeQuery("SELECT bName FROM Business WHERE cID = " + cID));
                    var bName = resNameRows[0][0] + " (business)";
                    clientName = bName;
                }
                if (!clientName.isEmpty()) {
                    clientComboBox.addItem(clientName);
                    clientIdByIndex.put(index, cID);
                    index++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sdlabel = new javax.swing.JLabel();
        saveP = new javax.swing.JButton();
        edLabel = new javax.swing.JLabel();
        spLabel = new javax.swing.JLabel();
        servicePlanCostField = new javax.swing.JTextField();
        bclabel1 = new javax.swing.JLabel();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        endDateChooser = new com.toedter.calendar.JDateChooser();
        sdlabel1 = new javax.swing.JLabel();
        clientComboBox = new javax.swing.JComboBox<>();
        billCycleComboBox = new javax.swing.JComboBox<>();

        setTitle("Add Service Plan");
        setBackground(new java.awt.Color(119, 120, 119));
        setBounds(new java.awt.Rectangle(0, 0, 600, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sdlabel.setText("Client:");
        getContentPane().add(sdlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        saveP.setText("Save");
        saveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePActionPerformed(evt);
            }
        });
        getContentPane().add(saveP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 140, -1));

        edLabel.setText("End Date:");
        getContentPane().add(edLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 130, -1, -1));

        spLabel.setText("Service Plan Cost:");
        getContentPane().add(spLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        servicePlanCostField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicePlanCostFieldActionPerformed(evt);
            }
        });
        getContentPane().add(servicePlanCostField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 170, -1));

        bclabel1.setText("Bill Cycle:");
        getContentPane().add(bclabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        startDateChooser.setDateFormatString("yyyy-MM-dd ");
        getContentPane().add(startDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 120, -1));

        endDateChooser.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(endDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 120, -1));

        sdlabel1.setText("Start Date:");
        getContentPane().add(sdlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 76, -1, -1));

        getContentPane().add(clientComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 220, -1));

        billCycleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anually", "Quarterly" }));
        getContentPane().add(billCycleComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 280, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void servicePlanCostFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicePlanCostFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicePlanCostFieldActionPerformed

    private void savePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePActionPerformed
        var cID = clientIdByIndex.get(clientComboBox.getSelectedIndex());
        var sDate = startDateChooser.getDate();
        var eDate = endDateChooser.getDate();
        var price = Integer.parseInt(servicePlanCostField.getText());
        var billCycle = (String) billCycleComboBox.getSelectedItem();
        var sDateString = String.format("%d-%d-%d", sDate.getYear() + 1900, sDate.getMonth(), sDate.getDay());
        var eDateString = String.format("%d-%d-%d", eDate.getYear() + 1900, eDate.getMonth(), eDate.getDay());

        if (!isEditMode) {
            insertToDB(cID, sDateString, eDateString, price, billCycle);
        }
        else if (isEditMode) {
            var triton = TritonDB.getInstance();
            var insert = "UPDATE Service_Plan\n";
            insert += String.format("SET eDate = '%s', price = %d, billCycle = '%s'", eDateString, price, billCycle);
            insert += "\nWHERE cID = " + cID;
            insert += " AND sDate = '" + sDatePk + "'";
            triton.executeUpdate(insert);
        }
        setVisible(false);
        save();
    }//GEN-LAST:event_savePActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bclabel1;
    private javax.swing.JComboBox<String> billCycleComboBox;
    private javax.swing.JComboBox<String> clientComboBox;
    private javax.swing.JLabel edLabel;
    private com.toedter.calendar.JDateChooser endDateChooser;
    private javax.swing.JButton saveP;
    private javax.swing.JLabel sdlabel;
    private javax.swing.JLabel sdlabel1;
    private javax.swing.JTextField servicePlanCostField;
    private javax.swing.JLabel spLabel;
    private com.toedter.calendar.JDateChooser startDateChooser;
    // End of variables declaration//GEN-END:variables

}
