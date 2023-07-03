package ru.thinking_in_java.chapter21.page966;

public class Meal {
    private final int orderNum;
    public Meal(int orderNum){
        this.orderNum = orderNum;
    }
    public String toString(){
        return "Meal orderNum: " + orderNum;
    }
}
