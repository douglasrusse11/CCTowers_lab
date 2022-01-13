public class Bedroom extends Room {

    private int roomNumber;
    private RoomType roomType;
    private double nightlyRate;

    public Bedroom(int _capacity, int _roomNumber, RoomType _roomType, double nightlyRate) {
        super(_capacity);
        this.roomNumber = _roomNumber;
        this.roomType = _roomType;
        this.nightlyRate = nightlyRate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public double getNightlyRate() {
        return nightlyRate;
    }
}
