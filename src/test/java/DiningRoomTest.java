import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    private DiningRoom diningRoom;

    @Before
    public void before(){
        diningRoom = new DiningRoom(40, "Ben Nevis");
    }

    @Test
    public void hasCapacity(){
        assertEquals(40, diningRoom.getCapacity());
    }

    @Test
    public void hasName(){
        assertEquals("Ben Nevis", diningRoom.getName());
    }
}
