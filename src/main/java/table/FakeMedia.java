package table;

import table.output.Media;

import java.util.function.Consumer;

/**
 * A media for text purposes. Takes the text to print and offers a way to check if it's right.
 * <p>This class is mutable and not thread-safe.</p>
 */
public final class FakeMedia implements Media {
    private final StringBuilder content;

    /**
     * Constructs the FakeMedia without any content to start with.
     */
    public FakeMedia() {
        this(new StringBuilder());
    }

    /**
     * @param startContent The initial content of the FakeMedia.
     */
    public FakeMedia(String startContent) {
        this(
                new StringBuilder(startContent)
        );
    }

    /**
     * @param startContent The initial content of the FakeMedia.
     */
    public FakeMedia(StringBuilder startContent) {
        content = startContent;
    }

    /**
     * FakeMedia will store the text to be printed to return the result with {@link FakeMedia#content()}. This
     * will mutate the state of FakeMedia.
     */
    @Override
    public void print(String text) {
        content.append(text);
    }

    // TODO: Find a better solution for this or create an interface for it.
    public String content() {
        return content.toString();
    }
}
