package j5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
public class J5 {
    
    public  void j5P1(String fileName) throws IOException {
        Stack<String> s1 = new Stack<String> ();
        Stack<String> s2 = new Stack<String> ();
        Stack<String> s3 = new Stack<String> ();


        Stack<String> s4 = new Stack<String> ();
        Stack<String> s5 = new Stack<String> ();
        Stack<String> s6 = new Stack<String> ();

        Stack<String> s7 = new Stack<String> ();
        Stack<String> s8 = new Stack<String> ();
        Stack<String> s9 = new Stack<String> ();

        s1.addAll(new ArrayList<>(Arrays.asList(("B G S C").split(" "))));
        s2.addAll(new ArrayList<>(Arrays.asList(("T M W H J N V G").split(" "))));
        s3.addAll(new ArrayList<>(Arrays.asList(("M Q S").split(" "))));

        s4.addAll(new ArrayList<>(Arrays.asList(("B S L T W N M").split(" "))));
        s5.addAll(new ArrayList<>(Arrays.asList(("J Z F T V G W P").split(" "))));
        s6.addAll(new ArrayList<>(Arrays.asList(("C T B G Q H S").split(" "))));

        s7.addAll(new ArrayList<>(Arrays.asList(("T J P B W").split(" "))));
        s8.addAll(new ArrayList<>(Arrays.asList(("G D C Z F T Q M").split(" "))));
        s9.addAll(new ArrayList<>(Arrays.asList(("N S H B P F").split(" "))));
      ArrayList<Stack<String>> l = new ArrayList<Stack<String>>();
      l.addAll(new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9)));
      
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while((line = br.readLine()) != null){
                int[]t = new int[3];
                t[0] = Integer.parseInt(line.split(" ")[1]);
                t[1] = Integer.parseInt(line.split(" ")[3]);
                t[2] = Integer.parseInt(line.split(" ")[5]);
                for (int i = 0 ; i < t[0];i++){
                    l.get(t[2]-1).push( l.get(t[1]-1).pop());
                }
            }
            }
            for (int i = 0 ; i < 9 ; i++){
                System.out.println(l.get(i).peek());
            }
    }
}
