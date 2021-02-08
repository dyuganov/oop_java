package ru.nsu.Dyuagnov.LogoWorld.Executor;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;

public interface Executor {
    public void move(Direction direction);
    //public void move(ru.nsu.Dyuagnov.LogoWorld.Coordinates.ru.nsu.Dyuagnov.LogoWorld.Coordinates coords);
    public void teleport(Coordinates coords);
    public void draw();
    public void ward();

}
