package filter;

public interface IFilterList<T> {
    public T peekFirst() throws Exception;
    public T peekLast() throws Exception;

    public void addFirst(T item) throws Exception;
    public void addLast(T item) throws Exception;
    public void addAfter(T item, T comparativeItem) throws Exception;

    public T removeFirst() throws Exception;
    public T removeLast() throws Exception;
    public void remove(T item) throws Exception;

    public T search(T item);
    public boolean isEmpty();
}
