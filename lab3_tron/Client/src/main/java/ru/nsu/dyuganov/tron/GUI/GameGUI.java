package main.java.ru.nsu.dyuganov.tron.GUI;

import main.java.ru.nsu.dyuganov.tron.GUI.Panels.GameCanvas;
import main.java.ru.nsu.dyuganov.tron.GUI.Panels.GamePanel;
import main.java.ru.nsu.dyuganov.tron.GUI.Panels.StartPanel;
import main.java.ru.nsu.dyuganov.tron.KeyController.KeyController;
import main.java.ru.nsu.dyuganov.tron.Model.Game.GameInfo;
import main.java.ru.nsu.dyuganov.tron.Model.Observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI implements Observer {
    Frame frame = new Frame();
    StartPanel startPanel = new StartPanel();
    //GamePanel gamePanel = new GamePanel();
    GameInfo currGameInfo = null;

    /* ---- Content ----*/
    Container contentPane = frame.getContentPane();
    private JButton serverGameButton = new JButton("Connect server");
    private JButton localGameButton = new JButton("Local game");
    private JTextField botsNumTextField = new JTextField("1", 5);
    private JLabel botsNumText = new JLabel("Bots number: ");
    private JButton backButton = new JButton("Back");
    private JButton startLocalGameButton = new JButton("Go!");

    private final Color pinkColour = new Color(194, 0, 127);
    private final Color darkBlueColor = new Color(11, 20, 28);

    private int botsNumber = 0;
    private boolean isLocalGame = false;
    private boolean isServerGame = false;


    public GameGUI(KeyController keyController) {
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startPanel.setBackground(darkBlueColor);

        /* ---- Key listener ---- */
        frame.addKeyListener(new GameKeyListener(keyController));
        frame.setFocusable(true);
        frame.requestFocusInWindow();

        /* ---- Display info ----*/
        frame.add(startPanel);

        startPanel.setLayout(new GridBagLayout());

        setupBotsText();
        setupBackMenuButton();
        setupStartLocalGameButton();
        setupLocalGameButton();
        setupServerGameButton();

        startPanel.add(localGameButton);
        startPanel.add(serverGameButton);
    }

    public void run() { // TODO ?
        frame.pack();
        frame.setVisible(true);
    }

    private void setupBotsText(){
        botsNumText.setForeground(pinkColour);
        botsNumText.setFont(new Font("Raleway", Font.PLAIN, 18));
    }

    private void setupStartLocalGameButton(){
        startLocalGameButton.addActionListener(new LocalGameStartActionListener());
        startLocalGameButton.setBackground(darkBlueColor);
        startLocalGameButton.setForeground(pinkColour);
    }

    private void setupBackMenuButton(){
        backButton.addActionListener(new BackEventListener());
        backButton.setBackground(darkBlueColor);
        backButton.setForeground(pinkColour);
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
        localGameButton.addActionListener(new LocalGameSetActionListener());
    }

    private void setupServerGameButton(){
        serverGameButton.setText("");
        serverGameButton.setIcon(new ImageIcon("Client/src/main/resources/scaled_images/server_game_button.png"));
        serverGameButton.setOpaque(false);
        serverGameButton.setContentAreaFilled(false);
        serverGameButton.setBorder(BorderFactory.createEmptyBorder());
        serverGameButton.setBorderPainted(false);
        serverGameButton.addActionListener(new ServerGameStartActionListener());
    }

    private class LocalGameSetActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startPanel.remove(serverGameButton);
            startPanel.add(botsNumText);
            startPanel.add(botsNumTextField);
            startPanel.add(startLocalGameButton);
            startPanel.add(backButton);

            startPanel.repaint();
            startPanel.revalidate();
        }
    }

    private class BackEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startPanel.add(serverGameButton);
            startPanel.remove(botsNumText);
            startPanel.remove(botsNumTextField);
            startPanel.remove(backButton);
            startPanel.remove(startLocalGameButton);

            startPanel.repaint();
            startPanel.revalidate();
        }
    }

    private class LocalGameStartActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setLocalGame(true);
            setBotsNumber(Integer.parseInt(botsNumTextField.getText()));
            frame.remove(startPanel);
            //frame.add(new GameCanvas()); // !!
            frame.add(new GamePanel(currGameInfo));
            frame.repaint();
            frame.revalidate();
            // TODO старт игровой отрисвоки
        }
    }

    private class ServerGameStartActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setServerGame(true);
            // TODO старт игровой отрисвоки
        }
    }

    @Override
    public synchronized void update(GameInfo gameInfo) {
        assert gameInfo != null;
        this.currGameInfo = gameInfo;
    }

    private synchronized GameInfo getCurrGameInfo(){
        return this.getCurrGameInfo();
    }

    private synchronized void setBotsNumber(int val) {
        this.botsNumber = val;
    }

    public synchronized int getBotsNumTextField() {
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
}
