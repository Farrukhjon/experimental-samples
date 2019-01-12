package util.concurrent.synchronizers.semaphore;

import java.util.Random;

class RestaurantCustomer extends Thread {

    private final Restaurant restaurant;
    private final int customerID;
    private static final Random random = new Random();

    RestaurantCustomer(final Restaurant restaurant, final int customerID) {
        this.restaurant = restaurant;
        this.customerID = customerID;
    }

    @Override
    public void run() {
        restaurant.useTable(this.customerID);
        try {
            int eatingTime = random.nextInt(30) + 1;
            System.out.printf("%s %s %s %s %s", "\nThe customer", this.customerID, "will eating for", eatingTime, "seconds.");
            Thread.sleep(eatingTime * 1000);
            System.out.printf("%s %s %s ", "\nThe customer", this.customerID, "is done  eating.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            restaurant.returnTable(this.customerID);
        }
    }
}
