package ru.ilka.google.mentoring.task1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnagramDeterminerTest {
    private String first;
    private String second;
    private boolean caseSensitive;
    private boolean expectedResult;
    private AnagramDeterminer anagramDeterminer;

    public AnagramDeterminerTest(String first, String second, boolean caseSensitive, boolean expectedResult) {
        this.first = first;
        this.second = second;
        this.caseSensitive = caseSensitive;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "{index}:  {0}, {1} - {3}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"qwerty", "ytrewq", false, true},
                {"12345A", "5432A1", false, true},
                {"listen", "silent", false, true},

                {"apple", "pabble", false, false},
                {"Ilya", "Filya", false, false},
                {"12345", "05432", false, false},

                /* case sensitive */
                {"qwertY", "Ytrewq", true, true},
                {"12345A", "5432A1", true, true},
                {"listen", "silent", true, true},

                {"qwertY", "yTrewq", true, false},
                {"12345A", "5432a1", true, false},
                {"listen", "silEnt", true, false},
        });
    }

    @Before
    public void setUp() {
        anagramDeterminer = new AnagramDeterminer();
    }

    @Test
    public void determineAnagrams() {
        assertEquals(expectedResult, anagramDeterminer.areAnagrams(first, second, caseSensitive));
    }
}
