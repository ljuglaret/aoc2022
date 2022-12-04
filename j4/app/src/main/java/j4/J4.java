package j4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class J4 {
    
    public boolean parseJ42022(String str) {
        boolean contient = false;
        int j1G = Integer.parseInt(str.split(",")[0].split("-")[0]);
        int j1D = Integer.parseInt(str.split(",")[0].split("-")[1]);
        int j2G = Integer.parseInt(str.split(",")[1].split("-")[0]);
        int j2D = Integer.parseInt(str.split(",")[1].split("-")[1]);
        if((j1G>=j2G && j1D <= j2D)||
                (j2G>=j1G && j2D <= j1D)) {
            contient = true;
        }
        return contient;
    }

    public boolean parseJ42022P2(String str) {
        boolean contient = false;
        int j1G = Integer.parseInt(str.split(",")[0].split("-")[0]);
        int j1D = Integer.parseInt(str.split(",")[0].split("-")[1]);
        int j2G = Integer.parseInt(str.split(",")[1].split("-")[0]);
        int j2D = Integer.parseInt(str.split(",")[1].split("-")[1]);
        if(! (
                (j1G<j2G && j1D < j2D && j2G>j1D)||
                (j2G<j1G && j2D < j1D && j1G>j2D)
            )
        ) {
            contient = true;
        }
        return contient;
    }
    
    public  int j4P1(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        int cpt = 0;    
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while((line = br.readLine()) != null){
                System.out.println(parseJ42022(line));
                if(parseJ42022(line)) {
                    cpt++;
                }
            }
            }
        return cpt;
    }
    public  int j4P2(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        int cpt = 0;    
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while((line = br.readLine()) != null){
                System.out.println(parseJ42022P2(line));
                if(parseJ42022P2(line)) {
                    cpt++;
                }
            }
            }
        return cpt;
    }
}
