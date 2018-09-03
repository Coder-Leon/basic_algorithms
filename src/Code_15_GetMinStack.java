import java.util.Stack;

public class Code_15_GetMinStack {
    public static class MyStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int num) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(num);
            } else if (num <= stackMin.peek()) {
                this.stackMin.push(num);
            } else {
                this.stackMin.push(this.stackMin.peek());
            }
            this.stackData.push(num);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("The stack is empty!");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        public int getMin(){
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("The stack is empty!");
            }
            return this.stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        System.out.println("Min: " + myStack.getMin());
        myStack.push(2);
        myStack.push(5);
        myStack.push(1);
        System.out.println("Min: " + myStack.getMin());
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Min: " + myStack.getMin());
    }
}
