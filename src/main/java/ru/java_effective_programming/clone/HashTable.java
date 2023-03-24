package ru.java_effective_programming.clone;


public class HashTable implements Cloneable{

    Entry[] buckets = new Entry[5];

    private static class Entry{
        final Object key;
        Object value;
        Entry next;
        Entry(Object key, Object value, Entry next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Entry deepCopy(){
            return new Entry(key, value, next == null ? null : next.deepCopy());
        }
    }

    public void add(Object key, Object value){
        buckets[(int) key] = new Entry(key, value, null);
    }

    public void addAllAuto(){
        for(int i = 0 ; i < buckets.length; i++){
            buckets[i] = new Entry(i, Integer.valueOf(i), new Entry(i, Integer.valueOf(i+i), null));
        }
    }

    public void seeAllBucket(){
        for(int i = 0 ; i < buckets.length; i++){
            System.out.println("i " + i + " " + buckets[i].key + " " + buckets[i].value + " ");
        }
    }

    public void change(int key, Object value){
        buckets[key] = new Entry(key, value, null);
    }

    @Override public HashTable clone(){
        try {
            HashTable result = (HashTable) super.clone();
//            result.buckets = buckets.clone();

            for(int i = 0; i < buckets.length; i++){
                if(buckets[i] != null){
                    result.buckets[i] = buckets[i].deepCopy();
                }
            }

            return result;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new AssertionError();
        }
    }
}
