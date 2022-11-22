package DataObjects;

public enum SeatType {
    HARDSEAT("Hard seat"),
    SOFTSEAT("Soft seat"),
    SSWAC("Soft seat with air conditioner"),
    HARDBED("Hard bed"),
    SOFTBED("Soft bed"),
    SBWAC("Soft bed with air conditioner");
    public final String seatType;

    SeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getSeatType() {
        return this.seatType;
    }
}
