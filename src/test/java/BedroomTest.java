import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    private Bedroom bedroom;

    @Before
    public void before() {
        bedroom = new Bedroom(1, 1, RoomType.SINGLE, 150.00);
    }

    @Test
    public void hasCapacity() {
        assertEquals(1, bedroom.getCapacity());
    }

    @Test
    public void hasNoGuests() {
        assertEquals(0, bedroom.getGuestCount());
    }

    @Test
    public void hasRoomNumber() {
        assertEquals(1, bedroom.getRoomNumber());
    }

    @Test
    public void hasRoomType() {
        assertEquals(RoomType.SINGLE, bedroom.getRoomType());
    }

    @Test
    public void canAddGuests() {
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(new Guest("Simon"));
        bedroom.addGuests(guests);
        assertEquals(1, bedroom.getGuestCount());
    }

    @Test
    public void canRemoveGuests() {
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(new Guest("Simon"));
        bedroom.addGuests(guests);
        bedroom.removeGuests();
        assertEquals(0, bedroom.getGuestCount());
    }

    @Test
    public void hasNightlyRate() {
        assertEquals(150.00, bedroom.getNightlyRate(), 0.0);
    }
}
