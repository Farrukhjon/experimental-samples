package util.concurrent.synchronizers.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Restaurant {

    private final Semaphore tables;

    public Restaurant(int tablesCount) {
        this.tables = new Semaphore(tablesCount);
    }

    public void useTable(int customerId) {
        try {
            System.out.printf("%s %s %s", "\nThe customer", customerId, "is trying to use a table");
            tables.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void returnTable(int customerId) {
        System.out.printf("%s %s %s", "\nThe customer", customerId, "returned a table");
        tables.release();
    }

    public static void main(String[] args) {
        int tablesCount = 3;
        Restaurant restaurant = new Restaurant(tablesCount);
        for (int customerID = 1; customerID < 5; customerID++) {
            RestaurantCustomer customer = new RestaurantCustomer(restaurant, customerID);
            customer.start();
        }
    }


}

