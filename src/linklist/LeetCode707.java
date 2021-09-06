package linklist;


import day01.ListNode;

/**
 * 设计链表
 * 简单单链表的设计
 * 注意使用了虚拟头节点
 * @author clearlove3
 */
public class LeetCode707 {
    class MyLinkedList {

        //容量(包括虚拟头节点)
        int size;
        //虚拟头节点
        ListNode head;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = head;
            for (int i = 0; i < index + 1; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            size++;
            ListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            ListNode tmp = new ListNode(val);
            tmp.next = pre.next;
            pre.next = tmp;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            ListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
        }
    }
}
