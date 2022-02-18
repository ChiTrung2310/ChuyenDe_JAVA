/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import jaco.mp3.player.MP3Player;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


/**
 *
 * @author Mr Trung
 */
public class DanhTuXi extends javax.swing.JFrame {
    int may, nguoi, diemMay = 0, diemNguoi = 0;
    String kQ = "";
    Date date = java.util.Calendar.getInstance().getTime();
    static int maxDiem = 3; //--Mặc định là 3 điểm người chơi có thể chỉnh lên số điểm cao hơn ở combobox
    private String StandardCharsets;


    /**
     * Creates new form DanhTuXi
     */
    public DanhTuXi() {
        initComponents();
        khoiDong();
        xuLiHinh();
        mP3Player.play();

        
    }
    
    //---Nhạc nền game
     public static final String SONG =("D:\\DA_CDJAVA\\Music\\Vexento.mp3");
        MP3Player mP3Player = new MP3Player(new File(SONG));
        
    //---Nhạc khi chiến thắng
     public static final String SONGWIN =("D:\\DA_CDJAVA\\Music\\thang.mp3");
        MP3Player mP3Playerwin = new MP3Player(new File(SONGWIN));
       
    //---Nhạc khi thua
     public static final String SONGLOSE =("D:\\DA_CDJAVA\\Music\\thua.mp3");
        MP3Player mP3Playerlose = new MP3Player(new File(SONGLOSE));
    
    public void xuLiHinh(){
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\DA_CDJAVA\\build\\classes\\icon\\bua1.png"));
       
    }
    
    public void khoiDong(){
        setLocationRelativeTo(null);
        lblNam.setVisible(true);
        lblNu.setVisible(false);
        lblKeoN.setVisible(false);
        lblBuaN.setVisible(false);
        lblBaoN.setVisible(false); 
        lblKeoM.setVisible(false);
        lblBuaM.setVisible(false);
        lblBaoM.setVisible(false); 
        lblThua.setVisible(false); 
        lblThang.setVisible(false); 
        lblHoa.setVisible(false); 
        setResizable(false); 
    }
    
    public void scaleImageLabel(String imgPath, JLabel lbl){
        ImageIcon icon = new ImageIcon(getClass().getResource(imgPath));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleIcon = new ImageIcon(imgScale);
        lbl.setIcon(scaleIcon);     
    }
    
    public void ghiFile() throws IOException {
        kQ = diemMay > diemNguoi ? "May thang" : "Ban thang";
        
        String dataString = Integer.toString(diemMay) + "\t" + Integer.toString(diemNguoi) + "\t" + kQ + "\t" + date + "\n";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("LichSuGameOanTuTi.txt",true))){
            bw.write(dataString);
            bw.close();
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        lblMay = new javax.swing.JLabel();
        lblBuaN = new javax.swing.JLabel();
        lblKeoN = new javax.swing.JLabel();
        lblBaoN = new javax.swing.JLabel();
        cboGioiTinh = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnKeo = new javax.swing.JButton();
        btnBua = new javax.swing.JButton();
        btnBao = new javax.swing.JButton();
        lblNam = new javax.swing.JLabel();
        lblNu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cboDiem = new javax.swing.JComboBox<>();
        lblBuaM = new javax.swing.JLabel();
        lblBaoM = new javax.swing.JLabel();
        lblKeoM = new javax.swing.JLabel();
        lblKQN = new javax.swing.JLabel();
        lblKQM = new javax.swing.JLabel();
        lblHoa = new javax.swing.JLabel();
        lblThang = new javax.swing.JLabel();
        lblThua = new javax.swing.JLabel();
        txtDiemMay = new javax.swing.JTextField();
        txtDiemBan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuThongTin = new javax.swing.JMenu();
        menuHuongDan = new javax.swing.JMenu();
        menuLichSu = new javax.swing.JMenu();
        menuThoat = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Game Oẳn Tú Xì");
        setMinimumSize(new java.awt.Dimension(760, 639));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lblMay.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\ghost.png")); // NOI18N
        getContentPane().add(lblMay);
        lblMay.setBounds(70, 230, 110, 100);

        lblBuaN.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\bua.png")); // NOI18N
        lblBuaN.setPreferredSize(new java.awt.Dimension(95, 91));
        getContentPane().add(lblBuaN);
        lblBuaN.setBounds(480, 210, 95, 118);

        lblKeoN.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\keo.png")); // NOI18N
        getContentPane().add(lblKeoN);
        lblKeoN.setBounds(480, 210, 95, 118);

        lblBaoN.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\bao.png")); // NOI18N
        lblBaoN.setPreferredSize(new java.awt.Dimension(95, 91));
        getContentPane().add(lblBaoN);
        lblBaoN.setBounds(480, 210, 95, 118);

        cboGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cboGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioiTinhActionPerformed(evt);
            }
        });
        getContentPane().add(cboGioiTinh);
        cboGioiTinh.setBounds(170, 10, 70, 26);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Giới tính");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(100, 10, 60, 20);

        btnKeo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\keo.png")); // NOI18N
        btnKeo.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                btnKeoComponentAdded(evt);
            }
        });
        btnKeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeoActionPerformed(evt);
            }
        });
        getContentPane().add(btnKeo);
        btnKeo.setBounds(190, 350, 102, 111);

        btnBua.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\bua.png")); // NOI18N
        btnBua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnBua);
        btnBua.setBounds(340, 350, 100, 111);

        btnBao.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\bao.png")); // NOI18N
        btnBao.setMaximumSize(new java.awt.Dimension(127, 111));
        btnBao.setMinimumSize(new java.awt.Dimension(127, 111));
        btnBao.setPreferredSize(new java.awt.Dimension(127, 111));
        btnBao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaoActionPerformed(evt);
            }
        });
        getContentPane().add(btnBao);
        btnBao.setBounds(480, 350, 100, 111);

        lblNam.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\man1.png")); // NOI18N
        getContentPane().add(lblNam);
        lblNam.setBounds(590, 220, 110, 110);

        lblNu.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\nu1.png")); // NOI18N
        getContentPane().add(lblNu);
        lblNu.setBounds(590, 220, 110, 110);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Chế độ chơi");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(480, 10, 90, 20);

        cboDiem.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboDiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3 điểm", "5 điểm", "10 điểm", "20 điểm", "50 điểm" }));
        cboDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDiemActionPerformed(evt);
            }
        });
        getContentPane().add(cboDiem);
        cboDiem.setBounds(580, 10, 100, 26);

        lblBuaM.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\bua.png")); // NOI18N
        lblBuaM.setPreferredSize(new java.awt.Dimension(95, 91));
        getContentPane().add(lblBuaM);
        lblBuaM.setBounds(190, 220, 95, 118);

        lblBaoM.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\bao.png")); // NOI18N
        lblBaoM.setPreferredSize(new java.awt.Dimension(95, 91));
        getContentPane().add(lblBaoM);
        lblBaoM.setBounds(190, 220, 95, 118);

        lblKeoM.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\keo.png")); // NOI18N
        getContentPane().add(lblKeoM);
        lblKeoM.setBounds(190, 220, 95, 118);

        lblKQN.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblKQN.setText("Điểm bạn:");
        getContentPane().add(lblKQN);
        lblKQN.setBounds(580, 170, 80, 20);

        lblKQM.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblKQM.setText("Điểm máy:");
        getContentPane().add(lblKQM);
        lblKQM.setBounds(40, 170, 80, 20);

        lblHoa.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\hoa.png")); // NOI18N
        getContentPane().add(lblHoa);
        lblHoa.setBounds(320, 200, 120, 110);

        lblThang.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\win.png")); // NOI18N
        getContentPane().add(lblThang);
        lblThang.setBounds(330, 200, 110, 110);

        lblThua.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mr Trung\\Documents\\NetBeansProjects\\Swing\\images\\thua.png")); // NOI18N
        getContentPane().add(lblThua);
        lblThua.setBounds(330, 200, 110, 110);

        txtDiemMay.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDiemMay.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(txtDiemMay);
        txtDiemMay.setBounds(130, 170, 50, 26);

        txtDiemBan.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDiemBan.setForeground(new java.awt.Color(204, 0, 204));
        getContentPane().add(txtDiemBan);
        txtDiemBan.setBounds(660, 170, 50, 26);
        txtDiemBan.getAccessibleContext().setAccessibleName("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("OẲN TÙ TÌ RA CÁI GÌ ???");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(230, 90, 310, 40);

        menuThongTin.setText("Thông tin");
        menuThongTin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuThongTinMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuThongTin);

        menuHuongDan.setText("Hướng dẫn");
        menuHuongDan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuHuongDan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHuongDanMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuHuongDan);

        menuLichSu.setText("Lịch sử");
        menuLichSu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuLichSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLichSuMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuLichSu);

        menuThoat.setForeground(new java.awt.Color(255, 0, 51));
        menuThoat.setText("Thoát");
        menuThoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menuThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuThoatMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuThoat);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void mayChon(){
        may = (int) (Math.random()*3)+1;
        switch(may){
            case 1: //--Kéo  
                lblBaoM.setVisible(false);
                lblBuaM.setVisible(false);
                lblKeoM.setVisible(true);
                break;
                
            case 2: //--Búa    
                lblBaoM.setVisible(false);
                lblBuaM.setVisible(true);
                lblKeoM.setVisible(false);
                break;
                
            case 3: //--Bao
                lblBaoM.setVisible(true);
                lblBuaM.setVisible(false);
                lblKeoM.setVisible(false);
                break;
                
        }
    }
    
    public void ketQua(){
        switch(may){
            case 1: //--Kéo
                switch(nguoi){
                    case 1:
                        lblThua.setVisible(false); 
                        lblHoa.setVisible(true);
                        lblThang.setVisible(false);
                        break; //-Kéo
                       
                    case 2:
                        lblThua.setVisible(false); 
                        lblHoa.setVisible(false);
                        lblThang.setVisible(true);
                        txtDiemBan.setText(Integer.toString(++diemNguoi));
                        break; //-Búa
                        
                    case 3:
                        lblThua.setVisible(true); 
                        lblHoa.setVisible(false);
                        lblThang.setVisible(false);
                        txtDiemMay.setText(Integer.toString(++diemMay));
                        break; //-Bao
                }
                break;
                
            case 2: //--Búa
               switch(nguoi){
                    case 1:
                        lblThua.setVisible(true); 
                        lblHoa.setVisible(false);
                        lblThang.setVisible(false);
                        txtDiemMay.setText(Integer.toString(++diemMay));
                        break; //-Kéo
                       
                    case 2:
                        lblThua.setVisible(false); 
                        lblHoa.setVisible(true);
                        lblThang.setVisible(false);
                        break; //-Búa
                        
                    case 3:
                        lblThua.setVisible(false); 
                        lblHoa.setVisible(false);
                        lblThang.setVisible(true);
                        txtDiemBan.setText(Integer.toString(++diemNguoi));
                        break; //-Bao
                }
                break; 
                
            case 3: //--Bao
                switch(nguoi){
                    case 1:
                        lblThua.setVisible(false); 
                        lblHoa.setVisible(false);
                        lblThang.setVisible(true);
                        txtDiemBan.setText(Integer.toString(++diemNguoi));
                        break; //-Kéo
                       
                    case 2:
                        lblThua.setVisible(true); 
                        lblHoa.setVisible(false);
                        lblThang.setVisible(false);
                        txtDiemMay.setText(Integer.toString(++diemMay));
                        break; //-Búa
                        
                    case 3:
                        lblThua.setVisible(false); 
                        lblHoa.setVisible(true);
                        lblThang.setVisible(false);
                        break; //-Bao
                }
                break;
        }
        
        if(diemMay == maxDiem || diemNguoi == maxDiem){
            try{
                ghiFile();
            }catch(IOException ex){
                Logger.getLogger(DanhTuXi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int chon = JOptionPane.YES_OPTION;
            if(diemMay == maxDiem){
                mP3Player.pause();
                mP3Playerlose.play();
                chon = JOptionPane.showConfirmDialog(null, "MÁY THẮNG !!! \nBạn có muốn chơi nữa không","Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);              
                
            }
            
            else if(diemNguoi == maxDiem){
                mP3Player.pause();
                mP3Playerwin.play();
                chon = JOptionPane.showConfirmDialog(null, "BẠN THẮNG !!! \nBạn có muốn chơi nữa không","Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);               
     
            }
            
            if(chon == JOptionPane.NO_OPTION){
//                System.exit(0);
                  this.dispose();
                  Pikachu frmPikachu = new Pikachu();
                  frmPikachu.setVisible(true);
                
            }else if(chon == JOptionPane.YES_OPTION){
                diemMay = diemNguoi = 0;
                txtDiemMay.setText("0");
                txtDiemBan.setText("0");
                kQ = "";
                mP3Player.play();  //--Phát lại nhạc nền khi tiếp tục chơi game
                khoiDong();    
            }
            
        }      
    }
       
    private void cboGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGioiTinhActionPerformed
        if(cboGioiTinh.getSelectedItem() =="Nam"){
            lblNam.setVisible(true);
            lblNu.setVisible(false);
        }
        else{
            lblNu.setVisible(true);
            lblNam.setVisible(false);
        }
    }//GEN-LAST:event_cboGioiTinhActionPerformed

    private void btnKeoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_btnKeoComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKeoComponentAdded

    private void btnKeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeoActionPerformed
        mayChon();
        nguoi = 1;
        ketQua();
        lblBaoN.setVisible(false);
        lblKeoN.setVisible(true);
        lblBuaN.setVisible(false);
        
    }//GEN-LAST:event_btnKeoActionPerformed

    private void btnBuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuaActionPerformed
        mayChon();
        nguoi = 2;
        ketQua();
        lblBaoN.setVisible(false);
        lblKeoN.setVisible(false);
        lblBuaN.setVisible(true);
       
    }//GEN-LAST:event_btnBuaActionPerformed

    private void btnBaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaoActionPerformed
        mayChon();
        nguoi = 3;
        ketQua();
        lblBaoN.setVisible(true);
        lblKeoN.setVisible(false);
        lblBuaN.setVisible(false);
    }//GEN-LAST:event_btnBaoActionPerformed

    private void cboDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDiemActionPerformed
        if(cboDiem.getSelectedItem() == "3 điểm"){
            maxDiem = 3;
        }
        else if(cboDiem.getSelectedItem() == "5 điểm"){
            maxDiem = 5;
        }
        else if(cboDiem.getSelectedItem() == "10 điểm"){
            maxDiem = 10;
        }
        else if(cboDiem.getSelectedItem() == "20 điểm"){
            maxDiem = 20;
        }
        else if(cboDiem.getSelectedItem() == "50 điểm"){
            maxDiem = 50;
        }
        
    }//GEN-LAST:event_cboDiemActionPerformed

    private void menuThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThongTinMouseClicked
        JOptionPane.showMessageDialog(this,"OẲN TÙ TÌ VỚI MÁY\nHọ Tên SV: Phan Chí Trung\nLớp: 18DTH1D", "Thông tin", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_menuThongTinMouseClicked

    private void menuHuongDanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHuongDanMouseClicked
//        huongDan frmhuongDan = new huongDan();
//        frmhuongDan.setVisible(true);
//        frmhuongDan.setLocationRelativeTo(this);
    }//GEN-LAST:event_menuHuongDanMouseClicked

    private void menuLichSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLichSuMouseClicked
//        lichSu frmlichSu = new lichSu();
//        frmlichSu.setVisible(true);
//        frmlichSu.setLocationRelativeTo(this);
    }//GEN-LAST:event_menuLichSuMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       mP3Player.pause();
       Pikachu frmPikachu = new Pikachu();
       frmPikachu.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void menuThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThoatMouseClicked
        this.dispose();
        mP3Player.pause();
        Pikachu frmPikachu = new Pikachu();
        frmPikachu.setVisible(true);
    }//GEN-LAST:event_menuThoatMouseClicked

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
            java.util.logging.Logger.getLogger(DanhTuXi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhTuXi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhTuXi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhTuXi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DanhTuXi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBao;
    private javax.swing.JButton btnBua;
    private javax.swing.JButton btnKeo;
    private javax.swing.JComboBox<String> cboDiem;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel lblBaoM;
    private javax.swing.JLabel lblBaoN;
    private javax.swing.JLabel lblBuaM;
    private javax.swing.JLabel lblBuaN;
    private javax.swing.JLabel lblHoa;
    private javax.swing.JLabel lblKQM;
    private javax.swing.JLabel lblKQN;
    private javax.swing.JLabel lblKeoM;
    private javax.swing.JLabel lblKeoN;
    private javax.swing.JLabel lblMay;
    private javax.swing.JLabel lblNam;
    private javax.swing.JLabel lblNu;
    private javax.swing.JLabel lblThang;
    private javax.swing.JLabel lblThua;
    private javax.swing.JMenu menuHuongDan;
    private javax.swing.JMenu menuLichSu;
    private javax.swing.JMenu menuThoat;
    private javax.swing.JMenu menuThongTin;
    private javax.swing.JTextField txtDiemBan;
    private javax.swing.JTextField txtDiemMay;
    // End of variables declaration//GEN-END:variables


}
