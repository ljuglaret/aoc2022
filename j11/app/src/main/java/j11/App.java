/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package j11;

import java.io.IOException;
import java.util.ArrayList;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    
//2 4 3 1 
//+ 4 6 0 4
    public static void main(String[] args) throws IOException {
        J11 j11 = new J11();
    ArrayList<Monkey>monkeys = new ArrayList<>();
  monkeys = j11.init("src/main/resources/j11.txt");
 //monkeys = (j11.init("src/test/resources/test.txt"));
  j11.p1(monkeys, 20);
   
    
    }
}
//111 547
//106 913
//108 851
//115 254
//102 714
//103 683
//323-298-331-318-55-314-25-337-342-298-331-333-57-314-25-337-
