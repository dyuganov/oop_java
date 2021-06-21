package main.java.ru.nsu.dyuganov.tron.GUI;

import main.java.ru.nsu.dyuganov.tron.GUI.Panels.GamePanel;
import main.java.ru.nsu.dyuganov.tron.KeyController.KeyController;
import main.java.ru.nsu.dyuganov.tron.Model.Game.GameInfo;
import main.java.ru.nsu.dyuganov.tron.Model.Observer.Observer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI implements Observer {
    Frame frame = new Frame();
    GamePanel mainPanel = new GamePanel();
    GameInfo currGameInfo = null;

    /* ---- Content ----*/
    Container contentPane = frame.getContentPane();
    private JButton serverGameButton = new JButton("Connect server");
    private JButton localGameButton = new JButton("Local game");
    private JTextField botsNum = new JTextField("1", 5);
    private JLabel botsNumText = new JLabel("Bots number: ");
    private JButton backButton = new JButton("Back");
    private JButton startLocalGameButton = new JButton("Go!");

    private int botsNumber = 0;
    private boolean isLocalGame = false;
    private boolean isServerGame = false;


    public GameGUI(KeyController keyController) {
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setBackground(new java.awt.Color(11, 20, 28));

        /* ---- Key listener ---- */
        frame.addKeyListener(new GameKeyListener(keyController));
        frame.setFocusable(true);
        frame.requestFocusInWindow();

        /* ---- Display info ----*/
        frame.add(mainPanel);

        mainPanel.setLayout(new GridBagLayout());

        setupBotsText();
        setupBackMenuButton();
        setupStartLocalGameButton();
        setupLocalGameButton();
        setupServerGameButton();


        mainPanel.add(localGameButton);
        mainPanel.add(serverGameButton);




    }

    public void run() { // TODO ?
        frame.pack();
        frame.setVisible(true);
    }

    private void setupBotsText(){
        botsNumText.setForeground(new Color(194, 0, 127));
        //botsNumText.setFont(new Font(botsNumText.getFont().getName(), Font.PLAIN, 18));
        botsNumText.setFont(new Font("Raleway", Font.PLAIN, 18));
    }

    private void setupStartLocalGameButton(){

    }

    private void setupBackMenuButton(){

    }

    private void setupLocalGameButton(){
        int scaleButtonW = 160;
        int scaleButtonH = 74;
        localGameButton.setText("");

        ImageIcon startImg = new ImageIcon("Client/src/main/resources/scaled_images/local_game_button_pink.png");
        Image scaledStartButton = startImg.getImage().getScaledInstance(scaleButtonW, scaleButtonH, Image.SCALE_DEFAULT);
        localGameButton.setIcon(new ImageIcon(scaledStartButton));
        //localGameButton.setIcon(new ImageIcon("Client/src/main/resources/scaled_images/local_game_button.png"));
        localGameButton.setOpaque(false);
        localGameButton.setContentAreaFilled(false);
        localGameButton.setBorder(BorderFactory.createEmptyBorder());
        localGameButton.setBorderPainted(false);
        localGameButton.addActionListener(new LocalGameStartEventListener());
    }

    private void setupServerGameButton(){
        serverGameButton.setText("");
        serverGameButton.setIcon(new ImageIcon("Client/src/main/resources/scaled_images/server_game_button.png"));
        serverGameButton.setOpaque(false);
        serverGameButton.setContentAreaFilled(false);
        serverGameButton.setBorder(BorderFactory.createEmptyBorder());
        serverGameButton.setBorderPainted(false);
        serverGameButton.addActionListener(new ServerGameStartEventListener());
    }

    @Override
    public synchronized void update(GameInfo gameInfo) {
        this.currGameInfo = gameInfo;
    }

    private class LocalGameStartEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!isLocalGame()){
                mainPanel.remove(serverGameButton);
                mainPanel.add(botsNumText);
                mainPanel.add(botsNum);
                mainPanel.add(startLocalGameButton);
                mainPanel.add(backButton);

                mainPanel.repaint();
                mainPanel.revalidate();

                setBotsNumber(Integer.parseInt(botsNum.getText()));
            }
            else{
                setLocalGame(true);

            }
        }
    }

    private synchronized void setBotsNumber(int val) {
        this.botsNumber = val;
    }

    public synchronized int getBotsNum() {
        return this.botsNumber;
    }

    public synchronized boolean isLocalGame(){
        return isLocalGame;
    }

    public synchronized boolean isServerGame(){
        return isServerGame;
    }

    private synchronized void setLocalGame(boolean val){
        this.isLocalGame = val;
        assert isLocalGame != isServerGame;
    }

    private synchronized void setServerGame(boolean val){
        this.isServerGame = val;
        assert isLocalGame != isServerGame;
    }


    private class BackEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // старт сервера
            // автоподключение на локалхост
            // запуск N ботов (выбор в окне) как отдельные потоки,
            contentPane.add(serverGameButton);
            contentPane.remove(botsNumText);
            contentPane.remove(botsNum);
            contentPane.remove(backButton);

            contentPane.repaint();
            contentPane.revalidate();
        }
    }

    private class ServerGameStartEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // старт игры, когда все нажмут ready
            System.out.println("SWING SASAAAAAAAT");

            // отрисовать интерфейс игры
            setServerGame(true);

        }
    }
}
