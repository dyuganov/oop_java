package ru.nsu.Dyuagnov.LogoWorld.Commands.CommandFactories;

import ru.nsu.Dyuagnov.LogoWorld.Commands.Command;
import ru.nsu.Dyuagnov.LogoWorld.Commands.CommandArgs;
import ru.nsu.Dyuagnov.LogoWorld.Commands.DrawCommand;

public class DrawCommandFactory implements CommandFactory {
    @Override
    public Command create(CommandArgs commandArgs) {
        return new DrawCommand(commandArgs);
    }
}
