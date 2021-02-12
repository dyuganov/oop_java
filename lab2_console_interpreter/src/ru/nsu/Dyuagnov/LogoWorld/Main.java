package ru.nsu.Dyuagnov.LogoWorld;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            Interpreter interpreter = new Interpreter();
            interpreter.run();
        }
        catch (RuntimeException e){
            System.out.println("RuntimeException: " + e.getLocalizedMessage());
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
