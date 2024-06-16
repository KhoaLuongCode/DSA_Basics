public class LinkedListStack<T extends Comparable<? super T>> {
    private Node<T> top;
    private int size;

    public LinkedListStack() {
        // top is currently null
        top = null;
        size = 0;
    }

    public boolean push(T value) {

        // creates a new node and set the T value into the new node
        Node<T> newNode = new Node<>(value);

        if (top == null){
            top = newNode;
        }
        else {
            // set the next field of the new node to point to the top of the stack
            newNode.next = top;
            // update the top as the new node
            top = newNode;
        }
        // increase the size by 1 because one value was pushed into the top of the stack
        size = size + 1;
        return true;
    }

    public T pop() {
        // see if there isn't any value in the stack, return null
        if (top == null) {
            return null;
        }
        // reference a value of type T
        T value = top.value;
        // refer the top the next value of the top in the stack
        top = top.next;
        // decrease the size of the stack because one element was removed
        size = size - 1;
        // return the value of the deleted element
        return value;
    }


    public T peek() {
        if (top == null) {
            return null;
        }
        return top.value;
    }

    public boolean isEmpty(){
        if (top == null){
            return true;
        }
        else{
            return false;
        }
    }

    public int getSize(){
        return size;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            next = null;
        }
    }
}

