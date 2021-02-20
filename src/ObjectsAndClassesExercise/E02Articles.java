package ObjectsAndClassesExercise;

import java.util.Scanner;

public class E02Articles {

    static class Article {
        String title;
        String content;
        String author;

   /*     public Article (String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

    */

        public Article() {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void editContent (String newContent) {
            this.content = newContent;
        }

        public void changeAuthor (String newAuthor) {
            this.author = newAuthor;
        }

        public void renameTitle (String newTitle) {
            this.title = newTitle;
        }

        public void override (String newTitle, String newContent, String newAuthor ) {
            System.out.printf("%s - %s: %s", newTitle, newContent, newAuthor);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(", ");

        Article article = new Article ();

        article.title = input [0];
        article.content = input [1];
        article.author = input [2];

        int n = Integer.parseInt (scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String [] command = scanner.nextLine().split(": ");
            if (command [0].equals("Edit")) {
                article.editContent(command[1]);
            } else if (command[0].equals("ChangeAuthor")) {
                article.changeAuthor(command[1]);
            } else if (command[0].equals("Rename")) {
                article.renameTitle(command[1]);
            }
        }

        article.override(article.title, article.content, article.author);

    }
}

