import java.util.Scanner;

class Node {
    String name;
    Node prev;
    Node next;

    public Node(String name) {
        this.name = name;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addLast(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void remove(String name) {
        Node current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                break;
            }
            current = current.next;
        }
    }

    public void printForward() {
        Node current = head;
        StringBuilder sb = new StringBuilder("Forward: ");
        while (current != null) {
            sb.append(current.name);
            if (current.next != null) {
                sb.append(" <-> ");
            }
            current = current.next;
        }
        System.out.println(sb.toString());
    }

    public void printBackward() {
        Node current = tail;
        StringBuilder sb = new StringBuilder("Backward: ");
        while (current != null) {
            sb.append(current.name);
            if (current.prev != null) {
                sb.append(" <-> ");
            }
            current = current.prev;
        }
        System.out.println(sb.toString());
    }
}

public class TrainCoaches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;
        String[] coaches = scanner.nextLine().split(",");
        
        if (!scanner.hasNextLine()) return;
        String coachToRemove = scanner.nextLine().trim();

        DoublyLinkedList train = new DoublyLinkedList();
        for (String coach : coaches) {
            train.addLast(coach.trim());
        }

        train.remove(coachToRemove);
        train.printForward();
        train.printBackward();
        scanner.close();
    }
}