package ui;

import javax.swing.*;
public class HomeScreen extends javax.swing.JFrame {
    /**
     * Creates new form homeScreen
     */
    public HomeScreen() {
        initComponents();
       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnPanel = new javax.swing.JPanel();
        cBtn = new javax.swing.JButton();
        empBtn = new javax.swing.JButton();
        appBtn = new javax.swing.JButton();
        mbtn = new javax.swing.JButton();
        eBtn = new javax.swing.JButton();
        tPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        infoArea = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnPanel.setBackground(new java.awt.Color(0, 0, 0));

        cBtn.setText("Clients");
        cBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBtnActionPerformed(evt);
            }
        });

        empBtn.setText("Employees");
        empBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empBtnActionPerformed(evt);
            }
        });

        appBtn.setText("Appointments");
        appBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appBtnActionPerformed(evt);
            }
        });

        mbtn.setText("Manufacturer");
        mbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnActionPerformed(evt);
            }
        });

        eBtn.setText("Equipment");
        eBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BtnPanelLayout = new javax.swing.GroupLayout(BtnPanel);
        BtnPanel.setLayout(BtnPanelLayout);
        BtnPanelLayout.setHorizontalGroup(
            BtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(empBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                        .addComponent(eBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(appBtn))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        BtnPanelLayout.setVerticalGroup(
            BtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnPanelLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(cBtn)
                .addGap(51, 51, 51)
                .addComponent(empBtn)
                .addGap(47, 47, 47)
                .addComponent(appBtn)
                .addGap(64, 64, 64)
                .addComponent(mbtn)
                .addGap(57, 57, 57)
                .addComponent(eBtn)
                .addGap(75, 75, 75))
        );

        getContentPane().add(BtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 130, 470));

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

        infoArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(infoArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 700, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBtnActionPerformed
        if (currentPanel != clientPanel){
            infoArea.removeAll();
            infoArea.add(clientPanel);
            infoArea.repaint();
            infoArea.revalidate();
            currentPanel = clientPanel;
        }
             
    }//GEN-LAST:event_cBtnActionPerformed

    
    private void empBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empBtnActionPerformed
             if (currentPanel != employeePanel){
            infoArea.removeAll();
            infoArea.add(employeePanel);
            infoArea.repaint();
            infoArea.revalidate();
            currentPanel = employeePanel;
        }
        
    }//GEN-LAST:event_empBtnActionPerformed

    
    private void appBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appBtnActionPerformed
         if (currentPanel != appPanel){
            infoArea.removeAll();
            infoArea.add(appPanel);
            infoArea.repaint();
            infoArea.revalidate();
            currentPanel = appPanel;
    }//GEN-LAST:event_appBtnActionPerformed
  }
    
    private void mbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnActionPerformed
       if (currentPanel != manPanel){
            infoArea.removeAll();
            infoArea.add(manPanel);
            infoArea.repaint();
            infoArea.revalidate();
            currentPanel = manPanel;
    }//GEN-LAST:event_mbtnActionPerformed
  }
    
    private void eBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBtnActionPerformed
     if (currentPanel != ePanel){
            infoArea.removeAll();
            infoArea.add(ePanel);
            infoArea.repaint();
            infoArea.revalidate();
            currentPanel = ePanel;
    }//GEN-LAST:event_eBtnActionPerformed
    }

    private JPanel employeePanel = new EmpPanel();
    private JPanel clientPanel = new CPanel();
    private JPanel appPanel = new AppPanel();
    private JPanel manPanel = new ManPanel();
    private JPanel ePanel = new EPanel();
    private JPanel currentPanel;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnPanel;
    private javax.swing.JButton appBtn;
    private javax.swing.JButton cBtn;
    private javax.swing.JButton eBtn;
    private javax.swing.JButton empBtn;
    private javax.swing.JPanel infoArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mbtn;
    private javax.swing.JPanel tPanel;
    // End of variables declaration//GEN-END:variables
}
