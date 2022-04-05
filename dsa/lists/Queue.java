package com.ishujaa.my_code_library.dsa.lists;

public class Queue extends DoublyLinkedList{
    public void enqueue(int value){
        super.addNodeTail(value);
    }

    public int dequeue(){
        return super.deleteHead();
    }

    public int peek(){
        return super.getHead();
    }

    public boolean isEmpty(){
        return super.getSize() == 0;
    }
}
