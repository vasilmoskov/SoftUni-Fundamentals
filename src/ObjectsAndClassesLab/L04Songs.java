package ObjectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L04Songs {

    static class Song {
        String typeList;
        String name;
        String time;

        public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getTypeList() {
            return typeList;
        }

        public String getName() {
            return name;
        }

        public String getTime() {
            return time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            String currentInput = scanner.nextLine();
            String[] tokens = currentInput.split("_");

            String typeList = tokens[0];
            String name = tokens[1];
            String time = tokens[2];

            Song song = new Song(typeList, name, time);

            songs.add(song);
        }

        String filterTypeList = scanner.nextLine();


        for (Song song : songs) {
            if (song.getTypeList().equals(filterTypeList)) {
                System.out.println(song.getName());
            } else if (filterTypeList.equals("all")) {
                System.out.println(song.getName());
            }
        }
    }

}
