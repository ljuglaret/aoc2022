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

    public ArrayList<String> parse (String fileName)throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        ArrayList<String> l = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while((line = br.readLine()) != null){
                l.add(line);
                
               }
            
        }
        return l;
    }

    public void p2(String fileName) throws IOException{
        int posCpr = 0;
        ArrayList<String> deplacements = parse(fileName);
        String str = "";
        int dernierElement = 1;
      
        for (int i = 0 ; i < deplacements.size() ;i++ ){
            String line = deplacements.get(i);
            if(line.contains("noop")){
                 if(posCpr == dernierElement - 1|| posCpr == dernierElement || posCpr == dernierElement + 1){
                    str+="#";
                }
                else{
                   str+=".";
                }
               
                if ( posCpr <=38){posCpr++;}
              else{posCpr = 0;}
            }
               if(line.contains("addx")) {
    
               System.out.println(posCpr+"-"+dernierElement);
               if(posCpr == dernierElement - 1|| posCpr == dernierElement || posCpr == dernierElement + 1){
                  str+="#";
              }
              else{
                 str+=".";
              }
              if ( posCpr <=38){posCpr++;}
              else{posCpr = 0;}

              if(posCpr == dernierElement - 1|| posCpr == dernierElement || posCpr == dernierElement + 1){
                str+="#";
            }
            else{
               str+=".";
            }
            if ( posCpr <=38){posCpr++;}
            else{posCpr = 0;}

                 dernierElement +=Integer.valueOf(line.split(" ")[1]);
              
               }
            }


            for (int i = 0 ; i<str.length()-40 ; i+=40){
                System.out.println(str.substring(i,i+40));          
            }
    }
}
