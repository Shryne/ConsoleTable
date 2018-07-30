package sample;

import table.Table;

/**
 * Sample code to create this table:<br>
 *  name  | age
 * -------------
 *  Steve | 32
 */
public final class TwoXTwo {
    public static void main(String[] args) {
        new Table(
                "name", "age", "Steve", 32
        ).printTo(System.out::println);
    }
}
