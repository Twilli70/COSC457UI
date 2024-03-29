/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cosc456_project;

/**
 *
 * @author trwil
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topIMG = new javax.swing.JLabel();
        loginBox = new javax.swing.JPanel();
        uLabel = new javax.swing.JLabel();
        pLabel = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        userNameField1 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();

        setTitle("Login");
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(0, 0, 700, 700));
        setForeground(java.awt.Color.white);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cosc456_project/pic/New02-300x100.png"))); // NOI18N
        getContentPane().add(topIMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 131));

        loginBox.setBackground(new java.awt.Color(154, 156, 154));
        loginBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        uLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        uLabel.setText("Username:");

        pLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pLabel.setText("Password:");

        userNameField.setBackground(new java.awt.Color(250, 250, 250));

        userNameField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        userNameField1.setText("Account Login");

        loginBtn.setBackground(new java.awt.Color(250, 250, 250));
        loginBtn.setText("LOG IN");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginBoxLayout = new javax.swing.GroupLayout(loginBox);
        loginBox.setLayout(loginBoxLayout);
        loginBoxLayout.setHorizontalGroup(
            loginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginBoxLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(loginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(loginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginBoxLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(loginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginBoxLayout.createSequentialGroup()
                        .addComponent(userNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginBoxLayout.createSequentialGroup()
                        .addComponent(loginBtn)
                        .addContainerGap())))
        );
        loginBoxLayout.setVerticalGroup(
            loginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(uLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(pLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(loginBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 199, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        var triton = TritonDB.getInstance();
        try {
            var result = triton.executeQuery("SELECT username, password FROM AdminLogin");
            var rows = triton.getResultRows(result);
            for (var r : rows) {
                if (userNameField.getText().equals(r[0]) && passwordField.getText().equals(r[1])) {
                    var homeScreen = new HomeScreen();
                    homeScreen.setVisible(true);
                    setVisible(false);
                    break;
                }
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_loginBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel loginBox;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel pLabel;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel topIMG;
    private javax.swing.JLabel uLabel;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel userNameField1;
    // End of variables declaration//GEN-END:variables
}
