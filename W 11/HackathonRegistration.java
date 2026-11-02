// Class representing a Team with a name and size
class Team {
    String name;
    int size;

    public Team(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return name + "(" + size + ")";
    }
}

public class HackathonRegistration {

    /**
     * Sorts the teams array in-place by size in ascending order using Insertion Sort.
     * Uses a strictly greater comparison (>) to maintain stability for equal sizes.
     */
    public static void sortTeams(Team[] teams) {
        if (teams == null || teams.length <= 1) {
            return;
        }

        for (int i = 1; i < teams.length; i++) {
            Team key = teams[i];
            int j = i - 1;

            // Shift elements to the right only while their size is strictly greater than the key's size.
            // Using '>' instead of '>=' ensures stability (preserves original registration order for ties).
            while (j >= 0 && teams[j].size > key.size) {
                teams[j + 1] = teams[j];
                j--;
            }

            // Drop the key into the open gap
            teams[j + 1] = key;
        }
    }

    // Helper method to print teams in the required format
    public static void printTeams(Team[] teams) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < teams.length; i++) {
            sb.append(teams[i].name).append("(").append(teams[i].size).append(")");
            if (i < teams.length - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        // Sample Input: Pixel(4), Byte(2), Nova(4), Echo(3), Atom(2)
        Team[] teams = {
            new Team("Pixel", 4),
            new Team("Byte", 2),
            new Team("Nova", 4),
            new Team("Echo", 3),
            new Team("Atom", 2)
        };

        System.out.print("Before sorting: ");
        printTeams(teams);

        // Sort teams in-place
        sortTeams(teams);

        System.out.print("After sorting:  ");
        printTeams(teams);
    }
}