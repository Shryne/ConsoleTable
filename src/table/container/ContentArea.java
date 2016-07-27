package table.container;

import table.Alignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static table.container.Row.row;

/**
 * Created by Seven on 21.07.2016.
 */
public class ContentArea {
    private final List<Row> rows;
    private final Alignment alignment;

    private ContentArea(List<Row> rows, Alignment alignment) {
        this.alignment = alignment;
        this.rows = isAligned() ? alignedRows(rows, alignment) : rows;
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

    // ####################################################
    // private helper
    // ####################################################
    private static List<Row> alignedRows(List<Row> rows, Alignment alignment) {
        return rows.stream().map(r -> row(r, alignment)).collect(Collectors.toList());
    }
}
