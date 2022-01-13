import java.util.ArrayList;

public abstract class Room {

    private int capacity;
    private ArrayList<Guest> guests;

    public Room(int capacity) {
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getGuestCount() {
        return guests.size();
    }

    public void addGuests(ArrayList<Guest> _guests) {
        this.guests.addAll(_guests);
    }

    public void removeGuests() {
        this.guests.clear();
    }
}
