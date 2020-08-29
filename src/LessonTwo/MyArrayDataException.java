package LessonTwo;

public class MyArrayDataException extends Exception{

    private int indexRow;
    private int indexColm;

    public MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyArrayDataException(int indexRow, int indexColm) {
        this.indexRow = indexRow;
        this.indexColm = indexColm;
    }

    public MyArrayDataException(String message, int indexRow, int indexColm) {
        super(message);
        this.indexRow = indexRow;
        this.indexColm = indexColm;
    }

    public MyArrayDataException(String message, Throwable cause, int indexRow, int indexColm) {
        super(message, cause);
        this.indexRow = indexRow;
        this.indexColm = indexColm;
    }

    @Override
    public String toString() {
        return "Cant parse element of matrix to int. ID elements: row = " + indexRow + " colm = " + indexColm;
    }
}
