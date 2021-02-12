package ru.nsu.Dyuganov.MorseCoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public final class Parser {
    public ArrayList<String> parseForEncoder(String fileName) throws java.io.IOException {
        final ArrayList<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = in.readLine()) != null) {
                for (String item : str.split(" ")) {
                    if (!item.equals(" ")) result.add(item);
                }
            }
        }
        return result;
    }

    public ArrayList<String> parseForDecoder(String fileName) throws java.io.IOException{
        final String morseCodeSpace = "    ";
        final ArrayList<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = in.readLine()) != null) {
                for (String item : str.split(morseCodeSpace)) {
                    if (!item.equals(" ")) result.add(item);
                }
            }
        }
        return result;
    }
}
