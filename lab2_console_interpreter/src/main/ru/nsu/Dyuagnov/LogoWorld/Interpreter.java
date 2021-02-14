package main.ru.nsu.Dyuagnov.LogoWorld;

import main.ru.nsu.Dyuagnov.LogoWorld.CommandFactories.CommandFactory;
import main.ru.nsu.Dyuagnov.LogoWorld.Commands.CommandArgs;
import main.ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import main.ru.nsu.Dyuagnov.LogoWorld.Field.Field;
import main.ru.nsu.Dyuagnov.LogoWorld.UI.UI;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Always reads from console, generates command for Executor and field.
 * Then draws field to console.
 * */
public class Interpreter {
    public Interpreter(){}
    private final static Logger logger = LogManager.getLogger(String.valueOf(Interpreter.class));

    /**
     * Endless loop for program
     * @param field - game field
     * @param executor - object on field
     * @param UI - class to display the field and executor
     * */
    public void run(Executor executor, Field field, UI UI) throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {
        // basic log4j configurator
        BasicConfigurator.configure();
        DOMConfigurator.configure("src/main/ru/nsu/Dyuagnov/LogoWorld/log4j.xml");

        try (Scanner in = new Scanner(System.in)) {
            printAvailableCommands();
            logger.info("Start info message printed.");
            final CommandArgs commandArgs = new CommandArgs(executor, field, null);
            logger.info("Command args created.");
            final CommandFactory commandFactory = new CommandFactory();
            logger.info("Command factory created.");
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
