/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author DuyDL2
 */
public class Main {

    MainFrame frame;
    Music m = new Music();
    AudioStream as = null;
    AudioPlayer ap = AudioPlayer.player;
    
    String kq ="";
    
    public Main() {
        frame = new MainFrame();
        MyTimeCount timeCount = new MyTimeCount();
        timeCount.start();
        new Thread(frame).start();

    }
    
   //-----Ghi file txt trên máy
    public void ghiFile() throws IOException {
            kq = frame.time == 0 ? "Ban thua" : "Ban thang";            
            String dataString = frame.lbScore.getText() + "\t"+ Integer.toString(frame.time)+ "\t" + kq + "\n";
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("LichSuGame.txt",true))){
                bw.write(dataString);
                bw.close();
            }       
        }
    
    //---Ghi kết quả người chơi vào Database (sql)
    public void ghiKetQua(){
        kq = frame.time == 0 ? "Bạn thua" : "Bạn thắng";
        String errConnect = Connect.getConnection();
        if(!errConnect.equals("")){
            JOptionPane.showMessageDialog(null, errConnect,"Lỗi", JOptionPane.ERROR_MESSAGE); //--Có thể sai chỗ null
            return;
        }
        String sql = "{call ThemLichSu(?,?,?,?,?)}";
        CallableStatement csmt;
        String ketqua;
        try{
            csmt = Connect.conn.prepareCall(sql);
            csmt.setString(1, frame.lbScore.getText());
            csmt.setInt(2, frame.time);
            csmt.setString(3, kq);
            csmt.setString(4, Connect.userID);
            csmt.registerOutParameter(5, java.sql.Types.NVARCHAR);
            csmt.execute();
            ketqua = csmt.getString(5);
            JOptionPane.showMessageDialog(null,ketqua, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            csmt.close();
            
            Connect.conn.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage(),"Lỗi", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    public static void main(String[] args) {
        new Main();
    }
    
    
    class MyTimeCount extends Thread {

        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (frame.isPause()) {
                    if (frame.isResume()) {
                        frame.time--;
                    }
                } else {
                    frame.time--;
                }
                if (frame.time == 10) {
                    as = m.warningMusic();
                    ap.start(as);
                }
                if (frame.time == 0) {
//                    try {
//                        ghiFile();
//                        } catch (IOException ex) {
//                            Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
//                        }              
                    ghiKetQua();
                    as = m.loseMusic();
                    ap.start(as);
                    
                    if (frame.showDialogExitGame2("Hết thời gian\nBạn có muốn chơi lại?", "Lose", 1) == true)
                    {
                         
                        ap.stop(as);
                        
                    }; ////---;(*)
                    
                    
                }
            }
        }
    }
    
}