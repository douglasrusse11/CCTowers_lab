import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Guest> guests;
    private HashMap<String, DiningRoom> diningRooms;
    private DiningRoom diningroom1;
    private DiningRoom diningroom2;

    @Before
    public void before() {
        guests = new ArrayList<>();
        guests.add(new Guest("Bob"));
        guests.add(new Guest("Michael"));
        bedrooms = new ArrayList<>();
        bedrooms.add(new Bedroom(1, 1, RoomType.SINGLE, 150));
        bedrooms.add(new Bedroom(2, 2, RoomType.DOUBLE, 250));
        conferenceRooms = new ArrayList<>();
        conferenceRooms.add(new ConferenceRoom(30, "Conference Room 1"));
        conferenceRooms.add(new ConferenceRoom(40, "Conference Room 2"));
        diningRooms = new HashMap<>();
        diningroom1 = new DiningRoom(50, "Eatery");
        diningroom2 = new DiningRoom(100, "Steakhouse");
        diningRooms.put(diningroom1.getName(), diningroom1);
        diningRooms.put(diningroom2.getName(), diningroom2);
        hotel = new Hotel(bedrooms, conferenceRooms, diningRooms);
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
    public void cannotCheckInGuestsIfRoomIsOccupied() {
        assertEquals(0, hotel.getBedrooms().get(0).getGuestCount());
        hotel.checkIn(guests, hotel.getBedrooms().get(0));
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

    @Test
    public void canBookRoom(){
        assertEquals( Booking.class, hotel.bookRoom(hotel.getBedrooms().get(0), 3 ).getClass() );
    }

    @Test
    public void hasDiningRooms() {
        assertEquals(diningroom1, hotel.getDiningRoom("Eatery"));
    }

    @Test
    public void canGetVacantBedrooms(){
        ArrayList<Bedroom> vacantBedrooms = hotel.getVacantBedrooms();
        assertEquals(0, vacantBedrooms.get(0).getGuestCount());
        assertEquals(0, vacantBedrooms.get(1).getGuestCount());
    }

    @Test
    public void canGetVacantBedroomsIfOneIsOccupied() {
        hotel.checkIn(guests, hotel.getBedrooms().get(0));
        assertEquals(1, hotel.getVacantBedrooms().size());
    }

    @Test
    public void canBuildExtension () {
        assertEquals(2, hotel.getBedrooms().size());
        assertEquals(2, hotel.getConferenceRooms().size());
        assertEquals(2, hotel.getDiningRooms().size());
        hotel.buildExtension(extensionBedrooms, extensionConferenceRooms, extensionDiningRooms);
        assertEquals(4, hotel.getBedrooms().size());
        assertEquals(4, hotel.getConferenceRooms().size());
        assertEquals(4, hotel.getDiningRooms().size());
    }
}
