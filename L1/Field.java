package javaapplication4;
import java.util.ArrayList;
public class Field {
    private Square[] field;
    private int fieldSize;
    
    Field () {
        this.fieldSize = 3;
        this.field = new Square[9];
        fillRandNums(field);
    }
    
    public void moveR() {
        int zero = getNull();
        if (zero % fieldSize == 0) return;
        else swap(zero, zero - 1);
    }
    
    public void moveL() {
        int zero = getNull();
        if (zero % fieldSize == fieldSize - 1) return;
        else swap(zero, zero + 1);
    }
    
    public void moveU() {
        int zero = getNull();
        if (zero / fieldSize == fieldSize - 1) return;
        else swap(zero, zero + fieldSize);
    }
    
    public void moveD() {
        int zero = getNull();
        if (zero / fieldSize == 0) return;
        else swap(zero, zero - fieldSize);
    }
    
    public void fillRightNums() {
        for (int i = 0; i < field.length - 1; i++) {
            this.field[i] = new Square(i + 1);
        }
        this.field[field.length - 1] = new Square(0);
    }
    
    public Square[] getField() {
        return this.field;
    }
    
    private int getNull() {
        for (int i = 0; i < field.length; i++) {
            if (field[i].getNum() == 0) return i;
        }
        return -1;
    }
    
    private void fillRandNums(Square[] field) {
        ArrayList<Integer> ar = new ArrayList(this.fieldSize * this.fieldSize);     //Creating new array with numbers;
        for (int i = 0; i < field.length; i++) {
            ar.add(i);
        }
        
        for (int i = 0; i < field.length; i++) {                                //Fillind field;
            field[i] = new Square(ar.remove((int)(Math.random() * ar.size())));
        }
    }
    
    public void fillSelectedNums(int[] ar) {
        if (ar.length != field.length) return;
        for (int i = 0; i < field.length; i++) {
            field[i] = new Square(ar[i]);
        }
    }
    
    private void swap (int i1, int i2) {
        if (i1 >= field.length || i2 >= field.length) return;
        if (i1 < 0 || i2 < 0) return;
        
        Square buf = field[i1];
        field[i1] = field[i2];
        field[i2] = buf;
    }

    private int getSize() {
        return fieldSize;
    }
    
    @Override
    public String toString() {
        String s = " ";
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                s += this.field[i * fieldSize + j];
                if (j == fieldSize - 1) {
                    if (i != fieldSize - 1) {
                        s += "\n---+---+---\n ";
                    } else s += "\n ";
                } else {
                    s += " | ";
                }
            }
        }
        return s;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) return false;
        Field f = (Field) o;
        if (f.getSize() != this.getSize()) return false;
        Square[] s = f.getField();
        for (int i = 0; i < field.length; i++) {
            if (this.field[i].equals(s[i])) return false;
        }
        return true;
    }
}
