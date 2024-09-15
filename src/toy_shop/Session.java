package toy_shop;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class Session {
    public Session(Iterable<String> toySet)
    {
        toyShop = new ToyShop();
        results = new LinkedList<>();
        warnings = new LinkedList<>();
        resultFileName = "output.txt";
        warnFileName = "warnings.txt";
        for(String toyItem : toySet)
        {
            boolean ok = toyShop.put(toyItem);
            if(!ok)
            {
                warnings.add("Cannot add toy: " + toyItem);
            }
        }
    }

    public void raffleOff(int times) throws Exception {
        int i;
        for(i = 0; i < times; ++i) {
            Toy toy = toyShop.get();
            results.add(String.valueOf(toy.id));
        }
    }

    public void printReportToFile() throws IOException {
        if(!warnings.isEmpty())
        {
            printToFile(warnFileName, warnings);
        }
        printToFile(resultFileName, results);
    }
    private void printToFile(String fileName, Iterable<String> text) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(String.join("\n", text));
        printWriter.close();
    }
    private final ToyShop toyShop;
    private final List<String> results;
    private final List<String> warnings;
    private final String resultFileName;
    private final String warnFileName;
}