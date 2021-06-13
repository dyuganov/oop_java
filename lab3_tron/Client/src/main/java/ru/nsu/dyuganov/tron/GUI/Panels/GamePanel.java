package main.java.ru.nsu.dyuganov.tron.GUI.Panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
    static final int SCREEN_WIDTH = 1280;
    static final int SCREEN_HEIGHT = 720;



     public GamePanel(){
         this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
     }

     public void draw(Graphics g){

     }

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

