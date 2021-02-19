package ru.nsu.dyuganov.logoworld.UI;

import ru.nsu.dyuganov.logoworld.AbstractExecutor.AbstractExecutor;
import ru.nsu.dyuganov.logoworld.Field.Field;

/**
 * Interface for display.
 * */
public interface UI {
    void draw(AbstractExecutor abstractExecutor, Field field);
}
