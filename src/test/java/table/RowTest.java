package table;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RowTest {
    @Test
    public void printsEmpty() {
        final var media = new FakeMedia();
        new Row('|').printTo(media);
        assertThat(media.content(), equalTo(""));
    }

    @Test
    public void printsOne() {
        final var media = new FakeMedia();
        new Row('|', "Hallo").printTo(media);
        assertThat(media.content(), equalTo("|Hallo|"));
    }

    @Test
    public void printTwo() {
        final var media = new FakeMedia();
        new Row('|', "1", "2").printTo(media);
        assertThat(media.content(), equalTo("|1|2|"));
    }

    @Test
    public void printMultiple() {
        final var media = new FakeMedia();
        new Row('|', "1", "2", "3", "4", "5").printTo(media);
        assertThat(media.content(), equalTo("|1|2|3|4|5|"));
    }
}
