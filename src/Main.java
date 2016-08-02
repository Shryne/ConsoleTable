import table.Alignment;
import table.container.Row;
import table.data.Cell;

import java.util.ArrayList;

import static table.container.Headline.headline;
import static table.container.ContentArea.contentArea;
import static table.container.Row.row;
import static table.data.Cell.cell;
import static table.Table.table;

public class Main {

    public static void main(String[] args) {
        /*
        System.out.println(Row.row(
                Alignment.DEFAULT,

                Cell.cell("Hey3", 30)
        ));
        System.out.println(Cell.cell("Hallo", 30, Alignment.RIGHT));
        */

        System.out.printf("%%-%ds", 5, "dfs\n");
        System.out.println(
                table(
                        headline(
                                row("hallo", "b2")
                        ),
                        contentArea(
                                row(Alignment.CENTER, cell("secando"), cell(":D", 5), cell("X, lol", 14)),
                                row(Alignment.CENTER, cell("Nr", 12)),
                                row(Alignment.CENTER, cell("secdo", 13), cell(":D", 5))
                        )
                )
        );
    }
}
