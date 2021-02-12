package ru.nsu.Dyuagnov.LogoWorld.CommandFactories;

import ru.nsu.Dyuagnov.LogoWorld.Commands.Command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandFactory {
    private final Map<String, Command> commands = new HashMap<String, Command>();

    public Command create(final String commandName) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (commands.containsKey(commandName)){
            return commands.get(commandName);
        }
        else{
            final Properties properties = new Properties();
            properties.load(CommandFactory.class.getResourceAsStream("CommandFactory.properties"));
            Class loadedClass = Class.forName(properties.getProperty(commandName));
            return commands.put(commandName, (Command)loadedClass.newInstance()); // newInstance() вернуло null
       }
    }
}
