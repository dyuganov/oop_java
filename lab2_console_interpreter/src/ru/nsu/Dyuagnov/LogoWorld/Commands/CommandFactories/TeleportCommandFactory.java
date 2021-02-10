package ru.nsu.Dyuagnov.LogoWorld.Commands.CommandFactories;

import ru.nsu.Dyuagnov.LogoWorld.Commands.Command;
import ru.nsu.Dyuagnov.LogoWorld.Commands.CommandArgs;
import ru.nsu.Dyuagnov.LogoWorld.Commands.InitCommand;
import ru.nsu.Dyuagnov.LogoWorld.Commands.TeleportCommand;

public class TeleportCommandFactory implements CommandFactory {
    @Override
    public Command create(CommandArgs commandArgs) {
        return new TeleportCommand(commandArgs);
    }
}
