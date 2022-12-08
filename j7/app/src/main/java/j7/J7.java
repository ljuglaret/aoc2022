package j7;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class J7 {

public boolean isCdRetour(String str){
    return str.equals("$ cd ..");
}

public boolean isCdAvance(String str){
    return str.contains("$ cd" ) && !str.contains("..");
}

public boolean isFile(String str){
    return str.split(" ")[0].chars().allMatch( Character::isDigit );
}

//dir e
public boolean isDirectory(String str){
    return str.substring(0, 3).equals("dir");
}

    public   List<String> lecture(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
           List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while((line = br.readLine()) != null){
                lines.add(line);
            }
            }
            return lines;
    }

   
    public int sum (Map<String,Integer> hm){
        int s = 0;
        for (Map.Entry<String,Integer> mapentry : hm.entrySet()) {
            s+=mapentry.getValue();
           
            }
        return s;
    }
    public int p1(List<String> lines){
        int cpt = 0 ;
        Map<String,Map<String,Integer>> commands = new HashMap<>();
        Stack<String> lastDirectories = new Stack<>();
        Map<String,Integer> repoSize = new HashMap<>();
        for (String l : lines){
           

            //$ cd e
            if(isCdAvance(l)){
                String name = l.split(" ")[2];
                lastDirectories.add(name);
                repoSize.put(name,0);
            }
            else if (isCdRetour(l)){
                lastDirectories.pop();
               

            }
            else if (isFile(l)){
                //5626152 d.ext
                Map<String,Integer> temp =  commands.get(lastDirectories.peek());
                String name = l.split(" ")[1];
                int value = Integer.parseInt(l.split(" ")[0]);
             

                if (temp!=null){
                    temp.put(name,value);
                    commands.put(lastDirectories.peek(),temp );
                    repoSize.put(lastDirectories.peek(),sum(temp));
                 

                }
                else {
                    Map<String,Integer> temp2 =  new HashMap<>();
                    temp2.put(name,value);
                    commands.put(lastDirectories.peek(),temp2 );
                    repoSize.put(lastDirectories.peek(),value);
                }
             
            }
        else if (isDirectory(l)){
            Map<String,Integer> temp =  commands.get(lastDirectories.peek());
            String name = l.split(" ")[1];
            if (temp!=null){
               
                temp.put(name,0);
                commands.put(lastDirectories.peek(),temp );

            }
            else {

                Map<String,Integer> temp2 =  new HashMap<>();
                temp2.put(name,0);
                commands.put(lastDirectories.peek(),temp2 );

            }
            
        }
        
        }

        System.out.println(commands);
        System.out.println(repoSize);
               
        return cpt;
    }

    
}
/**
 {a={f=29116, g=2557, h.lst=62596},
  d={d.ext=5626152, j=4060174, k=7214296, d.log=8033020},
   e={i=584}, 
 /={c.dat=8504156, b.txt=14848514}}  
 */