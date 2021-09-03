import java.util.concurrent.TimeUnit;

public class Waiter implements Runnable{
    private Meal meal;

    Waiter( Meal meal){
        this.meal = meal;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            try {
                meal.waitForCooked();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            meal.setServed();

        }
    }
}
