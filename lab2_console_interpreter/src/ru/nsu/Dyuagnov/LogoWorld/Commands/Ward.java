package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;

import java.lang.reflect.Field;

public class Ward implements Command{


    private Executor executor = null;
    public Ward(Executor executor){
        this.executor = executor;
    }
    @Override
    public void execute() {

    }
}
