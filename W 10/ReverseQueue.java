import java.util.Scanner;

// Custom Node class for Singly Linked List
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    // Helper to append a node to the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Reverses the singly linked list in place using three pointers
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // Store next node
            current.next = prev; // Reverse current node's pointer
            prev = current;      // Move prev one step forward
            current = next;      // Move current one step forward
        }

        return prev; // prev is the new head of the reversed list
    }

    // Utility to print the linked list
    public static void printList(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }
}

public class ReverseQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            SinglyLinkedList.printList(null);
            scanner.close();
            return;
        }

        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            SinglyLinkedList.printList(null);
            scanner.close();
            return;
        }

        // Clean input tokens
        input = input.replace("->", " ").replace(",", " ");
        String[] tokens = input.split("\\s+");

        SinglyLinkedList list = new SinglyLinkedList();
        for (String token : tokens) {
            if (!token.equalsIgnoreCase("null") && !token.isEmpty()) {
                list.addLast(Integer.parseInt(token));
            }
        }

        // Reverse list in place and print
        list.head = SinglyLinkedList.reverse(list.head);
        SinglyLinkedList.printList(list.head);

        scanner.close();
    }
}