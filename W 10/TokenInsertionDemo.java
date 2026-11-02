// Custom Node class representing a token
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class PriorityTokenList {
    Node head;

    /**
     * Adds a token at the front of the list (Priority).
     * Time Complexity: O(1)
     */
    public void addFirst(int token) {
        Node newNode = new Node(token);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Adds a token at the end of the list (Normal).
     * Time Complexity: O(N) - where N is the length of the list (traversing to the end).
     */
    public void addLast(int token) {
        Node newNode = new Node(token);
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

    /**
     * Inserts a token at a specified 0-based index (Rescheduled).
     * Time Complexity: O(index) - requires traversing up to the given index position.
     */
    public void insertAt(int index, int token) {
        if (index < 0) return;
        
        if (index == 0) {
            addFirst(token);
            return;
        }

        Node newNode = new Node(token);
        Node current = head;
        
        // Traverse to the node just before the target index
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Helper method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class TokenInsertionDemo {
    public static void main(String[] args) {
        PriorityTokenList list = new PriorityTokenList();

        // Initial list: 101 -> 102 -> 103
        list.addLast(101);
        list.addLast(102);
        list.addLast(103);

        System.out.print("Start: ");
        list.printList();

        // Operations: addFirst(100), addLast(104), insertAt(2, 150)
        list.addFirst(100);
        list.addLast(104);
        list.insertAt(2, 150);

        System.out.print("Expected Output: 100 -> 101 -> 150 -> 102 -> 103 -> 104 -> null\n");
        System.out.print("Actual Output:   ");
        list.printList();
    }
}