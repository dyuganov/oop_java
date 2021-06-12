package main.java.ru.nsu.dyuganov.tron.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI{
    JFrame frame = new JFrame("Tron game");
    Container container = frame.getContentPane();

    private JButton serverGameButton = new JButton("Connect server");

    private JButton localGameButton = new JButton("Local game", new ImageIcon("src/main/resources/images/play_button.png"));
    private JTextField botsNum = new JTextField("", 5);
    private JLabel botsNumText = new JLabel("Bots number: ");

    public GUI(){
        frame.setBounds(0, 0, 1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        localGameButton.addActionListener(new LocalGameStartEventListener());
        serverGameButton.addActionListener(new ServerGameStartEventListener());

        /*container.setLayout(new GridBagLayout());
        GridBagConstraints constraintsLocal = new GridBagConstraints();
        constraintsLocal.weightx = 0;
        constraintsLocal.weighty = 0;
        constraintsLocal.gridx = 0;
        constraintsLocal.gridy = 0;
        constraintsLocal.gridheight = 2;
        constraintsLocal.gridwidth = 2;

        GridBagConstraints constraintsServer = new GridBagConstraints();
        constraintsServer.weightx = 0;
        constraintsServer.weighty = 0;
        constraintsServer.gridx = 0;
        constraintsServer.gridy = 2;
        constraintsServer.gridheight = 2;
        constraintsServer.gridwidth = 2;

        //localGameButton.setBackground();
        container.add(localGameButton);
        container.add(serverGameButton);*/

/*
        ImageIcon background = new ImageIcon("C:\\Users\\Dyuga\\Desktop\\study_labs\\oop_java\\lab3_tron\\Client\\src\\main\\resources\\images\\background.png");
        ImageIcon backgroundGrid = new ImageIcon("C:\\Users\\Dyuga\\Desktop\\study_labs\\oop_java\\lab3_tron\\Client\\src\\main\\resources\\images\\start_screen_grid.png");
        ImageIcon backgroundBikes = new ImageIcon("C:\\Users\\Dyuga\\Desktop\\study_labs\\oop_java\\lab3_tron\\Client\\src\\main\\resources\\images\\start_screen_bikes.png");

        container.setBackground(new java.awt.Color(11, 20, 28));
        //container.setBackground(new java.awt.Color(111, 22, 22));
        Image scaleBack = background.getImage().getScaledInstance(1280, 720, Image.SCALE_FAST);
        Image scaleGrid = backgroundGrid.getImage().getScaledInstance(1280, 720, Image.SCALE_FAST);
        Image scaleStartBikes = backgroundBikes.getImage().getScaledInstance(1280, 720, Image.SCALE_DEFAULT);


        container.add(new JLabel(new ImageIcon(scaleBack)));
        container.add(new JLabel(new ImageIcon(scaleGrid)));
        container.add(new JLabel(new ImageIcon(scaleStartBikes)));
        frame.setMinimumSize(new Dimension(1280, 720));
        frame.setResizable(false);
        frame.setLocationByPlatform(true);*/
    }

    public void start(){
        frame.pack();
        frame.setVisible(true);
    }

    private class LocalGameStartEventListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // старт сервера
            // автоподключение на локалхост
            // запуск N ботов (выбор в окне) как отдельные потоки,
            container.remove(serverGameButton);
            container.add(botsNumText);
            container.add(botsNum);

            container.repaint();
            container.revalidate();
        }
    }

    private class ServerGameStartEventListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // старт игры, когда все нажмут ready
            System.out.println("SASAAAT");

        }
    }
}
