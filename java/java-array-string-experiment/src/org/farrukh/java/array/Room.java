package org.farrukh.java.array;

public class Room {

    private final String name;

    private Thing[] things;

    public Room(String name) {
        this.name = name;
    }

    public Thing[] getThings() {
        return things;
    }

    public void setThings(Thing[] things) {
        this.things = things;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Room: " + this.name;
    }

}
