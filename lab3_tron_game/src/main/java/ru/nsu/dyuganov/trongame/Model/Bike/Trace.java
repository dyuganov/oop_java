package ru.nsu.dyuganov.trongame.Model.Bike;

import ru.nsu.dyuganov.trongame.Model.Coordinates.Coordinates;

import java.util.ArrayList;

public class Trace {
    ArrayList<Coordinates> trace;
    Trace(){
        trace = new ArrayList<Coordinates>();
    }

    void addPoint(Coordinates coordinates){
        if(coordinates != null){
            trace.add(coordinates);
        }
        else{
            throw new IllegalArgumentException("Trace.addPoint(Coordinates coordinates) error. Coordinates == null.");
        }
    }

    void clear(){
        trace.clear();
    }
}
