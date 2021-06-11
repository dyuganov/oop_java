import java.util.concurrent.TimeUnit;

public class Waiter implements Runnable{
    private Meal meal;
    //int mealsCnt=0;

    Waiter( Meal meal){
        this.meal = meal;
        //this.mealsCnt = mealsCnt;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            try {
                meal.waitForCooked();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            meal.setServed();

        }
    }
}
