import table.Alignment;
import table.container.Row;
import table.data.Cell;

public class Main {

    public static void main(String[] args) {
        System.out.println(Row.row(
                Alignment.DEFAULT,

                Cell.cell("Hey3", 30)
        ));
        System.out.println(Cell.cell("Hallo", 30, Alignment.RIGHT));
    }
}
