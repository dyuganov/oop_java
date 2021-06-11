package main.java.ru.nsu.dyuganov.server.ThreadPool;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
    Set<Thread> threadSet = new HashSet<>();
    Queue<ThreadPoolTask> taskQueue = new ConcurrentLinkedQueue<>();

    public ThreadPool(int poolSize){
        for(int i = 0; i < poolSize; ++i){
            threadSet.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    while(!Thread.interrupted()){
                        if(!taskQueue.isEmpty()) {
                            taskQueue.poll().execute();
                        } else{
                            waitForTasks();
                        }
                    }
                }
            }));
        }
    }

    /**
     * Executes task. If there are non-started threads, start them.
     * */
    public void execute(ThreadPoolTask task){
        if(task == null) return;
        this.taskQueue.add(task);
        notifyAll();

        if(!taskQueue.isEmpty() && !isAllThreadsRunning()) {
            int tasksCnt = taskQueue.size();
            startThreads(tasksCnt);
        }
    }

    /**
     * Starts only created threads. If tasksQueue.size is less than threadPool.size, starts tasksQueue.size threads.
     * */
    private void startThreads(int threadsToStartNum){
        for(Thread thread : threadSet){
            if(!thread.isAlive() && threadsToStartNum > 0) thread.start();
            --threadsToStartNum;
        }
    }

    private boolean isAllThreadsRunning(){
        boolean result = true;
        for(Thread thread : threadSet){
            if (!thread.getState().equals(Thread.State.RUNNABLE)) {
                result = false;
                break;
            }
        }
        return result;
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


    /**
     * Starts only one thread of pool. Other threads will be started if needed.
     * */
    public void start(){
        threadSet.iterator().next().start();
    }

    public void interruptAll(){
        for(Thread thread : threadSet){
            thread.interrupt();
        }
    }
}
