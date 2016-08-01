import table.Alignment;
import table.container.Row;
import table.data.Cell;

import java.util.ArrayList;

import static table.container.Headline.headline;
import static table.container.ContentArea.contentArea;
import static table.container.Row.row;
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
        
        System.out.println(
                table(
                        headline(
                                row("hallo", "b2")
                        ),
                        contentArea(
                                row("Nr", "s"),
                                row("secando", ":D", "X")
                        )
                )
        );
    }
}
