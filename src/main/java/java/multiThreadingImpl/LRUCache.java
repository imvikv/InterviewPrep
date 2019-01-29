package java.multiThreadingImpl;

import java.util.HashMap;
import java.util.Map;

/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

Analysis

The key to solve this problem is using a double linked list which enables us to quickly move nodes.

LRU-Cache

The LRU cache is a hash table of keys and double linked nodes. The hash table makes the time of get() to be O(1). The list of double linked nodes make the nodes adding/removal operations O(1).
 * */
// This is the implementation of lru cache using one hash Map and DLL
public class LRUCache {

	// Queue<Node> queue = new LinkedList<>();
	private int limit = 10;
	Map<Integer, Node> map = new HashMap<>();
	Node head = null;
	Node end = null;

	/**
	 * @param limit
	 */
	public LRUCache(int limit) {
		super();
		this.limit = limit;
	}

	/**
	 * This method check element exist in map or not if yes then remove the
	 * element from DLL and put it to front
	 * 
	 * @param key
	 * @return
	 */
	public int get(int key) {
		if (map.containsKey(key)) {
			Node value = map.get(key);
			remove(value);
			setHead(value);
			return value.value;
		}
		return -1;
	}

	private void setHead(Node node) {
		if (head == null) {
			head = node;
			end = head;
		} else {
			node.pre = null;
			node.next = head;
			head.pre = node;
			head = node;
		}
	}

	private void remove(Node node) {

		// for removing an element you need to check edge cases is it head or
		// end else middle element

		if (node.pre == null) {
			// it's at head
			head = node.next;
		} else if (node.next == null) {
			// it's at end
			end = node.pre;
			end.next = null;
		} else {
			// middle element
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}

	}

	public void set(int key, int value) {
		// first check this element already exit or not
		Node tempNode = map.get(key);
		if (null != tempNode) {
			tempNode.value = value;
			remove(tempNode);
		}
		// if the element is not there
		else {
			tempNode = new Node(key, value);
			if (map.size() >= this.limit) {
				// remove element from end
				remove(end);
				map.remove(end.key);
			}
		}
		map.put(key, tempNode);
		setHead(tempNode);

	}

	public void printCacheList() {
		Node temp = head;
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		head = temp;
		System.out.println();

	}

}

class Node {

	Node pre;
	Node next;
	int key;
	int value;

	/**
	 * @param key
	 * @param value
	 */
	public Node(int key, int value) {
		super();
		this.key = key;
		this.value = value;

	}

}
