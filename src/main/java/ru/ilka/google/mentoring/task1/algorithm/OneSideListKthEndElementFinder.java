package ru.ilka.google.mentoring.task1.algorithm;

import ru.ilka.google.mentoring.common.exception.AlgorithmException;
import ru.ilka.google.mentoring.task1.entity.Node;
import ru.ilka.google.mentoring.task1.entity.OneSideList;

public class OneSideListKthEndElementFinder extends OneSideList {

    public OneSideListKthEndElementFinder() {
    }

    public OneSideListKthEndElementFinder(Node root) {
        super(root);
    }

    public OneSideListKthEndElementFinder(int[] values) {
        super(values);
    }

    public Node findKthLastElement(int k) {
        if (k > getLength()) {
            throw new AlgorithmException("K must be less than list length.");
        }
        Node node = getRoot();
        for (int i = 1; i < getLength() - k + 1; i++) {
            node = node.getNext();
        }
        return node;
    }
}
