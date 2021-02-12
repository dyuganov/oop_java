package ru.nsu.Dyuagnov.LogoWorld;

import ru.nsu.Dyuagnov.LogoWorld.CommandFactories.CommandFactory;
import ru.nsu.Dyuagnov.LogoWorld.Commands.Command;
import ru.nsu.Dyuagnov.LogoWorld.Commands.CommandArgs;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;

import java.io.IOException;
import java.util.Locale;

public class Parser {
    private final CommandArgs commandArgs = new CommandArgs(null, null, null);
    private final CommandFactory commandFactory = new CommandFactory();

    public Command parse(String commandLine, Executor executor, Field field) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        commandArgs.setArgs(commandLine.toUpperCase(Locale.ROOT).split(" "));
        commandArgs.setExecutor(executor);
        commandArgs.setField(field);
        commandFactory.create(commandArgs.getArgs()[0]).execute(commandArgs);
        // Варианты как сделать нормально:
        // - команда при создании внутри по ссылке хранит класс аргументов,
        // парсер меняет этот объект каждый раз, чтобы получались актуальные аргументы
        // - парсер переносится в основной цикл

        return null;
    }
}
