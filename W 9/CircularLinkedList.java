public class CircularLinkedList {
    private static class Node {
        String name;
        Node next;
        
        Node(String name) {
            this.name = name;
            this.next = null;
        }
    }

    private Node tail;

    public CircularLinkedList() {
        this.tail = null;
    }

    public void addLast(String name) {
        Node newNode = new Node(name);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void printTurns(int turns) {
        if (tail == null) {
            return;
        }
        
        Node current = tail.next;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < turns; i++) {
            sb.append(current.name).append(" ");
            current = current.next;
        }
        
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        CircularLinkedList game = new CircularLinkedList();
        game.addLast("Asha");
        game.addLast("Ravi");
        game.addLast("Neha");
        System.out.println("Expected Output: Asha Ravi Neha Asha Ravi Neha Asha");
        System.out.print("Actual Output:   ");
        game.printTurns(7);
    }
}