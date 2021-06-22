package main.java.ru.nsu.dyuganov.tron.GUI.Panels;

import main.java.ru.nsu.dyuganov.tron.Model.Coordinates.Coordinates;
import main.java.ru.nsu.dyuganov.tron.Model.Game.GameInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 1280;
    static final int SCREEN_HEIGHT = 720;

    private final int startOffsetX = 166;
    private final int startOffsetY = 40;
    private final int offset = 22;

    private final Color darkBlueColor = new Color(11, 20, 28);

    private final int bikeIdx = 0;
    private final int traceIdx = 1;
    private final int cornerTraceIdx = 2;

    private GameInfo gameInfo;
    private Map<Integer, ArrayList<Image>> idToBikeImages = new HashMap<>();

    final Image backGrid = new ImageIcon("Client/src/main/resources/scaled_images/main_game_grid.png").getImage();
    final Image background = new ImageIcon("Client/src/main/resources/scaled_images/background.png").getImage();

    final Image blueBike = new ImageIcon("Client/src/main/resources/scaled_images/blue_bike.png").getImage();
    final Image blueTrace = new ImageIcon("Client/src/main/resources/scaled_images/blue_trace.png").getImage();
    final Image blueTraceCorner = new ImageIcon("Client/src/main/resources/scaled_images/blue_corner_trace.png").getImage();
    final ArrayList<Image> blueImagesList = new ArrayList<>(Arrays.asList(blueBike, blueTrace, blueTraceCorner));

    final Image pinkBike = new ImageIcon("Client/src/main/resources/scaled_images/pink_bike.png").getImage();
    final Image pinkTrace = new ImageIcon("Client/src/main/resources/scaled_images/pink_trace.png").getImage();
    final Image pinkTraceCorner = new ImageIcon("Client/src/main/resources/scaled_images/pink_corner_trace.png").getImage();
    final ArrayList<Image> pinkImagesList = new ArrayList<>(Arrays.asList(pinkBike, pinkTrace, pinkTraceCorner));

    final Image orangeBike = new ImageIcon("Client/src/main/resources/scaled_images/orange_bike.png").getImage();
    final Image orangeTrace = new ImageIcon("Client/src/main/resources/scaled_images/orange_trace.png").getImage();
    final Image orangeTraceCorner = new ImageIcon("Client/src/main/resources/scaled_images/orange_corner_trace.png").getImage();
    final ArrayList<Image> orangeImagesList = new ArrayList<>(Arrays.asList(orangeBike, orangeTrace, orangeTraceCorner));

    final Image purpleBike = new ImageIcon("Client/src/main/resources/scaled_images/purple_bike.png").getImage();
    final Image purpleTrace = new ImageIcon("Client/src/main/resources/scaled_images/purple_trace.png").getImage();
    final Image purpleTraceCorner = new ImageIcon("Client/src/main/resources/scaled_images/purple_corner_trace.png").getImage();
    final ArrayList<Image> purpleImagesList = new ArrayList<>(Arrays.asList(purpleBike, purpleTrace, purpleTraceCorner));

    final ArrayList<ArrayList<Image>> imageLists = new ArrayList<>(Arrays.asList(blueImagesList, pinkImagesList, orangeImagesList, purpleImagesList));

    public GamePanel(GameInfo gameInfo){
        this.gameInfo = gameInfo;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(darkBlueColor);

        updateIdToBikeImages();
    }

    private void updateIdToBikeImages(){
        assert gameInfo.getIdToBikes().size() <= 4;
        if(gameInfo.getIdToBikes().size() == idToBikeImages.size()){
            return;
        }
        idToBikeImages.clear();
        for(Integer i : gameInfo.getIdToBikes().keySet()){
            idToBikeImages.put(i, imageLists.get(i));
        }
    }

    @Override
    public void paint(Graphics g){
        updateIdToBikeImages();
        g.setColor(darkBlueColor);
        g.drawImage(background, 0, 0, null);
        g.drawImage(backGrid, 0, 0, null);

        for(Integer userId : gameInfo.getIdToBikes().keySet()){
            ArrayList<Coordinates> trace = gameInfo.getIdToBikes().get(userId).getTrace().getTrace();
            for(int i = 0; i < trace.size(); ++i){
                int x = offset * trace.get(i).getX() + startOffsetX;
                int y = offset * trace.get(i).getY() + startOffsetY;
                Image img = idToBikeImages.get(userId).get(traceIdx);
                if(i == 0){
                    img = idToBikeImages.get(userId).get(bikeIdx);
                }
                g.drawImage(img, x, y, null);
            }
        }
    }

    public void updateGameInfo(GameInfo gameInfo){
        this.gameInfo = gameInfo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
