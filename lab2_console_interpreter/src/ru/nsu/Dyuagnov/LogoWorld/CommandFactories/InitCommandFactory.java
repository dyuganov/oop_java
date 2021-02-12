package ru.nsu.Dyuagnov.LogoWorld.Commands.CommandFactories;

import ru.nsu.Dyuagnov.LogoWorld.Commands.Command;
import ru.nsu.Dyuagnov.LogoWorld.Commands.CommandArgs;
import ru.nsu.Dyuagnov.LogoWorld.Commands.InitCommand;

public class InitCommandFactory implements CommandFactory {

    @Override
    public Command create(CommandArgs commandArgs) {
        return new InitCommand(commandArgs);
    }
}
