/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author DuyDL2
 */
public class MainFrame extends JFrame implements ActionListener, Runnable {

    private static final long serialVersionUID = 1L;

    private int maxTime = 500;  //--Thời gian khoảng 8 phút để chơi
    public int time = maxTime;
    private int row = 8;
    private int col = 8;
    private int width = 700;  //--700 Chiều dài của frame
    private int height = 500; //--500 chiều rộng của frame
    public JLabel lbScore;
    private JProgressBar progressTime;
    private JButton btnNewGame, btnExit;
    private ButtonEvent graphicsPanel;
    private JPanel mainPanel;

    private boolean pause = false;
    private boolean resume = false;
    Music m = new Music();
    AudioStream as = null;
    AudioPlayer ap = AudioPlayer.player;
    

    public MainFrame() {
        add(mainPanel = createMainPanel());
        setTitle("Pikachu Game");
        setResizable(false);        
        //--Nhớ chỗ này
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JButton button1 = new JButton("Button1");
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);
        as = m.startMusic();
        ap.start(as);
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\DA_CDJAVA\\build\\classes\\icon\\logo.png"));

    } 
    
      public void thoat(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );//Nếu bấm đóng thì không làm gì cả mà hỏi người dùng trước
        int kq = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát?","Thông báo",JOptionPane.YES_NO_OPTION);
        if(kq == 0)
        {
            this.dispose();
        }
    }       

    
    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createGraphicsPanel(), BorderLayout.CENTER);
        panel.add(createControlPanel(), BorderLayout.EAST);
        panel.add(createStatusPanel(), BorderLayout.PAGE_END);
        return panel;
    }

    private JPanel createGraphicsPanel() {
        graphicsPanel = new ButtonEvent(this, row, col);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.gray);
        panel.add(graphicsPanel);
        return panel;
    }

    private JPanel createControlPanel() {
        lbScore = new JLabel("0");
        // lbTime = new JLabel("0");
        progressTime = new JProgressBar(0, 100);
        progressTime.setValue(100);

        // tạo panel chứa điểm và thời gian
        JPanel panelLeft = new JPanel(new GridLayout(0, 1, 5, 5));
        panelLeft.add(new JLabel("Score:"));
        panelLeft.add(new JLabel("Time:"));

        JPanel panelCenter = new JPanel(new GridLayout(0, 1, 5, 5));
        panelCenter.add(lbScore);
        panelCenter.add(progressTime);

        JPanel panelScoreAndTime = new JPanel(new BorderLayout(5, 0));
        panelScoreAndTime.add(panelLeft, BorderLayout.WEST);
        panelScoreAndTime.add(panelCenter, BorderLayout.CENTER);

        // tạo panel chứa panelScoreAndTime và nút new game
        JPanel panelControl = new JPanel(new BorderLayout(10, 10));
        panelControl.setBorder(new EmptyBorder(10, 3, 5, 3));
        //--Điểm và thời gian nằm trên
        panelControl.add(panelScoreAndTime, BorderLayout.PAGE_START);
        //--Nút new game nằm giữa
        panelControl.add(btnNewGame = createButton("New Game"),BorderLayout.CENTER);
        //--Nút exit game nằm cuối
        panelControl.add(btnExit = createButton("Exit"), BorderLayout.PAGE_END);
        
        // use panel set Layout BorderLayout to panel control in top
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Status"));
        panel.add(panelControl, BorderLayout.PAGE_START);
        return panel;
    }

    // create status panel container author
    private JPanel createStatusPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setBackground(Color.lightGray);

        return panel;
    }

    // create a button
    private JButton createButton(String buttonName) {
        JButton btn = new JButton(buttonName);
        btn.addActionListener(this);
        return btn;
    }
    

    public void newGame() {
        time = maxTime;
        graphicsPanel.removeAll();
        mainPanel.add(createGraphicsPanel(), BorderLayout.CENTER);
        mainPanel.validate();
        mainPanel.setVisible(true);
        lbScore.setText("0");
    }
    
      

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewGame) {
            showDialogNewGame("Trò chơi chưa hoàn thành. Bạn muốn tạo game mới?", "Warning", 0);
        }
      
        else if(e.getSource() == btnExit){
            showDialogExitGame("Trò chơi chưa hoàn thành. Bạn muốn thoát?", "Warning", 0);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progressTime.setValue((int) ((double) time / maxTime * 100));
        }
    }

    public JProgressBar getProgressTime() {
        return progressTime;
    }

    public void setProgressTime(JProgressBar progressTime) {
        this.progressTime = progressTime;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean isResume() {
        return resume;
    }

    public void setResume(boolean resume) {
        this.resume = resume;
    }                            

    public boolean showDialogNewGame(String message, String title, int t) {
        pause = true;
        resume = false;
        ap.stop(as);
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        if (select == 0) {
            pause = false;
            ap.start(as);
            newGame();
            return true;
        } else {
            if (t == 1) {
                this.dispose();
                //---Hiện lại main chính
                Pikachu frmPikachu = new Pikachu();
                frmPikachu.setVisible(true);
                return false;
            } else {
                ap.start(as);
                resume = true;
                return true;
            }
        }
    }
               
    public boolean showDialogExitGame(String message, String title, int t) {
        pause = true;
        resume = false;
        ap.stop(as);
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        if (select == 0) {
            pause = false;
            ap.start(as);
            this.dispose();
            //--Khi thoát hiện lại phần menu chính
            Pikachu frmPikachu = new Pikachu();
            frmPikachu.setVisible(true);
            ap.stop(as);
            return true;
        } else {
            if (t == 1) {
                System.exit(0);
                return false;
            } else {
                ap.start(as);
                resume = true;
                return true;
            }
        }
    }   
    
    public boolean showDialogExitGame2(String message, String title, int t) {
        pause = true;
        resume = false;
        ap.stop(as);
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        if (select == 0) {
            pause = false;
            ap.start(as);
            newGame();
            ap.start(as);
            return true;
        } else {
            if (t == 1) {
                this.dispose();
                //---Hiện lại form main chính
                Pikachu frmPikachu = new Pikachu();
                frmPikachu.setVisible(true);
                time = 1;
                return false;
            } else {
                ap.start(as);
                resume = true;
                return true;
            }
        }
    }  
}