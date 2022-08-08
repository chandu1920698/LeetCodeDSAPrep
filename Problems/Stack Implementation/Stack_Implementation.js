/*
Data Structure : Stack
*/

class Stack {
    constructor() {
        this.stackArray = [1,2,3,4,5];
        //this.top = -1;
        this.arrayCapacity = this.stackArray.length;
    }

    add(element) {
        console.log('Before Adding : ', this.stackArray);
        this.stackArray.push(element);
        console.log('After Adding : ', this.stackArray);
        return this.stackArray;
    }

    pop() {
        if(this.stackArray.length > 0) {
            console.log('Before Popping : ', this.stackArray);
            this.stackArray.pop();
            return this.stackArray;
        } else {
            console.log('STACK IS ALREADY EMPTY');
            return 'STACK IS ALREADY EMPTY';
        }
    }

    peek() {
        return 'Top Element : ' + this.stackArray[this.stackArray.length - 1];
    }

    // isFull() {
    //     return (this.top == this.arrayCapacity - 1);
    // }

    isEmpty() {
        return 'IsEmpty : ' + (this.stackArray.length == 0);
    }
}

let stack = new Stack();

console.log('Stack Implementation Starts');
stack.add(1);
console.log(stack.pop());
console.log(stack.add(2));
console.log(stack.peek());
console.log(stack.isEmpty());
console.log('Stack Implementation Ends');