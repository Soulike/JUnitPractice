public class Counter
{
    private int count = 0;

    public int increment()
    {
        return this.count += 1;
    }

    public int decrement()
    {
        return this.count -= 1;
    }

    public int getCount()
    {
        return this.count;
    }
}
