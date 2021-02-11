package ru.nsu.Dyuagnov.LogoWorld;

import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Robot;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;
import ru.nsu.Dyuagnov.LogoWorld.UI.ConsoleUI;
import ru.nsu.Dyuagnov.LogoWorld.UI.UI;

import java.util.Scanner;

public class Interpreter {
    public Interpreter(){}

    public void run(){
        try (Scanner in = new Scanner(System.in)) {
            Parser parser = new Parser();
            Executor executor = new Robot(new Coordinates(0, 0));
            Field field = new Field(1,1);
            UI UI = new ConsoleUI();

            while (true) {
                parser.parse(in.nextLine(), executor, field).execute();
                UI.draw(executor, field);
            }
        }
    }
}
