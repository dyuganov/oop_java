package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;



/**
 * Universal arguments for commands.
 *
 *
 * */
public class CommandArgs {
    private Executor executor;
    private Field field ;
    private String[] args;

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
