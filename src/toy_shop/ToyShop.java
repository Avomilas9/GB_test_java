package toy_shop;
import java.util.*;

public class ToyShop {
    public ToyShop()
    {
        toyList = new PriorityQueue<>();
        sumWeight = 0;
    }
    public boolean put(String str)
    {
        List<String> vals = Arrays.asList(str.split(" "));
        if(vals.size() < 3)
        {
            return false;
        }
        try
        {
            int id = Integer.parseInt(vals.get(0));
            int weight = Integer.parseInt(vals.get(1));
            String name = vals.get(2);
            put(id, name, weight);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public void put(int id, String name, int weight)
    {
        Toy toy = new Toy(id, name, weight);
        toyList.add(toy);
        sumWeight += weight;
    }

    public Toy get() throws Exception {
        Random random = new Random();
        int leftWeight = random.nextInt(sumWeight);
        for(Toy toy : toyList)
        {
            leftWeight -= toy.weight;
            if(leftWeight < 0)
                return toy;
        }
        throw new Exception("Cannot get toy: internal error");
    }

    PriorityQueue<Toy> toyList;
    int sumWeight;
}