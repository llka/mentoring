package ru.ilka.google.mentoring.task1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.ilka.google.mentoring.task1.algorithm.AnagramDeterminer;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnagramSentencesDeterminerTest {
    private String first;
    private String second;
    private boolean caseSensitive;
    private boolean expectedResult;
    private AnagramDeterminer anagramDeterminer;

    public AnagramSentencesDeterminerTest(String first, String second, boolean caseSensitive, boolean expectedResult) {
        this.first = first;
        this.second = second;
        this.caseSensitive = caseSensitive;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "{index}:  {0}, {1} - {3}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"as asd asda.", "as asd asad.", false, true},
                {"123, 456.", "321,,, 465", false, true},
                {"123, 456.", "321,,, 465, 231", false, true},
                {"listen triangle", "silent INTEgraL", false, true},

                {"as asd asdae.", "as asd asad.", false, false},
                {"123, 456.", "321,,, 465 567", false, false},
                {"listen triangle", "silent INTEgraL", true, false},
        });
    }

    @Before
    public void setUp() {
        anagramDeterminer = new AnagramDeterminer();
    }

    @Test
    public void determineSentenceAnagrams() {
        assertEquals(expectedResult, anagramDeterminer.areAnagramsSentences(first, second, caseSensitive));
    }
}
