package org.farrukh.experiments.dp.behavioral.strategy.ch1;

/**
 * @author Farrukhjon SATTOROV
 */
public class Robot {

    private IBehavior strategy;
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public IBehavior getStrategy() {
        return strategy;
    }

    public void move() {
        System.out.print(this.name + " ");
        int command = strategy.moveCommand();
        System.out.println(this.name + " " + String.valueOf(command));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrategy(IBehavior strategy) {
        this.strategy = strategy;
    }
}
