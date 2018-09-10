package org.farrukh.java.array;

public class Home {

    private Room[] rooms;

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Home:");
        for (Room room : rooms) {
            builder.append("{");
            Thing[] things = room.getThings();
            for (Thing thing : things) {
                builder.append(" Room: ");
                builder.append(room.getName()).append(",");
                builder.append(" Thing: ");
                builder.append(thing.getName());

            }
            builder.append("}");
        }
        return builder.toString();
    }

}
