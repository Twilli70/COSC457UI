/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.pages;

import cosc456_project.TritonDB;

/**
 *
 * @author ezeha
 */
public class ClientPage extends javax.swing.JPanel {

    /**
     * Creates new form ClientPage
     */
    public ClientPage() {
        initComponents();
        var triton = TritonDB.getInstance();
        // Too tired, its not enough to just show the selection query
        // All the data from the clientData must be displayed + the unique data of residential and business
        // This is just a test
        try{
            var clientData = triton.executeQuery("SELECT * FROM Client");
            residentialDBE.initTable(triton.getResultColumns(clientData), triton.getResultRows(clientData));
        }
        catch (Exception e){
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

        main1 = new cosc456_project.Main();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        residentialDBE = new ui.DatabaseEditor();
        businessDBE = new ui.DatabaseEditor();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.addTab("Residential", residentialDBE);
        jTabbedPane1.addTab("Business", businessDBE);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.DatabaseEditor businessDBE;
    private javax.swing.JTabbedPane jTabbedPane1;
    private cosc456_project.Main main1;
    private ui.DatabaseEditor residentialDBE;
    // End of variables declaration//GEN-END:variables
}