package components.booking;

import entities.Member;

public class BookingService {
    public void bookClass(Member member, String className) {
        System.out.println("[BookingComponent]: " + member.getFullName() + " successfully booked '" + className + "' class.");
    }

    public void cancelBooking(Member member, String className) {
        System.out.println("[BookingComponent]: Booking for '" + className + "' cancelled.");
    }
}
