import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private HashMap<String, DiningRoom> diningRooms;

    public Hotel(ArrayList<Bedroom> _bedrooms, ArrayList<ConferenceRoom> _conferenceRooms, HashMap<String, DiningRoom> _diningRooms) {
        this.bedrooms = _bedrooms;
        this.conferenceRooms = _conferenceRooms;
        this.diningRooms = _diningRooms;
    }

    public ArrayList<Bedroom> getBedrooms() {
        return bedrooms;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return conferenceRooms;
    }

    public void checkIn(ArrayList<Guest> _guests, Bedroom _room) {
        _room.addGuests(_guests);
    }

    public void checkOut(Bedroom _room) {
        _room.removeGuests();
    }

    public Booking bookRoom(Bedroom _room, int _nights) {
        return new Booking(_room, _nights);
    }

    public DiningRoom getDiningRoom(String _name) {
        return diningRooms.get(_name);
    }
}
