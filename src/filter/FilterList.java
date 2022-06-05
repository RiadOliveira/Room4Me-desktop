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

	public Node searchNode(T data) {
		Node p = head;

		while (p != null) {
			if (p.data == data) return p;
			p = p.next;
		}

		return null;
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
		Node previous = null;

		while (p != null) {
			previous = p;
			p = p.next;

			if (p != null && p.id == id) {
				return previous;
			}
		}
		
		return null;
	}

	public Node searchBefore(T data) {
		Node p = head;
		Node previous = null;

		while (p != null) {
			previous = p;
			p = p.next;

			if (p != null && p.data == data) {
				return previous;
			}
		}
		
		return null;
	}

	public T remove(int id) {
		if (head == null) return null;
		
		Node previous = searchBefore(id);
		Node removed = null;
		T result = null;

		if (previous == null) {
			removed = head;
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				head = head.next;
				removed.next = null;
			}
		} else {
			removed = previous.next;
			if (removed == tail) {
				tail = previous;
				previous.next = null;
			} else {
				previous.next = removed.next;
				removed.next = null;
			}
		}

		result = removed.data;
		return result;
	}

	public void exchangePositionWithPrevious(
		T positionData
	) {
		Node beforeNode = searchBefore(positionData);
		Node previousBeforeNode = searchBefore(beforeNode.data);
		Node currentNode = beforeNode.next;
		
		if(previousBeforeNode != null) previousBeforeNode.next = currentNode;
		beforeNode.next = currentNode.next;
		currentNode.next = beforeNode;

		if(beforeNode == head) head = currentNode;
		else if(currentNode == tail) tail = beforeNode;
		iterationNode = beforeNode;
	}

	@Override
	public boolean hasNext() {
		boolean verifyHasNext = iterationNode != tail;
		if(!verifyHasNext) iterationNode = null;

		return verifyHasNext;
	}

	@Override
	public T next() {
		if(iterationNode == null) iterationNode = head;
		else iterationNode = iterationNode.next;

		return iterationNode.data;
	}

	@Override
	public Iterator<T> iterator() {
		return this;
	}
}


