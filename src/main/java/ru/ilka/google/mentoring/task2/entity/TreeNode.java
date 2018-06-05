package ru.ilka.google.mentoring.task2.entity;

import java.util.Objects;

public class TreeNode {
    private TreeNode ancestor;
    private TreeNode left;
    private TreeNode right;
    private int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(TreeNode ancestor, TreeNode left, TreeNode right, int value) {
        this.ancestor = ancestor;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TreeNode getAncestor() {
        return ancestor;
    }

    public void setAncestor(TreeNode ancestor) {
        this.ancestor = ancestor;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return value == treeNode.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
