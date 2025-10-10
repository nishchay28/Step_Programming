import java.util.*;

public class HW6_FileOrganizer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of files:");
        int n = Integer.parseInt(sc.nextLine());
        String[] files = new String[n];

        for (int i = 0; i < n; i++) {
            files[i] = sc.nextLine().trim();
        }

        Map<String, List<String>> categorized = categorizeFiles(files);
        Map<String, String> renamed = generateNewNames(categorized);
        displayReport(files, categorized, renamed);

        sc.close();
    }

    static Map<String, List<String>> categorizeFiles(String[] files) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("Documents", new ArrayList<>());
        map.put("Images", new ArrayList<>());
        map.put("Others", new ArrayList<>());

        for (String file : files) {
            int dot = file.lastIndexOf('.');
            String ext = (dot != -1) ? file.substring(dot + 1).toLowerCase() : "";
            if (ext.equals("txt") || ext.equals("doc")) {
                map.get("Documents").add(file);
            } else if (ext.equals("jpg") || ext.equals("png")) {
                map.get("Images").add(file);
            } else {
                map.get("Others").add(file);
            }
        }
        return map;
    }

    static Map<String, String> generateNewNames(Map<String, List<String>> categorized) {
        Map<String, String> renamed = new HashMap<>();
        String date = java.time.LocalDate.now().toString();
        for (Map.Entry<String, List<String>> entry : categorized.entrySet()) {
            String category = entry.getKey();
            List<String> files = entry.getValue();
            int count = 1;
            for (String file : files) {
                int dot = file.lastIndexOf('.');
                String ext = (dot != -1) ? file.substring(dot + 1) : "";
                String newName = category + "_" + date + "_" + count + "." + ext;
                renamed.put(file, newName);
                count++;
            }
        }
        return renamed;
    }

    static void displayReport(String[] originalFiles, Map<String, List<String>> categorized, Map<String, String> renamed) {
        System.out.println("\nFile Organization Report:");
        System.out.printf("%-25s %-15s %-30s\n", "Original Filename", "Category", "New Suggested Name");
        for (String file : originalFiles) {
            String category = "Others";
            for (Map.Entry<String, List<String>> entry : categorized.entrySet()) {
                if (entry.getValue().contains(file)) {
                    category = entry.getKey();
                    break;
                }
            }
            System.out.printf("%-25s %-15s %-30s\n", file, category, renamed.get(file));
        }

        System.out.println("\nCategory-wise File Counts:");
        for (Map.Entry<String, List<String>> entry : categorized.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
        }
    }
}
