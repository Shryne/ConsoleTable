package table;

import table.output.Media;

/**
 *
 */
public final class Table {
    private final Border border;
    private final Content content;

    public Table(Content content) {
        this(
                new Border(),
                content
        );
    }

    /**
     * Primary constructor.
     */
    // TODO: Content should've methods, that are important for Table
    public Table(Border border, Content content) {
        this.border = border;
        this.content = content;
    }

    public void printTo(Media media) {
        media.print(
                String.join(
                        border.top(content.width()), "\n",
                        content.toString(),
                        border.bottom(content.width()), "\n"
                )
        );
    }
}
