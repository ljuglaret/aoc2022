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

       for (int i = 0 ; i  < l0.size() ; i++){
       // inspect[i] = l0.get(i).getItems().size();
       }
       
        for (int i = 0 ; i <round  ;i++){
           
           

            for (int m =0 ; m < l0.size() ; m++){
                inspect[m]+=l0.get(m).getItems().size();
                Monkey currentMonkey = l0.get(m);
                    
                ArrayList<Integer>items =currentMonkey.getItems();
                Collections.reverse(items);
               // Collections.reverse(items);
               while(items.size()>0){
                   
                    int item = items.get(items.size()-1);
                    int newValue = (currentMonkey.setWorriedLevel(item))/3;
                    int idx = 0 ;
                    if((int)newValue % currentMonkey.getTestDivisibleBy() == 0 ){
                        idx = currentMonkey.getMonkeyTrue();
                       
                    }
                    else{
                        idx = currentMonkey.getMonkeyFalse();
                        
                    }   
                    l0.get(idx).addItemToMonkey(newValue);
                    
                    currentMonkey.getItems().remove(items.size()-1);
                   
                }
            
                System.out.print(i +" -"); List<Integer> list = new ArrayList<>();
                for (int p = 0 ; p< inspect.length ; p++){
                   
                    list.add(inspect[p]);
                }
                Collections.sort(list);
                Collections.reverse(list);
                System.out.print(list + ":"+ list.get(0)*list.get(1) + " ");
                 System.out.println(m);
              // currentMonkey.getItems().removeAll(items);
                
            }
           
           
            
            //System.out.println(l0.get(1).getItems());   
            // System.out.println();
        }
      
return l0;        
       
    }
}
