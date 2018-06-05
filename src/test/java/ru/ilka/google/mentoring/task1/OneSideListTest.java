package ru.ilka.google.mentoring.task1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.ilka.google.mentoring.common.exception.AlgorithmException;
import ru.ilka.google.mentoring.task1.algorithm.OneSideListKthEndElementFinder;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OneSideListTest {
    private OneSideListKthEndElementFinder oneSideListKthEndElementFinder;
    private int k;
    private int expectedResult;
    private Class<? extends Exception> expectedException;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public OneSideListTest(OneSideListKthEndElementFinder oneSideListKthEndElementFinder, int k, int expectedResult, Class<? extends Exception> expectedException) {
        this.oneSideListKthEndElementFinder = oneSideListKthEndElementFinder;
        this.k = k;
        this.expectedResult = expectedResult;
        this.expectedException = expectedException;
    }


    @Parameterized.Parameters(name = "{1}, {2}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {new OneSideListKthEndElementFinder(new int[]{1, 2, 3, 4}), 3, 2, null},
                {new OneSideListKthEndElementFinder(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 10, 1, null},
                {new OneSideListKthEndElementFinder(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 1, 10, null},
                {new OneSideListKthEndElementFinder(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 100, 0, AlgorithmException.class},
                {new OneSideListKthEndElementFinder(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 0, 0, AlgorithmException.class},
        });
    }

    @Test
    public void shouldThrowAlgorithmException() throws AlgorithmException {
        if (expectedException != null) {
            thrown.expect(expectedException);
        }
        assertEquals(expectedResult, oneSideListKthEndElementFinder.findKthLastElement(k).getValue());
    }

}
