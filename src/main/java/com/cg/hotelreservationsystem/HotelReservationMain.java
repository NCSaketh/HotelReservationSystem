package com.cg.hotelreservationsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservationMain {

    Scanner input = new Scanner(System.in);
    public ArrayList<Hotel> hotelList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Great Hotel Reservation System");
    }


    //UC1 : Adding hotel for regular customers
    private List<Hotel> addHotel(){
        System.out.println("Enter the Hotel's Name: ");
        String hotelName = input.nextLine();
        System.out.println("Enter the rate for Customers: ");
        int rate = input.nextInt();
        input.nextLine();

        Hotel hotel = new Hotel(hotelName, rate);
        hotelList.add(hotel);
        return hotelList;
    }

}
