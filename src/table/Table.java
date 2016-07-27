package table;

import table.container.ContentArea;
import table.container.Headline;

/**
 * This class is used to create a table inside the console.
 * To do this one must simply print it with System.out.
 *
 * The result looks like:
 * <br>
 * topAndLeftHeadline | headline | headLine | topAndRightHeadline<br>
 * --------------------------------------------------------------<br>
 * leftHeadline       | content  | content  | rightHeadline<br>
 * --------------------------------------------------------------<br>
 * leftAndBottomHead..| bottom   | bottom   | rightAndBottomHead.<br>
 *
 * Note that the settings for the width and alignment of the tables
 * input is done inside the other classes, like {@link table.container.ContentArea}
 * and {@link table.container.Headline}.
 */
public final class Table {
    public static final String COLUMN_DELIMITER = "|";
    private static final String HEADLINE_DELIMITER = "+";

    private final String tableText;

    private Table(Alignment alignment, Headline headline, ContentArea contentArea) {
        Headline alignedHeadline = alignment.isAligned() ? headline(headline, alignment) : headline;
        ContentArea alignedContentArea = contentArea.isAligned() ? contentArea(contentArea, alignment) : contentArea;

        
    }

    public static Table table(Alignment alignment, Headline headline, ContentArea contentArea) {
        return new Table(alignment, headline, contentArea);
    }

    public static Table table(Headline headline, ContentArea contentArea) {
        return table(Alignment.DEFAULT, headline, contentArea);
    }
}
