package algoRandomImpl;

public class LinkedListImpl {
	private int a;
	private LinkedListImpl next;

	public LinkedListImpl(int a) {
		this.a = a;
	}

	private int getA() {
		return a;
	}

	private void setA(int a) {
		this.a = a;
	}

	private LinkedListImpl getNext() {
		return next;
	}

	private void setNext(LinkedListImpl next) {
		this.next = next;
	}

	// main method
	public static void main(String[] args) {
		LinkedListImpl head = new LinkedListImpl(1);
		for (int k = 1; k <= 10; k++) {
			head.add(head, k);
		}
		System.out.println(head.getMidElement(head));
	}

	// method to add elements
	private boolean add(LinkedListImpl head, int b) {
		if (null != head) {
			while (null != head.next) {
				head = head.next;
			}

			head.next = new LinkedListImpl(b);
			return true;
		}
		return false;
	}

	// method to get Mid Element
	private int getMidElement(LinkedListImpl head) {
		if (null == head) {
			return 0;
		} else {
			LinkedListImpl slow = head;
			LinkedListImpl fast = head;
			while (null != fast && null != fast.next && null != fast.next.next) {
				fast = fast.next.next;
				slow = slow.next;
				
			}
			return slow.getA();
		}

	}
}
