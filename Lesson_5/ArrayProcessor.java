import exceptions.MyArraySizeException;
import exceptions.MyArrayDataException;

public class ArrayProcessor {
    
    public static int processArray(String[][] array) 
            throws MyArraySizeException, MyArrayDataException {
        
        // 1. Проверка на null
        if (array == null) {
            throw new MyArraySizeException("Массив не может быть null");
        }
        
        // 2. Проверка размера (должен быть 4x4)
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть 4x4, а у вас " + 
                                         array.length + " строк");
        }
        
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Массив должен быть 4x4, а в строке " + 
                                             i + " - " + array[i].length + " столбцов");
            }
        }
        
        // 3. Суммирование элементов
        int sum = 0;
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int num = Integer.parseInt(array[i][j]);
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, 
                        "Не число в ячейке [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }
        
        return sum;
    }
}