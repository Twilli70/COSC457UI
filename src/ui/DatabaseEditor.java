/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ezeha
 */
public class DatabaseEditor extends javax.swing.JPanel {

    /**
     * Creates new form DatabaseView
     */
    public DatabaseEditor() {
        initComponents();
    }
    
    public void initTable(String[] columnNames, Object[][] rows){
        dbTable.setModel(new DefaultTableModel(rows, columnNames));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentArea = new javax.swing.JPanel();
        TableScroll = new javax.swing.JScrollPane();
        dbTable = new javax.swing.JTable();
        Add = new javax.swing.JButton();
        Remove = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contentArea.setBackground(new java.awt.Color(119, 120, 119));
        contentArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        contentArea.add(TableScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 640, 370));

        Add.setText("Add");
        contentArea.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 80, -1));

        Remove.setText("Remove");
        contentArea.add(Remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 80, -1));

        add(contentArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 430));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Remove;
    private javax.swing.JScrollPane TableScroll;
    private javax.swing.JPanel contentArea;
    private javax.swing.JTable dbTable;
    // End of variables declaration//GEN-END:variables
}