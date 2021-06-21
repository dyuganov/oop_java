package main.java.ru.nsu.dyuganov.tron.GUI;

import main.java.ru.nsu.dyuganov.tron.KeyController.KeyController;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// TODO: OLD!!!!!!!!!!!!!!!!!
public class GUI{
    KeyController keyController;

    JFrame frame = new JFrame("Tron game");
    Container container = frame.getContentPane();

    private JButton serverGameButton = new JButton("Connect server");

    private JButton localGameButton = new JButton("Local game");
    private JTextField botsNum = new JTextField("", 5);
    private JLabel botsNumText = new JLabel("Bots number: ");
    private JButton backButton = new JButton("Back");

    private KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            keyController.handleKey(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            keyController.handleKey(e);
        }
        @Override
        public void keyReleased(KeyEvent e) {}
    };

    public GUI(KeyController keyController){
        this.keyController = keyController;

        frame.setBounds(0, 0, 1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addKeyListener(keyListener);
        frame.setFocusable(true);
        frame.requestFocusInWindow();

        /*localGameButton.addActionListener(new LocalGameStartEventListener());
        serverGameButton.addActionListener(new ServerGameStartEventListener());
        backButton.addActionListener(new BackEventListener());*/

        container.setLayout(new GridBagLayout());
        GridBagConstraints constraintsLocal = new GridBagConstraints();
        constraintsLocal.weightx = 0;
        constraintsLocal.weighty = 0;
        constraintsLocal.gridx = 0;
        constraintsLocal.gridy = 0;
        constraintsLocal.gridheight = 10;
        constraintsLocal.gridwidth = 10;

        GridBagConstraints constraintsServer = new GridBagConstraints();
        constraintsServer.weightx = 0;
        constraintsServer.weighty = 0;
        constraintsServer.gridx = 0;
        constraintsServer.gridy = 10;
        constraintsServer.gridheight = 2;
        constraintsServer.gridwidth = 2;

         localGameButton.setText("");
         final int buttonW = 82;
         final int buttonH = 40;
         final int scaleMul = 2;
         int scaleButtonW = buttonW * scaleMul;
         int scaleButtonH = buttonH * scaleMul;
         localGameButton.setPreferredSize(new Dimension(scaleButtonW, scaleButtonH));
        ImageIcon startImg = new ImageIcon("C:\\Users\\Dyuga\\Desktop\\study_labs\\oop_java\\lab3_tron\\Client\\src\\main\\resources\\images\\play_button.png");
        Image scaledStartButton = startImg.getImage().getScaledInstance(scaleButtonW, scaleButtonH, Image.SCALE_DEFAULT);
        localGameButton.setIcon(new ImageIcon(scaledStartButton));
        localGameButton.setOpaque(false);
        localGameButton.setContentAreaFilled(false);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        localGameButton.setBorder(emptyBorder);
        localGameButton.setBorderPainted(false);


        container.add(localGameButton);
        container.add(serverGameButton);




/*
        ImageIcon background = new ImageIcon("C:\\Users\\Dyuga\\Desktop\\study_labs\\oop_java\\lab3_tron\\Client\\src\\main\\resources\\images\\background.png");
        ImageIcon backgroundGrid = new ImageIcon("C:\\Users\\Dyuga\\Desktop\\study_labs\\oop_java\\lab3_tron\\Client\\src\\main\\resources\\images\\start_screen_grid.png");
        ImageIcon backgroundBikes = new ImageIcon("C:\\Users\\Dyuga\\Desktop\\study_labs\\oop_java\\lab3_tron\\Client\\src\\main\\resources\\images\\start_screen_bikes.png");
        Image scaleBack = background.getImage().getScaledInstance(1280, 720, Image.SCALE_FAST);
        Image scaleGrid = backgroundGrid.getImage().getScaledInstance(1280, 720, Image.SCALE_FAST);
        Image scaleStartBikes = backgroundBikes.getImage().getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        container.add(new JLabel(new ImageIcon(scaleBack)));
        container.add(new JLabel(new ImageIcon(scaleGrid)));
        container.add(new JLabel(new ImageIcon(scaleStartBikes)));
*/


        ImageIcon background = new ImageIcon("C:\\Users\\Dyuga\\Desktop\\study_labs\\oop_java\\lab3_tron\\Client\\src\\main\\resources\\images\\background_compiled.png");
        Image scaleBack = background.getImage().getScaledInstance(1280, 720, Image.SCALE_FAST);
        //container.add(new JLabel(new ImageIcon(scaleBack)));



        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("C:\\Users\\Dyuga\\Desktop\\study_labs\\oop_java\\lab3_tron\\Client\\src\\main\\resources\\images\\background_compiled.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel backPanel = new JPanel();
        backPanel.setPreferredSize(new Dimension(1280, 720));
        frame.paint(img.getGraphics());
        frame.add(backPanel);



        container.setBackground(new java.awt.Color(11, 20, 28));
        //container.setBackground(new java.awt.Color(111, 22, 22));

        frame.setMinimumSize(new Dimension(1280, 720));
        frame.setResizable(false);
        frame.setLocationByPlatform(true);


    }

    public void start(){
        frame.pack();
        frame.setVisible(true);
    }



}
