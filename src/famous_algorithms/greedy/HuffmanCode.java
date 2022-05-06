package com.ishujaa.my_code_library.src.famous_algorithms.greedy;

import com.ishujaa.my_code_library.src.dsa.trees.Heap;
import com.ishujaa.my_code_library.src.dsa.trees.HeapObject;

import java.util.HashMap;

public class HuffmanCode {

    private HashMap<Character, String> codes;

    private class AlphaFrqPair extends HeapObject {
        char name;
        AlphaFrqPair left, right;
        String code;
    }

    private void assignCodes(AlphaFrqPair root){

        if(root.left != null){
            root.left.code = root.code+"0";
            assignCodes(root.left);
        }

        if(root.right != null){
            root.right.code = root.code+"1";
            assignCodes(root.right);
        }

        if(root.name != '$') codes.put(root.name, root.code);

    }

    public HashMap<Character, String> getCodes(char[] alphabet, long[] frequency){
        codes = new HashMap<>();
        int itemCount = alphabet.length;

        AlphaFrqPair[] pairs = new AlphaFrqPair[itemCount+1];
        for(int i=1; i<=itemCount; i++){
            pairs[i] = new AlphaFrqPair();
            pairs[i].name = alphabet[i-1];
            pairs[i].value = frequency[i-1];
        }

        Heap heap = new Heap(pairs, false);

        for(int i=1; i<itemCount; i++){
            AlphaFrqPair newNode = new AlphaFrqPair();
            newNode.name = '$';
            newNode.left = (AlphaFrqPair) heap.extractMin();
            newNode.right = (AlphaFrqPair) heap.extractMin();
            newNode.value = newNode.left.value + newNode.right.value;
            heap.insert(newNode);
        }

        AlphaFrqPair tree = (AlphaFrqPair) heap.extractMin();
        tree.code = "";
        assignCodes(tree);

        return codes;
    }
}
