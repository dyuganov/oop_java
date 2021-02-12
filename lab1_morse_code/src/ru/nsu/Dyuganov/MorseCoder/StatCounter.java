package ru.nsu.Dyuganov.MorseCoder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public final class StatCounter {
    private final Set<CharCounter> statistics = new HashSet<CharCounter>();

    public StatCounter(){}

    public void add(Character character){
        statistics.add(new CharCounter(character));
    }

    public void printToFile(String fileName) throws IOException {
        try (FileWriter statsOut = new FileWriter(fileName)) {
            Integer cnt = 0;
            for(CharCounter counter : statistics){
                statsOut.write(counter.getSymbol().toString() + ' ' + counter.getCounter() + '\n');
                cnt += counter.getCounter();
            }
            statsOut.write("\n" + "TOTAL: " + cnt.toString());
        }
    }
}
