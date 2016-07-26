package table.container;

import table.Alignment;
import table.Table;
import table.data.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static table.data.Cell.cell;

/**
 * An immutable class to represent a row inside a table.
 */
public final class Row {
    private final Alignment alignment;
    private final List<Cell> cells;
    private final String formattedText;

    private Row(Alignment alignment, List<Cell> cells) {
        this.alignment = alignment;
        this.cells = isAligned() ? alignedCells(cells, alignment) : cells;
        formattedText = cellsText(this.cells);
    }

    public static Row row(Alignment alignment, Cell... data) {
        return new Row(alignment, Arrays.asList(data));
    }

    public static Row row(Alignment alignment, String... texts) {
        return row(alignment, texts);
    }

    public static Row row(String... texts) {
        return row(Alignment.DEFAULT, texts);
    }

    public static Row row(Cell... data) {
        return row(Alignment.DEFAULT, data);
    }

    @Override
    public String toString() {
        return formattedText;
    }

    /**
     * @return false when the alignment is DEFAULT, otherwise true.
     */
    public boolean isAligned() {
        return alignment != Alignment.DEFAULT;
    }

    // ####################################################
    // private helper
    // ####################################################
    private static final List stringArrayToCellList(String[] array) {
        List<Cell> result = new ArrayList<>();
        for (String s : array) {
            result.add(cell(s));
        }
        return result;
    }

    private static List<Cell> alignedCells(List<Cell> cells, Alignment alignment) {
        List<Cell> alignedCells = new ArrayList<>(cells.size());
        for (Cell c : cells) {
            if (c.isAligned()) {
                alignedCells.add(c);
            } else {
                alignedCells.add(cell(c, alignment));
            }
        }
        return alignedCells;
    }

    private static String cellsText(List<Cell> cells) {
        StringBuilder cellsText = new StringBuilder("|");
        cells.forEach(c -> cellsText.append(c.toString()).append(Table.COLUMN_DELIMITER));

        return cellsText.toString();
    }
}
