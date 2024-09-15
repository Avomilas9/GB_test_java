package toy_shop;

public final class Toy implements Comparable<Toy>
{
    public Toy(int i, String n, int w) {
        id = i;
        name = n;
        weight = w;
    }
    @Override
    public int compareTo(Toy o) {
        return Integer.compare(this.id, o.id);
    }
    public int id;
    public String name;
    public int weight;
}