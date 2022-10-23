package com.ishujaa.my_code_library.src.dsa.trees;

public class BST{
    private BinTreeNode root;
    private int size;
    public final int NULL = Integer.MIN_VALUE;

    public BST(){}

    public BST(String s){
        String[] keys = s.split(" ");
        for(String key: keys){
            int k = Integer.parseInt(key);
            insert(k);
        }
    }

    /*public boolean verifyBST(BinTreeNode parent, BinTreeNode node){//incorrect
        if(node != null){
            if(node.left != null){
                if(node.left.value > node.value && parent.value > node.value)
                    return false;
            }

            if(node.right != null){
                if(node.right.value <= node.value && parent.value <= node.value)
                    return false;
            }

            return verifyBST(node, node.left) && verifyBST(node, node.right);
        }

        return true;
    }*/

    //10 5 18 2 9 15 19 N 4 8 N 1
    //3 1 5 N 2 4 8 N N N N 7 N 6

    private BinTreeNode findLoc(int n, BinTreeNode node){//finds correct position for insertion
        if(node != null){
            if(n <= node.value){
                if(node.left == null)
                    return node;
                return findLoc(n, node.left);
            }else{
                if(node.right == null)
                    return node;
                return findLoc(n, node.right);
            }
        }
        return null;
    }//O(h)

    public void insert(int n){
        if(n!=NULL){
            BinTreeNode node = new BinTreeNode();
            node.value = n;
            node.left = node.right = null;

            if(root == null) root = node;
            else{
                BinTreeNode loc = findLoc(n, root);
                if(loc != null){
                    if(n <= loc.value) loc.left = node;
                    else loc.right = node;
                }
            }
            size++;
        }
    }

    private boolean search(int n, BinTreeNode node){
        if(node != null){
            if(n == node.value) return true;
            if(n < node.value){
                if(node.left != null)
                    return search(n, node.left);
            }else{
                if(node.right != null)
                    return search(n, node.right);
            }
        }
        return false;
    }//O(h)

    public boolean search(int key){
        return search(key, root);
    }

    private boolean delete(int key, BinTreeNode parent, BinTreeNode node){
        if(node.value == key){
            if(node.left == null && node.right == null){
                if(parent.right == node)
                    parent.right = null;
                else parent.left = null;
            }
            else if(node.left != null && node.right == null){
                if(parent.right == node)
                    parent.right = node.left;
                else parent.left = node.left;
            }
            else if(node.left == null){
                if(parent.right == node)
                    parent.right = node.right;
                else parent.left = node.right;
            }
            else{ //none is null
                //replace with the smallest node in right subtree
                BinTreeNode temp = node.right;
                parent = node;
                while(temp.left != null){
                    parent = temp;
                    temp = temp.left;
                }

                node.value = temp.value;
                if(parent == node){
                    parent.right = temp.right;
                }else
                    parent.left = null;
            }
            return true;
        }else if(key < node.value && node.left != null)
            return delete(key, node, node.left);
        else if(key > node.value && node.right != null)
            return delete(key, node, node.right);

        return false;//not found
    }//O(h)

    public void delete(int key){
        if(size >= 1){

            if(size == 1 && root.value == key){
                root = null;
                size--;
                return;
            }

            if(delete(key, root, root))
                size--;
        }
    }

    private int floor(int key, BinTreeNode prevSmallest, BinTreeNode node){
        if(node.value == key){
            return key;
        }else{
            if(key < node.value){
                if(node.left != null)
                    return floor(key, prevSmallest, node.left);
                else
                    if(prevSmallest.value < key) return prevSmallest.value;
                    else return NULL;
            }else{
                if(node.right == null)
                    return node.value;
                else
                    return floor(key, node, node.right);
            }
        }
    }

    public int floor(int key){
        if(size == 1){
            if(root.value <= key) return root.value;
        }else if(size > 1){
            return floor(key, root, root);
        }

        return NULL;
    }

    private int ceil(int key, BinTreeNode prevLargest, BinTreeNode node){
        if(node.value == key){
            return key;
        }else{
            if(key > node.value){
                if (node.right != null)
                    return ceil(key, prevLargest, node.right);
                else
                    if(prevLargest.value > key) return prevLargest.value;
                    else return NULL;
            }else{
                if (node.left == null)
                    return node.value;
                else
                    return ceil(key, node, node.left);
            }
        }
    }

    public int ceil(int key){
        if(size == 1){
            if(root.value >= key) return root.value;
        }else if(size > 1){
            return ceil(key, root, root);
        }

        return NULL;
    }

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

    private void levelOrder(StringBuilder sb, BinTreeNode root){
        if(root != null){
            BinTreeNode temp = root;

        }
    }

    public String getLevelOrder(){
        StringBuilder sb = new StringBuilder();
        levelOrder(sb, root);
        return sb.toString();
    }

    public int getSize() {
        return size;
    }

    public BinTreeNode getRoot() {
        return root;
    }
}
