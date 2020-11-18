package com.cg.hotelreservationsystem;
<<<<<<< HEAD

import java.util.ArrayList;
import java.util.List;
=======
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;
>>>>>>> UC2_FindCheapestHotel
import java.util.Scanner;

public class HotelReservation {

    //Global Scanner
<<<<<<< HEAD
    static Scanner sc = new Scanner(System.in);
=======
    static Scanner sc=new Scanner(System.in);
>>>>>>> UC2_FindCheapestHotel

    //creating global list of hotel
    private static ArrayList<HotelObject> hotelList;

    public HotelReservation() {
        hotelList = new ArrayList<HotelObject>();
    }

    public void addToList(HotelObject hotel) {
        hotelList.add(hotel);
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public boolean addHotel(String hotelName, int rate_regular, String cust_type) {
        HotelObject hotel = new HotelObject(hotelName, rate_regular, cust_type);
        addToList(hotel);
        return true;
    }

    public boolean addHotel(String hotelName, int rate_regular) {
        HotelObject hotel = new HotelObject(hotelName, rate_regular, "regular");
=======
    public boolean addHotel(String hotelName, int rate_regular) {

        HotelObject hotel = new HotelObject(hotelName,rate_regular);
>>>>>>> UC2_FindCheapestHotel
=======
    public boolean addHotel(String hotelName, int rateWeekdayRegular,int rateWeekendRegular) {

        HotelObject hotel = new HotelObject(hotelName,rateWeekdayRegular);
        hotel.setWeekendRates(rateWeekendRegular);
>>>>>>> UC3_AddWeekDayWeekendRates
        addToList(hotel);
        return true;
    }

    public void display() {
<<<<<<< HEAD
        for (HotelObject hotel : hotelList) {
=======
        for (HotelObject hotel:hotelList) {
>>>>>>> UC2_FindCheapestHotel
            hotel.display();
        }
    }

<<<<<<< HEAD
    public static void main(String[] args) {
=======
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
>>>>>>> UC2_FindCheapestHotel

        //Default entries
        HotelReservation buildObj = new HotelReservation();
        buildObj.addHotel("Lakewood", 110,90);
        buildObj.addHotel("Bridgewood", 160,50);
        buildObj.addHotel("Ridgewood", 220,150);

<<<<<<< HEAD
        System.out.println("Welcome to Hotel Reservation Program");
=======
        System.out.println( "Welcome to Hotel Reservation Program" );
>>>>>>> UC2_FindCheapestHotel

        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println();

<<<<<<< HEAD
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
=======
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
>>>>>>> UC2_FindCheapestHotel
