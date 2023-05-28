package ru.java_philosophy.chapter21.page908;

public class InnerThread1 {

    private int countDown = 5;
    private Inner inner;

    private class Inner extends Thread {

        public Inner(){
            this.start();
        }

        public String toString(){
            return "#" + getName() + "("+ countDown +")";
        }

        public void run(){
            while (true){
                System.out.println(this);
                if(--countDown == 0){
                    System.out.println("END " + this);
                    return;
                }
            }
        }
    }

    public InnerThread1(){
        this.inner = new Inner();
    }

    public static void main(String[] args) {
        for (int i =0; i < 5; i ++){
            new InnerThread1();
        }
    }
}
