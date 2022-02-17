package com.ishujaa.my_code_library.dsa.lists;

public class Stack extends SinglyLinkedList{
    public void push(int value){
        super.addNodeHead(value);
    }

    public int pop(){
        return super.deleteHead();
    }

    public int peek(){
        if(super.head != null){
            return super.head.value;
        }

        return Integer.MIN_VALUE;
    }

    public boolean isEmpty(){
        return super.getSize() == 0;
    }
}
