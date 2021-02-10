package ru.nsu.Dyuagnov.LogoWorld;

import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Robot;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;

import java.util.Scanner;


public class Interpreter {
    public Interpreter(){}

    public void run(){
        Scanner in = new Scanner(System.in);
        Parser parser = new Parser();
        Executor executor = new Robot(new Coordinates(0,0));
        Field field = new Field();

        while(true){
            parser.parse(in.nextLine(), executor, field).execute();

        }
    }
}
