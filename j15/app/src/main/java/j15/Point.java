
package j15;


public class Point {
    private long x;
    private long y;

    public Point(long x , long y){
        this.x = x ; 
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long distM  (Point p2){
            return Math.abs(x-p2.x) + Math.abs(y-p2.y);
    }

    @Override
    public String toString() {
        return getX()+";"+getY();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
        return true;
        }
        if (!(o instanceof Point)) {
        return false;
        }
        Point p = (Point)o;
        return p.x == this.x && this.y == p.y;
    }

    @Override
    public int hashCode(){
        return (int) Math.random()*10000;
        //this.x*10+ this.y;
    }

    public long coeffDirecteur(Point p2){
        return ((this.y-p2.y)/(this.x-p2.x));
    }

    public long aLorigine(Point p2){
        return this.y - this.x* this.coeffDirecteur(p2);
    }

    public long intersectionX (Point p2, long droite){
        return (droite - this.aLorigine(p2))/this.coeffDirecteur(p2);
    }


}