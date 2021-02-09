package ru.nsu.Dyuagnov.LogoWorld;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Robot;

public class Interpreter {
    private Executor executor = null;

    public Interpreter(){
        executor = new Robot(new Coordinates(0,0));
    }
    public Interpreter(Executor executor){
        this.executor = executor;
    }

    public void run(){


        while(true){

        }
    }
}
