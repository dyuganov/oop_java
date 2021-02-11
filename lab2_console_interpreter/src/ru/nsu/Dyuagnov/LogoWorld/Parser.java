package ru.nsu.Dyuagnov.LogoWorld;

import ru.nsu.Dyuagnov.LogoWorld.Commands.*;
import ru.nsu.Dyuagnov.LogoWorld.Commands.CommandFactories.*;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;

import java.util.Locale;

public class Parser {
    public Command parse(String commandLine, Executor executor, Field field){
        commandLine = commandLine.toUpperCase(Locale.ROOT);
        String[] args = commandLine.split(" ");

        CommandFactory commandFactory = null;
        switch (args[0]) {
            // INIT <width> <height> <x> <y>
            case "INIT" -> commandFactory = new InitCommandFactory();
            // MOVE [L|R|U|D] <steps>
            case "MOVE" -> commandFactory = new MoveCommandFactory();
            // DRAW
            case "DRAW" -> commandFactory = new DrawCommandFactory();
            // WARD
            case "WARD" -> commandFactory = new WardCommandFactory();
            // TELEPORT <x> <y>
            case "TELEPORT" -> commandFactory = new TeleportCommandFactory();
            default -> {
                System.out.println("Wrong command.");
                return null;
            }
        }
        return commandFactory.create(new CommandArgs(executor, field, args));
    }
}
