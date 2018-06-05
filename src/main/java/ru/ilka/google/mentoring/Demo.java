package ru.ilka.google.mentoring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.ilka.google.mentoring.task2.algorithm.BinaryTree;


public class Demo {
    private static final Logger logger = LogManager.getLogger(Demo.class);

    public static void main(String... args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(6);

        binaryTree.findAncestors(6).forEach(System.out::println);
    }
}
