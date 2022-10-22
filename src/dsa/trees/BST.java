package com.ishujaa.my_code_library.src.dsa.trees;

public class BST {
    private BSTNode root;
    private int size;
    public final int NULL = Integer.MIN_VALUE;

    private BSTNode findLoc(int n, BSTNode node){//finds correct position for insertion
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
            BSTNode node = new BSTNode();
            node.value = n;
            node.left = node.right = null;

            if(root == null) root = node;
            else{
                BSTNode loc = findLoc(n, root);
                if(loc != null){
                    if(n <= loc.value) loc.left = node;
                    else loc.right = node;
                }
            }
            size++;
        }
    }

    private boolean search(int n, BSTNode node){
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

    private boolean delete(int key, BSTNode parent, BSTNode node){
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
                BSTNode temp = node.right;
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

    private int floor(int key, BSTNode prevSmallest, BSTNode node){
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

    private int ceil(int key, BSTNode prevLargest, BSTNode node){
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

    private void inorder(StringBuilder sb, BSTNode root){
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

    public void preorder(StringBuilder sb, BSTNode root){
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

    public void postorder(StringBuilder sb, BSTNode root){
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

    public int getSize() {
        return size;
    }
}
