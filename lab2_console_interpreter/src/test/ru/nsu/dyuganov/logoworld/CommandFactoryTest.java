package ru.nsu.dyuganov.logoworld;

import org.junit.jupiter.api.Test;
import main.ru.nsu.dyuagnov.logoworld.CommandFactories.CommandFactory;
import main.ru.nsu.dyuagnov.logoworld.Commands.Command;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class CommandFactoryTest {
    private CommandFactory commandFactory = new CommandFactory();

    @Test
    void create(){
        try{
            String[] commandNames = {"INIT", "DRAW", "WARD", "MOVE", "TELEPORT"};
            for(String name : commandNames){
                Command command = commandFactory.create(name);
                assertNotEquals(null, command);
                assertNotEquals(null, commandFactory.create(name));
                assertEquals(command, commandFactory.create(name));
            }
        } catch (IOException | InstantiationException | InvocationTargetException |
                NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
