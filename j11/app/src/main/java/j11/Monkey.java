package j11;
/*
 * Monkey 0:
  Starting items: 79, 98
  Operation: new = old * 19
  Test: divisible by 23
    If true: throw to monkey 2
    If false: throw to monkey 3
 */

import java.util.ArrayList;

public class Monkey {
    private ArrayList<Integer>items = new ArrayList<>();
    private String operation;
    private int testDivisibleBy;
    private int monkeyTrue;
    private int monkeyFalse;

    public Monkey(ArrayList<Integer>items ,String operation,int testDivisibleBy,int monkeyTrue, int monkeyFalse){
      this.items.addAll(items);
      this.operation=operation;
      this.testDivisibleBy = testDivisibleBy;
      this.monkeyTrue = monkeyTrue;
      this.monkeyFalse = monkeyFalse;
    }

    public ArrayList<Integer> getItems() {
        return this.items;
    }
    public int getMonkeyFalse() {
        return monkeyFalse;
    }
    public int getMonkeyTrue() {
        return monkeyTrue;
    }
    public String getOperation() {
        return operation;
    }
    public int getTestDivisibleBy() {
        return testDivisibleBy;
    }

    public boolean okTest(int x){
      return x%getTestDivisibleBy()==0;
    }
    public int removeItemFromMonkey(int item){
      
      for (int i = 0 ; i < items.size() ; i++){
        if (items.get(i) == item){
         return this.items.remove(i);
        }
      }
     return -1;
    }

    public void addItemToMonkey(int item){
      this.items.add(items.size(),item);
    }

    //old * 19
    public int setWorriedLevel(int old){
    
      String op = this.operation.replaceAll("[^0-9]","");
      int v = 0 ;
     
      if (op.isEmpty()){
        v = old;
      
      }
      else{
        v = Integer.valueOf(op);
       
      }
    
      if (operation.contains("*")){
        return old*v;
      }
      else if (operation.contains("+")){
        return old+v;
      }
      else if (operation.contains("-")){
        return old-v;
      }
      //(operation.contains("/"))
      else {
        return old/v;
      }
      
    
    }

   
    public String toString (){
      String str = items.toString()+ " \n"+ operation + "\n" +testDivisibleBy + "\n" + monkeyTrue + "\n"+monkeyFalse;
      return str;
    }
}
