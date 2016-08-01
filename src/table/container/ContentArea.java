package table.container;

import table.Alignment;
import table.data.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import static table.container.Row.row;

/**
 * Created by Seven on 21.07.2016.
 */
public class ContentArea {
    private final List<Row> rows;
    private final Alignment alignment;
    private final String asString;

    private ContentArea(List<Row> rows, Alignment alignment) {
        this.alignment = alignment;
        this.rows = maximiseRows(
                isAligned() ? alignedRows(rows, alignment) : rows
        );


        asString = toString(this.rows);
    }

    public static ContentArea contentArea(Alignment alignment, Row... rows) {
        return new ContentArea(Arrays.asList(rows), alignment);
    }

    public static ContentArea contentArea(Row... rows) {
        return contentArea(Alignment.DEFAULT, rows);
    }

    public static ContentArea contentArea(ContentArea oldContentArea, Alignment newAlignment) {
        return new ContentArea(oldContentArea.rows, newAlignment);
    }

    public boolean isAligned() {
        return alignment != Alignment.DEFAULT;
    }

    @Override
    public String toString() {
        return asString;
    }

    // ####################################################
    // private helper
    // ####################################################
    private static List<Row> alignedRows(List<Row> rows, Alignment alignment) {
        return rows.stream().map(r -> row(r, alignment)).collect(Collectors.toList());
    }

    private static String toString(List<Row> rows) {
        StringBuilder result = new StringBuilder();
        rows.forEach(r -> result.append(r).append("\n"));
        // to delete the "\n" at the end
        return result.deleteCharAt(result.length() - 1).toString();
    }

    private static List<Row> maximiseRows(List<Row> rows) {
        return adjustWidth(adjustColumnAmount(rows));
    }

    private static List<Row> adjustColumnAmount(List<Row> rows) {
        int maxColumnAmount = maxColumnAmount(rows);
        return rows.stream()
                .map(r -> row(r, maxColumnAmount))
                .collect(Collectors.toList());
    }

    private static int maxColumnAmount(List<Row> rows) {
        return Collections.max(rows,
                (r1, r2) -> Integer.compare(r1.columnAmount(), r2.columnAmount()))
                .columnAmount();
    }

    private static List<Row> adjustWidth(List<Row> toAdjust) {
        List<Row> adjusted = new ArrayList<>(toAdjust.size());
        List<Integer> newWidthCells = maxWidthCells(toAdjust);

        for (Row r : toAdjust) {
            adjusted.add(row(r, newWidthCells));
        }

        return adjusted;
    }

    private static List<Integer> maxWidthCells(List<Row> toAdjust) {
        List<Integer> maxWidth = new ArrayList<>();
        if (toAdjust.size() > 0) {
            for (int i = 0; i < toAdjust.get(0).getCells().size(); i++) {
                maxWidth.add(maxCellWidth(toAdjust, i));
            }
        }

        return maxWidth;
    }

    private static int maxCellWidth(List<Row> toAdjust, int i) {
        int max = 0;
        for (Row row : toAdjust) {
            max = Math.max(row.getCells().get(i).width(), max);
        }
        return max;
    }

    private static int maxWidth(List<Cell> cells) {
        int maxWidth = 0;
        for (Cell cell : cells) {
            maxWidth = Math.max(cell.width(), maxWidth);
        }
        return maxWidth;
    }
}
