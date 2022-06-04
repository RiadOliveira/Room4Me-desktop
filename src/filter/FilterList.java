package filter;

import java.util.Iterator;

public class FilterList<T> implements Iterable<T>,Iterator<T>{
	class Node {
		int id;
		T data;
		Node next;

		public Node(T data) {
			this.id = nextId;
			nextId++;

			this.data = data;
			this.next = null;
		}
	}

	private int nextId;
	private Node head;
	private Node tail;
	private int size;
	private Node iterationNode = null;

	public int getSize() {
		return size;
	}

	public FilterList() {
		head = null;
		tail = null;
		nextId = 1;
		size = 0;
	}

	public void add(T data) {
		addLast(data);
	}

	public void addLast(T data) {
		Node nData = new Node(data); 

		if (head == null) {
			head = nData;
			tail = nData;
		} else {
			tail.next = nData;
			tail = nData;
		}

		size++;
	}

	public void addFirst(T data) {
		Node nData = new Node(data); 

		if (head == null) {
			head = nData;
			tail = nData;
		} else {
			nData.next = head;
			head = nData;
		}

		size++;
	}

	public void addAfter(T data, int id) throws Exception {
		Node p = searchNode(id);

		if (p == null) throw new Exception();
		else {
			Node nData = new Node(data);

			if (p.next == null) tail = nData;
			nData.next = p.next;
			p.next = nData;
		}

		size++;
	}

	public Node searchNode(int id) {
		Node p = head;

		while (p != null) {
			if (p.id == id) return p;
			p = p.next;
		}

		return null;
	}

	public T peekFirst() {
		if (head == null) return null;
		return head.data;
	}

	public T peekLast() {
		if (tail == null) return null;
		return tail.data;
	}

	public T search(int id) { 
		Node p = searchNode(id);
		
		if (p == null) return null;
		return p.data;
	}

	public T removeFirst() {
		if (head == null) return null;

		Node p = head;
		T result = null;

		result = p.data;
		if (head == tail) {
			head = null;
			tail = null;
		} else head = head.next;
	
		p.next = null;
		size--;

		return result;
	}

	public T removeLast() {
		if (tail == null) return null;

		T result = tail.data;
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			Node p = head;
			while (p.next != tail) {
				p = p.next;
			}

			tail = p;
			tail.next = null;
		}

		size--;
		return result;
	}

	public Node searchBefore(int id) {
		Node p = head;
		Node previus = null;

		while (p != null) {
			previus = p;
			p = p.next;

			if (p != null && p.id == id) {
				return previus;
			}
		}
		
		return null;
	}

	public T remove(int id) {
		if (head == null) return null;
		
		Node previus = searchBefore(id);
		Node removed = null;
		T result = null;

		if (previus == null) {
			removed = head;
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				head = head.next;
				removed.next = null;
			}
		} else {
			removed = previus.next;
			if (removed == tail) {
				tail = previus;
				previus.next = null;
			} else {
				previus.next = removed.next;
				removed.next = null;
			}
		}

		result = removed.data;
		return result;
	}

	@Override
	public boolean hasNext() {
		return iterationNode != tail;
	}

	@Override
	public T next() {
		if(iterationNode == null){
			iterationNode = head;
		} else iterationNode = iterationNode.next;
		
		return iterationNode.data;
	}

	@Override
	public Iterator<T> iterator() {
		return this;
	}
}


