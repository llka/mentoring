package ru.ilka.google.mentoring.task2.algorithm;

import ru.ilka.google.mentoring.common.exception.AlgorithmException;
import ru.ilka.google.mentoring.task2.entity.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private TreeNode root;
    private int height;
    private int nodes;

    public BinaryTree() {
        this.root = null;
        this.height = 0;
        this.nodes = 0;
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
        this.height = 1;
        this.nodes = 1;
    }

    public BinaryTree(int[] values) {
        for (int i = 0; i < values.length; i++) {
            add(values[i]);
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int getHigth() {
        countHeightAndSum();
        return height;
    }

    public int getNodes() {
        return nodes;
    }


    public void add(int value) {
        TreeNode newNode = new TreeNode(value);
        root = addRecursive(root, newNode);
    }

    public List<TreeNode> findAncestors(int value) {
        ArrayList<TreeNode> ancestors = new ArrayList<>();
        TreeNode find = findRecursive(root, value);
        while (find.getAncestor() != null) {
            ancestors.add(find.getAncestor());
            find = find.getAncestor();
        }
        return ancestors;
    }

    public boolean contains(int value) {
        return containsNodeRecursive(root, value);
    }

    private TreeNode findRecursive(TreeNode current, int value) {
        if (current == null) {
            throw new AlgorithmException("No such value in the tree!");
        }
        if (value == current.getValue()) {
            return current;
        }
        if (value < current.getValue()) {
            return findRecursive(current.getLeft(), value);
        } else {
            return findRecursive(current.getRight(), value);
        }
    }

    private boolean containsNodeRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.getValue()) {
            return true;
        }
        return value < current.getValue()
                ? containsNodeRecursive(current.getLeft(), value)
                : containsNodeRecursive(current.getRight(), value);
    }

    private TreeNode addRecursive(TreeNode current, TreeNode newNode) {
        if (current == null) {
            return newNode;
        }
        int value = newNode.getValue();
        if (value < current.getValue()) {
            if (current.getLeft() == null) {
                newNode.setAncestor(current);
            }
            current.setLeft(addRecursive(current.getLeft(), newNode));
        } else if (value > current.getValue()) {
            if (current.getRight() == null) {
                newNode.setAncestor(current);
            }
            current.setRight(addRecursive(current.getRight(), newNode));
        } else {
            // value already exists
            throw new AlgorithmException("The value " + value + " already exists!");
        }

        return current;
    }

    private int countHeightAndSum() {
        int height = 0;
        int sum = 0;
        while (true) {
            sum += Math.pow(2, height);
            if (sum <= nodes) {
                height++;
            } else {
                break;
            }
        }
        this.height = height;
        return sum;
    }

    private boolean isLastLayerFull() {
        int sum = countHeightAndSum();
        return height == sum;
    }
}
