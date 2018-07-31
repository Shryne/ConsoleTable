package table;

import table.output.Media;

import java.util.Objects;

/**
 * This class is used to create a table.<br>
 * The result looks like:
 * <p>
 * topAndLeftHeadline | headline | headLine | topAndRightHeadline<br>
 * --------------------------------------------------------------<br>
 * leftHeadline       | content  | content  | rightHeadline<br>
 * --------------------------------------------------------------<br>
 * leftAndBottomHead..| bottom   | bottom   | rightAndBottomHead.<br>
 * </p>
 * Note that the settings for the width and alignment of the tables
 * input is done inside the other classes, like {@link table.container.ContentArea}
 * and {@link table.container.Headline}.
 * <p>This class is immutable and thread-safe.</p>
 */
public final class Table {
    private final Cells cells;

    /**
     * Primary constructor.
     * @param cells of the table.
     */
    public Table(Cells cells) {
        this.cells = Objects.requireNonNull(cells);
    }

    public void printTo(Media media) {

    }
}
