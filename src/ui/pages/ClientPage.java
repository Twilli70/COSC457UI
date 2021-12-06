/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.pages;

import cosc456_project.TritonDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import ui.popups.*;
/**
 *
 * @author ezeha
 */
public class ClientPage extends javax.swing.JPanel implements IPage{

    private Hashtable<Integer,String> clientIdByIndex = new Hashtable<Integer,String>();
    
    public ClientPage() {
        
        initComponents();
        
         var triton = TritonDB.getInstance();
      
        try{
             var clientRData = triton.executeQuery("SELECT r.cID, fName, lName\nFROM Residential r, Client_Type c\n WHERE r.cID = c.cID AND c.is_Res = 1"); 
             residentialDBE.initTable(triton.getResultColumns(clientRData), triton.getResultRows(clientRData),new ClientPopup());
                            
             var clientBData = triton.executeQuery("SELECT b.cID, bName\nFROM Business b, Client_Type c\n WHERE b.cID = c.cID AND c.is_Bus =1");
             businessDBE.initTable(triton.getResultColumns(clientBData), triton.getResultRows(clientBData),new ClientPopup());
               
           
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main1 = new cosc456_project.Main();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        residentialDBE = new ui.DatabaseEditor("Residential", new String[]{"cID"});
        businessDBE = new ui.DatabaseEditor("Business", new String[]{"cID"});

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.addTab("Residential", residentialDBE);
        jTabbedPane1.addTab("Business", businessDBE);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 440));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.DatabaseEditor businessDBE;
    private javax.swing.JTabbedPane jTabbedPane1;
    private cosc456_project.Main main1;
    private ui.DatabaseEditor residentialDBE;
    // End of variables declaration//GEN-END:variables

    @Override
    public void closePopups() {
        businessDBE.closePopups();
        residentialDBE.closePopups();
    }
}

