package ru.ilka.google.mentoring.task2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.ilka.google.mentoring.common.exception.AlgorithmException;
import ru.ilka.google.mentoring.task1.algorithm.OneSideListKthEndElementFinder;
import ru.ilka.google.mentoring.task2.algorithm.BinaryTree;
import ru.ilka.google.mentoring.task2.entity.TreeNode;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BinaryTreeFindAncestorsTest {
    private BinaryTree binaryTree;
    private int valueToFind;
    private List<Integer> expectedAncestors;
    private Class<? extends Exception> expectedException;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public BinaryTreeFindAncestorsTest(BinaryTree binaryTree, int valueToFind, List<Integer> expectedAncestors, Class<? extends Exception> expectedException) {
        this.binaryTree = binaryTree;
        this.valueToFind = valueToFind;
        this.expectedAncestors = expectedAncestors;
        this.expectedException = expectedException;
    }

    /*
       8
      5 10
    4 7 9 15
     */

    @Parameterized.Parameters(name = "{1} - {2}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {new BinaryTree(new int[]{8, 10, 5, 7, 4, 9, 15}), 4, Arrays.asList(5, 8), null},
                {new BinaryTree(new int[]{8, 10, 5, 7, 4, 9, 15}), 15, Arrays.asList(10, 8), null},
                {new BinaryTree(new int[]{8, 10, 5, 7, 4, 9, 15}), 5, Arrays.asList(8), null},
        });
    }

    @Test
    public void shouldThrowAlgorithmException() throws AlgorithmException {
        if (expectedException != null) {
            thrown.expect(expectedException);
            thrown.expectMessage("The value " + valueToFind + " already exists!");
        }
        List<TreeNode> actualAncestors = binaryTree.findAncestors(valueToFind);
        assertEquals(expectedAncestors.size(), actualAncestors.size());
        for (int i = 0; i < expectedAncestors.size(); i++) {
            assertEquals(Integer.valueOf(expectedAncestors.get(i)), Integer.valueOf(actualAncestors.get(i).getValue()));
        }
    }
}
