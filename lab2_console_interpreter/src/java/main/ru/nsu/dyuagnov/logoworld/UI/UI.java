package main.ru.nsu.dyuagnov.logoworld.UI;

import main.ru.nsu.dyuagnov.logoworld.Executor.Executor;
import main.ru.nsu.dyuagnov.logoworld.Field.Field;

/**
 * Interface for display.
 * */
public interface UI {
    void draw(Executor executor, Field field);
}
