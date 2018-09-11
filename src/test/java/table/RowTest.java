package table;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RowTest {
    @Test
    public void printsEmpty() {
        final var media = new FakeMedia();
        new Row('|').printTo(media);
        assertEquals("", media.content());
    }

    @Test
    public void printsOne() {
        final var media = new FakeMedia();
        new Row('|', "Hallo").printTo(media);
        assertEquals("| Hallo |", media.content());
    }

    @Test
    public void printTwo() {
        // TODO: Implement it
    }

    @Test
    public void printMultiple() {
        // TODO: Implement it
    }
}
