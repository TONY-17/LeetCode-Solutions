package javacode;

public class AddTwoNumbers {
    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     *
     *
     * public class ListNode {
     *     int data;
     *     ListNode next;
     *
     *     public ListNode(int data) {
     *         this.data = data;
     *     }
     *
     *     public ListNode(int data, ListNode next) {
     *         this.data = data;
     *         this.next = next;
     *     }
     * }
     *
     */
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        int carry = 0;
        // Perform operations within the loop if there's values in the lists and there's a value we carried
        while (list1 != null || list2 != null || carry > 0) {
            int sum = 0;

            if (list1 != null) {
                sum += list1.data;
                list1 = list1.next;
            }


            if (list2 != null) {
                sum += list2.data;
                list2 = list2.next;
            }

            // Store carried value and value from the two nodes if any
            sum += carry;
            // Loses precision since its an int , will only store the value before the comma
            carry = sum / 10;

            // Get the remainder and store in a new node
            ListNode node = new ListNode(sum % 10);
            // Node after dummy
            current.next = node;
            // Set current to the newly created node
            current = node;

        }
        // Return the node after the dummy node (-1)
        return dummy.next;

    }

}
