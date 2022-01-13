public class Booking {
    private Bedroom room;
    private int numberOfNights;

    public Booking(Bedroom room, int numberOfNights) {
        this.room = room;
        this.numberOfNights = numberOfNights;
    }

    public Bedroom getRoom() {
        return room;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }
    
    public double getTotalBill() {
        return room.getNightlyRate() * numberOfNights;
    }
}
