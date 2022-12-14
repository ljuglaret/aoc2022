/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package j11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class AppTest {
    ArrayList<ArrayList<Integer>> items = new ArrayList<>();
    ArrayList<Monkey> monkeys = new ArrayList<>();
 J11 j11 = new J11();
    @BeforeEach
     void f() throws IOException{
       
        monkeys.addAll(j11.init("src/test/resources/test.txt"));
     }
    @Test void afterOneRound() throws IOException {
      
        for (Monkey m : j11.p1(monkeys,1)){
            items.add(m.getItems());
        }
        ArrayList<ArrayList<Integer>> exceptedItems = new ArrayList<>();

        exceptedItems.add(new ArrayList<>(Arrays.asList(20, 23, 27, 26)));
        exceptedItems.add(new ArrayList<>(Arrays.asList(2080, 25, 167, 207, 401, 1046)));
        exceptedItems.add(new ArrayList<>());
        exceptedItems.add(new ArrayList<>());

        ArrayList<Integer> exceptedCountItems = new ArrayList<>();
        exceptedCountItems.add(4);
        exceptedCountItems.add(6);
        exceptedCountItems.add(0);
        exceptedCountItems.add(4);

        int i = 0 ;
        for(ArrayList<Integer> l :items){
            assertEquals(exceptedItems.get(i),l);
            i++;
        }
      
    }

    @Test void after20Round() throws IOException {
        
        for (Monkey m : j11.p1(monkeys,20)){
            items.add(m.getItems());
        }
        ArrayList<ArrayList<Integer>> exceptedItems = new ArrayList<>();

        exceptedItems.add(new ArrayList<>(Arrays.asList(10, 12, 14, 26, 34)));
        exceptedItems.add(new ArrayList<>(Arrays.asList(245, 93, 53, 199, 115)));
        exceptedItems.add(new ArrayList<>());
        exceptedItems.add(new ArrayList<>());
        int i = 0 ;
        for(ArrayList<Integer> l :items){
            assertEquals(exceptedItems.get(i),l);
            i++;
        }
      
    }
}
