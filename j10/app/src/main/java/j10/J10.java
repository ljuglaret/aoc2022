package j10;

import java.io.IOException;
import java.util.*;
import java.io.*;

public class J10 {
    public ArrayList<Integer> lecture (String fileName)throws IOException {
       
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        ArrayList<Integer> l = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
             int dernierElement = 1;
             l.add(1);
            while((line = br.readLine()) != null){
               
            if(line.contains("noop")){
                l.add(dernierElement);
            }
               if(line.contains("addx")) {
                l.add(Integer.valueOf(dernierElement));
                l.add(Integer.valueOf(dernierElement));

                //l.add(l.get(l.size()-1));
                dernierElement = (l.get(l.size()-1))+Integer.valueOf(line.split(" ")[1]);
                
               }
            }
            l.add(dernierElement);

        }
        return l;
    }
    public int p1(ArrayList<Integer> l){
        int cpt = 0 ;
        //20 - 60 - 100 - 140
        for (int i =20 ; i < l.size() ; i+=39){
                

            cpt+= i * l.get(i);
            i++;
       }
        return cpt;
    }
}
