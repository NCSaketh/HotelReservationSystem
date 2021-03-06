package com.cg.hotelreservationsystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {

    private HotelReservation hotelReservation;
    private Customer cust;

    @Before
    public void init() {
        hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 110,90,80,80,3);
        hotelReservation.addHotel("Bridgewood", 160,50,110,50,4);
        hotelReservation.addHotel("Ridgewood", 220,150,100,40,5);
    }

    //Testing for creation of 3 hotels
    @Test
    public void whenLakewoodAdded_ShouldReturnTrue()
    {
        assertTrue(hotelReservation.addHotel("Lakewood", 110,90,80,80,3));
    }

    @Test
    public void whenBridgewoodAdded_ShouldReturnTrue()
    {
        assertTrue(hotelReservation.addHotel("Bridgewood", 160,50,110,50,4));
    }

    @Test
    public void whenRidgewoodAdded_ShouldReturnTrue()
    {
        assertTrue(hotelReservation.addHotel("Ridgewood", 220,150,100,40,5));
    }

    //Testing for correct output for staying 1 day
    @Test
    public void whenStayed1Day_CheapestHotelShouldBe_Lakewood()
    {
        cust=hotelReservation.findCheapestHotel("Regular","12.05.2020", "13.05.2020");
        assertEquals(110, cust.getBill());
    }

    @Test
    public void whenStayed1Day_CheapestHotelShouldCost_110()
    {
        cust=hotelReservation.findCheapestHotel("Regular","12.05.2020", "13.05.2020");
        assertEquals("Lakewood", cust.getHotelName());
    }

    @Test
    public void whenStayed1DayOnWeekendCheapestHotelShouldBeBridgeWood()
    {
        cust=hotelReservation.findCheapestHotel("Regular","12.09.2020", "13.09.2020");
        assertEquals("Bridgewood", cust.getHotelName());
    }

    @Test
    public void whenStayed1DayOnWeekendCheapestHotelShouldCost_50()
    {
        cust=hotelReservation.findCheapestHotel("Regular","12.09.2020", "13.09.2020");
        assertEquals(50, cust.getBill());
    }

    //Rating Testing With DummyHotel
    @Test
    public void whenStayed1DayCheapestHotelShouldBeDummyHotel()
    {
        hotelReservation.addHotel("DummyHotel", 110,90,80,80,5);
        cust=hotelReservation.findCheapestHotel("Regular","12.05.2020", "13.05.2020");
        assertEquals("DummyHotel", cust.getHotelName());
    }

    //Checking for best rated hotel
    @Test
    public void whenStayed1DayMaxRatedHotelShouldBeRidgeWood()
    {
        cust=hotelReservation.bestRatedHotel("Regular","12.05.2020", "13.05.2020");
        assertEquals("Ridgewood", cust.getHotelName());
    }

    //Testing for correct output for staying 1 day as Reward Cust

    //Weekday Rate
    @Test
    public void whenStayedWeekdayCheapestHotelShouldCost80()
    {
        cust=hotelReservation.findCheapestHotel("Reward","12.05.2020", "13.05.2020");
        assertEquals(80, cust.getBill());
    }

    //Weekend Rate
    @Test
    public void whenStayedWeekendCheapestHotelShouldCost80()
    {
        cust=hotelReservation.findCheapestHotel("Reward","12.09.2020", "13.09.2020");
        assertEquals(80, cust.getBill());
    }
}