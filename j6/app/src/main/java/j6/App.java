/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package j6;

import java.io.IOException;

public class App {
   

    public static void main(String[] args) throws IOException {
        J6 j6 = new J6();
        System.out.println(j6.p1(j6.lecture("src/main/resources/j6.txt")));
    }
}