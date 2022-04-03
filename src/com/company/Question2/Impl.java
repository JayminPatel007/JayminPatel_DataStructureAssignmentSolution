package com.company.Question2;

import com.company.ds.BinaryTreeImpl;
import com.company.ds.Node;
import com.company.ds.StackImpl;

import java.util.ArrayList;
import java.util.List;

public class Impl {
    public static void run() {
        BinaryTreeImpl<Integer> tree = new BinaryTreeImpl<Integer>();
        tree.root = new Node<Integer>(50);
        tree.root.left = new Node<Integer>(30);
        tree.root.right = new Node<Integer>(60);
        tree.root.left.left = new Node<Integer>(10);
        tree.root.right.left = new Node<Integer>(55);

        List<Integer> list = inOrderTraversal(tree);
        BinaryTreeImpl<Integer> skewTree = new BinaryTreeImpl<Integer>();
        tree.root = new Node<Integer>(list.get(0));
        Node<Integer> current = tree.root;
        for (int i = 1; i < list.size(); i++) {
            current.right = new Node<Integer>(list.get(i));
            current = current.right;
        }
        current = tree.root;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    public static List<Integer> inOrderTraversal(BinaryTreeImpl<Integer> tree) {
        List<Integer> output_list = new ArrayList<Integer>();
        StackImpl<Node<Integer>> stack = new StackImpl<Node<Integer>>(100);
        if (tree.root == null) {
            return output_list;
        }

        Node<Integer> current = tree.root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            output_list.add(current.data);
            current = current.right;
        }

        return  output_list;
    }
}
