package com.cg.hotelreservationsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {

    //Global Scanner
    static Scanner sc = new Scanner(System.in);

    //creating global list of hotel
    private static ArrayList<HotelObject> hotelList;

    public HotelReservation() {
        hotelList = new ArrayList<HotelObject>();
    }

    public void addToList(HotelObject hotel) {
        hotelList.add(hotel);
    }

    public boolean addHotel(String hotelName, int rate_regular, String cust_type) {
        HotelObject hotel = new HotelObject(hotelName, rate_regular, cust_type);
        addToList(hotel);
        return true;
    }

    public boolean addHotel(String hotelName, int rate_regular) {
        HotelObject hotel = new HotelObject(hotelName, rate_regular, "regular");
        addToList(hotel);
        return true;
    }

    public void display() {
        for (HotelObject hotel : hotelList) {
            hotel.display();
        }
    }

    public static void main(String[] args) {

        //Default entries
        HotelReservation buildObj = new HotelReservation();
        buildObj.addHotel("Lakewood", 110);
        buildObj.addHotel("Bridgewood", 160);
        buildObj.addHotel("Ridgewood", 220);

        System.out.println("Welcome to Hotel Reservation Program");

        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println();

        System.out.println("Please add hotel.");
        System.out.println();
        System.out.print("Enter hotel name: ");
        String hotelName = sc.next();
        System.out.print("Enter regular rate of rooms: ");
        int rate_regular = sc.nextInt();

        buildObj.addHotel(hotelName, rate_regular);

        //Showing results
        buildObj.display();
    }
}
