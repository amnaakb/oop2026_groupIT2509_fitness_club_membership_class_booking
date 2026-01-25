package entities;

public class Booking {
    private int id;
    private int memberId;
    private int fitnessClassId;
    private String bookingDate;
    private String status;

    public Booking() {
    }

    public Booking(int id, int memberId, int fitnessClassId, String bookingDate, String status) {
        this.id = id;
        this.memberId = memberId;
        this.fitnessClassId = fitnessClassId;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getFitnessClassId() {
        return fitnessClassId;
    }

    public void setFitnessClassId(int fitnessClassId) {
        this.fitnessClassId = fitnessClassId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", fitnessClassId=" + fitnessClassId +
                ", bookingDate='" + bookingDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

