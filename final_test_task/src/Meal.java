public class Meal {
    private boolean isCooked = false; // EDA is prigotovlena (true) or sъedena (false)

    public synchronized void setCooked(){
        this.isCooked = true;
        System.out.println("Cooked");
        notify();
    }
    public synchronized void setServed(){
        this.isCooked = false;
        System.out.println("Served");
        notify();
    }

    public synchronized void waitForCooked() throws InterruptedException {
        while(!isCooked) {
            wait();
        }
    }
    public synchronized void waitForServed() throws InterruptedException {
        while(isCooked){
            wait();
        }
    }

}
