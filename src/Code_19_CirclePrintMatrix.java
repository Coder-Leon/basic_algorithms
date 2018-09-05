public class Code_19_CirclePrintMatrix {

    public static void circlePrintMatrix(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1; // 二维数组的长度是行数
        int d = matrix[0].length - 1; // 二维数组第一行的长度是列数
        while (a <= c && b <= d) {
            printMatrixEdge(matrix, a++, b++, c--, d--);
        }
    }

    public static void printMatrixEdge(int[][] matrix, int a, int b, int c, int d) {
        if (a == c) {
            while (b != d) {
                System.out.print(matrix[a][b++] + " ");
            }
        } else if (b == d) {
            while (a != c) {
                System.out.print(matrix[a++][b]);
            }
        } else {
            int curCol = b;
            int curRow = a;
            while (curCol != d) {
                System.out.print(matrix[a][curCol++] + " ");
            }
            while (curRow != c) {
                System.out.print(matrix[curRow++][d] + " ");
            }
            while (curCol != b) {
                System.out.print(matrix[c][curCol--] + " ");
            }
            while (curRow != a) {
                System.out.print(matrix[curRow--][b] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        circlePrintMatrix(matrix);
    }
}
