package main.ru.nsu.dyuagnov.logoworld;

import main.ru.nsu.dyuagnov.logoworld.Coordinates.Coordinates;
import main.ru.nsu.dyuagnov.logoworld.Executor.Direction;
import main.ru.nsu.dyuagnov.logoworld.Executor.Robot;
import main.ru.nsu.dyuagnov.logoworld.UI.UI;
import main.ru.nsu.dyuagnov.logoworld.Executor.Executor;
import main.ru.nsu.dyuagnov.logoworld.Field.Field;
import main.ru.nsu.dyuagnov.logoworld.UI.ConsoleUI;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;

public class Main {
    private final static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        DOMConfigurator.configure("src/java/resources/log4j.xml");
        //logger.setLevel(Level.DEBUG);
        logger.debug("Main started.");
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
        logger.debug("Main finished work.");
    }
}
