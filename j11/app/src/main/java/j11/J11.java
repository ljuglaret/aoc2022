package j11;
import java.util.*;
import java.io.*;
public class J11 {
    /*
     * Monkey 0:
        Starting items: 79, 98
        Operation: new = old * 19
        Test: divisible by 23
            If true: throw to monkey 2
            If false: throw to monkey 3
     */
    /*
     * public Monkey(
     *      ArrayList<Integer>items ,
     *      String operation,
     *      int testDivisibleBy,
     *      int monkeyTrue,
     *      int monkeyFalse
     * )
     */
    //   

    public ArrayList<Integer> parseItems (String line){
       
       int cpt = 0 ;
        for (int i = 0 ; i < line.length() ; i++){
            if (line.charAt(i) ==','){
                cpt++;
            }
        }
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0 ; i <= cpt ; i++){
            l.add(Integer.valueOf(line.split(": ")[1].split(",")[i].replace(" ", "")));
        }
        
        
        return l;
    }

    public ArrayList<Monkey> init(String filePath)throws IOException{
        ArrayList<Monkey> l = new ArrayList<>();
        File file = new File(filePath);
        FileReader fr = new FileReader(file);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            String op ="";
            int testDivisibleBy = 0 ;
            int monkeyTrue = 0;
            int monkeyFalse = 0;
            ArrayList<Integer> items = new ArrayList<>();
            while((line = br.readLine()) != null){
               
              
                if(line.contains("items")){
                    items.clear();
                    items.addAll(parseItems(line));
                }
                //Operation: new = old * 19
                else if(line.contains("Operation")){
                    op = line.split(" = ")[1];
                }
                //Test: divisible by 23
                else if(line.contains("Test")){
                    testDivisibleBy = Integer.valueOf(line.replaceAll("[^0-9]", ""));
                    
                }
                //If true: throw to monkey 2
                else if(line.contains("If true")){
                    monkeyTrue = Integer.valueOf(line.replaceAll("[^0-9]", ""));
                }
                //If false: throw to monkey 3
                else if(line.contains("If false")){
                    monkeyFalse = Integer.valueOf(line.replaceAll("[^0-9]", ""));
                }
                else if(line.contains("$$")){
                  
                    Monkey currentMonkey = new Monkey(items,op,testDivisibleBy,monkeyTrue,monkeyFalse);
                    l.add(currentMonkey);
                }
            }
        }
        return l;
       }
    
    
    /*
     * Monkey 0 inspected items 101 times.
Monkey 1 inspected items 95 times.
Monkey 2 inspected items 7 times.
Monkey 3 inspected items 105 times.
     */
    
    public ArrayList<Monkey> p1( ArrayList<Monkey> l0, int round){
       int[] inspect = new int[l0.size()];

       for (int n = 0 ; n < l0.size() ; n++){
      inspect[n]=l0.get(n).getItems().size();
          
          
      }
       // ArrayList<Monkey> l1 = new ArrayList<>();
        //l1.addAll(l0); 
        
        for (int i = 0 ; i <round  ;i++){
           // System.out.print(inspect[0]+" ; "+inspect[1]+" ; "+inspect[2]+" ; "+inspect[3]+" ; "); 
            //System.out.println();
           
            for (int m =0 ; m < l0.size() ; m++){
                Monkey currentMonkey = l0.get(m);
               
                     
                ArrayList<Integer>items =currentMonkey.getItems();
                for (int k = 0 ; k < items.size() ; k++){
                   
                    int item = items.get(k);
                    int newValue = (currentMonkey.setWorriedLevel(item))/3;
                  
                    if(currentMonkey.okTest(newValue) ){
                        l0.get(currentMonkey.getMonkeyTrue()).addItemToMonkey(newValue);
                        inspect[currentMonkey.getMonkeyTrue()]++;
                        
                    }
                    else{
                        l0.get(currentMonkey.getMonkeyFalse()).addItemToMonkey(newValue);
                        inspect[currentMonkey.getMonkeyFalse()]++;
                        
                    }   
                   
                         
                }
             
           
                currentMonkey.getItems().removeAll(items);
            
            }
            for (int n = 0 ; n < l0.size() ; n++){
                System.out.print(inspect[n]+"-");
                 
             } 
            
             System.out.println();
        }
       
return l0;        
       
    }
}
