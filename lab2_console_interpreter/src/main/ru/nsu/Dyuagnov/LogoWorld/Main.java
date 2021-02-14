package main.ru.nsu.Dyuagnov.LogoWorld;

import main.ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;
import main.ru.nsu.Dyuagnov.LogoWorld.Executor.Robot;
import main.ru.nsu.Dyuagnov.LogoWorld.UI.UI;
import main.ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import main.ru.nsu.Dyuagnov.LogoWorld.Field.Field;
import main.ru.nsu.Dyuagnov.LogoWorld.UI.ConsoleUI;

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
