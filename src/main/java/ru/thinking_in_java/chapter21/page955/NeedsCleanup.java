package ru.thinking_in_java.chapter21.page955;

public class NeedsCleanup {
    private final int id;

    public NeedsCleanup(int id){
        this.id = id;
        System.out.println("NeedsCleanup " + this.id);
    }

    public void cleanup(){
        System.out.println("Cleaning up " + this.id);
    }

}
