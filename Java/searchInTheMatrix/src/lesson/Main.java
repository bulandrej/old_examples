package lesson;

// Определить количество столбцов матрицы, в которых больше пяти отрицательных элементов.

public class Main {

    static int[][] matrix;

    public static void main(String[] args) {

        matrix = new int[][]{
                {1,   2, -3,   4,  5,   9,  11, 14},
                {6,   7, -8,   9, 10, -17, -11, 21, 22, 24, 54, 32},
                {11, 12, -13, 14, 15, -48,  22, 31},
                {16, 17, -18, 19, 20, -12, 334, 781},
                {21, 22, -23, 24, 25, -58,  61, 84},
                {21, 22, -14, 24, 25, -58,  61, 84},
                {21, 29, -23, 78, 25, -66,  61, 84}
        };

        System.out.println("количество столбцов с более, чем 5 отрицательными элементами: " + countColumn());
    }

    private static int matrixDimension() {
        int dimension = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) {
                dimension = matrix[i].length;
                continue;
            }
            dimension = (dimension > matrix[i].length) ? matrix[i].length : dimension;
        }
        return dimension;
    }

    private static boolean countNegativInColumn(int n) {
        int x = 0;
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][n] < 0) x++;
        }
        return (x>5)? true:false;
    }

    private static int countColumn() {
        int count = 0;
        for (int j = 0; j < matrixDimension(); j++)
            if(countNegativInColumn(j)) count++;
        return count;
    }
}
