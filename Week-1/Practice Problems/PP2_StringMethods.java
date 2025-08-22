import java.util.Scanner;

public class PP2_StringMethods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c=0;
        
        System.out.println("Enter Full Name: ");
        String s1 = sc.nextLine();
        System.out.println("Fav programming langauge: ");
        String s2 = sc.nextLine();
        System.out.println("Experience Till now: ");
        String s3 = sc.nextLine();

        int a = s1.indexOf(' ');

        //extracting substring
        String sb1 = s1.substring(0, a);
        String sb2 = s1.substring((a+1), s1.length());
        System.out.println("\nFirst name: "+sb1+"\nlast Name: "+ sb2);

        //counting spaces in sentence
        for(int i = 0; i<s3.length();i++){
            if((s3.charAt(i)) == ' '){
                continue;
            }
            c++;
        }
        System.out.println("Total charecters in Sentence excluding <BlankSpaces>: "+ c);

        //converting programming langauge to uppercase
        System.out.println("Programming langauge to uppercase: "+ s2.toUpperCase());

        sc.close();
    }
}
