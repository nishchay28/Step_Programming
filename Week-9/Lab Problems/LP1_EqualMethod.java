public class LP1_EqualMethod {
    public static void main(String[] args) {
        String a = new String("SRM");
        String b = new String("SRM");

        System.out.println("Using == : " + (a == b));           // false
        System.out.println("Using equals() : " + a.equals(b));  // true
    }
}
