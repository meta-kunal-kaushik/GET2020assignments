package circularQueue;

import java.util.Scanner;

public class CircularQueueImplement {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Size of Circular Queue : ");
		int maxSize = scan.nextInt();
		CircularQueue object = new CircularQueue(maxSize);
		System.out.println("Enqueu performed : ");
		object.enqueue(12);
		object.enqueue(14);
		object.enqueue(17);
		object.enqueue(19);
		object.enqueue(22);
		object.enqueue(3);
		System.out.println("Dequeue performed : ");
		for(int index=0;index<7;index++) {
			int data = object.dequeue();
			if(data == Integer.MIN_VALUE)
				System.out.println("Queue underflow..");
			else
				System.out.println(data+" is deleted from queue");
		}
		
	}
}
