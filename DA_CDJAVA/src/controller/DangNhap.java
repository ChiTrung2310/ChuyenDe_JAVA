/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mr Trung
 */
public class DangNhap extends javax.swing.JFrame {

    /**
     * Creates new form ĐangNhap
     */
    public DangNhap() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false); 
        btnChoiGame.setVisible(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\DA_CDJAVA\\build\\classes\\icon\\logo.png"));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCauChao = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAccount = new javax.swing.JTextField();
        paPass = new javax.swing.JPasswordField();
        btnDangNhap = new javax.swing.JButton();
        btnDangKy = new javax.swing.JButton();
        btnChoiGame = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMinimumSize(new java.awt.Dimension(575, 430));
        getContentPane().setLayout(null);

        lblCauChao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCauChao.setForeground(new java.awt.Color(204, 0, 204));
        lblCauChao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblCauChao);
        lblCauChao.setBounds(30, 330, 280, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pikachu.gif"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 30, 380, 340);

        txtAccount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAccount.setForeground(new java.awt.Color(153, 153, 153));
        txtAccount.setText("Account");
        txtAccount.setToolTipText("Nhập tài khoản");
        txtAccount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAccountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAccountFocusLost(evt);
            }
        });
        getContentPane().add(txtAccount);
        txtAccount.setBounds(318, 95, 202, 33);

        paPass.setToolTipText("Nhập mật khẩu");
        getContentPane().add(paPass);
        paPass.setBounds(318, 146, 202, 33);

        btnDangNhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(0, 204, 0));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setToolTipText("Nhấn để đăng nhập");
        btnDangNhap.setMaximumSize(new java.awt.Dimension(111, 25));
        btnDangNhap.setMinimumSize(new java.awt.Dimension(111, 25));
        btnDangNhap.setPreferredSize(new java.awt.Dimension(111, 25));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangNhap);
        btnDangNhap.setBounds(318, 210, 202, 37);

        btnDangKy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDangKy.setForeground(new java.awt.Color(204, 0, 204));
        btnDangKy.setText("Tạo tài khoản");
        btnDangKy.setToolTipText("Nhấn để tạo tài khoản");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangKy);
        btnDangKy.setBounds(318, 273, 202, 37);

        btnChoiGame.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnChoiGame.setForeground(new java.awt.Color(255, 0, 0));
        btnChoiGame.setText("Vào GAME");
        btnChoiGame.setToolTipText("Nhấn để bắt đầu chơi game");
        btnChoiGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoiGameActionPerformed(evt);
            }
        });
        getContentPane().add(btnChoiGame);
        btnChoiGame.setBounds(320, 330, 200, 37);
        btnChoiGame.getAccessibleContext().setAccessibleDescription("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG NHẬP");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(318, 46, 202, 22);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bg5.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 570, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        String taikhoan = txtAccount.getText();
        String matkhau = String.valueOf(paPass.getPassword());
        if(taikhoan.equals("") ||  matkhau.equals("")){
            lblCauChao.setText("Nhập thông tin tài khoản và mật khẩu");
            txtAccount.requestFocus();
        }
        else {
            lblCauChao.setText(Connect.getConnection());
            if(lblCauChao.getText().equals("")){
                String sql = "select * from USERS where UserID = ? and Pass= ?";
                PreparedStatement pstm;
            
                try{
                    pstm = Connect.conn.prepareStatement(sql);
                    pstm.setString(1, taikhoan);
                    pstm.setString(2, matkhau);
                    
                  try(ResultSet rs = pstm.executeQuery()){
                        if(rs.next()){
                            Connect.userID = txtAccount.getText();
                            String name = rs.getString("Name");
                            lblCauChao.setText("Chào bạn: "+ name);
                            Connect.name = name;
                            btnChoiGame.setVisible(true);                     
                        }
                        else
                            lblCauChao.setText("Thông tin đăng nhập không hợp lệ");
                        rs.next();
                    }
                    pstm.close();
                    Connect.conn.close();
                    
                }catch(SQLException ex){
                   lblCauChao.setText("Lỗi: "+ ex.getMessage());
                }
            }
       }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        DangKy frmDangKy = new DangKy();
        frmDangKy.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDangKyActionPerformed

    private void txtAccountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAccountFocusGained
        if(txtAccount.getText().equals("Account")){
            txtAccount.setText("");
            txtAccount.setForeground(new Color(51,0,51));
        }
    }//GEN-LAST:event_txtAccountFocusGained

    private void txtAccountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAccountFocusLost
         if(txtAccount.getText().equals("")){
            txtAccount.setText("Account");
            txtAccount.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtAccountFocusLost

    private void btnChoiGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoiGameActionPerformed
        Pikachu frmPikachu = new Pikachu();
        frmPikachu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnChoiGameActionPerformed

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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoiGame;
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCauChao;
    private javax.swing.JPasswordField paPass;
    private javax.swing.JTextField txtAccount;
    // End of variables declaration//GEN-END:variables
}
