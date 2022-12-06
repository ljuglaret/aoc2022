package j6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class J6 {

    public  String lecture(String fileName) throws IOException {
        String str="";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
           
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while((line = br.readLine()) != null){
                str+=line;
            }
            }
        return str;
    }
    public  boolean toutDifferent(String str){
        for(int i = 0 ; i<  str.length() - 1;i++){
      for (int j = i + 1 ; j < str.length();j++){
        if(str.charAt(i) == str.charAt(j)){
         return false;
        }
      }
    }
    return true;
  }
  public  int p1(String str,int lg){
    int i = 0 ;
    boolean trouve = false;
    while(!trouve){
      String sschaine = str.substring(i,i+lg);
      if(!toutDifferent(sschaine)){
        i++;

      }
      else{
        trouve = true;
      }
    }
    return i+lg;
  }
    
}
