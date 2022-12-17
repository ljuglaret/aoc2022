package j9;

import java.util.HashSet;

public class Position  implements Comparable<Position> {
    private int i;
    private int j;
    public Position(int i , int j){
        this.i = i;
        this.j = j;
    }
   
    public int getI() {
        return i;
    }
    public int getJ() {
        return j;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public String toString(){
        return this.i + "-" + this.j;
    }
    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return ((Position) o).i == this.i && ((Position) o).j == j ;
}
@Override
public int hashCode() {
    return this.i*10 + this.j;
}


@Override
public int compareTo(Position p2) {
    if(this.getI() < p2.getI()){
        return -1;
    }
    else if ((this.i > p2.i)){
        return 1;     
    }
    return 0;
}


}
