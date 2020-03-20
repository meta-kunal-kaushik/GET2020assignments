// Queue implementation 
class Queue {
    constructor() {
        this.queue = [];
        this.front = 0;
        this.last = 0;
        this.queueLimit = 4;
    }
    enqueue(element) {
        if (this.queueLimit - 1 < this.last)
            return "Queue overflow";
        else {
            this.queue[this.last] = element;
            this.last++;
        }
    }
    dequeue() {
        if (this.front == this.last || this.front == 0 && this.last == 0) {
            this.front = 0;
            this.last = 0;
            return "Queue is empty (underflow)";
        } else
            this.front++;
    }
    showQueue() {
        if (this.queue.length == 0)
            return "Queue is empty";
        var output = "";
        for (var index1 = this.front; index1 < this.last; index1++) {
            output += this.queue[index1] + " ";
        }
        return output;
    }
}