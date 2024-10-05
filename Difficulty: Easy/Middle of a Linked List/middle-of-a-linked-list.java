//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution g = new Solution();
            int ans = g.getMiddle(head);
            System.out.println(ans);
            // printList(head);
            t--;
        }
    }
}

// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    int getMiddle(Node head) {
        if (head == null) {
            return -1;  // or any appropriate value for empty list
        }
        
        Node temp = head;
        int len = 0;
        
        // First, calculate the length of the linked list
        while (temp != null) {
            len += 1;
            temp = temp.next;
        }
        
        // Calculate the middle index (0-based, so len/2 gives us the middle)
        len = len / 2;
        
        // Reset temp to head and traverse to the middle element
        temp = head;
        for (int i = 0; i < len; i++) {
            temp = temp.next;
        }
        
        // Return the data at the middle node
        return temp.data;
    }
}

