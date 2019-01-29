package gfg.linkedList;

public class ReverseLL {
	static Node head;

	public static void main(String[] args) {

		ReverseLL l = new ReverseLL();
		Node head = l.insert(null, 1);
		head = l.insert(head, 2);
		head = l.insert(head, 3);
		head = l.insert(head, 4);
		head = l.insert(head, 5);
		Node newHead = l.reverseLLrecursive(head);
		l.printLL(newHead);
		// System.out.println();
		// l.printReverseLL(head);

	}

	/**
	 * print linked list
	 * 
	 * @param head
	 */
	public void printLL(Node head) {
		if (null == head) {
			return;
		} else {
			while (head != null) {
				System.out.println(head.data);
				head = head.next;
			}
		}
	}

	/**
	 * @param head
	 */
	public void printReverseLL(Node head) {
		if (null == head) {
			return;
		} else
			printReverseLL(head.next);
		System.out.println(head.data);
	}

	/**
	 * @param head
	 * @param value
	 * @return
	 */
	public Node insert(Node head, int value) {
		Node newNode = new Node(value, null);
		Node temp = head;
		if (head == null) {
			head = newNode;
			return head;

		} else {
			while (null != head.next) {
				head = head.next;
			}
			head.next = newNode;
		}

		return temp;
	}

	/**
	 * This is recursively calling and reach till the end of list the main logic
	 * it implements is reversing the next of every item , starting from the end
	 * it stops before second last item, return the last item as new Head and
	 * now change the polarity of signs
	 * 
	 * @param head
	 * @return
	 */
	public Node reverseLLrecursive(Node head) {

		if (head.next == null) {
			return head;
		}
		Node newNode = reverseLLrecursive(head.next);
		head.next.next = head;
		head.next = null;
		return newNode;

	}

	/**
	 * This method reverse the linked list by creating a new linked list logic
	 * it follows is copy first element make it new head and move the old head
	 * to next element , copy this node as temp which will become next nrehead
	 * point the temp next to new Head and change the new head to temp. it
	 * creates n new nodes
	 * 
	 * @param head
	 * @return
	 */
	public Node reverseLL(Node head) {
		Node newhead = new Node(head.data, null);

		while (head.next != null) {
			head = head.next;
			Node temp = new Node(head.data, null);
			temp.next = newhead;
			newhead = temp;
		}

		return newhead;
	}
}

class Node {

	int data;
	Node next;

	/**
	 * @param data
	 * @param next
	 */
	Node(int data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}

}
