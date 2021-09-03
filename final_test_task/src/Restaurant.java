public class Restaurant{
    void work(int mealsCnt) throws InterruptedException {
        Meal meal = new Meal();
        Thread chefThread = new Thread(new Chef(mealsCnt, meal));
        Thread waiterThread = new Thread(new Waiter(meal));
        chefThread.start();
        waiterThread.setDaemon(true);
        waiterThread.start();

        chefThread.join();
    }
}
