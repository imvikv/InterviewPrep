package algo.java.randomImpl;

import java.util.HashMap;
import java.util.Map;

public class LRU {

class Node 
{
	int key;
	int value;
	Node next;
	Node prev;
	public Node(int key, int value) {
		super();
		this.key = key;
		this.value = value;
	}

}

Node head,end;
int capacity;

Map<Integer, Node> map;
	
	public LRU(int capacity) {
	super();
	this.capacity = capacity;
	map=new HashMap<>();
}


	public int get(int key)
	{
		if(map.containsKey(key))
		{
			Node n=map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		
		return -1;
	}
	
	private void setHead(Node n) {
		
		n.prev=null;
		n.next=head;
		if(head!=null) {
			head.prev=n;
		}
		head=n;
		if(end==null)
			end=head;
				
	}


	private void remove(Node n) {
		if(n.next!=null)
		{
			//means not end
			n.next.prev=n.prev;
		}
		else
			end=n.prev;
		if(n.prev !=null)
		{
			//not head
			n.prev.next=n.next;			
		}
		else
		{
			head=n.next;
		}
	}


	public void set(int key,int value)
	{
		if(map.containsKey(key))
		{
			//means we need to update the existing values
			Node n=map.get(key);
			n.value=value;
			remove(n);
			setHead(n);
			map.put(key, n);
		}
		else
		{
			Node n1=new Node(key, value);
			if(map.size()<capacity)
			{
				//means we can safely add 
				setHead(n1);
			}
			else
			{
				//case when we need to evict
				map.remove(end.key);
				remove(end);
				setHead(n1);
				
			}
			map.put(key, n1);
		}
		
	}


public static void main(String[] args) {
/*	LRU l=new LRU(1);
	l.set(2, 1);
	l.set(2, 2);
	System.out.println(l.get(2));
	l.set(1, 1);
	l.set(4, 1);
	System.out.println(l.get(2));*/
    //7 2 G 2 S 2 6 G 1 S 1 5 S 1 2 G 1 G 2
	LRU k=new LRU(2);
	System.out.println(k.get(2));
	k.set(2, 6);
	System.out.println(k.get(1));
	k.set(1, 5);
	k.set(1, 2);
	System.out.println(k.get(1));
	System.out.println(k.get(2));
}

}
