package ru.nsu.Dyuagnov.LogoWorld.Executor;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates;

public interface Executor {
    public void move(Direction direction);
    public void teleport(Coordinates coords);
    public void draw();
    public void ward();
}
