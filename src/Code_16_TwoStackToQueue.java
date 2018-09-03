import java.util.Stack;

public class Code_16_TwoStackToQueue {
    public static class TwoStackQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackQueue() {
            this.stackPush = new Stack<Integer>();
            this.stackPop = new Stack<Integer>();
        }

        public void add(int num) {
            this.stackPush.push(num);

        }

        public int poll() {
            if (this.stackPush.empty() && this.stackPop.empty()) {
                throw new RuntimeException("The queue is empty!");
            } else if (this.stackPop.empty()) {
                while (!this.stackPush.empty()) {
                    this.stackPop.push(this.stackPush.pop());
                }
            }
            return this.stackPop.pop();
        }

        public int peek() {
            if (this.stackPush.empty() && this.stackPop.empty()) {
                throw new RuntimeException("The queue is empty!");
            } else if (this.stackPop.empty()) {
                while (!this.stackPush.empty()) {
                    this.stackPop.push(this.stackPush.pop());
                }
            }
            return this.stackPop.peek();
        }
    }

    public static void main(String[] args) {
        TwoStackQueue myQueue = new TwoStackQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        myQueue.add(4);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
    }
}
