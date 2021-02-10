package ru.nsu.Dyuagnov.LogoWorld;

public class Main {
    public static void main(String[] args) {
        try{
            Interpreter interpreter = new Interpreter();
            interpreter.run();
        }
        catch (RuntimeException e){
            System.out.println("RuntimeException: " + e.getLocalizedMessage() + "\n" + e.getMessage());
        }
    }
}
