package ru.nsu.dyuganov.logoworld.Interpreter;

import ru.nsu.dyuganov.logoworld.CommandFactories.CommandFactory;
import ru.nsu.dyuganov.logoworld.Commands.Command;
import ru.nsu.dyuganov.logoworld.Commands.CommandArgs;
import ru.nsu.dyuganov.logoworld.Executor.Executor;
import ru.nsu.dyuganov.logoworld.Field.Field;
import ru.nsu.dyuganov.logoworld.UI.UI;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Always reads from console, generates command for ru.nsu.dyuganov.logoworld.Executor and field.
 * Then draws field to console.
 * */
public class Interpreter {
    public Interpreter(){
        DOMConfigurator.configure("src/main/resources/ru.nsu.dyuganov.logoworld/log4j.xml");
    }
    private final static Logger logger = LogManager.getLogger(Interpreter.class);

    /**
     * Endless loop for program
     * @param field - game field
     * @param executor - object on field
     * @param UI - class to display the field and executor
     * */
    public void run(Executor executor, Field field, UI UI) throws IOException, ReflectiveOperationException {
        logger.debug("Interpreter run started.");
        try (Scanner in = new Scanner(System.in)) {
            printAvailableCommands();
            logger.debug("Start info message printed.");
            final CommandArgs commandArgs = new CommandArgs(executor, field, null);
            logger.debug("Command args created.");
            final CommandFactory commandFactory = new CommandFactory();
            logger.debug("Command factory created.");

            while (true) {
                logger.info("Started command reading loop.");
                System.out.print("Your command: ");
                String line = in.nextLine().toUpperCase(Locale.ROOT);
                logger.debug("Got user command: " + line);
                commandArgs.setArgs(line.split(" "));
                logger.debug("Command args splitted.");
                if(commandArgs.getArgs()[0].equals("EXIT")) {
                    break;
                }
                Command currentCommand = commandFactory.create(commandArgs.getArgs()[0]);
                currentCommand.execute(commandArgs);
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
