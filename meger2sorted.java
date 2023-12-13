import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Link list node
class Node {
    int key;
    Node next;

    public Node(int key) {
        this.key = key;
        next = null;
    }
}

class Main {
    // Return a new node
    public static Node newNode(int key) {
        return new Node(key);
    }

    // Function to create a linked list based on user input
    private static Node createLinkedList(Scanner sc) {
        Node head = null;
        Node tail = null;

        int length = sc.nextInt();
        for (int i = 0; i < length; i++) {
            int value = sc.nextInt();
            Node node = new Node(value);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create the first linked list
        
        Node a = createLinkedList(sc);

        // Create the second linked list
        
        Node b = createLinkedList(sc);

        List<Integer> v = new ArrayList<>();
        while (a != null) {
            v.add(a.key);
            a = a.next;
        }

        while (b != null) {
            v.add(b.key);
            b = b.next;
        }

        Collections.sort(v);
        Node result = new Node(-1);
        Node temp = result;
        for (int i = 0; i < v.size(); i++) {
            result.next = new Node(v.get(i));
            result = result.next;
        }

        temp = temp.next;
        while (temp != null) {
            System.out.println(temp.key + " ");
            temp = temp.next;
        }
    }
}
