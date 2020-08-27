package LessonTwo;

public class Matrix {

    private String[][] matrix;
    private int sizeMatrix;
    private int sum;

    public Matrix(String[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix() {
        matrix = new String[][] {
                {"1", "2", "3", "4"},
                {"5", "f", "6", "7"},
                {"8", "9", "10", "10"},
                {"12", "13", "15" , "16"}
        };
    }

    public int getSum() {
        return sum;
    }


    public String[][] getMatrix() {
        return matrix;
    }

    public void printMatrix(Object[][] matrix) {
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public int getSizeMatrix() {
        return sizeMatrix;
    }

    public void setMatrix(String[][] matrix) throws MyArraySizeException{
        if(!isEqualSize(matrix)) {
            throw new MyArraySizeException("Different size matrix !");
        }
        this.matrix = matrix;
    }

    public Integer[][] setStringMatrixToIntMatrix() throws MyArrayDataException {
        Integer[][] matrixInt = new Integer[matrix.length][matrix.length];
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                try {
                    matrixInt[i][j] = Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Error in function \"setStringMatrixToIntMatrix\" ",i,j);
                }
                sum = sum + matrixInt[i][j];
            }
        }
        return matrixInt;
    }


// CHECKERS



    public boolean isSquare() {
        boolean check = true;
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                if(matrix.length != matrix[i].length) {
                    check = false;
                    return check;
                }
            }
        }
        sizeMatrix = matrix.length;
        return check;
    }

    private boolean isEqualSize(String[][] matrix) {
        if(matrix.length != this.matrix.length) {
            return false;
        }
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                if(this.matrix.length != matrix[i].length) {
                    return false;
                }
            }
        }
        return true;
    }

    //end class
}
