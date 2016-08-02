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
        return new Row(alignment, stringArrayToCellList(texts));
    }

    public static Row row(String... texts) {
        return row(Alignment.DEFAULT, texts);
    }

    public static Row row(Cell... data) {
        return row(Alignment.DEFAULT, data);
    }

    public static Row row(Row oldRow, Alignment newAlignment) {
        return new Row(newAlignment, oldRow.cells);
    }

    public static Row row(Row oldRow, int newColumnAmount) {
        if (oldRow.columnAmount() < newColumnAmount) {
            List<Cell> cells = new ArrayList<>(oldRow.cells.size());
            cells.addAll(emptyCells(newColumnAmount - cells.size()));

            return new Row(oldRow.alignment, cells);
        } else if ( oldRow.columnAmount() == newColumnAmount) {
            return oldRow;
        } else {
            throw new IllegalArgumentException("newColumnAmount has to be greater" +
                    "then rows current amount: " + newColumnAmount + " vs " + oldRow.columnAmount());
        }
    }

    public static Row row(Row oldRow, List<Integer> newCellWidths) {
        List<Cell> cells = new ArrayList<>(oldRow.cells.size());
        for (int i = 0; i < newCellWidths.size(); i++) {
            cells.add(cell(oldRow.getCells().get(i), newCellWidths.get(i)));
        }
        return new Row(oldRow.alignment, cells);
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

    List<Cell> getCells() {
        return cells;
    }

    public int columnAmount() {
        return cells.size();
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

    private static List<Cell> emptyCells(int amount) {
        List<Cell> emptyCells = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            emptyCells.add(cell(" "));
        }
        return emptyCells;
    }
}
