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
        if (minWidth < 1) throw new IllegalArgumentException(
                String.format("minWidth can't be lower than 1 but is: %d, text: %s, %s",
                        minWidth, text, alignment)
        );

        this.alignment = alignment;
        this.minWidth = minWidth;
        this.text = text;
        this.formattedText = String.format(
                String.format("%%-%ds", minWidth),
                alignment.align(text.length(), minWidth) + text
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

    public static Cell cell(Cell oldCell, int newWidth) {
        if (oldCell.minWidth < newWidth) {
            return cell(oldCell.text, newWidth, oldCell.alignment);
        } else if (oldCell.minWidth == newWidth) {
            return oldCell;
        } else {
            throw new IllegalArgumentException(String.format("The old width (%d) has to be" +
                    " smaller than the new one (%d", oldCell.minWidth, newWidth));
        }
    }

    /**
     * @return false when the alignment is DEFAULT, otherwise true.
     */
    public boolean isAligned() {
        return alignment != Alignment.DEFAULT;
    }

    public int width() {
        return minWidth;
    }

    @Override
    public String toString() {
        return formattedText;
    }
}
