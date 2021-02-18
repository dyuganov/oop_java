package ru.nsu.dyuganov.logoworld.UI;

import ru.nsu.dyuganov.logoworld.Executor.Executor;
import ru.nsu.dyuganov.logoworld.Field.Field;

/**
 * Interface for display.
 * */
public interface UI {
    void draw(Executor executor, Field field);
}
