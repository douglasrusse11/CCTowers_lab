import java.lang.reflect.Array;
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

    public HashMap<String, DiningRoom> getDiningRooms() {
        return diningRooms;
    }

    public void checkIn(ArrayList<Guest> _guests, Bedroom _room) {
        if (_room.getGuestCount() == 0) {
            _room.addGuests(_guests);
        }
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

    public ArrayList<Bedroom> getVacantBedrooms() {
        ArrayList<Bedroom> vacantBedrooms = new ArrayList<>();
        for (Bedroom bedroom: bedrooms) {
            if (bedroom.getGuestCount() == 0) {
                vacantBedrooms.add(bedroom);
            }
         }
        return vacantBedrooms;
    }

    public void buildExtension(ArrayList<Bedroom> _newBedrooms, ArrayList<ConferenceRoom> _newConferenceRooms, ArrayList<DiningRoom> _newDiningRooms) {
        bedrooms.addAll(_newBedrooms);
        conferenceRooms.addAll(_newConferenceRooms);
        HashMap<String, DiningRoom> newDiningRoomHashmap = new HashMap<>();
        for (DiningRoom room: _newDiningRooms) {
            newDiningRoomHashmap.put(room.getName(), room);
        }
        diningRooms.putAll(newDiningRoomHashmap);
    }
}
