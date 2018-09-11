package table.num;

import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaxTest {
    public void emptyNotCalled() {
        new Max<>(List.of(), Object::hashCode);
    }

    @Test(expected = NoSuchElementException.class)
    public void empty() {
        new Max<>(List.of(), Object::hashCode).intValue();
    }

    @Test
    public void one() {
        assertThat(
                new Max<>(
                        List.of("HA"),
                        String::length
                ).longValue(),
                equalTo(2L)
        );
    }

    @Test
    public void two() {
        assertThat(
                new Max<>(
                        List.of("A", "BCD"),
                        String::length
                ).intValue(),
                equalTo(3)
        );
    }

    @Test
    public void multiple() {
        assertThat(
                new Max<>(
                        List.of("123", "2", "94", "123456", "43453"),
                        String::length
                ).longValue(),
                equalTo(6L)
        );
    }
}
