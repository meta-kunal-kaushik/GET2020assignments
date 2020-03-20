//                                            Doubly linklist

node = function(element) {
    this.data = element;
    this.next = null;
    this.prev = null;
}
doublyLinkedList = function() {
    this.head = null;
    this.add = function(element) {
        newNode = new node(element);
        if (this.head == null) {
            this.head = newNode;
        } else {
            var currentNode = this.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            newNode.prev = currentNode;
            currentNode.next = newNode;
        }
    }
    this.deleteNode = function(element) {
        var currentNode = this.head;
        if (currentNode == null) {
            console.log("List is empty");
        } else if (currentNode != null && currentNode.data == element) {
            this.head = this.head.next;
            this.head.prev = null;
        } else {
            while (currentNode.next != null && currentNode.data != element) {
                currentNode = currentNode.next;
            }
            if (currentNode.next != null) {
                currentNode.next.prev = currentNode.prev;
            }
            currentNode.prev.next = currentNode.next;
        }
    }
    this.printList = function() {
        var currentNode = this.head;
        if (currentNode == null) {
            console.log("Empty");
        }
        while (currentNode != null) {
            console.log(currentNode.data);
            currentNode = currentNode.next;
        }
    }
}