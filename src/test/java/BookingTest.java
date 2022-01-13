import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    private Booking booking;

    @Before
    public void before() {
        booking = new Booking(new Bedroom(2, 1, RoomType.DOUBLE, 150.00), 4);
    }

    @Test
    public void hasNumberOfNights() {
        assertEquals(4, booking.getNumberOfNights());
    }

    @Test
    public void hasBedroom(){
        Bedroom room = booking.getRoom();
        assertEquals(2, room.getCapacity());
    }

    @Test
    public void canGetTotalBill() {
        assertEquals(600.00, booking.getTotalBill(), 0.0);
    }

}
