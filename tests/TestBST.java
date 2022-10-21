package com.ishujaa.my_code_library.tests;

import com.ishujaa.my_code_library.src.dsa.trees.BST;
import junit.framework.TestCase;
import org.junit.Assert;

public class TestBST extends TestCase {

    protected BST bst;

    @Override
    public void setUp() throws Exception {
        bst = new BST();
    }

    public void testDelete(){
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(1);
        bst.insert(2);

        bst.delete(4);

        bst.insert(10);
        bst.insert(8);
        bst.delete(5);

        assertEquals(bst.getInorder(), "1 2 3 8 10 ");
        assertEquals(bst.getPreOrder(), "8 3 1 2 10 ");
        assertEquals(bst.getPostOrder(), "2 1 3 10 8 ");

    }
}
