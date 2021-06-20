public class Chef implements Runnable {
    private int mealsNum = 0;
    private Meal meal;

    Chef(int mealsNum, Meal meal){
        this.mealsNum = mealsNum;
        this.meal = meal;
    }

    @Override
    public void run() {
        int cnt = 0;
        while (cnt < mealsNum){
            try {
                meal.waitForServed();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            meal.setCooked();
            ++cnt;
        }
    }
}
