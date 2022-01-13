import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Guest> guests;

    @Before
    public void before() {
        guests = new ArrayList<>();
        guests.add(new Guest("Bob"));
        guests.add(new Guest("Michael"));
        bedrooms = new ArrayList<>();
        bedrooms.add(new Bedroom(1, 1, RoomType.SINGLE));
        bedrooms.add(new Bedroom(2, 2, RoomType.DOUBLE));
        conferenceRooms = new ArrayList<>();
        conferenceRooms.add(new ConferenceRoom(30, "Conference Room 1"));
        conferenceRooms.add(new ConferenceRoom(40, "Conference Room 2"));
        hotel = new Hotel(bedrooms, conferenceRooms);
    }


    @Test
    public void getBedrooms() {
        assertEquals(2, hotel.getBedrooms().size());
    }

    @Test
    public void getConferenceRooms() {
        assertEquals(2, hotel.getConferenceRooms().size());
    }

    @Test
    public void canCheckGuestsIn() {
        assertEquals(0, hotel.getBedrooms().get(0).getGuestCount());
        hotel.checkIn(guests, hotel.getBedrooms().get(0));
        assertEquals(2, hotel.getBedrooms().get(0).getGuestCount());
    }

    @Test
    public void canCheckGuestsOut() {
        hotel.checkIn(guests, hotel.getBedrooms().get(0));
        assertEquals(2, hotel.getBedrooms().get(0).getGuestCount());
        hotel.checkOut(hotel.getBedrooms().get(0));
        assertEquals(0, hotel.getBedrooms().get(0).getGuestCount());
    }
}
