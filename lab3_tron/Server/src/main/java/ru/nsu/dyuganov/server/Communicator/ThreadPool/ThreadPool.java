package main.java.ru.nsu.dyuganov.server.Communicator.ThreadPool;

import main.java.ru.nsu.dyuganov.server.Communicator.ThreadPool.Tasks.ThreadPoolTask;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
    Set<Thread> threadSet = new HashSet<>();
    Queue<ThreadPoolTask> taskQueue = new ConcurrentLinkedQueue<>();
    boolean shutdownRequest = false;

    public ThreadPool(int poolSize) {
        shutdownRequest = false;
        for(int i = 0; i < poolSize; ++i){
            Thread newThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(!shutdownRequest){
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
        if(task == null) return;
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
        shutdownRequest = true;
        notifyAll();
    }

    public void interruptAll(){
        shutdownRequest = true;
        notifyAll();
        for(Thread thread : threadSet){
            thread.interrupt();
        }
    }
}
