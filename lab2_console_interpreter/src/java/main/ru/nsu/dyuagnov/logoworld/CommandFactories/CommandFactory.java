package main.ru.nsu.dyuagnov.logoworld.CommandFactories;

import main.ru.nsu.dyuagnov.logoworld.Commands.Command;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Creates command objects that implement Command interface.
 * Stores created commands.
 * */
public class CommandFactory {
    private final static Logger logger = LogManager.getLogger(CommandFactory.class);
    private final Map<String, Command> commands = new HashMap<String, Command>();

    /**
     * Creates command using command name as a key.
     *
     * @param commandName key for creation a command.
     *                    This key + command class name are in "CommandList.properties" file.
     *                    Commands create in runtime using reflection.
     *
     * Checks that first command is "INIT".
     * */
    public Command create(final String commandName) throws IOException, ReflectiveOperationException {
        DOMConfigurator.configure("src/java/resources/log4j.xml");
        logger.debug("Command creation started.");
        logger.debug("Got args command name: " + commandName);
        if (commands.containsKey(commandName)){
            logger.info("Found command in cache.");
            logger.debug("Command creation finished.");
            return commands.get(commandName);
        }
        else{
            if(!commands.containsKey("INIT") && !commandName.equals("INIT")){
                logger.error("Throw IllegalArgumentException. Command name is not INIT and no INIT command found in cache.");
                throw new IllegalArgumentException("First command should be \"INIT\". ");
            }
            final Properties properties = new Properties();
            properties.load(Command.class.getResourceAsStream("CommandList.properties")); // расположение относительно CLASS_NAME.class.getResourceAsStrea
            logger.debug("Properties file loaded.");
            Class loadedClass = Class.forName(properties.getProperty(commandName));
            logger.debug("Loaded class from properties by name.");
            Command newCommand = (Command)loadedClass.getConstructor().newInstance();
            logger.info("Created new command.");
            commands.put(commandName, newCommand);
            logger.debug("Command put to cache.");
            logger.debug("Command creation finished.");
            return newCommand;
        }
    }
}
