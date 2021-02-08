package ru.nsu.Dyuagnov.LogoWorld.Commands;

import java.lang.reflect.Field;

public interface Command {
    void execute(String[] args, Field field);
}
