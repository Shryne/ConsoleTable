package table;

/**
 * Alignment for the text inside a cell/row/...
 */
public enum Alignment {
    CENTER((len, width) -> timesSpaces((width - len) / 2)),
    LEFT((len, width) -> " "),
    RIGHT((len, width) -> timesSpaces(width - len)),
    DEFAULT((len, width) -> LEFT.align(len, width));

    private final AlignmentCalculation alignmentCalculation;

    Alignment(AlignmentCalculation alignmentCalculation) {
        this.alignmentCalculation = alignmentCalculation;
    }

    /**
     * Used to align a text inside a cell.
     * @param length The length of the string to be aligned.
     * @param width The width of the cell to be aligned on.
     * @return A certain amount of spaces to align the text
     * based on the enum.
     */
    public String align(int length, int width) {
        return alignmentCalculation.apply(length, width);
    }

    /**
     * A helper method to create the alignment. A cell has a text and
     * an alignment and to actually align the text based on the length
     * and the width of the cell spaces are used.
     * @param n amount of spaces.
     * @return String with n spaces.
     */
    private static String timesSpaces(int n) {
        StringBuilder result = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            result.append(" ");
        }
        return result.toString();
    }
}

/**
 * This interface is needed to create a lambda expression
 * for the enum {@link table.Alignment} to calculate
 * the actual position of the text for the cells.
 */
@FunctionalInterface
interface AlignmentCalculation {
    String apply(int stringLength, int cellWidth);
}