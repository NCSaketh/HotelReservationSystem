package com.cg.hotelreservationsystem;

<<<<<<< HEAD
public class HotelObject{
    public String hotelName;				//Obj Attributes
    public int rate_regular;
    public String cust_type="regular";		//Default=regular

    //Constructor
    public HotelObject(String hotelName, int rate_regular, String cust_type) {
        this.hotelName = hotelName;
        this.rate_regular = rate_regular;
        this.cust_type = cust_type;
=======
public class HotelObject {

    public String hotelName;				//Obj Attributes
    public int rateWeekdayRegular;
    public int rateWeekendRegular;

    //Constructor
    public HotelObject(String hotelName, int rate_regular) {
        this.hotelName = hotelName;
        this.rateWeekdayRegular = rate_regular;
    }

    public HotelObject(String hotelName) {
        this.hotelName = hotelName;
>>>>>>> UC2_FindCheapestHotel
    }

    @Override
    public String toString() {
        return "Hotel Object "+hotelName+" created";
    }

    public void setWeekendRates(int rateWeekend) {
        this.rateWeekendRegular=rateWeekend;
        System.out.println("Weekend Rates Updated");
    }

    public void display() {				//Method for displaying all details

        System.out.println("------------------------------------------------------");
        System.out.println("Hotel Name: "+hotelName);
<<<<<<< HEAD
        System.out.println("Regular Rate: "+rate_regular);
<<<<<<< HEAD
        System.out.println("Customer Type: "+cust_type);
        System.out.println("------------------------------------------------------");
        System.out.println();
    }
}
=======
=======
        System.out.println("Regular Weekday Rate: "+rateWeekdayRegular);
        System.out.println("Regular Weekend Rate: "+rateWeekendRegular);
>>>>>>> UC3_AddWeekDayWeekendRates
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getrateWeekdayRegular() {
        return rateWeekdayRegular;
    }

    public void setrateWeekdayRegular(int rate_regular) {
        this.rateWeekdayRegular = rate_regular;
    }
}
>>>>>>> UC2_FindCheapestHotel
