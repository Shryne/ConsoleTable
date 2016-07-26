package table.data;

import table.Alignment;

/**
 * Created by Seven on 21.07.2016.
 */
public final class Cell {
    // ####################################################
    // vars
    // ####################################################
    private final String formattedText;
    private final String text;
    private final int minWidth;
    private final Alignment alignment;

    // ####################################################
    // methods
    // ####################################################
    private Cell(String text, int minWidth, Alignment alignment) {
        this.alignment = alignment;
        this.minWidth = minWidth;
        this.text = text;
        this.formattedText = String.format(
                "%-" + minWidth + "s", alignment.align(text.length(), minWidth) + text
        );
    }

    public static Cell cell(String text, int minWidth, Alignment alignment) {
        return new Cell(text, minWidth, alignment);
    }

    public static Cell cell(String text, Alignment alignment) {
        return cell(text, text.length(), alignment);
    }

    public static Cell cell(String text, int minWidth) {
        return cell(text, minWidth, Alignment.DEFAULT);
    }

    public static Cell cell(String text) {
        return cell(text, Alignment.DEFAULT);
    }

    public static Cell cell(Cell oldCell, Alignment newAlignment) {
        return cell(oldCell.text, oldCell.minWidth, newAlignment);
    }

    /**
     * @return false when the alignment is DEFAULT, otherwise true.
     */
    public boolean isAligned() {
        return alignment != Alignment.DEFAULT;
    }

    @Override
    public String toString() {
        return formattedText;
    }
}
