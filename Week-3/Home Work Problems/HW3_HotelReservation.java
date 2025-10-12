import java.util.*;

public class HW3_HotelReservation {
    static int totalBookings = 0;
    static double hotelRevenue = 0;
    static String hotelName = "Sunrise Inn";

    static class Room {
        String roomNumber, roomType;
        double pricePerNight;
        boolean isAvailable;
        int maxOccupancy;

        Room(String num, String type, double price, int occ) {
            this.roomNumber = num;
            this.roomType = type;
            this.pricePerNight = price;
            this.maxOccupancy = occ;
            this.isAvailable = true;
        }
    }

    static class Guest {
        String guestId, guestName, phoneNumber, email;
        String[] bookingHistory = new String[5];
        int historyCount = 0;

        Guest(String id, String name, String phone, String email) {
            this.guestId = id;
            this.guestName = name;
            this.phoneNumber = phone;
            this.email = email;
        }

        void addBooking(String bookingId) {
            bookingHistory[historyCount++] = bookingId;
        }
    }

    static class Booking {
        String bookingId;
        Guest guest;
        Room room;
        String checkInDate, checkOutDate;
        double totalAmount;

        Booking(String id, Guest g, Room r, String in, String out) {
            this.bookingId = id;
            this.guest = g;
            this.room = r;
            this.checkInDate = in;
            this.checkOutDate = out;
            this.totalAmount = r.pricePerNight * 2;
            r.isAvailable = false;
            g.addBooking(id);
            totalBookings++;
            hotelRevenue += totalAmount;
        }
    }

    public static void main(String[] args) {
        Room r1 = new Room("101", "Deluxe", 3000, 2);
        Guest g1 = new Guest("G1", "NISHCHAY", "9999999999", "nish@example.com");
        Booking b1 = new Booking("B1", g1, r1, "2025-10-12", "2025-10-14");

        System.out.println("Booking ID: " + b1.bookingId);
        System.out.println("Guest: " + b1.guest.guestName);
        System.out.println("Room: " + b1.room.roomNumber);
        System.out.println("Total: ₹" + b1.totalAmount);
    }
}
