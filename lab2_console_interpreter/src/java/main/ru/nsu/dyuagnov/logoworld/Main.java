package main.ru.nsu.dyuagnov.logoworld;

import main.ru.nsu.dyuagnov.logoworld.Coordinates.Coordinates;
import main.ru.nsu.dyuagnov.logoworld.Executor.Robot;
import main.ru.nsu.dyuagnov.logoworld.UI.UI;
import main.ru.nsu.dyuagnov.logoworld.Executor.Executor;
import main.ru.nsu.dyuagnov.logoworld.Field.Field;
import main.ru.nsu.dyuagnov.logoworld.UI.ConsoleUI;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        try{
            Executor executor = new Robot(new Coordinates(0, 0));
            Field field = new Field(1,1);
            UI UI = new ConsoleUI();
            Interpreter interpreter = new Interpreter();
            interpreter.run(executor, field, UI);
        }
        catch (RuntimeException e){
            System.out.println("RuntimeException: " + e.getLocalizedMessage());
        }
        catch (IOException | ClassNotFoundException | IllegalAccessException |
                NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

    }
}
