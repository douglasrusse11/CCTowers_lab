import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ConferenceRoomTest {

    private ConferenceRoom conferenceRoom;

    @Before
    public void before(){
        conferenceRoom = new ConferenceRoom(40, "Ben Nevis");
    }

    @Test
    public void hasCapacity(){
        assertEquals(40, conferenceRoom.getCapacity());
    }

    @Test
    public void hasName(){
        assertEquals("Ben Nevis", conferenceRoom.getName());
    }

}
