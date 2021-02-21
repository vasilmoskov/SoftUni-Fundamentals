package ObjectsAndClassesExercise;

import java.util.*;

public class E04Articles2 {

    public static class Article {
        String title;
        String content;
        String author;

        public Article (String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return title + " - " + content + ": " + author;
        }

    }

    public static class TitleSorter implements Comparator<E04Articles2.Article>
    {
        @Override
        public int compare(E04Articles2.Article o1, E04Articles2.Article o2) {
            return o1.getTitle().compareToIgnoreCase(o2.getTitle());
        }
    }

    public static class ContentSorter implements Comparator<E04Articles2.Article>
    {
        @Override
        public int compare(E04Articles2.Article o1, E04Articles2.Article o2) {
            return o1.getContent().compareToIgnoreCase(o2.getContent());
        }
    }

    public static class AuthorSorter implements Comparator<E04Articles2.Article>
    {
        @Override
        public int compare(E04Articles2.Article o1, E04Articles2.Article o2) {
            return o1.getAuthor().compareToIgnoreCase(o2.getAuthor());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt (scanner.nextLine());

        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split(", ");
            String title = input[0];
            String content = input[1];
            String author = input[2];
            Article article = new Article(title,content,author);
            articles.add(article);
        }

        String orderCommand = scanner.nextLine();

        if (orderCommand.equals("title")) {
            articles.sort(new E04Articles2.TitleSorter());
        } else if (orderCommand.equals("content")){
            articles.sort(new E04Articles2.ContentSorter());
        } else if (orderCommand.equals("author")) {
            articles.sort(new E04Articles2.AuthorSorter());
        }

        for (Article article: articles) {
            System.out.println(article);
        }
    }
}
