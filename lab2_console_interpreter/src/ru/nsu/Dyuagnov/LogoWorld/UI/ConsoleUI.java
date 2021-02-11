package ru.nsu.Dyuagnov.LogoWorld.UI;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;

public class ConsoleUI implements UI {

    @Override
    public void draw(Executor executor, Field field) {
        if(executor == null || field == null){
            throw new IllegalArgumentException("ConsoleUI.draw(Executor executor, Field field) error. Got null argument.");
        }
        final int viewField = 10;
        for(int i = -viewField; i < viewField; ++i){
            for(int j = -viewField; j < viewField; ++j){
                if(executor.getCoordinates().getX() == i && executor.getCoordinates().getY() == j) {
                    System.out.print("E");
                    continue;
                }
                int x = i + executor.getCoordinates().getX();
                int y = j + executor.getCoordinates().getY();
                if(x < 0 || x >= field.getWidth() || y < 0 || y >= field.getHeight()) {
                    System.out.print("  ");
                }
                else {
                    System.out.print(field.getObject(new Coordinates(x, y)).toString());
                }
            }
            System.out.print('\n');
        }
    }
}
