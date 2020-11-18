package com.cg.hotelreservationsystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HotelReservationTest {

    private HotelReservation hotelReservation;

    @Before
    public void init() {
        hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 110);
        hotelReservation.addHotel("Bridgewood", 160);
        hotelReservation.addHotel("Ridgewood", 220);
    }

    //Testing for creation of 3 hotels
    @Test
    public void whenLakewoodAdded_ShouldReturnTrue()
    {
        assertTrue(hotelReservation.addHotel("Lakewood",110));
    }

    @Test
    public void whenBridgewoodAdded_ShouldReturnTrue()
    {
        assertTrue(hotelReservation.addHotel("Bridgewood", 160));
    }

    @Test
    public void whenRidgewoodAdded_ShouldReturnTrue()
    {
        assertTrue(hotelReservation.addHotel("Ridgewood", 220));
    }
}
