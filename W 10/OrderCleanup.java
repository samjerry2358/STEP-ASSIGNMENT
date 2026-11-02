// Custom Node class representing an order
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class OrderCleanup {

    /**
     * Removes every node with the given code and returns the new head.
     */
    public static Node removeAll(Node head, int code) {
        // Create a dummy node to handle edge cases where the head itself matches the code
        Node dummy = new Node(0);
        dummy.next = head;
        Node current = dummy;

        // Traverse the linked list
        while (current.next != null) {
            if (current.next.data == code) {
                // Remove the node by bypassing it
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        return dummy.next;
    }

    // Helper method to print the linked list for testing
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // --- Sample 1 Test ---
        // orders = 5 -> 3 -> 5 -> 8 -> 5, code = 5
        Node head1 = new Node(5);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);

        System.out.println("--- Sample 1 ---");
        System.out.print("Before: ");
        printList(head1);
        head1 = removeAll(head1, 5);
        System.out.print("After:  ");
        printList(head1);

        // --- Sample 2 Test ---
        // orders = 5 -> 5 -> 5, code = 5
        Node head2 = new Node(5);
        head2.next = new Node(5);
        head2.next.next = new Node(5);

        System.out.println("\n--- Sample 2 ---");
        System.out.print("Before: ");
        printList(head2);
        head2 = removeAll(head2, 5);
        System.out.print("After:  ");
        printList(head2);
    }
}