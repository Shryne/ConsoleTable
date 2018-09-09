package table;

public final class Head implements Content {
    private final Row row;

    public Head(String... strings) {
        this(new Row(strings));
    }

    public Head(Row row) {
        this.row = row;
    }

    @Override
    public Nat width() {
        // TODO: Implement it
        return null;
    }
}
