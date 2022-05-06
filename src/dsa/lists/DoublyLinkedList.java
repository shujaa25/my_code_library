package com.ishujaa.my_code_library.src.dsa.lists;

public class DoublyLinkedList extends SinglyLinkedList{
    private class Node extends SinglyLinkedList.Node{
        Node prev;
    }
    protected Node head, tail;

    protected int getHead(){
        if(head != null){
            return head.value;
        }
        return Integer.MIN_VALUE;
    }

    protected int getTail(){
        if(tail != null){
            return tail.value;
        }
        return Integer.MIN_VALUE;
    }

    public void addNodeHead(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        node.prev = null;
        if(head == null){
            tail = head = node;
        }else{
            head.prev = node;
            head = node;
        }

        increaseSize(1);
    }

    public void addNodeTail(int value){
        Node node = new Node();
        node.value = value;
        node.next = null;
        node.prev = tail;
        if(head == null){
            tail = head = node;
        }else{
            tail.next = node;
            tail = node;
        }

        increaseSize(1);
    }

    public int deleteHead(){
        int deletedKey = Integer.MIN_VALUE;
        if(head != null){
            deletedKey = head.value;
            if(head.next == null){
                tail = head = null;
            }
            else{
                head = (Node)head.next;
                head.prev = null;
            }
            increaseSize(-1);
        }
        return deletedKey;
    }

    public int deleteTail(){
        int deletedKey = Integer.MIN_VALUE;
        if(tail != null){
            deletedKey = tail.value;
            if(tail.prev == null){
                tail = head = null;
            }
            else{
                tail = (Node)tail.prev;
                tail.next = null;
            }
            increaseSize(-1);
        }
        return deletedKey;
    }

    public boolean find(int value){
        SinglyLinkedList.Node temp = head;
        while(temp != null){
            if(temp.value == value) return true;
            temp = temp.next;
        }
        return false;
    }

    public void printAll(){
        SinglyLinkedList.Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
