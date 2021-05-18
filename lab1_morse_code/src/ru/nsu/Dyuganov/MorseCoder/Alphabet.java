package ru.nsu.Dyuganov.MorseCoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class Alphabet {
    private final Map<Character, String> charToMorse = new HashMap<Character, String>();
    private final Map<String, Character> morseToChar = new HashMap<String, Character>();

    public Alphabet(String fileName) throws java.io.IOException {
        final int expectedSpacePos = 1;

        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = in.readLine()) != null) {
                if (str.indexOf(' ') != expectedSpacePos || str.isEmpty()) {
                    throw new IOException("Alphabet file has wrong format");
                }
                String[] splitStr = str.split(" ");
                charToMorse.put(str.charAt(0), splitStr[1]);
                morseToChar.put(splitStr[1], str.charAt(0));
            }
        }

        if (charToMorse.isEmpty() || morseToChar.isEmpty()) {
            throw new IOException("Alphabet file is empty, nothing to do there");
        }
    }

    public String getMorseCodeByChar(Character character) {
        return charToMorse.get(character);
    }

    public Character getCharByMorseCode(String morseCode) {
        return morseToChar.get(morseCode);
    }
}
