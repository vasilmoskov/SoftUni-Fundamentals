package ObjectsAndClassesMoreExercise;

import java.util.*;

public class ME04TeamworkProjects {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> allTeams = new ArrayList<>();
        List<String> allUsers = new ArrayList<>();

        List<Team> teams = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("-");
            String creator = input[0];
            String teamName = input[1];

            if (!allUsers.contains(creator)) {
                allUsers.add(creator);
            } else {
                System.out.printf("%s cannot create another team!%n", creator);
            }

            if (!allTeams.contains(teamName)) {
                allTeams.add(teamName);
            }

            boolean teamExists = false;

            for (int j = 0; j < teams.size(); j++) {
                Team currentTeam = teams.get(j);
               // List<String> usersInCurrentTeam = currentTeam.getUsers();
                String nameOfCurrentTeam = currentTeam.getName();

                if (nameOfCurrentTeam.equals(teamName)) {
                    teamExists = true;
                    System.out.printf("Team %s was already created!%n", teamName);
                }
            }

            if (!teamExists) {
                List<String> users = new ArrayList<>();
                //users.add(creator);
                Team currentTeam = new Team(users, teamName, creator);
                teams.add(currentTeam);
                System.out.printf("Team %s has been created by %s!%n", teamName, creator);
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("end of assignment")) {
            String[] inputAsArray = input.split("->");
            String user = inputAsArray[0];
            String teamName = inputAsArray[1];

            if (!allTeams.contains(teamName)) {
                System.out.printf("Team %s does not exist!%n", teamName);
            } else if (allUsers.contains(user)) {
                System.out.printf("Member %s cannot join team %s!%n", user, teamName);
            } else {
                for (int j = 0; j < teams.size(); j++) {
                    Team currentTeam = teams.get(j);
                    if (currentTeam.getName().equals(teamName)) {
                        List<String> usersInCurrentTeam = currentTeam.getUsers();
                        usersInCurrentTeam.add(user);
                        currentTeam.setUsers(usersInCurrentTeam);
                    }
                }
            }

            input = scanner.nextLine();
        }

        List<String> teamsToDisband = new ArrayList<>();
        
        Collections.sort(teams, new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                int res = Integer.compare(o2.getUsers().size(), o1.getUsers().size());
                if (res == 0) {
                    res = o1.getName().compareTo(o2.getName());
                }
                return res;
            }
        });

        for (int i = 0; i < teams.size(); i++) {

            List<String> users = teams.get(i).getUsers();
            Collections.sort(users);

            if (!users.isEmpty()) {
                System.out.println(teams.get(i).getName());
                System.out.printf("- %s%n", teams.get(i).getCreator());


                for (int j = 0; j < users.size(); j++) {
                    System.out.printf("-- %s%n", users.get(j));
                }

            } else {
                teamsToDisband.add(teams.get(i).getName());
            }
        }

        Collections.sort(teamsToDisband);

        System.out.println("Teams to disband:");
        for (int i = 0; i < teamsToDisband.size(); i++) {
            System.out.println(teamsToDisband.get(i));
        }

    }

    public static class Team {
        List<String> users;
        String nameOfTheTeam;
        String creator;

        public Team(List<String> users, String nameOfTheTeam, String creator) {
            this.users = users;
            this.nameOfTheTeam = nameOfTheTeam;
            this.creator = creator;
        }

        public String getName() {
            return nameOfTheTeam;
        }

        public String getCreator() {
            return creator;
        }

        public List<String> getUsers() {
            return users;
        }

        public void setUsers(List<String> users) {
            this.users = users;
        }

        public void setNameOfTheTeam(String nameOfTheTeam) {
            this.nameOfTheTeam = nameOfTheTeam;
        }


    }


}
