public class PP1_StringComparison {
    public static void main(String[] args){
        
        String s1 = "Java Programming"; // Using string literal
        String s2 = new String("Java Programming"); // Using new keyword 
        char[] charArray = { 'J', 'a', 'v', 'a',' ','P','r','o','g','r','a','m','m','i','n','g' };
        String s3 = new String(charArray); // Using character array

        if(s1 == s2){
            System.out.println("Java Programming(lireral)= Java Programming(new)");
        }
        else{
            System.out.println("Java Programming(lireral) != Java Programming(new)");
        }

        if(s1 == s3){
            System.out.println("Java Programming(lireral) = Java Programming(array)");
        }
        else{
            System.out.println("Java Programming(lireral) != Java Programming(array)");
        }
        if (s2 == s3) {
            System.out.println("Java Programming(new) = Java Programming(array)");
        }
        else{
            System.out.println("Java Programming(new) = Java Programming(array)");
        }
    }
}