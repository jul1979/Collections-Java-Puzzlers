package be.smals.paumard;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record Location(double longitude, double latitude) {

    //constructeur canonique explicite
   /* public Location(double longitude, double latitude) {
        if (longitude < 0 || latitude < 0)
            System.out.printf("longitude:%.2f  is negative!\n", longitude);
        this.latitude = Math.abs(latitude);
        this.longitude = Math.abs(longitude);
    }*/

    //constructeur compact
    public Location {
        if (longitude < 0 || latitude < 0) {
            System.out.printf("longitude:%.2f  is negative!\n", longitude);
        }
        latitude = Math.abs(latitude);
        longitude = Math.abs(longitude);
    }

    //constructeur non canonique 1
    public Location(String coordinates) {
        this(Double.parseDouble(coordinates.split(":")[0]),
                Double.parseDouble(coordinates.split(":")[1]));
    }

    //constructeur non canonique 2
    public Location(double latitude) {
        this(latitude, 0.0);
    }

    public static void test() {
        record Team(String name, List<String> members) {
            private static final String TYPE = "GEOMETRIC";

            Team {
                members = List.copyOf(members);
            }
        }
        Team bulls = new Team("bobcats", new ArrayList<>(List.of("michael", "scottie", "Dennis")));
    }

    public static void main(String[] args) {
        // System.out.printf("%s%n", DayOfWeek.MONDAY.plus(3));
        //System.out.printf("now: %s%n", LocalDateTime.now());
        boolean dayOfMonth = LocalDate.now().isLeapYear();
        System.out.println("dayOfMonth = " + dayOfMonth);
        System.out.printf(
                "now: %s%n",
                LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                )
        );
    }
}

