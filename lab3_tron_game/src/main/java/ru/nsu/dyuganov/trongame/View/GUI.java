package ru.nsu.dyuganov.trongame.View;

import ru.nsu.dyuganov.trongame.Contoller.Controller;
import ru.nsu.dyuganov.trongame.Model.GameModel.GameModel;
import ru.nsu.dyuganov.trongame.Observer.GameUpdates;
import ru.nsu.dyuganov.trongame.Observer.Subscriber;

import javax.swing.*;
import java.awt.*;

public class GUI implements Runnable, Subscriber {
    private GameUpdates gameUpdates = null;
    private Controller controller = null;

    public GUI(Controller controller){
        this.controller = controller;
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Game test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("src/main/resources/ru.nsu.dyuganov.trongame/log4j/textures/main_game_grid.png");
        Image scaleImg = icon.getImage().getScaledInstance(1280, 720, Image.SCALE_FAST);
        frame.getContentPane().add(new JLabel(new ImageIcon(scaleImg)));

        frame.getContentPane().setBackground(new java.awt.Color(11, 20, 28));
        frame.setMinimumSize(new Dimension(1280, 720));
        frame.setResizable(false);

        frame.pack();
        frame.setVisible(true);

        // draw and get updates
    }

    @Override
    public void update(GameUpdates gameUpdates) {

    }
}
