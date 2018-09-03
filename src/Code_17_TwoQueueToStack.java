import java.util.LinkedList;
import java.util.Queue;

public class Code_17_TwoQueueToStack {
    public static class TwoQueueStack {
        private Queue<Integer> queue;
        private Queue<Integer> helpQueue;

        public TwoQueueStack(){
            this.queue = new LinkedList<Integer>();
            this.helpQueue = new LinkedList<Integer>();
        }

        public void push(int num) {
            this.queue.add(num);
        }

        public int pop(){
            if (this.queue.isEmpty()) {
                throw new RuntimeException("The stack is empty!");
            } else {
                while (this.queue.size() > 1){
                    this.helpQueue.add(this.queue.poll());
                }
            }
            int res = this.queue.poll();
            swap();
            return res;
        }

        public int peek(){
            if (this.queue.isEmpty()) {
                throw new RuntimeException("The stack is empty!");
            } else {
                while (this.queue.size() > 1){
                    this.helpQueue.add(this.queue.poll());
                }
            }
            int res = this.queue.poll();
            this.helpQueue.add(res);
            swap();
            return res;
        }

        public void swap(){
            Queue<Integer> tmp = this.helpQueue;
            this.helpQueue = this.queue;
            this.queue = tmp;
        }
    }

    public static void main(String[] args) {
        TwoQueueStack myStack = new TwoQueueStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
