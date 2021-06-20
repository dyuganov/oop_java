package main.java.ru.nsu.dyuganov.tron.Model.Bike;


import main.java.ru.nsu.dyuganov.tron.Model.Coordinates.Coordinates;

import java.util.ArrayList;

public class Trace {
    final ArrayList<Coordinates> trace;
    Trace(){
        trace = new ArrayList<Coordinates>();
    }

    void addPoint(Coordinates coordinates){
        if(coordinates != null){
            trace.add(coordinates);
        }
        else{
            throw new IllegalArgumentException("Cant add point to trace. Coordinates == null.");
        }
    }

    void deletePoint(Coordinates coordinates){
        trace.remove(coordinates);
    }

    void clear(){
        trace.clear();
    }

    boolean isEmpty(){
        return trace.isEmpty();
    }

    int size(){
        return trace.size();
    }
}