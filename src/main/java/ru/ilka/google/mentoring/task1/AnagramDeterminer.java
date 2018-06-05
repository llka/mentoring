package ru.ilka.google.mentoring.task1;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramDeterminer {

    private static final String DELIMITER = " ";

    public boolean areAnagrams(String first, String second, boolean caseSensitive) {
        if (first.length() != second.length()) {
            return false;
        }
        if (!caseSensitive) {
            first = first.toLowerCase();
            second = second.toLowerCase();
        }
        HashMap<Character, Integer> letters = new HashMap<>();
        Character letter;
        for (int i = 0; i < first.length(); i++) {
            letter = first.charAt(i);
            letters.put(letter, letters.getOrDefault(letter, 0) + 1);
        }
        for (int i = 0; i < second.length(); i++) {
            letter = second.charAt(i);
            int letterCount = letters.getOrDefault(letter, -1);
            if (letterCount < 0) {
                return false;
            } else {
                letters.put(letter, --letterCount);
            }

        }
        return true;
    }

    public boolean areAnagramsSentences(String first, String second, boolean caseSensitive) {
        if (!caseSensitive) {
            first = first.toLowerCase();
            second = second.toLowerCase();
        }
        first = removePunctuation(first);
        second = removePunctuation(second);

        List<String> firstSentence = Arrays.asList(first.trim().split(DELIMITER));
        List<String> secondSentence = Arrays.asList(second.trim().split(DELIMITER));

        ArrayList<HashMap<Character, Integer>> wordsAndLetters = new ArrayList<>(firstSentence.size());
        for (int i = 0; i < firstSentence.size(); i++) {
            HashMap<Character, Integer> letters = new HashMap<>();
            String word = firstSentence.get(i);
            Character letter;
            for (int j = 0; j < word.length(); j++) {
                letter = word.charAt(j);
                letters.put(letter, letters.getOrDefault(letter, 0) + 1);
            }
            wordsAndLetters.add(letters);
        }

        for (int i = 0; i < secondSentence.size(); i++) {
            String word = secondSentence.get(i);
            boolean findAnagram = false;

            int j = 0;
            while (!findAnagram && j < wordsAndLetters.size()) {
                HashMap<Character, Integer> letters = wordsAndLetters.get(j);
                Character letter;
                boolean anagram = true;
                for (int k = 0; k < word.length(); k++) {
                    letter = word.charAt(k);
                    int letterCount = letters.getOrDefault(letter, -1);
                    if (letterCount < 0) {
                        anagram = false;
                        break;
                    } else {
                        letters.put(letter, --letterCount);
                    }
                }

                if (letters.values().stream().anyMatch(count -> count > 0)) {
                    anagram = false;
                }

                if (anagram) {
                    findAnagram = true;
                }
                j++;
            }

            if (!findAnagram) {
                return false;
            }
        }

        return true;
    }

    private String removePunctuation(String sentence) {
        final String DOT = "\\.";
        final String COMMA = ",";
        sentence = sentence.replaceAll(COMMA, "");
        sentence = sentence.replaceAll(DOT, "");
        return sentence;
    }
}
