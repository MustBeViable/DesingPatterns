package context;

public class Result {
    final String name;
    final long nanos;

    public Result(String name, long nanos) {
        this.name = name;
        this.nanos = nanos;
    }

    public String getName() {
        return name;
    }

    public long getNanos() {
        return nanos;
    }
}
