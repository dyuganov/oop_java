package ru.nsu.dyuganov.logoworld.UI;

import ru.nsu.dyuganov.logoworld.Coordinates.Coordinates;
import ru.nsu.dyuganov.logoworld.Executor.Executor;
import ru.nsu.dyuganov.logoworld.Field.Field;

public class ConsoleUI implements UI {

    @Override
    public void draw(Executor executor, Field field) {
        if(executor == null || field == null){
            throw new IllegalArgumentException("ConsoleUI.draw(ru.nsu.dyuganov.logoworld.Executor executor, ru.nsu.dyuganov.logoworld.Field field) error. Got null argument.");
        }
        final int viewField = 10;
        for(int i = -viewField; i < viewField; ++i){
            for(int j = -viewField; j < viewField; ++j){
                int x = i + executor.getCoordinates().getX();
                int y = j + executor.getCoordinates().getY();
                if(executor.getCoordinates().getX() == x && executor.getCoordinates().getY() == y) {
                    System.out.print("E ");
                }
                else if(x < 0 || x >= field.getHeight() || y < 0 || y >= field.getWidth()) {
                    System.out.print("  ");
                }
                else {
                    System.out.print(field.getCell(new Coordinates(x, y)).toString() + ' ');
                }
            }
            System.out.print('\n');
        }
    }
}
