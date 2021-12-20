package javaapplication4;
public class Square {
    private int num;
    
    Square (int num) {
        this.num = num;
    }
    
    public int getNum() {
        return this.num;
    }

    @Override
    public String toString() {
        if (num == 0) return "-";
        return num + "";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) return false;
        if (((Square) o).getNum() != this.num) return false;
        return true;
    }
}
