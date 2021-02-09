package ru.nsu.Dyuagnov.LogoWorld;

import ru.nsu.Dyuagnov.LogoWorld.Commands.*;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Direction;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;

import java.util.Locale;


import static java.lang.Integer.parseInt;

public class Parser {
    public Command parse(String commandLine, Executor executor, Field field){
        commandLine = commandLine.toUpperCase(Locale.ROOT);
        String[] args = commandLine.split(" ");

        switch (args[0]){
            case "INIT": // INIT <width> <height> <x> <y>
                return new InitCommand(new CommandArgs(executor, field, args)); // TODO сделать это через фабрику

            case "MOVE": // MOVE [L|R|U|D] <steps>
                return new MoveCommand(new CommandArgs(executor, field, args));

            case "DRAW": // DRAW
                return new DrawCommand(new CommandArgs(executor, field, args));

            case "WARD": // WARD
                return new WardCommand(new CommandArgs(executor, field, args));

            case "TELEPORT": // TELEPORT <x> <y>
                return new TeleportCommand(new CommandArgs(executor, field, args));

            default:
                System.out.println("Wrong command.");
                return null;
        }
    }
}
