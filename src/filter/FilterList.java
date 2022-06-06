package filter;


import java.util.Iterator;

public class FilterList<T> implements IFilterList<T>, Iterable<T>, Iterator<T> {
	private class Node {
        public Node previous = null;
        public Node next = null;
        public T data;

        public Node(T data) {
            this.data = data;
        }
    }

    private int size = 0;
    private Node head = null;
    private Node tail = null;
	private Node iterationNode = null;

	public int getSize() {
		return size;
	}

    public boolean isEmpty() {
        return size == 0;
    }

    public T peekFirst() throws Exception {
        if(isEmpty()) return null;
        return head.data;
    }

    public T peekLast() throws Exception {
        if(isEmpty()) return null;
        return tail.data;
    }
    public Node searchNode(int position) {
		Node iterationNode = head;

        for(int ind=0 ; ind<position ; ind++) {
            if(iterationNode == null) return null;
            iterationNode = iterationNode.next;
        }

		return iterationNode;
	}

    private Node searchNode(T item) {
        if(isEmpty()) return null;

        Node iterationNode = head;
        while(iterationNode != null) {
            if(iterationNode.data.equals(item)) return iterationNode;
            iterationNode = iterationNode.next;
        }

        return null;
    }
    public T search(int position) {
		Node findedNode = searchNode(position);
        return findedNode == null ? null : findedNode.data;
	}
    
    public T search(T item) {
        Node findedNode = searchNode(item);
        return findedNode != null ? findedNode.data : null;
    }

    public void addFirst(T item) {
        Node createdNode = new Node(item);
        createdNode.next = head;

        head = createdNode;
        if(tail == null) tail = head;

        size++;
    }

    public void addLast(T item) {
        if(tail == null) addFirst(item);
        else {
            Node createdNode = new Node(item);
            createdNode.previous = tail;
            tail.next = createdNode;
    
            tail = createdNode;
            if(head == null) head = tail;
            
            size++;
        }
    }

	public void add(T item) {
		addLast(item);
	}

    public void addAfter(T item, T comparativeItem) {
        if(isEmpty()) return;

        if(comparativeItem.equals(tail.data)) {
            addLast(item);
            return;
        }

        Node comparativeNode = searchNode(comparativeItem);
        if(comparativeNode == null) return;

        Node createdNode = new Node(item);
        Node nextNode = comparativeNode.next;

        createdNode.previous = comparativeNode;
        createdNode.next = nextNode;
        
        comparativeNode.next = createdNode;
        nextNode.previous = createdNode;

        size++;
    }

    public T removeFirst() {
        if(isEmpty()) return null;
        T removedHead = head.data;

        if(head == tail) tail = null;
        head = head.next;
        head.previous = null;

        size--;
        return removedHead;
    }

    public T removeLast() {
        if(isEmpty()) return null;
        T removedTail = tail.data;
        
        if(tail == head) head = null;
        tail = tail.previous;
        tail.next = null;

        size--;
        return removedTail;
    }
    public T remove(int position) {
		if (head == null) return null;
		
		Node previous = searchNode(position).previous;
		Node removed = null;
		T result = null;
    
		if (previous == null) {
			removed = head;
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				head = head.next;
                head.previous = null;
			}
		} else {
			removed = previous.next;
			if (removed == tail) {
				tail = previous;
				previous.next = null;
			} else {
				previous.next = removed.next;
                removed.next.previous = previous;
			}
		}

		result = removed.data;
		return result;
	}

    public void remove(T item) {
        if(isEmpty()) return;

        Node findedNode = searchNode(item);
        if(findedNode == null) return;

        if(findedNode == head) removeFirst();
        else if(findedNode == tail) removeLast();
        else {
            Node nextNode = findedNode.next;
            Node beforeNode = findedNode.previous;

            nextNode.previous = beforeNode;
            beforeNode.next = nextNode;

            size--;
        }
    }

	public void exchangePositionWithPrevious(
		T positionData
	) {
		Node currentNode = searchNode(positionData);
		Node beforeNode = currentNode.previous;
		
		Node afterCurrentNode = currentNode.next;
		Node previousBeforeNode = beforeNode.previous;
		if(previousBeforeNode != null) previousBeforeNode.next = currentNode;
		if(afterCurrentNode != null) afterCurrentNode.previous = beforeNode; 

		beforeNode.previous = currentNode;
		beforeNode.next = afterCurrentNode;
		currentNode.next = beforeNode;
		currentNode.previous = previousBeforeNode;

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