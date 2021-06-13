package main.java.ru.nsu.dyuganov.tron.GUI;

import main.java.ru.nsu.dyuganov.tron.KeyController.KeyController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI {
    Frame frame = new Frame();
    GamePanel mainPanel = new GamePanel();

    /* ---- Content ----*/
    Container contentPane = frame.getContentPane();
    private JButton serverGameButton = new JButton("Connect server");
    private JButton localGameButton = new JButton("Local game");
    private JTextField botsNum = new JTextField("", 5);
    private JLabel botsNumText = new JLabel("Bots number: ");
    private JButton backButton = new JButton("Back");


    public GameGUI(KeyController keyController){
        /* ---- Key listener ---- */
        frame.addKeyListener(new GameKeyListener(keyController));
        frame.setFocusable(true);
        frame.requestFocusInWindow();

        /* ---- Display info ----*/
        frame.add(mainPanel);


    }

    public void start(){
        frame.pack();
        frame.setVisible(true);
    }

    private class LocalGameStartEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // старт сервера
            // автоподключение на локалхост
            // запуск N ботов (выбор в окне) как отдельные потоки,
            contentPane.remove(serverGameButton);
            contentPane.add(botsNumText);
            contentPane.add(botsNum);
            contentPane.add(backButton);

            contentPane.repaint();
            contentPane.revalidate();
        }
    }

    private class BackEventListener implements ActionListener{
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

    private class ServerGameStartEventListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // старт игры, когда все нажмут ready
            System.out.println("SWING SASAAAAAAAT");

        }
    }
}
