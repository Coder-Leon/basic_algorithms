public class Code_14_ArrayToQueue {
    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer start;
        private Integer end;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("This init size is less than 0!");
            }
            arr = new Integer[initSize];
            size = 0;
            start = 0;
            end = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[start];
        }

        public void push(int num) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full!");
            }
            arr[end] = num;
            size++;
            end = (end == (arr.length - 1)) ? 0 : (end + 1);
        }

        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("This queue is empty!");
            }
            int tmp = start;
            start = (start == (arr.length - 1)) ? 0 : (start + 1);
            size--;
            return arr[tmp];
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        queue.push(4);
        queue.push(5);
        System.out.println(queue.peek());
    }
}
