function Queue() {
    this.elements = [];
}

Queue.prototype.enqueue = function(element) {
    this.elements.push(element);
}

Queue.prototype.dequeue = function() {
    if (this.length() == 0)
        return "Queue is Empty";
    return this.elements.shift();
}
Queue.prototype.length = function() {
    return this.elements.length;
}
