package j1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
public class J1 {
    public  int p1( String fileName) throws IOException{
    
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            int somme = 0;
            int sommeMax = 0 ;
            while((line = br.readLine()) != null){
                if(line.isEmpty()){
                    if (somme > sommeMax){
                        sommeMax = somme;
                    }
                    somme = 0;
                } 
                else{
                    somme +=Integer.parseInt(line);
                }
        }
        return sommeMax;

    }
}
public  int p2( String fileName) throws IOException{
    
    File file = new File(fileName);
    FileReader fr = new FileReader(file);
    
    ArrayList<Integer> l = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(fr)) {
        String line;
        int somme = 0;
        while((line = br.readLine()) != null){
            if(line.isEmpty()){
               l.add(somme);
               somme = 0;
            } 
            else{
                somme +=Integer.parseInt(line);
            }
    }
    Collections.sort(l, Collections.reverseOrder());
   
    return l.get(0)+l.get(1)+l.get(2);

}}
}
