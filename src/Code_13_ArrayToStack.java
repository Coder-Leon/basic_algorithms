public class Code_13_ArrayToStack {
    public static class ArrayStack {
        private Integer[] arr;
        private Integer index;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init index is less than 0!");
            }
            arr = new Integer[initSize];
            index = 0;
        }

        public Integer peek() {
            if (index == 0) {
                return null;
            }
            return arr[index - 1];
        }

        public void push(int num) {
            if (index == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The Stack is full!");
            }
            arr[index++] = num;
        }

        public Integer pop() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("The Stack is empty!");
            }
            return arr[--index];
        }
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.peek();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
    }
}
