package table;

/**
 * The border of a cell.
 * <p>This class is immutable and thread-safe.</p>
 */
public final class Border {
    private final char topCharacter;
    private final char leftCharacter;
    private final char rightCharacter;
    private final char bottomCharacter;

    public Border(char topCharacter, char leftCharacter, char rightCharacter, char bottomCharacter) {
        this.topCharacter = topCharacter;
        this.leftCharacter = leftCharacter;
        this.rightCharacter = rightCharacter;
        this.bottomCharacter = bottomCharacter;
    }

    public String top(int width) {
        return repeatedCharacter(topCharacter, width);
    }

    public String bottom(int width) {
        return repeatedCharacter(bottomCharacter, width);
    }

    public String left() {
        return leftCharacter + "";
    }

    public String right() {
        return rightCharacter + "";
    }

    private static String repeatedCharacter(char toRepeat, int times) {
        return new String(
                new char[times]
        ).replace("\0", toRepeat + "");
    }
}
