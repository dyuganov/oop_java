package ru.nsu.Dyuagnov.LogoWorld;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Robot;

import java.util.Scanner;


public class Interpreter {
    public Interpreter(){}

    public void run(){
        Scanner in = new Scanner(System.in);
        Parser parser = new Parser();
        Executor executor = new Robot(new Coordinates(0,0));

        while(true){
            parser.parse(in.nextLine(), executor).execute();

        }
    }
}
