package table.container;

import javafx.geometry.Pos;
import table.Alignment;
import table.data.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static table.container.Row.row;
import static table.data.Cell.cell;

/**
 * The class to model a headline inside a table.
 * Note that a table can have multiple headlines at
 * once (for as a maximum) or even zero. Furthermore
 * a headline can be placed in four different locations
 * which can be declared by using the {@link Headline.Position}
 * enum.
 */
public final class Headline {
    /**
     * This enum is used to specify the position of the
     * headline inside a table.
     */
    private enum Position {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    private final Row row;
    private final Position position;

    private Headline(Row row, Position position) {
        this.row = row;
        this.position = position;
    }

    public static Headline headline(Row row, Position position) {
        return new Headline(row, position);
    }

    public static Headline headline(Row row) {
        return headline(row, Position.TOP);
    }

    public static Headline headline(Headline oldHeadline, Alignment newAlignment) {
        return headline(row(oldHeadline.row, newAlignment), oldHeadline.position);
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return row.toString();
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

    private static List<Cell> alignedrow(List<Cell> row, Alignment alignment) {
        List<Cell> alignedrow = new ArrayList<>(row.size());
        for (Cell c : row) {
            if (c.isAligned()) {
                alignedrow.add(c);
            } else {
                alignedrow.add(cell(c, alignment));
            }
        }
        return alignedrow;
    }
}
