package circularQueue;

/**
 * @author kunal
 * Interface to implement queue
 */
public interface Queue {
	boolean isFull();
	boolean isEmpty();
	void enqueue(int data);
	int dequeue();
}