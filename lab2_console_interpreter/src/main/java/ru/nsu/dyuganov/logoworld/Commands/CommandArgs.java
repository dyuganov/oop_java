package ru.nsu.dyuganov.logoworld.Commands;

import ru.nsu.dyuganov.logoworld.Executor.Executor;
import ru.nsu.dyuganov.logoworld.Field.Field;

/**
 * Universal arguments for commands.
 * Contains ru.nsu.dyuganov.logoworld.Executor, ru.nsu.dyuganov.logoworld.Field and String[] with original line after splitting.
 * */
public class CommandArgs {
    private Executor executor;
    private Field field ;
    private String[] args;

    /**
     * @param executor abstract LogoWorld executor.
     * @param field main game field for executor to interact.
     * @param args parsed arguments from user command.
     * */
    public CommandArgs(Executor executor, Field field, String[] args){
        this.executor = executor;
        this.field = field;
        this.args = args;
    }

    public String[] getArgs(){
        return args;
    }

    public Executor getExecutor(){
        return executor;
    }

    public Field getField(){
        return field;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}
