package main.ru.nsu.dyuagnov.logoworld;

import main.ru.nsu.dyuagnov.logoworld.CommandFactories.CommandFactory;
import main.ru.nsu.dyuagnov.logoworld.Commands.Command;
import main.ru.nsu.dyuagnov.logoworld.Commands.CommandArgs;
import main.ru.nsu.dyuagnov.logoworld.Executor.Executor;
import main.ru.nsu.dyuagnov.logoworld.Field.Field;
import main.ru.nsu.dyuagnov.logoworld.UI.UI;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Always reads from console, generates command for Executor and field.
 * Then draws field to console.
 * */
public class Interpreter {
    public Interpreter(){}
    private final static Logger logger = LogManager.getLogger(Interpreter.class);

    /**
     * Endless loop for program
     * @param field - game field
     * @param executor - object on field
     * @param UI - class to display the field and executor
     * */
    public void run(Executor executor, Field field, UI UI) throws IOException, ReflectiveOperationException {
        DOMConfigurator.configure("src/java/resources/log4j_interpreter.xml");
        logger.setLevel(Level.DEBUG);
        logger.debug("Interpreter started.");
        try (Scanner in = new Scanner(System.in)) {
            printAvailableCommands();
            logger.debug("Start info message printed.");
            final CommandArgs commandArgs = new CommandArgs(executor, field, null);
            logger.debug("Command args created.");
            final CommandFactory commandFactory = new CommandFactory();
            logger.debug("Command factory created.");

            while (true) {
                logger.info("Started command reading loop.");
                String line = in.nextLine().toUpperCase(Locale.ROOT);
                logger.debug("Got user command: " + line);
                commandArgs.setArgs(line.split(" "));
                logger.debug("Command args splitted.");
                if(commandArgs.getArgs()[0].equals("EXIT")) {
                    break;
                }
                Command currentCommand = commandFactory.create(commandArgs.getArgs()[0]);
                logger.debug("Command created.");
                currentCommand.execute(commandArgs);
                logger.debug("Command executed.");
                UI.draw(executor, field);
                logger.debug("Field displayed.");
            }
            logger.debug("Interpreter finished work.");
        }
    }

    /**
     * Prints message with available commands.
     * */
    private void printAvailableCommands(){
        System.out.println("Available commands:\n" +
                "INIT <width> <height> <x> <y>\n" +
                "MOVE [L|R|U|D] <steps>\n" +
                "DRAW\n" +
                "WARD\n" +
                "TELEPORT <x> <y>\n" +
                "EXIT");
    }
}
