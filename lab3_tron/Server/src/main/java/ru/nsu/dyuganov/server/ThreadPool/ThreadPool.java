package main.java.ru.nsu.dyuganov.server.ThreadPool;

import main.java.ru.nsu.dyuganov.server.ThreadPool.Tasks.ThreadPoolTask;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
    Set<Thread> threadSet = new HashSet<>();
    Queue<ThreadPoolTask> taskQueue = new ConcurrentLinkedQueue<>();
    boolean shutdownRequest = false;

    public ThreadPool(int poolSize){
        shutdownRequest = false;
        for(int i = 0; i < poolSize; ++i){
            Thread newThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(!Thread.interrupted() || shutdownRequest){
                        if(!taskQueue.isEmpty()) {
                            taskQueue.poll().execute();
                        } else{
                            waitForTasks();
                        }
                    }
                }
            });
            newThread.setDaemon(true);
            threadSet.add(newThread);
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

    public void start(){
        for(Thread thread : threadSet){
            thread.start();
        }
    }

    public void shutdown(){
        shutdownRequest = true;
    }

    public void interruptAll(){
        shutdownRequest = true;
        for(Thread thread : threadSet){
            thread.interrupt();
        }
    }
}
