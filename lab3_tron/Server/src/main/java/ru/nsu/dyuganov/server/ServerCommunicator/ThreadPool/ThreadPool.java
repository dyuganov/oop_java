package main.java.ru.nsu.dyuganov.server.ServerCommunicator.ThreadPool;

import main.java.ru.nsu.dyuganov.server.ServerCommunicator.ThreadPool.Tasks.ThreadPoolTask;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPool {
    Set<Thread> threadSet = new HashSet<>();
    Queue<ThreadPoolTask> taskQueue = new ConcurrentLinkedQueue<>();
    AtomicBoolean shutdownRequest = new AtomicBoolean(false);

    public ThreadPool(int poolSize) {
        shutdownRequest.set(false);
        for(int i = 0; i < poolSize; ++i){
            Thread newThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(!shutdownRequest.get()){
                        if(!taskQueue.isEmpty()) {
                            try {
                                taskQueue.poll().execute();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else{
                            waitForTasks();
                        }
                    }
                }
            });
            threadSet.add(newThread);
            newThread.start();
        }
    }

    public void execute(ThreadPoolTask task){
        if(task == null) {
            return;
        }
        this.taskQueue.add(task);
        notify();
    }

    private void waitForTasks() {
        while(taskQueue.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        shutdownRequest.set(true);
        notifyAll();
    }

    public void interruptAll(){
        for(Thread thread : threadSet){
            thread.interrupt();
        }
    }
}
