/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import cosc456_project.TritonDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.pages.IPage;
import ui.popups.Popup;

/**
 *
 * @author ezeha
 */
public class DatabaseEditor extends javax.swing.JPanel implements IPage {

    /**
     * Creates new form DatabaseView
     */
    private Popup addDataWindow;
    private String[] primaryKeys;
    private String tableName;
    private String populationStatement;

    public DatabaseEditor() {

    }

    public DatabaseEditor(String tabName, String[] pK) {
        initComponents();
        primaryKeys = pK;
        tableName = tabName;
    }

    public void updateTable() {
        var triton = TritonDB.getInstance();
        try {
            var result = triton.executeQuery(populationStatement);
            var rows = triton.getResultRows(result);
            var columnNames = triton.getResultColumns(result);

            dbTable.setModel(new DefaultTableModel(rows, columnNames));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initTable(Popup popupWindow, String popStatement) {
        populationStatement = popStatement;
        addDataWindow = popupWindow;
        addDataWindow.addDatabaseEditor(this);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                addDataWindow.setVisible(true);
                addDataWindow.isEditMode = false;
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (dbTable.getSelectedRow() != -1) {
                    addDataWindow.setVisible(true);
                    addDataWindow.isEditMode = true;
                }
            }
        });
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TableScroll = new javax.swing.JScrollPane();
        dbTable = new javax.swing.JTable();
        editButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dbTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableScroll.setViewportView(dbTable);

        add(TableScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 640, 370));

        editButton.setText("Edit");
        add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 80, -1));

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        add(removeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 80, -1));

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 80, -1));
    }// </editor-fold>//GEN-END:initComponents
    private String getDeleteStatement() {
        var deleteStatement = "DELETE FROM " + tableName + " WHERE ";
        var primaryKeyCount = 0;
        int selectRow = dbTable.getSelectedRow();
        for (int i = 0; i < dbTable.getColumnCount(); i++) {
            for (var pk : primaryKeys) {
                dbTable.getColumnName(i);
                if (pk.equals(dbTable.getColumnName(i))) {
                    deleteStatement += pk + "=" + dbTable.getValueAt(selectRow, i);
                    primaryKeyCount++;
                    if (primaryKeyCount < primaryKeys.length) {
                        deleteStatement += " AND ";
                    }
                }
            }
        }
        return deleteStatement;
    }
    
    public JTable getTable(){
        return dbTable;
    }

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int selectRow = dbTable.getSelectedRow();
        var triton = TritonDB.getInstance();
        try {
            triton.executeUpdate(getDeleteStatement());

        } catch (Exception e) {
            e.printStackTrace();
        }
        updateTable();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane TableScroll;
    private javax.swing.JButton addButton;
    private javax.swing.JTable dbTable;
    private javax.swing.JButton editButton;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void closePopups() {
        addDataWindow.setVisible(false);
    }
}
