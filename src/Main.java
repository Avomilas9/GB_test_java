import toy_shop.Session;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        List<String> data = new LinkedList<>();
        //ToyShop shop = new ToyShop();
        Scanner sc = new Scanner(System.in);
        int ret = 0;
        while( ret == 0)
        {
            System.out.println("Please, insert action: 1 - add toy, 2 - raffle off a toy, 3 - auto, 4 - exit");
            int ans = sc.nextInt();
            if(ans == 1)
            {
                System.out.println("Please, insert toy: id weight name");
                String str = sc.nextLine();
                while (str.isEmpty())
                {
                    str = sc.nextLine();
                }
                data.add(str);
            }
            else if(ans == 2)
            {
                Session session = new Session(data);
                session.raffleOff(10);
                session.printReportToFile();
                //System.out.println("Surprise:\n");
                //for(int i = 0; i < 10; ++i)
                //{
                //    Toy toy = shop.get();
                //    System.out.println("Toy: " + toy.name + ", weight: " + toy.weight);
                //}
                ret = 1;
            }
            else if(ans == 3)
            {
                String[] defaultData = {
                        "1 2 constructor"
                      , "2 2 robot"
                      , "3 6 puppet"
                };
                Session session = new Session(Arrays.asList(defaultData));
                session.raffleOff(10);
                session.printReportToFile();
                //for(String str : data)
                //{
                //    boolean res = shop.put(str);
                //    if(!res) {
                //        System.out.println("Error of adding toy");
                //        return;
                //    }
                //}
                //System.out.println("Surprise:\n");
                //Map<String, Integer> map = new HashMap<>();
                //int i;
                //for(i = 0; i < 10; ++i)
                //{
                //    Toy toy = shop.get();
                //    map.put(toy.name, map.getOrDefault(toy.name, 0) + 1);
                //    System.out.println("Toy: " + toy.name + ", weight: " + toy.weight);
                //}
                //System.out.println("map: " + map);
                ret = 1;
            }
            else if(ans == 4)
            {
                System.out.println("Exit...");
                ret = 1;
            }
            else
            {
                System.out.println("Cannot recognize command");
            }
        }
    }
}