package ru.nsu.Dyuganov.MorseCoder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MorseDecoder {
    private final Alphabet alphabet;

    public MorseDecoder(Alphabet alphabet){
        this.alphabet = alphabet;
    }

    public void decode(ArrayList<String> text, String resultFileName) throws IOException {
        final StringBuilder resultString = new StringBuilder();
        final StatCounter statCounter = new StatCounter();

        try (FileWriter decodeOut = new FileWriter(resultFileName)) {
            for(String str : text) {
                for (String character : str.split(" ")) {
                    resultString.append(alphabet.getCharByMorseCode(character));
                    statCounter.add(alphabet.getCharByMorseCode(character));
                }
                resultString.append(' ');
            }
            decodeOut.write(resultString.toString() + '\n');
        }
        statCounter.printToFile("decode_stats.txt");
    }
}
