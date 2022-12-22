package j15;


import java.util.*;
import java.io.*;

public class J15 {

    private  String cheminFichier;

    public J15(String cheminFichier){
        this.cheminFichier = cheminFichier;
    }

    public ArrayList<Point[]>  init() throws IOException {
        ArrayList<Point[]> poss= new ArrayList<>();

            File file = new File(cheminFichier);
            FileReader fr = new FileReader(file);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line;
              
                while ((line = br.readLine()) != null) {
                String[] s = line.split(",");
                long xSensor =  Integer.valueOf(s[0].replaceAll("[^0-9]", ""));
                long ySensor = Integer.valueOf(s[1].split(":")[0].replaceAll("[^0-9]", ""));
                long xBeacon = Integer.valueOf(s[1].split(":")[1].replaceAll("[^0-9]", ""));
                long yBeacon = Integer.valueOf( s[2].replaceAll("[^0-9]", ""));
             //   System.out.println( xSensor +"-"+ySensor+"-"+xBeacon+"-"+yBeacon);
                    Point[]co = new Point[2];
                    co[0] = new Point(xSensor,ySensor);
                    co[1] = new Point(xBeacon, yBeacon);
                    poss.add(co);
                }
            }
        
        return poss;
    }
    public Set<Point> losange (Point gauche, Point basOuHaut, Point droit,long ligne){
        Set<Point> points = new HashSet<>();
        long x1 = gauche.intersectionX(basOuHaut,ligne);
        long x2 = basOuHaut.intersectionX(droit,ligne);
        for (long i = x1 ; i<=x2;i++){
            points.add(new Point(i, ligne));
        }
        return points;
    }
    public long p1(long ligne) throws IOException{
        ArrayList<Point[]> couples = init();
        //abscisses
        Set<Long> hashtag = new HashSet<>(); 
        for (Point[] couple : couples){
            
            long milieuY = (couple)[0].getY();
            long dmMaxLosange = couple[0].distM(couple[1]);
            long sommetBasLosangeY = milieuY - dmMaxLosange;
            long sommetHautLosangeY = milieuY + dmMaxLosange;
            if(ligne >= sommetBasLosangeY && ligne<=sommetHautLosangeY && ligne!= (couple)[0].getY() ){
                long milieuX = (couple)[0].getX();
    
                long sommetBasLosangeX = milieuX ;
    
                long sommetHautLosangeX = milieuX;
    
                long sommetGaucheLosangeX =  milieuX - dmMaxLosange;
                long sommetGaucheLosangeY = milieuY;
    
                long sommetDroitLosangeX =  milieuX + dmMaxLosange;
                long sommetDroitLosangeY = milieuY;
                Point gauche = new Point (sommetGaucheLosangeX,sommetGaucheLosangeY);
                Point haut =    new Point (sommetHautLosangeX,sommetHautLosangeY);
                Point bas = new Point (sommetBasLosangeX,sommetBasLosangeY);
                Point droit = new Point (sommetDroitLosangeX,sommetDroitLosangeY);

                if(ligne>milieuY){
                    long x1 = gauche.intersectionX(haut,ligne);
                    long x2 = haut.intersectionX(droit,ligne);
                    for (long i = x1 ; i<=x2;i++){
                        hashtag.add(i);
                    }
                }

                else{
                    long x1 = gauche.intersectionX(bas,ligne);
                    long x2 = bas.intersectionX(droit,ligne);
                    for (long i = x1 ; i<=x2;i++){
                        hashtag.add(i);
                    }

                }
            }
         
        }
   
return hashtag.size()-1;
    }
}



