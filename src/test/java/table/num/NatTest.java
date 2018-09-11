package table.num;

import org.junit.Test;
import table.num.Nat;

/*
 * The tests aim to check whether the exception is thrown or not, but not whether the number is correctly stored,
 * because the logic for that is quite easy.
 */
public class NatTest {
    @Test
    public void zero() {
        new Nat(0);
    }

    @Test
    public void overZero() {
        new Nat(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative() {
        new Nat(-1);
    }
}
