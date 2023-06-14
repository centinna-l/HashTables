
/**
 * 
 * To find the union and intersection of two linked lists using hash tables in
 * Java, you can follow these steps:
 * 
 * Create a HashMap or Hashtable to store the unique elements of the linked
 * lists.
 * 
 * Traverse the first linked list and add each element to the hash table.
 * 
 * Traverse the second linked list and perform the following operations:
 * 
 * For the union, add each element to the hash table.
 * For the intersection, check if each element exists in the hash table. If it
 * does, add it to another hash table or a separate list to store the
 * intersection elements.
 * At the end, you will have the union and intersection stored in separate hash
 * tables or lists.
 * 
 * Here's a Java code example that demonstrates this approach:
 */
import java.util.HashMap;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class UnionAndIntersection {

    public static Node union(Node head1, Node head2) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        Node resultHead = null;
        Node resultTail = null;
        while (head1 != null) {
            int data = head1.data;
            if (!hashMap.containsKey(data)) {
                Node newNode = new Node(data);
                hashMap.put(data, true);
                if (resultHead == null) {
                    resultHead = newNode;
                    resultTail = newNode;
                } else {
                    resultTail.next = newNode;
                    resultTail = newNode;
                }
            }
            head1 = head1.next;
        }

        while (head2 != null) {
            int data = head2.data;
            if (!hashMap.containsKey(data)) {
                hashMap.put(data, true);
                Node newNode = new Node(data);
                resultTail.next = newNode;
                resultTail = newNode;
            }
            head2 = head2.next;
        }
        return resultHead;
    }

    public static Node intersection(Node head1, Node head2) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        Node resultHead = null;
        Node resultTail = null;

        while (head1 != null) {
            int data = head1.data;
            hashMap.put(data, true);
            head1 = head1.next;
        }

        while (head2 != null) {
            int data = head2.data;
            if (hashMap.containsKey(data)) {
                hashMap.remove(data);
                Node newNode = new Node(data);
                if (resultHead == null) {
                    resultHead = newNode;
                    resultTail = newNode;
                } else {
                    resultTail.next = newNode;
                    resultTail = newNode;
                }
            }
            head2 = head2.next;
        }
        return resultHead;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        // Create the second linked list: 3 -> 4 -> 5 -> 6 -> 7
        Node head2 = new Node(3);
        head2.next = new Node(4);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(6);
        head2.next.next.next.next = new Node(7);

        System.out.print("Union of the linked lists: ");
        Node unionResult = union(head1, head2);
        printList(unionResult);

        System.out.print("Intersection of the linked lists: ");
        Node intersectionResult = intersection(head1, head2);
        printList(intersectionResult);

    }

}
