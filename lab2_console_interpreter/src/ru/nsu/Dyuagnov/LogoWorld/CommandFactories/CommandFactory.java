package ru.nsu.Dyuagnov.LogoWorld.CommandFactories;

import ru.nsu.Dyuagnov.LogoWorld.Commands.Command;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandFactory {
    private final Map<String, Command> commands = new HashMap<String, Command>();

    public Command create(final String commandName) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (commands.containsKey(commandName)){
            return commands.get(commandName);
        }
        else{
            final Properties properties = new Properties();
            properties.load(Command.class.getResourceAsStream("CommandFactory.properties")); // расположение относительно CLASS_NAME.class.getResourceAsStrea
            Class loadedClass = Class.forName(properties.getProperty(commandName));
            Command newCommand = (Command)loadedClass.getConstructor().newInstance();
            commands.put(commandName, newCommand);
            return newCommand;
        }
    }
}
