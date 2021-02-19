package ru.nsu.dyuganov.logoworld.Commands;

import ru.nsu.dyuganov.logoworld.AbstractExecutor.AbstractExecutor;
import ru.nsu.dyuganov.logoworld.Field.Field;

/**
 * Universal arguments for commands.
 * Contains abstract Executor, Field and String[] with original line after splitting.
 */
public class CommandArgs {
    private AbstractExecutor abstractExecutor;
    private Field field;
    private String[] args;

    /**
     * @param abstractExecutor abstract LogoWorld executor.
     * @param field    main game field for executor to interact.
     * @param args     parsed arguments from user command.
     */
    public CommandArgs(AbstractExecutor abstractExecutor, Field field, String[] args) {
        this.abstractExecutor = abstractExecutor;
        this.field = field;
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    public AbstractExecutor getExecutor() {
        return abstractExecutor;
    }

    public Field getField() {
        return field;
    }

    public void setExecutor(AbstractExecutor abstractExecutor) {
        this.abstractExecutor = abstractExecutor;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}
