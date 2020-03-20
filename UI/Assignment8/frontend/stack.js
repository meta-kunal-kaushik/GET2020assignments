class Stack {
    constructor() {
        this.stack = [];
    }
    push(element) {
        this.stack.push(element);
    }
    pop() {
        if (this.isEmpty())
            return "stack is empty";
        this.stack.pop();
    }
    printStack() {
        if (this.isEmpty())
            return "Stack is Empty";
        var output = "";
        for (var index = this.stack.length - 1; index => 0; index--)
            output += this.stack[index] + "\n";
        return output;
    }
    isEmpty() {
        return this.stack.length == 0;
    }
}