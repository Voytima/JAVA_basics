// 3*) Напистаь простую реализацию стека. (иметь операции push и pop)

public class MyStack {
    static class Stack {
        private final int[] arr;
        private int top;
        private final int content;

        // Constructor:
        Stack(int size) {
            arr = new int[size];
            content = size;
            --top;
        }

        // Secondary func to add "x" in stack:
        public void push(int x) {
            if (isFull()) {
                System.out.println("Overflow!\n");
                System.exit(-1);
            }
            System.out.println("In >> " + x);
            arr[++top] = x;
        }

        // Secondary func to extract "top x" from stack:
        public void pop() {
            if (isEmpty()) {
                System.out.println("Underflow!\n");
                System.exit(-1);
            }
            System.out.println("Out << " + peek());
            top--;
        }

        // Secondary func to return "top x" from stack:
        public int peek() {
            if (!isEmpty()) {
                return arr[top];
            } else {
                System.exit(-1);
            }
            return -1;
        }

        // Secondary func to return stack size:
        public int size() {
            return top + 1;
        }

        // Secondary func to check if stack is empty:
        public boolean isEmpty() {
            return size() == 0;
        }

        // Secondary func to check is stack is full:
        public boolean isFull() {
            return size() == content;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Top element in stack is: " + stack.peek());
        System.out.println("Stack size is: " + stack.size());
        System.out.println();

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("Top element in stack now is: " + stack.peek());
        System.out.println("Stack size is: " + stack.size());
        System.out.println();

        if (stack.isEmpty()) {
            System.out.println("Stack is empty...");
        } else {
            System.out.println("Stack is not empty!");
        }

        // Some checks below:
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        System.out.println();
//
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
    }
}