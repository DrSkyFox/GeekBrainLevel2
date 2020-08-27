package LessonTwo;

public class MainExcepApp {
/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
 при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива,
преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
 и вывести результат расчета.
 */
    public static void main(String[] args) {
        System.out.println("RunProg");
        Matrix matrix = new Matrix();
        matrix.printMatrix(matrix.getMatrix());


        String[][] chMattix = new String[][] {
                {"1", "2", "3", "4"},
                {"5", "f", "6", "7"},
                {"8", "9", "10", "10"},
                {"12", "13", "15" , "16"},
                {"22", "33", "55" , "66"}
        };
        try {
            matrix.setMatrix(chMattix);
            matrix.printMatrix(matrix.getMatrix());

        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            matrix.setMatrix(new String[][] {
                    {"1", "2", "3", "4"},
                    {"5", "45", "6", "7"},
                    {"8", "9", "10", "10"},
                    {"12", "13", "15" , "f"}
            });
        }

        try {
            matrix.printMatrix(matrix.setStringMatrixToIntMatrix());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
            System.out.println("PreSum: " + matrix.getSum());
            e.printStackTrace();
            return;
        }

        System.out.println("Sum: " + matrix.getSum());


    }
}
