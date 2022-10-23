package com.ishujaa.my_code_library.src.dsa.trees;

public class BinTree {
    private BinTreeNode root;
    private int size;
    private final int NULL = Integer.MIN_VALUE;

    public BinTree(){}

    /*public BinTree(String s){
        String[] keys = s.split(" ");
        for(String key: keys){
            int k = Integer.parseInt(key);
            insert(k);
        }
    }

    public void insert(int key){
        BinTreeNode node = new BinTreeNode();
        node.value = key;
        node.left = node.right = null;

        if(root == null) root = node;
        else{
            //insert based on level ordering
        }
        size++;
    }*/

    private void inorder(StringBuilder sb, BinTreeNode root){
        if(root != null){
            if(root.left != null)
                inorder(sb, root.left);
            sb.append(root.value).append(" ");
            if(root.right != null)
                inorder(sb, root.right);
        }
    }

    public String getInorder(){
        StringBuilder sb = new StringBuilder();
        inorder(sb, root);
        return sb.toString();
    }

    public void preorder(StringBuilder sb, BinTreeNode root){
        if(root != null){
            sb.append(root.value).append(" ");
            if(root.left != null)
                preorder(sb, root.left);
            if(root.right != null)
                preorder(sb, root.right);
        }
    }

    public String getPreOrder(){
        StringBuilder sb = new StringBuilder();
        preorder(sb, root);
        return sb.toString();
    }

    public void postorder(StringBuilder sb, BinTreeNode root){
        if(root != null){
            if(root.left != null)
                postorder(sb, root.left);
            if(root.right != null)
                postorder(sb, root.right);
            sb.append(root.value).append(" ");
        }
    }

    public String getPostOrder(){
        StringBuilder sb = new StringBuilder();
        postorder(sb, root);
        return sb.toString();
    }

    public BinTreeNode getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }
}
