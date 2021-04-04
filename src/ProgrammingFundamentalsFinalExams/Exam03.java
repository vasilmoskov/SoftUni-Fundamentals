package ProgrammingFundamentalsFinalExams;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exam03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Username> usernames = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Log out")) {
            String[] tokens = input.split(": ");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "New follower":
                    if (!usernames.containsKey(username)) {
                        Username currentUser = new Username(username, 0, 0);
                        usernames.put(username, currentUser);
                    }

                    break;

                case "Like":
                    int count = Integer.parseInt(tokens[2]);

                    if (!usernames.containsKey(username)) {
                        Username currentUser = new Username(username, count, 0);
                        usernames.put(username, currentUser);
                    } else {
                        Username currentUser = usernames.get(username);
                        currentUser.setLikesCount(currentUser.getLikesCount() + count);

                    }

                    break;

                case "Comment":

                    if (!usernames.containsKey(username)) {
                        Username currentUser = new Username(username, 0, 1);
                        usernames.put(username, currentUser);
                    } else {
                        Username currentUser = usernames.get(username);
                        currentUser.setCommentsCount(currentUser.getCommentsCount() + 1);

                    }

                    break;

                case "Blocked":

                    if (usernames.containsKey(username)) {
                        usernames.remove(username);
                    } else {
                        System.out.println(username + " doesn't exist.");
                    }

                    break;
            }

            input = scanner.nextLine();
        }


        System.out.println(usernames.size() + " followers");

        usernames.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getCommentsCount() + e2.getValue().getLikesCount(),
                            e1.getValue().getCommentsCount() + e1.getValue().getLikesCount()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(),
                        e.getValue().getCommentsCount() + e.getValue().getLikesCount()));
    }

    public static class Username {
        private String name;
        private int likesCount;
        private int commentsCount;

        public Username(String name, int likesCount, int commentsCount) {
            this.name = name;
            this.likesCount = likesCount;
            this.commentsCount = commentsCount;
        }

        public String getName() {
            return name;
        }

        public int getLikesCount() {
            return likesCount;
        }

        public void setLikesCount(int likesCount) {
            this.likesCount = likesCount;
        }

        public int getCommentsCount() {
            return commentsCount;
        }

        public void setCommentsCount(int commentsCount) {
            this.commentsCount = commentsCount;
        }
    }
}
