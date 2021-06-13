package main.java.ru.nsu.dyuganov.tron.GUI;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Frame(){
        super("Tron game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setMinimumSize(new Dimension(1280, 720));
        this.setResizable(false);
        this.setLocationByPlatform(true);
        this.getContentPane().setBackground(new java.awt.Color(11, 20, 28));
    }
}
