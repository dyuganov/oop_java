package ru.nsu.Dyuagnov.LogoWorld.Commands;

import java.lang.reflect.Field;

public class Init implements Command{
    @Override
    public void execute(String[] args, Field field) {

    }

    // INIT <width> <height> <x> <y>
    public Init(int width, int height, int x, int y){

    }
}
