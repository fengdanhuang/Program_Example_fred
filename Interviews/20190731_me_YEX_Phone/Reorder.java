
/*
Interviwer: JD


This program reorders binary trees to be descending. The tree is descending 
if all children of a node are less than or equal to the node. For example,
the following tree is descending:
    7
   / \
  4   3

The following is noe:
    3
   / \
  5   8

This tree can be made descending by swapping 8 and 3.

Right now, this program is broken. Your job is to make it work. Start with 
the main() method, which creates some trees, reorders them and tests
them to be descending. Some of these tests are failing. Note that the main
method and methods used by it to test function correctly, so no need to 
focus on those for debugging, thougt it may help to read them to
understand what they do.
*/

import java.io.*;
import java.util.*;


public class Solution{

    public static class Node{
        private int value;
        private Node left;
        private Node right;

        Node(int val){
            this.value = val;
        }

        int getValue(){ return value;}
        void setValue(int value){ this.value = value;}

        Node getLeft(){ return this.left;}
        void setLeft(Node left){ this.left = left;}
     
        Node getRight(){ return this.right;}
        void setRight(Node right){ this.right = right;}
    }

    public static void reorder(Node node){
        //Base case: We've reached the bottom of the tree
        if (node == null){ 
            return;
        }
        
        Node left = node.getLeft();
        Node right = node.getRight();

        //If left and right are both <=, we're good
        if ((left == null || left.getValue() <= node.getValue()) &&
            (right == null || right.getValue() <= node.getValue())) {
            return;
        }

        //Find the larger child to swap with if one of the children is >
        Node swap = left;
        if (left == null){
            swap = right;
        } else if (right != null || right.getValue() > left.getValue()) {
            swap = right;
        }

        //
