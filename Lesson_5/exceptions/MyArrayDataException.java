package exceptions;

public class MyArrayDataException extends Exception {
    private int row;
    private int col;
    
    public MyArrayDataException(int row, int col, String message) {
        super(message);
        this.row = row;
        this.col = col;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
}