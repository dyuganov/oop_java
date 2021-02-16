package main.ru.nsu.dyuagnov.logoworld.CommandFactories;

import main.ru.nsu.dyuagnov.logoworld.Commands.Command;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Creates command objects that implement ru.nsu.Dyuagnov.LogoWorld.Commands.Command.
 * Stores created commands.
 * */
public class CommandFactory {
    private final static Logger logger = LogManager.getLogger(CommandFactory.class);
    private final Map<String, Command> commands = new HashMap<String, Command>();

    /**
     * Creates command using command name as a key.
     *
     * @param commandName - key for creation a command.
     *                    This key + command class name are in "CommandList.properties" file.
     *                    Commands create in runtime using reflection.
     *
     * Checks that first command is "INIT".
     * */
    public Command create(final String commandName) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (commands.containsKey(commandName)){
            return commands.get(commandName);
        }
        else{
            if(!commands.containsKey("INIT") && !commandName.equals("INIT")){
                throw new RuntimeException("First command should be \"INIT\". ");
            }
            final Properties properties = new Properties();
            properties.load(Command.class.getResourceAsStream("CommandList.properties")); // расположение относительно CLASS_NAME.class.getResourceAsStrea
            Class loadedClass = Class.forName(properties.getProperty(commandName));
            Command newCommand = (Command)loadedClass.getConstructor().newInstance();
            commands.put(commandName, newCommand);
            return newCommand;
        }
    }
}
