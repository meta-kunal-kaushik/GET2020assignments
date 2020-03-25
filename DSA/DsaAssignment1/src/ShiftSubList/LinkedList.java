package ShiftSubList;

/**
 * 
 * @author Kunal A sub list is a part of list within a given window of positions
 *         named Left and Right, where Left is the left position in list and Right is the
 *         right position. Implement a linked list and write a method to rotate
 *         sub list in clockwise direction by the number of steps (NoOfShifts) given as
 *         input. For Example: Given Linked list is 2->3->4->5->6->7 and Left=2,
 *         Right=5 and NoOfShifts=2 Sublist is 3->4->5->6 Rotating the sublinklist 3->4->5->6
 *         with NoOfShifts=2 the result would be 5->6->3->4. So, our new linked list is
 *         2->5->6->3->4->7. As an output display the modified linked list.
 */
public class LinkedList {

	private Node head;
	/**
	 * 
	 * @author Kunal
	 * This is a sub class to Implement Node structure
	 */
	private static class Node {
		private int value;
		private Node next;

		Node(int value) {
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
	 * 
	 * @param left , denotes the start of sublist
	 * @param right , denotes the end of sublist
	 * @param noOfShifts , denotes how many rotations are to be performed on the sublist
	 */
	public void shiftListElements(int left, int right, int noOfShifts) {
		Node start = head;
		Node last = head;
		Node tempNode;
		int counter = 1;
		int tempValue;
		while (counter < left) {
			start = start.next;
			counter++;
		}
		counter = 1;
		while (counter < right) {
			last = last.next;
			counter++;
		}

		for (int index1 = 0; index1 < noOfShifts; index1++) {
			tempValue = start.value;
			tempNode = start;
			for (int index2 = 0; index2 < right - left; index2++) {
				tempNode.value = tempNode.next.value;
				tempNode = tempNode.next;
			}
			tempNode.value = tempValue;
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

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		// Adding elements to linkedList
		list.addToTheLast(new Node(2));
		list.addToTheLast(new Node(3));
		list.addToTheLast(new Node(4));
		list.addToTheLast(new Node(5));
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.printList();
		list.shiftListElements(2, 5, 2);
		list.printList();
	}
}
