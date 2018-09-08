package org.farrukh.java.array;

public class Main {

    public static void main(String[] args) {
        Home myHome = new Home();

        Room[] myRooms = {new Room("Bad room"), new Room("Bath room"), new Room("Kitchen room")};

        for (Room myRoom : myRooms) {
            myRoom.setThings(new Thing[]{new Thing("A")});
        }

        //showHome(myHome);


        myHome.setRooms(myRooms);

        showHome(myHome);

        updateThings(myHome);

        showHome(myHome);

    }

    private static void updateThings(Home myHome) {
        Room[] rooms = myHome.getRooms();
        for (Room myRoom : rooms) {
            myRoom.setThings(new Thing[]{new Thing("B")});
        }
    }

    private static void showHome(Home myHome) {
        System.out.println(myHome);
    }

}
