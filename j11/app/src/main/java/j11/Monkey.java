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
import java.util.Stack;

public class Monkey {
  private Stack<Long> items = new Stack<>();
  private String operation;
  private int testDivisibleBy;
  private int monkeyTrue;
  private int monkeyFalse;

  public Monkey(Stack<Long> items, String operation, int testDivisibleBy, int monkeyTrue, int monkeyFalse) {
    this.items.addAll(items);
    this.operation = operation;
    this.testDivisibleBy = testDivisibleBy;
    this.monkeyTrue = monkeyTrue;
    this.monkeyFalse = monkeyFalse;
  }

  public Stack<Long> getItems() {
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

  public boolean okTest(int x) {
    return x % getTestDivisibleBy() == 0;
  }

  public long removeItemFromMonkey(long item) {

    for (int i = 0; i < items.size(); i++) {
      if (items.get(i) == item) {
        return this.items.remove(i);
      }
    }
    return -1;
  }

  public void addItemToMonkey(long item) {
    this.items.push(item);
  }

  // old * 19
  public long setWorriedLevel(long old) {

    String op = this.operation.replaceAll("[^0-9]", "");
    long v = 0;

    if (op.isEmpty()) {
      v = old;

    } else {
      v = Integer.valueOf(op);

    }

    if (operation.contains("*")) {

      return old * v;
    } else if (operation.contains("+")) {

      return old + v;
    } else if (operation.contains("-")) {
      return old - v;
    }
    // (operation.contains("/"))
    else if (operation.contains("/")) {
      return old / v;
    }

    return 0;

  }

  public String toString() {
    String str = items.toString() + " \n" + operation + "\n" + testDivisibleBy + "\n" + monkeyTrue + "\n" + monkeyFalse;
    return str;
  }
}