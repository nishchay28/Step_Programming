import java.util.*;

public class LP1_SubStringOccurrences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String target = sc.nextLine();
        String replacement = sc.nextLine();

        int[] positions = findOccurrences(text, target);
        String manualResult = replaceManually(text, target, replacement, positions);
        String builtInResult = text.replace(target, replacement);
        boolean isSame = compareResults(manualResult, builtInResult);

        System.out.println(manualResult);
        System.out.println(builtInResult);
        System.out.println(isSame);

        sc.close();
    }

    public static int[] findOccurrences(String text, String target) {
        List<Integer> posList = new ArrayList<>();
        int index = text.indexOf(target);
        while (index != -1) {
            posList.add(index);
            index = text.indexOf(target, index + target.length());
        }
        int[] positions = new int[posList.size()];
        for (int i = 0; i < posList.size(); i++) {
            positions[i] = posList.get(i);
        }
        return positions;
    }

    public static String replaceManually(String text, String target, String replacement, int[] positions) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int posIndex = 0;
        while (i < text.length()) {
            if (posIndex < positions.length && i == positions[posIndex]) {
                result.append(replacement);
                i += target.length();
                posIndex++;
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static boolean compareResults(String manual, String builtIn) {
        return manual.equals(builtIn);
    }
}