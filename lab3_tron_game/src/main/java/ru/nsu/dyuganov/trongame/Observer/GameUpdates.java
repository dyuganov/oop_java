package ru.nsu.dyuganov.trongame.Observer;

import ru.nsu.dyuganov.trongame.Model.Bike.Bike;
import ru.nsu.dyuganov.trongame.Model.Bike.Trace;

import java.util.HashMap;
import java.util.Map;

public class GameUpdates {
    private Map<Integer, Bike> bikes = null;
    private Map<Integer, Trace> traces = null;

    public GameUpdates(Map<Integer, Bike> bikes, Map<Integer, Trace> traces){
        this.bikes = new HashMap<>(bikes);
        this.traces = new HashMap<>(traces);
    }

    public Map<Integer, Bike> getBikes(){
        return bikes;
    }

    public Map<Integer, Trace> getTraces() {
        return traces;
    }

    public void setBikes(Map<Integer, Bike> bikes) {
        this.bikes = bikes;
    }

    public void setTraces(Map<Integer, Trace> traces) {
        this.traces = traces;
    }
}
