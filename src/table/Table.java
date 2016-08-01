package table;

import table.container.ContentArea;
import table.container.Headline;
import static table.container.Headline.headline;
import static table.container.ContentArea.contentArea;

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
        String headlineString =
                (alignment.isAligned() ? headline(headline, alignment) : headline).toString();

        String contentAreaString =
                (contentArea.isAligned() ? contentArea(contentArea, alignment) : contentArea).toString();

        tableText = headlineString + "\n" + headlineRow(headlineString.length()) + "\n" + contentAreaString;
    }

    public static Table table(Alignment alignment, Headline headline, ContentArea contentArea) {
        return new Table(alignment, headline, contentArea);
    }

    public static Table table(Headline headline, ContentArea contentArea) {
        return new Table(Alignment.DEFAULT, headline, contentArea);
    }


    @Override
    public String toString() {
        return tableText;
    }
    // ####################################################
    // private helper
    // ####################################################
    private static String headlineRow(int width) {
        return timesString(HEADLINE_DELIMITER, width);
    }

    /**
     * Similar {@link Alignment}, unfortunately...
     *
     * A helper method to multiply the given String.
     * @param n amount of repetition of the String.
     * @return String * n.
     */
    private static String timesString(String string, int n) {
        StringBuilder result = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            result.append(string);
        }
        return result.toString();
    }
}
