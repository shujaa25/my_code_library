package com.ishujaa.my_code_library.src.dsa.lists;

public class DeQueue extends Queue{
    public void enqueueHead(int value){
        super.addNodeHead(value);
    }
    public int dequeueTail(){
        return super.deleteTail();
    }
    public int peekTail(){
        return super.getTail();
    }
}
