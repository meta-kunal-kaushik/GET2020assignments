//                                                                  Singly linklist operations
class Node {
    constructor(element) {
        this.element = element;
        this.nextLink = null;
    }
}
class LinkList {
    constructor() {
        this.header = null;
        this.numberOfElements = 0;
    }

    add(element) {
        var newNode = new Node(element);
        if (this.header == null)
            this.header = newNode;
        else {
            newNode.nextLink = this.header;
            this.header = newNode;
        }
        this.numberOfElements++;
    }

    removeItemAtIndex(index) {
        var listElement = this.header;
        var prev = null;
        var count = 1;
        if (index == 1) { // delete first node
            this.header = this.header.nextLink;
        } else if (index == this.numberOfElements) { // delete last node
            while (listElement.nextLink != null) {
                prev = listElement;
                listElement = listElement.nextLink;
            }
            prev.nextLink = null;
        } else { //delete intermediate node
            while (listElement) {
                if (count == index) {
                    prev.nextLink = listElement.nextLink;
                }
                prev = listElement;
                listElement = listElement.nextLink;
                count++;
            }
        }
        return "Item deleted successfully";
    }

    printLinkList() {
        var listElement = this.header;
        var output = "";
        while (listElement) {
            output += listElement.element + "  ";
            listElement = listElement.nextLink;
        }
        return output;
    }

}