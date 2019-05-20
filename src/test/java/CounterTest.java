import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CounterTest
{
    private Counter counter = null;

    @BeforeEach
    void before()
    {
        counter = new Counter();
    }

    @Test
    void incrementTest()
    {
        assertEquals(counter.increment(), 1);
        assertEquals(counter.increment(), 2);
    }

    @Test()
    void decrementTest()
    {
        assertEquals(counter.decrement(), -1);
        assertEquals(counter.decrement(), -2);
    }
}
