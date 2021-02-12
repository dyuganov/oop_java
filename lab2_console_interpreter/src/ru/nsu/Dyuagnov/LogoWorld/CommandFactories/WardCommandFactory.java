package ru.nsu.Dyuagnov.LogoWorld.Commands.CommandFactories;

import ru.nsu.Dyuagnov.LogoWorld.Commands.Command;
import ru.nsu.Dyuagnov.LogoWorld.Commands.CommandArgs;
import ru.nsu.Dyuagnov.LogoWorld.Commands.WardCommand;

public class WardCommandFactory implements CommandFactory {

    @Override
    public Command create(CommandArgs commandArgs) {
        return new WardCommand(commandArgs);
    }
}
