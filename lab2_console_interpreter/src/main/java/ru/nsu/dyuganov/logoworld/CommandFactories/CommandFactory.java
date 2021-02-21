package ru.nsu.dyuganov.logoworld.CommandFactories;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.nsu.dyuganov.logoworld.Commands.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Creates command objects that implement Command interface.
 * Stores created commands.
 */
public class CommandFactory {
    private final static Logger logger = LogManager.getLogger(CommandFactory.class);
    private final Map<String, Command> commands = new HashMap<String, Command>();

    public CommandFactory() {
        DOMConfigurator.configure("src/main/resources/ru.nsu.dyuganov.logoworld/log4j.xml");
    }

    /**
     * Creates command using command name as a key.
     *
     * @param commandName key for creation a command.
     *                    This key + command class name are in "commandlist.properties" file.
     *                    Commands are created in runtime using reflection.
     *                    <p>
     *                    Checks that first command is "INIT".
     */
    public Command create(final String commandName) throws IOException {
        logger.debug("Command creation started.");
        logger.debug("Got args command name: " + commandName);

        if (commands.containsKey(commandName)) {
            logger.info("Found command in cache.");
            logger.debug("Command creation finished.");
            return commands.get(commandName);
        }
        if (!commands.containsKey("INIT") && !commandName.equals("INIT")) {
            logger.error("Command name is not INIT and no INIT command found in cache.");
            System.err.println("First command must be INIT.");
            return null;
        }

        String commandsFileName = "src/main/resources/ru.nsu.dyuganov.logoworld/commandlist.properties";
        final Properties properties = getProperties(commandsFileName);
        Command newCommand = createCommand(commandName, properties);
        commands.put(commandName, newCommand);

        logger.debug("Command put to cache.");
        logger.debug("Command creation finished.");
        return newCommand;
    }

    private Properties getProperties(final String commandsFileName) throws IOException {
        final Properties properties = new Properties();
        try (BufferedReader propertiesReader = new BufferedReader(new FileReader(commandsFileName))) {
            properties.load(propertiesReader);
            logger.debug("Loaded file with command classes names.");
        }
        return properties;
    }

    private Command createCommand(final String commandName, final Properties properties){
        logger.debug("Properties file loaded.");
        Command newCommand = null;
        try {
            Class loadedClass = Class.forName(properties.getProperty(commandName));
            logger.debug("Loaded class from properties by name.");
            newCommand = (Command) loadedClass.getConstructor().newInstance();
            logger.info("Created new command.");
        } catch (ReflectiveOperationException | RuntimeException e) {
            logger.error("Can't find command in properties or other problem while creating command: " + e.getStackTrace());
            System.err.println("Can't create command.");
            logger.debug("Command creation finished.");
            return null;
        }
        return newCommand;
    }
}






