package UI_DESIGN;

public class homeScreen extends javax.swing.JFrame {
    /**
     * Creates new form homeScreen
     */
    public homeScreen() {
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
        parentPanel = new javax.swing.JPanel();
        cPanel = new javax.swing.JPanel();
        empPanel = new javax.swing.JPanel();
        appPanel = new javax.swing.JPanel();
        mPanel = new javax.swing.JPanel();
        ePanel = new javax.swing.JPanel();
        tPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

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

        parentPanel.setLayout(new java.awt.CardLayout());

        cPanel.setBackground(new java.awt.Color(20, 156, 65));

        javax.swing.GroupLayout cPanelLayout = new javax.swing.GroupLayout(cPanel);
        cPanel.setLayout(cPanelLayout);
        cPanelLayout.setHorizontalGroup(
            cPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        cPanelLayout.setVerticalGroup(
            cPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        parentPanel.add(cPanel, "card2");

        empPanel.setBackground(new java.awt.Color(217, 135, 20));

        javax.swing.GroupLayout empPanelLayout = new javax.swing.GroupLayout(empPanel);
        empPanel.setLayout(empPanelLayout);
        empPanelLayout.setHorizontalGroup(
            empPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        empPanelLayout.setVerticalGroup(
            empPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        parentPanel.add(empPanel, "card3");

        appPanel.setBackground(new java.awt.Color(250, 7, 230));

        javax.swing.GroupLayout appPanelLayout = new javax.swing.GroupLayout(appPanel);
        appPanel.setLayout(appPanelLayout);
        appPanelLayout.setHorizontalGroup(
            appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        appPanelLayout.setVerticalGroup(
            appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        parentPanel.add(appPanel, "card5");

        mPanel.setBackground(new java.awt.Color(53, 232, 226));

        javax.swing.GroupLayout mPanelLayout = new javax.swing.GroupLayout(mPanel);
        mPanel.setLayout(mPanelLayout);
        mPanelLayout.setHorizontalGroup(
            mPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        mPanelLayout.setVerticalGroup(
            mPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        parentPanel.add(mPanel, "card4");

        ePanel.setBackground(new java.awt.Color(242, 250, 7));

        javax.swing.GroupLayout ePanelLayout = new javax.swing.GroupLayout(ePanel);
        ePanel.setLayout(ePanelLayout);
        ePanelLayout.setHorizontalGroup(
            ePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        ePanelLayout.setVerticalGroup(
            ePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        parentPanel.add(ePanel, "card6");

        getContentPane().add(parentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 700, 440));

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

    private void cBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBtnActionPerformed
        parentPanel.removeAll();
        parentPanel.add(cPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_cBtnActionPerformed

    
    private void empBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empBtnActionPerformed
        parentPanel.removeAll();
        parentPanel.add(empPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_empBtnActionPerformed

    
    private void appBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appBtnActionPerformed
        parentPanel.removeAll();
        parentPanel.add(appPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_appBtnActionPerformed

    
    private void mbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnActionPerformed
        parentPanel.removeAll();
        parentPanel.add(mPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_mbtnActionPerformed

    
    private void eBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBtnActionPerformed
        parentPanel.removeAll();
        parentPanel.add(ePanel);
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_eBtnActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(homeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              new homeScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnPanel;
    private javax.swing.JButton appBtn;
    private javax.swing.JPanel appPanel;
    private javax.swing.JButton cBtn;
    private javax.swing.JPanel cPanel;
    private javax.swing.JButton eBtn;
    private javax.swing.JPanel ePanel;
    private javax.swing.JButton empBtn;
    private javax.swing.JPanel empPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mPanel;
    private javax.swing.JButton mbtn;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JPanel tPanel;
    // End of variables declaration//GEN-END:variables
}
