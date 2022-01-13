import java.util.ArrayList;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;

    public Hotel(ArrayList<Bedroom> _bedrooms, ArrayList<ConferenceRoom> _conferenceRooms) {
        this.bedrooms = _bedrooms;
        this.conferenceRooms = _conferenceRooms;
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
}
