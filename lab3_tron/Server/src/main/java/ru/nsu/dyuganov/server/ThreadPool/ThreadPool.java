package main.java.ru.nsu.dyuganov.server.ThreadPool;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ThreadPool {
    Map<Integer, Thread> threads = new HashMap<>();
    Queue<>
    Thread mainThread;

    public ThreadPool(int size){
        for(int i = 0; i < size; ++i){

        }
    }

    public void start(){
        mainThread.start();
    }

    public void stop(){
        mainThread.interrupt();
    }

}
