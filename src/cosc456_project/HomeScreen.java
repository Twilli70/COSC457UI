package cosc456_project;

import javax.swing.*;
import ui.DatabaseEditor;
import ui.pages.ClientPage;
public class HomeScreen extends javax.swing.JFrame {
    /**
     * Creates new form homeScreen
     */
    private ClientPage clientPage = new ClientPage();
    private DatabaseEditor employeePage = new DatabaseEditor();
    private DatabaseEditor appointmentPage = new DatabaseEditor();
    private DatabaseEditor manufacturerPage = new DatabaseEditor();
    private DatabaseEditor equipmentPage = new DatabaseEditor();
    private JPanel currentPage;
    
    public HomeScreen() {
        initComponents();
        switchToPage(clientPage);
        var triton = TritonDB.getInstance();
        // Too tired, its not enough to just show the selection query
        // All the data from the clientData must be displayed + the unique data of residential and business
        // This is just a test
        try{
            var clientData = triton.executeQuery("SELECT * FROM Employees");
            employeePage.initTable(triton.getResultColumns(clientData), triton.getResultRows(clientData));
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

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manufacturerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(equipmentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appointmentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(clientBtn)
                .addGap(51, 51, 51)
                .addComponent(employeeBtn)
                .addGap(47, 47, 47)
                .addComponent(appointmentBtn)
                .addGap(64, 64, 64)
                .addComponent(manufacturerBtn)
                .addGap(57, 57, 57)
                .addComponent(equipmentBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(btnPanel);

        contentArea.setBackground(new java.awt.Color(119, 120, 119));
        contentArea.setLayout(new javax.swing.BoxLayout(contentArea, javax.swing.BoxLayout.LINE_AXIS));
        jSplitPane2.setRightComponent(contentArea);

        getContentPane().add(jSplitPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 830, 430));

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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                .addContainerGap())
        );
        tPanelLayout.setVerticalGroup(
            tPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        getContentPane().add(tPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 80));

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
    private javax.swing.JPanel tPanel;
    // End of variables declaration//GEN-END:variables
}
