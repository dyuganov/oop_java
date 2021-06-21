package main.java.ru.nsu.dyuganov.tron.GUI.Panels;

import main.java.ru.nsu.dyuganov.tron.Model.Game.GameInfo;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
    static final int SCREEN_WIDTH = 1280;
    static final int SCREEN_HEIGHT = 720;

     public StartPanel(){
         this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
     }

    //private GameInfo gameInfo;
    //Image backGrid = new ImageIcon("Client/src/main/resources/scaled_images/main_game_grid.png").getImage();
    //Image blueBike = new ImageIcon("Client/src/main/resources/scaled_images/blue_bike.png").getImage();

    //private final Color darkBlueColor = new Color(11, 20, 28);

   /* @Override
    public void paint(Graphics g){
        //g.setColor(darkBlueColor);
        //g.drawImage(backGrid, 0, 0, null);
    }*/


/*    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Client/src/main/resources/images/start_back_scaled.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert img != null;
        g2D.drawImage(img, 0, 0, null);
    }*/
}

