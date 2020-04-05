package PriorityQueue;

public class PriorityQueue {
    int sizeArray;
    int arr[];
    int size = 0;

    /**
     * This is used to initilize size and array
     * 
     * @param element
     */
    PriorityQueue(int element) {
        arr = new int[element];
        this.sizeArray = element;

    }

    /**
     * This method is used to add the data to queue
     * 
     * @param data
     */
    public void enque(int data) {
        int index;
        if (!isFull()) {
            if (isEmpty()) {
                arr[0] = data;
                size++;

            } else {
                for (index = size - 1; index >= 0; index--) {

                    if (data > arr[index]) {

                        arr[index + 1] = arr[index];
                    } else {
                        break;
                    }
                }
                arr[index + 1] = data;
                size++;
            }
        } else {
            System.out.println("queue is full");
        }
    }

    /**
     * This is used to check whether queue is empty
     * 
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * This is used to check whether queue is full
     * 
     * @return
     */
    public boolean isFull() {
        return size == sizeArray;
    }

    /**
     * This is used to delete from queue
     */
    public void deque() {
        if (!isEmpty()) {
            arr[--size] = 0;
        } else {
            System.out.println("Queue is empty");
        }
    }

    public int[] show() {

        return arr;

    }

}
