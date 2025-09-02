import java.util.*;

public class LP5_SubStringEmail {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String email = sc.nextLine();
            if (isValid(email)) {
                int atPos = email.indexOf('@');
                // int dotPos = email.indexOf('.', atPos);

                String username = email.substring(0, atPos);
                String domain = email.substring(atPos + 1);
                String domainName = domain.substring(0, domain.indexOf('.'));
                String extension = domain.substring(domain.indexOf('.') + 1);

                System.out.println("Email: " + email);
                System.out.println("Username: " + username);
                System.out.println("Domain Name: " + domainName);
                System.out.println("Extension: " + extension);
                System.out.println("Valid: true\n");
            } else {
                System.out.println("Email: " + email);
                System.out.println("Invalid: true\n");
            }
        }

        sc.close();
    }

    public static boolean isValid(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        int dot = email.indexOf('.', at);
        return at > 0 && dot > at + 1 && lastAt == at && dot < email.length() - 1;
    }
}