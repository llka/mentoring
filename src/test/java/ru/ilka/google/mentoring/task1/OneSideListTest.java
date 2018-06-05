package ru.ilka.google.mentoring.task1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.ilka.google.mentoring.task1.algorithm.OneSideListKthEndElementFinder;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OneSideListTest {
    private OneSideListKthEndElementFinder oneSideListKthEndElementFinder;
    private int k;
    private int expectedResult;

    public OneSideListTest(OneSideListKthEndElementFinder oneSideListKthEndElementFinder, int k, int expectedResult) {
        this.oneSideListKthEndElementFinder = oneSideListKthEndElementFinder;
        this.k = k;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "{1}, {2}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {new OneSideListKthEndElementFinder(new int[]{1, 2, 3, 4}), 3, 2},
                {new OneSideListKthEndElementFinder(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 10, 1},
                {new OneSideListKthEndElementFinder(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 1, 10},
                {new OneSideListKthEndElementFinder(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 2, 9},
        });
    }

    @Test
    public void determineAnagrams() {
        assertEquals(expectedResult, oneSideListKthEndElementFinder.findKthLastElement(k).getValue());
    }
}
