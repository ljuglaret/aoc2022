package j11;

import java.util.*;
import java.io.*;

public class J11 {
    /*
     * Monkey 0:
     * Starting items: 79, 98
     * Operation: new = old * 19
     * Test: divisible by 23
     * If true: throw to monkey 2
     * If false: throw to monkey 3
     */
    /*
     * public Monkey(
     * ArrayList<Long>items ,
     * String operation,
     * int testDivisibleBy,
     * int monkeyTrue,
     * int monkeyFalse
     * )
     */
    //

    public ArrayList<Long> parseItems(String line) {

        int cpt = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ',') {
                cpt++;
            }
        }
        ArrayList<Long> l = new ArrayList<>();
        for (int i = 0; i <= cpt; i++) {
            l.add(Long.valueOf(line.split(": ")[1].split(",")[i].replace(" ", "")));
        }

        return l;
    }

    public ArrayList<Monkey> init(String filePath) throws IOException {
        ArrayList<Monkey> l = new ArrayList<>();
        File file = new File(filePath);
        FileReader fr = new FileReader(file);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            String op = "";
            int testDivisibleBy = 0;
            int monkeyTrue = 0;
            int monkeyFalse = 0;
            Stack<Long> items = new Stack<>();
            while ((line = br.readLine()) != null) {

                if (line.contains("items")) {
                    items.clear();
                    items.addAll(parseItems(line));
                }
                // Operation: new = old * 19
                else if (line.contains("Operation")) {
                    op = line.split(" = ")[1];
                }
                // Test: divisible by 23
                else if (line.contains("Test")) {
                    testDivisibleBy = Integer.valueOf(line.replaceAll("[^0-9]", ""));

                }
                // If true: throw to monkey 2
                else if (line.contains("If true")) {
                    monkeyTrue = Integer.valueOf(line.replaceAll("[^0-9]", ""));
                }
                // If false: throw to monkey 3
                else if (line.contains("If false")) {
                    monkeyFalse = Integer.valueOf(line.replaceAll("[^0-9]", ""));
                } else if (!line.contains("Monkey")) {

                    Monkey currentMonkey = new Monkey(items, op, testDivisibleBy, monkeyTrue, monkeyFalse);
                    l.add(currentMonkey);
                }
            }
        }
        return l;
    }

    /*
     * Monkey 0 inspected items 101 times.
     * Monkey 1 inspected items 95 times.
     * Monkey 2 inspected items 7 times.
     * Monkey 3 inspected items 105 times.
     */

    public ArrayList<Monkey> p1(ArrayList<Monkey> l0, int round) {
        long[] inspect = new long[l0.size()];
        List<Long> list = new ArrayList<>();

        for (int i = 0; i < round; i++) {

            for (int m = 0; m < l0.size(); m++) {
                // System.out.println(l0.get(m).getItems());

                Monkey currentMonkey = l0.get(m);

                while (l0.get(m).getItems().size() != 0) {
                    inspect[m]++;
                    long x = currentMonkey.getItems().pop();
                    long newValue = (long) Math.floor(currentMonkey.setWorriedLevel(x) / 3);
                    if ((int) newValue % currentMonkey.getTestDivisibleBy() == 0) {
                        l0.get(currentMonkey.getMonkeyTrue()).getItems().push(newValue);

                    } else {
                        l0.get(currentMonkey.getMonkeyFalse()).getItems().push(newValue);

                    }
                }

                // System.out.print(i +" -");

                for (int p = 0; p < inspect.length; p++) {

                    list.add(inspect[p]);
                }
                Collections.sort(list);
                Collections.reverse(list);
                // System.out.print(list + ":"+ list.get(0)*list.get(1) + " ");
                // System.out.println(m);

            }

            // System.out.println();
        }
        System.out.println(list.get(0) * list.get(1) + " ");

        return l0;

    }
}
