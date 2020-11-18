package com.cg.hotelreservationsystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {

    HotelReservationMain hotelReservationMain;

    @Before
    public void init(){
        hotelReservationMain = new HotelReservationMain();
    }

    @Test
    public void givenHotel_WhenAdded_ShoudlAddHotel(){
        Hotel hotel1 = new Hotel("LakeWood",110);
        Hotel hotel2 = new Hotel("BridgeWood",160);
        Hotel hotel3 = new Hotel("RidgeWood",220);

        hotelReservationMain.hotelList.add(hotel1);
        hotelReservationMain.hotelList.add(hotel2);
        hotelReservationMain.hotelList.add(hotel3);
        Assert.assertEquals(3, hotelReservationMain.hotelList.size());
    }

    @Test
    public void givenHotelList_ShouldReturnCheapestHotelInGivenDateRange() {
        Hotel hotel1 = new Hotel("LakeWood",110,"11-10-2020","12-10-2020");
        Hotel hotel2 = new Hotel("BridgeWood",160, "11-10-2020","12-10-2020");
        Hotel hotel3 = new Hotel("RidgeWood",220,"11-10-2020","12-10-2020");

        hotelReservationMain.hotelList.add(hotel1);
        hotelReservationMain.hotelList.add(hotel2);
        hotelReservationMain.hotelList.add(hotel3);

        Assert.assertEquals(110, hotelReservationMain.findCheapestHotel("11-10-2020","12-10-2020"));
    }
}
