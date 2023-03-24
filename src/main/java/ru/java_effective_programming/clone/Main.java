package ru.java_effective_programming.clone;

import java.util.Hashtable;

public class Main {

    public static void main(String... args){

        HashTable hashTable = new HashTable();
        hashTable.addAllAuto();
        HashTable hashTableClone = hashTable.clone();

        boolean e = hashTable == hashTableClone;
        boolean e2 = hashTable.buckets[0] == hashTableClone.buckets[0];


        hashTable.add(0, 100);

//        hashTable.change(0,"01");
//        hashTableClone.change(1,"01");
//
//        hashTable.seeAllBucket();
//        hashTableClone.seeAllBucket();

        //boolean e2 = hashTable.buckets == hashTableClone.buckets;
//        Hashtable

        System.out.println("hashTable == hashTableClone ? = " + e);
        System.out.println("hashTable.buckets == hashTableClone.buckets ? = " + e2);

    }
}
