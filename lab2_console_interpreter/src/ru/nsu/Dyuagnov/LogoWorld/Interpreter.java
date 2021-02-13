package ru.nsu.Dyuagnov.LogoWorld;

import ru.nsu.Dyuagnov.LogoWorld.CommandFactories.CommandFactory;
import ru.nsu.Dyuagnov.LogoWorld.Commands.CommandArgs;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Robot;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;
import ru.nsu.Dyuagnov.LogoWorld.UI.ConsoleUI;
import ru.nsu.Dyuagnov.LogoWorld.UI.UI;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Scanner;

public class Interpreter {
    public Interpreter(){}

    public void run() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        try (Scanner in = new Scanner(System.in)) {
            printAvaliableCommands();

            Executor executor = new Robot(new Coordinates(0, 0));
            Field field = new Field(1,1);
            UI UI = new ConsoleUI();
            final CommandArgs commandArgs = new CommandArgs(executor, field, null);
            final CommandFactory commandFactory = new CommandFactory();

            while (true) {
                System.out.println("Your command: ");
                commandArgs.setArgs(in.nextLine().toUpperCase(Locale.ROOT).split(" "));
                commandFactory.create(commandArgs.getArgs()[0]).execute(commandArgs);
                UI.draw(executor, field);
            }
        }
    }

    private void printAvaliableCommands(){
        System.out.println("Available commands:\n" +
                "INIT <width> <height> <x> <y>\n" +
                "MOVE [L|R|U|D] <steps>\n" +
                "DRAW\n" +
                "WARD\n" +
                "TELEPORT <x> <y>\n");
    }
}
