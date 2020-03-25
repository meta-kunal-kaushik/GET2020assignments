package MultiVarientPolyDegree;

import MultiVarientPolyDegree.MultiVarientPolyDegree.LinkedList.Node;

/**
 * 
 * @author Kunal
 * Provides a function to find the degree of a multivariate polynomial.
 */
public class MultiVarientPolyDegree {
	PolyNode headOfPoly;
	int noOfPolys;

	/**
	 * This linklist is used for storing each element of polynomial in a
	 * separate list
	 * 
	 * @author Kunal
	 *
	 */
	public static class LinkedList {
		private Node head;
		private int noOfNodes;
		private int coeff;

		public static class Node {
			private char variable;
			private int degree;
			private Node next;

			private Node(char variable, int degree) {
				this.variable = variable;
				this.degree = degree;
			}
		}

		public LinkedList(int coeff) {
			this.coeff = coeff;
		}

		public void addToTheLast(Node node) {

			if (head == null) {
				head = node;
			} else {
				Node temp = head;
				while (temp.next != null)
					temp = temp.next;

				temp.next = node;
			}
			noOfNodes++;
		}

		public String printList() {
			Node temp = head;
			String returnVal = "";
			while (temp != null) {
				returnVal += temp.variable + "^" + temp.degree;
				temp = temp.next;
			}
			return returnVal;
		}
	}

	/**
	 * This class stores info about each Element in polynomial Expression
	 * 
	 * @author Kunal
	 *
	 */
	private static class PolyNode {
		LinkedList polyExpression;
		PolyNode nextPolyNode;

		public PolyNode(LinkedList polyExpression) {
			this.polyExpression = polyExpression;
		}

	}

	/**
	 * This class adds each polynomial Element at the end of the last polynomial
	 * Element in MultiVarientPolyDegree list
	 * 
	 * @param polyNode
	 */
	public void addPolyNode(PolyNode polyNode) {
		if (headOfPoly == null) {
			headOfPoly = polyNode;
		} else {
			PolyNode temp = headOfPoly;
			while (temp.nextPolyNode != null)
				temp = temp.nextPolyNode;
			temp.nextPolyNode = polyNode;
		}
		noOfPolys++;
	}

	/**
	 * This function finds the maximum degree in the polynomial
	 * 
	 * @return maximum degree
	 */
	public int degreeOfPolynomial() {
		int degree = 0;
		int index1 = 0;
		int sum = 0;
		PolyNode poly = headOfPoly;
		while (poly != null) {
			// for each polynomial Element
			while (index1 < poly.polyExpression.noOfNodes) {
				// sum of degree of all variables in a single polynomial Element
				// Ex : x^3 Z^10 p^2 , then sum of degree =15
				sum = 0;
				Node node = poly.polyExpression.head;
				while (node != null) {
					sum += node.degree;
					node = node.next;
				}
				index1++;
			}
			System.out.println("sum : " + sum);
			// compare the degree of each polynomial Element
			if (sum > degree) {
				degree = sum;
			}
			poly = poly.nextPolyNode;
			index1 = 0;
		}
		return degree;
	}

	/**
	 * This function prints the polynomial
	 */
	public void printPolynomial() {
		PolyNode temp = headOfPoly;
		while (temp != null) {
			System.out.print(temp.polyExpression.coeff + " "
					+ temp.polyExpression.printList() + "   +   ");
			temp = temp.nextPolyNode;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		// 1st element of polynomial
		LinkedList list1 = new LinkedList(32);
		list1.addToTheLast(new Node('x', 2));
		list1.addToTheLast(new Node('y', 1));
		PolyNode polyElement1 = new PolyNode(list1);
		// 2nd element of polynomial
		LinkedList list2 = new LinkedList(34);
		list2.addToTheLast(new Node('y', 2));
		list2.addToTheLast(new Node('z', 2));
		list2.addToTheLast(new Node('p', 10));
		PolyNode polyElement2 = new PolyNode(list2);
		// 3rd element of polynomial
		LinkedList list3 = new LinkedList(51);
		list3.addToTheLast(new Node('x', 3));
		list3.addToTheLast(new Node('z', 4));
		PolyNode polyElement3 = new PolyNode(list3);

		// add all polyElements to polynomial
		MultiVarientPolyDegree polynomial = new MultiVarientPolyDegree();
		polynomial.addPolyNode(polyElement1);
		polynomial.addPolyNode(polyElement2);
		polynomial.addPolyNode(polyElement3);
		polynomial.printPolynomial();
		System.out.println("Degree of polynomial : "
				+ polynomial.degreeOfPolynomial());
	}
}
