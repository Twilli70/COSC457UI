package cosc456_project;

import javax.swing.*;
import ui.DatabaseEditor;
import ui.pages.ClientPage;
import ui.popups.*;
public class HomeScreen extends javax.swing.JFrame {
    /**
     * Creates new form homeScreen
     */
    private ClientPage clientPage = new ClientPage();
    private DatabaseEditor employeePage = new DatabaseEditor("Employees", new String[]{"empID"});
    private DatabaseEditor appointmentPage = new DatabaseEditor("Appointment", new String[]{"aID"});
    private DatabaseEditor manufacturerPage = new DatabaseEditor("Manufacturer", new String[]{"mID"});
    private DatabaseEditor equipmentPage = new DatabaseEditor("Equipment", new String[]{"eID"});
    private DatabaseEditor transactionPage = new DatabaseEditor("Transactions", new String[]{"tID"});
    private DatabaseEditor servicePlanPage = new DatabaseEditor("Service_Plan", new String[]{"cId, sDate"});
    private JPanel currentPage;
    
    public HomeScreen() {
        initComponents();
        switchToPage(clientPage);
        
        var triton = TritonDB.getInstance();
        try{
            var employeeData = triton.executeQuery("SELECT * FROM Employees");
            employeePage.initTable(triton.getResultColumns(employeeData), triton.getResultRows(employeeData), new EmployeePopup());
            
            var appointmentData = triton.executeQuery("SELECT * FROM Appointment");
            appointmentPage.initTable(triton.getResultColumns(appointmentData), triton.getResultRows(appointmentData), new AppointmentPopup());
            
            var manufacturerData = triton.executeQuery("SELECT * FROM Manufacturer");
            manufacturerPage.initTable(triton.getResultColumns(manufacturerData), triton.getResultRows(manufacturerData), new ManufacturerPopup());
            
            var equipmentData = triton.executeQuery("SELECT * FROM Equipment");
            equipmentPage.initTable(triton.getResultColumns(equipmentData), triton.getResultRows(equipmentData), new EquipmentPopup());
            
            var transactionData = triton.executeQuery("SELECT * FROM Transactions");
            transactionPage.initTable(triton.getResultColumns(transactionData), triton.getResultRows(transactionData), new TransactionPopup());
            
            var servicePlanData = triton.executeQuery("SELECT * FROM Service_Plan");
            servicePlanPage.initTable(triton.getResultColumns(servicePlanData), triton.getResultRows(servicePlanData), new ServiceplanPopup());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void switchToPage(JPanel newPage){
        if(currentPage != newPage){
            contentArea.removeAll();
            contentArea.add(newPage);
            contentArea.repaint();
            contentArea.revalidate();
            currentPage = newPage;
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        btnPanel = new javax.swing.JPanel();
        clientBtn = new javax.swing.JButton();
        employeeBtn = new javax.swing.JButton();
        appointmentBtn = new javax.swing.JButton();
        manufacturerBtn = new javax.swing.JButton();
        equipmentBtn = new javax.swing.JButton();
        transactionBtn = new javax.swing.JButton();
        servicePlanBtn = new javax.swing.JButton();
        contentArea = new javax.swing.JPanel();
        tPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSplitPane2.setBorder(null);

        btnPanel.setBackground(new java.awt.Color(0, 0, 0));

        clientBtn.setText("Clients");
        clientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientBtnActionPerformed(evt);
            }
        });

        employeeBtn.setText("Employees");
        employeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeBtnActionPerformed(evt);
            }
        });

        appointmentBtn.setText("Appointments");
        appointmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentBtnActionPerformed(evt);
            }
        });

        manufacturerBtn.setText("Manufacturer");
        manufacturerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufacturerBtnActionPerformed(evt);
            }
        });

        equipmentBtn.setText("Equipment");
        equipmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipmentBtnActionPerformed(evt);
            }
        });

        transactionBtn.setText("Transaction");
        transactionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionBtnActionPerformed(evt);
            }
        });

        servicePlanBtn.setText("Service Plan");
        servicePlanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicePlanBtnActionPerformed(evt);
            }
        });

        contentArea.setBackground(new java.awt.Color(119, 120, 119));
        contentArea.setLayout(new javax.swing.BoxLayout(contentArea, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(servicePlanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transactionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manufacturerBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(equipmentBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appointmentBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(contentArea, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(clientBtn)
                .addGap(37, 37, 37)
                .addComponent(employeeBtn)
                .addGap(41, 41, 41)
                .addComponent(appointmentBtn)
                .addGap(35, 35, 35)
                .addComponent(equipmentBtn)
                .addGap(39, 39, 39)
                .addComponent(manufacturerBtn)
                .addGap(41, 41, 41)
                .addComponent(transactionBtn)
                .addGap(40, 40, 40)
                .addComponent(servicePlanBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(contentArea, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane2.setLeftComponent(btnPanel);

        getContentPane().add(jSplitPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 900, 490));

        tPanel.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("UCDI Security Inc.");

        javax.swing.GroupLayout tPanelLayout = new javax.swing.GroupLayout(tPanel);
        tPanel.setLayout(tPanelLayout);
        tPanelLayout.setHorizontalGroup(
            tPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        tPanelLayout.setVerticalGroup(
            tPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        getContentPane().add(tPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientBtnActionPerformed
        switchToPage(clientPage);
    }//GEN-LAST:event_clientBtnActionPerformed

    private void employeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeBtnActionPerformed
        switchToPage(employeePage);
    }//GEN-LAST:event_employeeBtnActionPerformed

    private void appointmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentBtnActionPerformed
        switchToPage(appointmentPage);
    }//GEN-LAST:event_appointmentBtnActionPerformed

    private void manufacturerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufacturerBtnActionPerformed
        switchToPage(manufacturerPage);
    }//GEN-LAST:event_manufacturerBtnActionPerformed

    private void equipmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipmentBtnActionPerformed
        switchToPage(equipmentPage);
    }//GEN-LAST:event_equipmentBtnActionPerformed

    private void transactionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionBtnActionPerformed
        switchToPage(transactionPage);
    }//GEN-LAST:event_transactionBtnActionPerformed

    private void servicePlanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicePlanBtnActionPerformed
     switchToPage(servicePlanPage);
    }//GEN-LAST:event_servicePlanBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton appointmentBtn;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton clientBtn;
    private javax.swing.JPanel contentArea;
    private javax.swing.JButton employeeBtn;
    private javax.swing.JButton equipmentBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JButton manufacturerBtn;
    private javax.swing.JButton servicePlanBtn;
    private javax.swing.JPanel tPanel;
    private javax.swing.JButton transactionBtn;
    // End of variables declaration//GEN-END:variables
}
