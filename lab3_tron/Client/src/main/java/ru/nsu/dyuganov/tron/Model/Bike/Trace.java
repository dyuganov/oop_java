package main.java.ru.nsu.dyuganov.tron.Model.Bike;


import main.java.ru.nsu.dyuganov.tron.Model.Coordinates.Coordinates;

import java.util.ArrayList;

public class Trace {
    private final ArrayList<Coordinates> trace;

    public Trace() {
        trace = new ArrayList<Coordinates>();
    }

    public void addPoint(Coordinates coordinates) {
        if (coordinates != null) {
            trace.add(coordinates);
        } else {
            throw new IllegalArgumentException("Cant add point to trace. Coordinates == null.");
        }
    }

    public boolean contains(Coordinates coordinates) {
        return trace.contains(coordinates);
    }

    public void clear() {
        trace.clear();
    }

    public ArrayList<Coordinates> getTrace(){
        return trace;
    }

    public void deletePoint(Coordinates coordinates) {
        trace.remove(coordinates);
    }

    public boolean isEmpty() {
        return trace.isEmpty();
    }

    public int size() {
        return trace.size();
    }
}