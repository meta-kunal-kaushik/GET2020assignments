package Loop;

/**
 * 
 * @author Kunal
 * This class is made to test whether there are any Loops in the list or not
 */
public class LinkedList{

	private Node head;
	/**
	 * 
	 * @author Kunal
	 * This is a sub class to Implement Node structure
	 */
	public static class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;

		}
	}
	/**
	 * This method adds the new node at the end of the list
	 * @param node
	 */
	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}
	/**
	 * This function simply prints the elements of the list
	 */
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	public void addALoop() {
		Node moveAheadPointer = this.head;

		while (moveAheadPointer.next != null) {
			moveAheadPointer = moveAheadPointer.next;
		}
		moveAheadPointer.next = head;

	}
	public boolean ifLoopExists() {
		Node fastPtr = head;
		Node slowPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (slowPtr == fastPtr)
				return true;

		}
		return false;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		// Creating a linked list

		list.addToTheLast(new Node(5));
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
		list.printList();
		list.addALoop();

		// Test if loop existed or not
		System.out.println("Loop existed-->" + list.ifLoopExists());

	}

}