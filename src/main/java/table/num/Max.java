package table.num;

import java.util.Collection;
import java.util.function.Function;

/**
 * The maximum number of a method from an object inside of a given collection. Example:
 * <pre><code>new Max(["a", "ab", "cdef"], String::length); => 4, because "cdef is the longest.</code></pre>
 * <p>This class is immutable and thread-safe, as long as the given collection isn't changed while working with this
 * class..</p>
 * @param <T> The type of the elements inside the collection.
 */
public final class Max<T> extends Number {
    private final Collection<T> collection;
    private final Function<T, Integer> function;

    /**
     * Primary constructor.
     * @param collection of the elements. There must be at least one element in the collection. However there won't be
     *                   any checks for that, until one calls the methods to retrieve the value.
     * @param function to get the number from.
     */
    public Max(Collection<T> collection, Function<T, Integer> function) {
        this.collection = collection;
        this.function = function;
    }

    /**
     * Applies the function and searches for the maximum number. This method will actually do the lookup.
     * @throws java.util.NoSuchElementException if the given collection is empty.
     */
    @Override
    public int intValue() {
        final var iterator = collection.iterator();
        int result = function.apply((iterator.next()));
        while (iterator.hasNext()) {
            result = Math.max(result, function.apply(iterator.next()));
        }
        return result;
    }

    /**
     * Applies the function and searches for the maximum number. This method will actually do the lookup.
     * @throws java.util.NoSuchElementException if the given collection is empty.
     */
    @Override
    public long longValue() {
        return intValue();
    }

    /**
     * Applies the function and searches for the maximum number. This method will actually do the lookup.
     * @throws java.util.NoSuchElementException if the given collection is empty.
     */
    @Override
    public float floatValue() {
        return intValue();
    }

    /**
     * Applies the function and searches for the maximum number. This method will actually do the lookup.
     * @throws java.util.NoSuchElementException if the given collection is empty.
     */
    @Override
    public double doubleValue() {
        return intValue();
    }
}
