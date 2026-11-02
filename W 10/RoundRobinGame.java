import java.util.Scanner;

// Node class for the circular singly linked list
class Node {
    String name;
    Node next;

    public Node(String name) {
        this.name = name;
        this.next = null;
    }
}

// Circular Singly Linked List
class CircularLinkedList {
    private Node tail = null;

    // Adds a player to the end of the circular linked list
    public void addLast(String name) {
        Node newNode = new Node(name);
        if (tail == null) {
            tail = newNode;
            tail.next = tail; // Points to itself to form the circle
        } else {
            newNode.next = tail.next; // New node points to head
            tail.next = newNode;      // Tail points to new node
            tail = newNode;           // New node becomes the new tail
        }
    }

    // Prints the player for each turn in round-robin order
    public void printTurns(int turns) {
        if (tail == null || turns <= 0) {
            return;
        }

        Node current = tail.next; // Start from the head (which is tail.next)
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < turns; i++) {
            sb.append(current.name);
            if (i < turns - 1) {
                sb.append(" ");
            }
            current = current.next; // Move to the next player
        }
        System.out.println(sb.toString());
    }
}

public class RoundRobinGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example input handling
        // Input format expected: players separated by comma, followed by number of turns
        // e.g., Asha, Ravi, Neha
        // 7
        if (!scanner.hasNextLine()) return;
        String[] players = scanner.nextLine().split(",");
        
        int turns = Integer.parseInt(scanner.nextLine().trim());

        CircularLinkedList gameList = new CircularLinkedList();
        for (String player : players) {
            gameList.addLast(player.trim());
        }

        gameList.printTurns(turns);
        scanner.close();
    }
}