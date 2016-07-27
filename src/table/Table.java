package table;

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

    private Table() {
        
    }
}
