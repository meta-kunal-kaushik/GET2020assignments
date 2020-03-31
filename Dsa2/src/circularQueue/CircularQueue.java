package circularQueue;

/**
 * @author kunal 
 * Contains various method of queue
 */
public class CircularQueue implements Queue {
	int maxSize;
	int rear;
	int front;
	int cirQueue[];

	/**
	 * Constructor to set size of queue array
	 * @param maxSize
	 */
	public CircularQueue(int maxSize) {
		this.maxSize = maxSize;
		this.cirQueue = new int[maxSize];
		rear = -1;
		front = -1;
	}

	/**
	 * Method to add item in queue
	 * 
	 * @param item, item which is to be added
	 * @return : true if item added , else false
	 */
	public void enqueue(int item) {
		if (isFull()) {
			System.out.println("Queue is Full");
		} else if (front == -1) {
			front = rear = 0;
			cirQueue[rear] = item;
		} else if (rear == maxSize - 1 && front != 0) {
			rear = 0;
			cirQueue[rear] = item;
		} else {
			rear++;
			cirQueue[rear] = item;
		}
	}

	/**
	 * Method to delete item from queue
	 * 
	 * @return : item which is deleted
	 */
	public int dequeue() {
		if (front == -1) {
			System.out.println("Queue is Empty");
			return Integer.MIN_VALUE;
		}
		int data = cirQueue[front];
		cirQueue[front] = -1;
		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == maxSize - 1)
			front = 0;
		else
			front++;
		return data;
	}

	/**
	 * Method to check whether queue is full or not
	 * 
	 * @return : true if full else false
	 */
	public boolean isFull() {
		if ((front == 0 && rear == maxSize - 1)
				|| (rear == (front - 1) % (maxSize - 1))) {
			System.out.println("Queue is Full");
			return true;
		}
		return false;
	}

	/**
	 * Method to check either queue is empty
	 * 
	 * @return : true if empty else false
	 */
	public boolean isEmpty() {
		if (front == -1) {
			System.out.println("Queue is Empty");
			return true;
		}
		return false;
	}

	/**
	 * Method to display the queue
	 */
	public void display() {
		if (isEmpty()) {
			return;
		}
		System.out.println("Elements in Circular Queue are: ");
		if (rear >= front) {
			for (int i = front; i <= rear; i++)
				System.out.println(cirQueue[i] + " ");
		} else {
			for (int i = front; i < maxSize; i++)
				System.out.println(cirQueue[i] + " ");

			for (int i = 0; i <= rear; i++)
				System.out.println(cirQueue[i] + " ");
		}
	}
}