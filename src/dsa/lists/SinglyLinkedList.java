package com.ishujaa.my_code_library.src.dsa.lists;

public class SinglyLinkedList {
    protected class Node{
        int value;
        Node next;
    }
    private int size;
    protected Node head;

    public void addNodeHead(int value){ // O(1)
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = head;
        head = newNode;

        increaseSize(1);
    }

    public void addPreSorted(int value){ // O(n)
        Node newNode = new Node();
        newNode.value = value;

        //assuming the list is presorted
        Node temp = head; Node prev = null;
        while(temp != null && temp.value < value){
            prev = temp;
            temp = temp.next;
        }

        newNode.next = temp;
        if(prev != null)
            prev.next = newNode;
        else head = newNode;

        increaseSize(1);
    }

    public int deleteHead(){
        int deletedKey = Integer.MIN_VALUE;
        if(head != null){
            deletedKey = head.value;
            head = head.next;
            increaseSize(-1);
        }
        return deletedKey;
    }

    public boolean exists(int value){
        Node temp = head;
        while(temp != null){
            if(temp.value == value) return true;
            temp = temp.next;
        }
        return false;
    }

    public boolean deleteValue(int value){
        if(head != null){
            if(head.value == value){
                head = head.next;
                increaseSize(-1);
                return true;
            }
            if(head.next != null){
                Node temp = head;
                while(temp.next != null){
                    if(temp.next.value == value){
                        temp.next = temp.next.next;
                        increaseSize(-1);
                        return true;
                    }
                    temp = temp.next;
                }
            }

        }

        return false;
    }

    public int getSize(){
        return size;
    }

    protected void increaseSize(int count){
        size+=count;
    }

    public void printAll(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
