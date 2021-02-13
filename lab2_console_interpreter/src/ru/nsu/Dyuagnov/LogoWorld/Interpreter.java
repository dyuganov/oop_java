package ru.nsu.Dyuagnov.LogoWorld;

import ru.nsu.Dyuagnov.LogoWorld.CommandFactories.CommandFactory;
import ru.nsu.Dyuagnov.LogoWorld.Commands.CommandArgs;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;
import ru.nsu.Dyuagnov.LogoWorld.UI.UI;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Always reads from console, generates command for Executor and field.
 * Then draws field to console.
 * */
public class Interpreter {
    public Interpreter(){}

    /**
     * Endless loop for program
     * @param field - game field
     * @param executor - object on field
     * @param UI - class to display the field and executor
     * */
    public void run(Executor executor, Field field, UI UI) throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {
        try (Scanner in = new Scanner(System.in)) {
            printAvailableCommands();
            final CommandArgs commandArgs = new CommandArgs(executor, field, null);
            final CommandFactory commandFactory = new CommandFactory();
            while (true) {
                System.out.print("Your command: ");
                commandArgs.setArgs(in.nextLine().toUpperCase(Locale.ROOT).split(" "));
                commandFactory.create(commandArgs.getArgs()[0]).execute(commandArgs);
                UI.draw(executor, field);
            }
        }
    }

    /**
     * Prints message with main supported commands.
     * */
    private void printAvailableCommands(){
        System.out.println("Available commands:\n" +
                "INIT <width> <height> <x> <y>\n" +
                "MOVE [L|R|U|D] <steps>\n" +
                "DRAW\n" +
                "WARD\n" +
                "TELEPORT <x> <y>\n");
    }
}
