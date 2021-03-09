package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class E08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, List<String>> companies = new TreeMap<>();

        while (!input.equals("End")) {
            String [] inputAsArray = input.split(" -> ");
            String currentCompanyName = inputAsArray[0];
            String id = inputAsArray[1];

            if (!companies.containsKey(currentCompanyName)) {
                List<String> companyId = new ArrayList<>();
                companyId.add(id);
                companies.put(currentCompanyName, companyId);
            } else {
                List<String> companyId = companies.get(currentCompanyName);
                if (!companyId.contains(id)) {
                    companyId.add(id);
                }
                companies.put(currentCompanyName, companyId);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : companies.entrySet()) {
            System.out.println(entry.getKey());
            List<String> companyId = companies.get(entry.getKey());
            for (int i = 0; i < companyId.size(); i++) {
                System.out.printf("-- %s%n", companyId.get(i));
            }
        }


    }
}
