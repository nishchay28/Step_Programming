public class HW1_MovieTicket {
    String movieName;
    String theatreName;
    int seatNumber;
    double price;

    public HW1_MovieTicket() {
        movieName = "Unknown";
        theatreName = "Unknown";
        seatNumber = 0;
        price = 0.0;
    }

    public HW1_MovieTicket(String movieName) {
        this.movieName = movieName;
        this.theatreName = "Unknown";
        this.seatNumber = 0;
        this.price = 200.0;
    }

    public HW1_MovieTicket(String movieName, int seatNumber) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.theatreName = "PVR";
        this.price = 200.0;
    }

    public HW1_MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public void printTicket() {
        System.out.println("Movie: " + movieName);
        System.out.println("Theatre: " + theatreName);
        System.out.println("Seat No: " + seatNumber);
        System.out.println("Price: ₹" + price);
    }

    public static void main(String[] args) {
        HW1_MovieTicket t1 = new HW1_MovieTicket();
        HW1_MovieTicket t2 = new HW1_MovieTicket("Inception");
        HW1_MovieTicket t3 = new HW1_MovieTicket("Interstellar", 12);
        HW1_MovieTicket t4 = new HW1_MovieTicket("Oppenheimer", "INOX", 5, 350.0);

        t1.printTicket();
        System.out.println();
        t2.printTicket();
        System.out.println();
        t3.printTicket();
        System.out.println();
        t4.printTicket();
    }
}
