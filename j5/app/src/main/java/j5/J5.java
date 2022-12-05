package j5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
public class J5 {


    public ArrayList<Stack<String>>  initTest (){
        ArrayList<Stack<String>> l = new ArrayList<Stack<String>>();
        Stack<String> s1 = new Stack<String> ();
        Stack<String> s2 = new Stack<String> ();
        Stack<String> s3 = new Stack<String> ();
        s1.addAll(new ArrayList<>(Arrays.asList(("Z N").split(" "))));
        s2.addAll(new ArrayList<>(Arrays.asList(("M C D").split(" "))));
        s3.addAll(new ArrayList<>(Arrays.asList(("P").split(" "))));
        l.addAll(new ArrayList<>(Arrays.asList(s1,s2,s3)));
        return l;

    }
    

    public ArrayList<Stack<String>>  init (){
        ArrayList<Stack<String>> l = new ArrayList<Stack<String>>();
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

        l.addAll(new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9)));

        return l;

    }
    
    public  String j5P1(ArrayList<Stack<String>> l,String fileName) throws IOException {
       
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
            String res = "";
            for (int i = 0 ; i < l.size() ; i++){
                res+=l.get(i).peek();
                System.out.println(l.get(i).peek());
            }
            return res;
    }

    public  String j5P2(ArrayList<Stack<String>> l,String fileName) throws IOException {

        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while((line = br.readLine()) != null){
                int[]t = new int[3];
                t[0] = Integer.parseInt(line.split(" ")[1]);
                t[1] = Integer.parseInt(line.split(" ")[3]);
                t[2] = Integer.parseInt(line.split(" ")[5]);
                ArrayList<String>temp = new ArrayList<>();
               
                for (int i = 0 ; i < t[0];i++){
                    temp.add( l.get(t[1]-1).pop());
                }
                for (int i = t[0] - 1 ; i >=0 ;i--){
                    l.get(t[2]-1).push( temp.get(i));
                }
               
            }
            }
            String res = "";
            for (int i = 0 ; i < l.size() ; i++){
                res+=l.get(i).peek();
                System.out.println(l.get(i).peek());
            }
            return res;
    }
}
