package ru.nsu.dyuganov.logoworld;

import ru.nsu.dyuganov.logoworld.Coordinates.Coordinates;
import ru.nsu.dyuganov.logoworld.Executor.Robot;
import ru.nsu.dyuganov.logoworld.Interpreter.Interpreter;
import ru.nsu.dyuganov.logoworld.UI.UI;
import ru.nsu.dyuganov.logoworld.Executor.Executor;
import ru.nsu.dyuganov.logoworld.Field.Field;
import ru.nsu.dyuganov.logoworld.UI.ConsoleUI;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;

public class Main {
    private final static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        DOMConfigurator.configure("src/main/resources/ru.nsu.dyuganov.logoworld/log4j.xml");
        logger.info("ru.nsu.dyuganov.logoworld.Main started.");
        try{
            Executor executor = new Robot(new Coordinates(0, 0));
            Field field = new Field(1,1);
            UI UI = new ConsoleUI();
            Interpreter interpreter = new Interpreter();
            interpreter.run(executor, field, UI);
        }
        catch (RuntimeException e){
            logger.debug("Caught RuntimeException: " + e.getLocalizedMessage());
            System.err.println("RuntimeException: " + e.getLocalizedMessage());
            e.printStackTrace();
        }
        catch (ReflectiveOperationException e) {
            logger.debug("Caught ReflectiveOperationException: " + e.getLocalizedMessage());
            System.err.println("ReflectiveOperationException: " + e.getLocalizedMessage());
            e.printStackTrace();
        }
        catch (IOException e){
            logger.debug("Caught IOException: " + e.getLocalizedMessage());
            System.err.print("IOException: " + e.getLocalizedMessage());
            e.printStackTrace();
        }
        logger.info("ru.nsu.dyuganov.logoworld.Main finished work.");
    }
}
