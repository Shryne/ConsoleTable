package table.output;

/**
 * The interface for an output target for the table.
 */
@FunctionalInterface
public interface Media {
    /**
     * Prints the given string to the media.
     * @param text to be printed.
     */
    void print(String text);
}
