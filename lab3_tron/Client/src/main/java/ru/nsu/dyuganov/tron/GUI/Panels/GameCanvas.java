package main.java.ru.nsu.dyuganov.tron.GUI.Panels;

import main.java.ru.nsu.dyuganov.tron.GameController.GameController;
import main.java.ru.nsu.dyuganov.tron.Model.Game.GameInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// TODO DELETE
public class GameCanvas extends Canvas {

    private GameInfo gameInfo;
    Image backGrid = new ImageIcon("Client/src/main/resources/scaled_images/main_game_grid.png").getImage();
    Image blueBike = new ImageIcon("Client/src/main/resources/scaled_images/blue_bike.png").getImage();

    private final Color darkBlueColor = new Color(11, 20, 28);

    public GameCanvas(){

    }

    @Override
    public void paint(Graphics g){
        g.setColor(darkBlueColor);
        g.drawImage(backGrid, 0, 0, null);
        g.drawImage(blueBike, 40,100, null);
    }

}
