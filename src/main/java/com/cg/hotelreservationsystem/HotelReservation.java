package com.cg.hotelreservationsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class HotelReservation {

    //Global Scanner
    static Scanner sc=new Scanner(System.in);

    //creating global list of hotel
    private static ArrayList<HotelObject> hotelList;

    public HotelReservation() {
        hotelList = new ArrayList<HotelObject>();
    }

    public void addToList(HotelObject hotel) {
        hotelList.add(hotel);
    }

    public boolean addHotel(String hotelName, int rateWeekdayRegular,int rateWeekendRegular) {

        HotelObject hotel = new HotelObject(hotelName,rateWeekdayRegular);
        hotel.setWeekendRates(rateWeekendRegular);
        addToList(hotel);
        return true;
    }

    public void display() {
        for (HotelObject hotel:hotelList) {
            hotel.display();
        }
    }

    public int daysRented(String start_date, String end_date) {

        try {
            Date startDate= new SimpleDateFormat("DD.MM.yyyy").parse(start_date);
            Date endDate= new SimpleDateFormat("DD.MM.yyyy").parse(end_date);
            long time_diff = startDate.getTime() - endDate.getTime();
            return (int) (2+(time_diff / (1000 * 60 * 60 * 24)));
        }catch(ParseException exception){
            exception.printStackTrace();
        }
        return 0;
    }

    public Customer findCheapestHotel(String start_date, String end_date) {

        int daysStayed=daysRented(start_date, end_date);
        Optional<HotelObject> cheapestHotelOpt = hotelList.stream().min(Comparator.comparing(
                HotelObject::getrateWeekdayRegular));

        HotelObject cheapestHotel = cheapestHotelOpt.get();
        int bill=daysStayed*cheapestHotel.getrateWeekdayRegular();

        return new Customer(cheapestHotel.hotelName, daysStayed, bill);
    }

    public static void main( String[] args )
    {

        //Default entries
        HotelReservation buildObj = new HotelReservation();
        buildObj.addHotel("Lakewood", 110,90);
        buildObj.addHotel("Bridgewood", 160,50);
        buildObj.addHotel("Ridgewood", 220,150);

        System.out.println( "Welcome to Hotel Reservation Program" );

        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println();

        System.out.println("What do you want to do?");
        System.out.println("1. Add Hotel Entry.");
        System.out.println("2. Find Cheapest Hotel.");
        String user_input=sc.next();

        //Initializing main program
        switch(user_input) {

            case "1": {
                System.out.println("Please add hotel.");
                System.out.println();
                System.out.print("Enter hotel name: ");
                String hotelName = sc.next();
                System.out.print("Enter regular rate of rooms: ");
                int rateWeekdayRegular = sc.nextInt();
                System.out.print("Enter WeekDay rate of rooms: ");
                int rateWeekday = sc.nextInt();
                System.out.print("Enter Weekend rate of rooms: ");
                int rateWeekendRegular = sc.nextInt();

                buildObj.addHotel(hotelName, rateWeekdayRegular, rateWeekendRegular);
                break;
            }
            case "2": {
                System.out.println("Enter date range to find hotel in format(DD.MM.yyyy)");
                System.out.println("Enter Check-In date: ");
                String start_date = sc.next();
                System.out.println("Enter Check-Out date: ");
                String end_date = sc.next();
                Customer cust = buildObj.findCheapestHotel(start_date,end_date);

                cust.showBill();
                break;
            }
            default:
                System.out.println("Unknown input.");
        }
    }
}