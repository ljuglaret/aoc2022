package j8;
import java.io.*;
import java.util.*;


public class J8 {

    public List<Integer> parse (String s){
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0 ; i < s.length() ; i++){
            l.add(Integer.valueOf(s.charAt(i)));
        }
        return l;
    }
   public  ArrayList<List<Integer>> lecture(String cheminFichier) throws IOException{
    ArrayList<List<Integer>> l = new ArrayList<>();
    File file = new File(cheminFichier);
    FileReader fr = new FileReader(file);
    try (BufferedReader br = new BufferedReader(fr)) {
        String line;
        while((line = br.readLine()) != null){
            l.add(parse(line));
        }
    }
    return l;
   }


   public boolean estCache(int x , List<Integer> voisins){
    for (int e : voisins){
        if(e>=x){
            return true;
        }
    }
    return false;
   }

   public List<Integer> voisinsGauche(int i,int j, ArrayList<List<Integer>> l){
    List<Integer> vg = new ArrayList<>();
    for(int j1 = 0 ; j1<j ;j1++ ){
        vg.add(l.get(i).get(j1));
    }
    return vg;
   }
    
   public List<Integer> voisinsDroite(int i,int j, ArrayList<List<Integer>> l){
    List<Integer> vd = new ArrayList<>();
    for(int j1 = j+1 ; j1<l.get(i).size();j1++ ){
        vd.add(l.get(i).get(j1));
    }
    return vd;
   }

   public List<Integer> voisinsHaut(int i,int j, ArrayList<List<Integer>> l){
    List<Integer> vh = new ArrayList<>();
    for(int i1 = 0 ; i1<i;i1++ ){
        vh.add(l.get(i1).get(j));
    }
    return vh;
   }

   public List<Integer> voisinsBas(int i,int j, ArrayList<List<Integer>> l){
    List<Integer> vb = new ArrayList<>();
    for(int i1 = i+1 ; i1<l.size();i1++ ){
        vb.add(l.get(i1).get(j));
    }
    return vb;
   }

   public int compteEltBords(ArrayList<List<Integer>> l){
    int cpt = 2*((l.size()-2) + l.get(0).size() );
    return cpt;
   }

   public int p1(ArrayList<List<Integer>> l){
    int cpt = 0 ;
    for(int i = 1 ; i < l.size() - 1; i ++){
        for(int j = 1 ; j<l.get(i).size() - 1 ; j++){
            int x = l.get(i).get(j);
            if(
                !estCache(x, voisinsGauche(i,j,l))
            || !estCache(x, voisinsDroite(i,j,l))
            || !estCache(x, voisinsHaut(i,j,l))
            || !estCache(x, voisinsBas(i,j,l))
            ){
                cpt++;
            }
        }
    }
    return cpt + compteEltBords(l);
   }

}
